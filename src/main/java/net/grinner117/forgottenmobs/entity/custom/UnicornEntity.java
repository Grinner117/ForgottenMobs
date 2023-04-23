package net.grinner117.forgottenmobs.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;


public class UnicornEntity extends AbstractHorse implements IAnimatable {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(net.minecraft.world.entity.animal.horse.Horse.class, EntityDataSerializers.INT);
    AnimationFactory manager = GeckoLibUtil.createFactory(this);

    public UnicornEntity(EntityType<? extends UnicornEntity> p_30689_, Level p_30690_) {
        super(p_30689_, p_30690_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 100.0D)
                .add(Attributes.ATTACK_SPEED, 0.5F)
                .add(Attributes.FOLLOW_RANGE, 148.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.JUMP_STRENGTH, 0.5F)
                .build();
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    //Sound
    protected void playGallopSound(SoundType p_30709_) {
        super.playGallopSound(p_30709_);
        if (this.random.nextInt(10) == 0) {
            this.playSound(SoundEvents.HORSE_BREATHE, p_30709_.getVolume() * 0.6F, p_30709_.getPitch());
        }
        ItemStack stack = this.inventory.getItem(1);
        if (isArmor(stack)) stack.onHorseArmorTick(level, this);
    }

    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundEvents.HORSE_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.ENDER_DRAGON_DEATH;
    }

    @Nullable
    protected SoundEvent getEatingSound() {
        return SoundEvents.HORSE_EAT;
    }

    protected SoundEvent getHurtSound(DamageSource p_30720_) {
        super.getHurtSound(p_30720_);
        return SoundEvents.HORSE_HURT;
    }

    protected SoundEvent getAngrySound() {
        super.getAngrySound();
        return SoundEvents.ENDERMAN_SCREAM;
    }

    public InteractionResult mobInteract(Player p_30713_, InteractionHand p_30714_) {
        ItemStack itemstack = p_30713_.getItemInHand(p_30714_);
        if (!this.isBaby()) {
            if (this.isTamed() && p_30713_.isSecondaryUseActive()) {
                this.openCustomInventoryScreen(p_30713_);
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }

            if (this.isVehicle()) {
                return super.mobInteract(p_30713_, p_30714_);
            }
        }

        if (!itemstack.isEmpty()) {
            if (this.isFood(itemstack)) {
                return this.fedFood(p_30713_, itemstack);
            }

            InteractionResult interactionresult = itemstack.interactLivingEntity(p_30713_, this, p_30714_);
            if (interactionresult.consumesAction()) {
                return interactionresult;
            }

            if (!this.isTamed()) {
                this.makeMad();
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }

            boolean flag = !this.isBaby() && !this.isSaddled() && itemstack.is(Items.SADDLE);
            if (this.isArmor(itemstack) || flag) {
                this.openCustomInventoryScreen(p_30713_);
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }
        }

        if (this.isBaby()) {
            return super.mobInteract(p_30713_, p_30714_);
        } else {
            this.doPlayerRide(p_30713_);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }
    }

    //this entity heals itself passiively
    public void aiStep() {
        if (this.level.isClientSide) {
            this.updateSwingTime();
        }
        if (this.random.nextInt(100) == 0) {
            this.heal(1.0F);
        }
        super.aiStep();
    }

    //this entity heals the rider
    public void onPassengerTurned(Entity p_70043_) {
        super.onPassengerTurned(p_70043_);
        if (p_70043_ instanceof Player) {
            Player player = (Player) p_70043_;
            player.heal(1.0F);
        }
    }

    //Unicorn gives it's rider the glow effect every tick and removes the particles from the mobeffect


    public void tick() {
        super.tick();
        if (this.isVehicle()) {
            Entity entity = this.getPassengers().get(0);
            if (entity instanceof Player) {
                Player player = (Player) entity;
                player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));
                player.addEffect(new MobEffectInstance(MobEffects.HEAL, 100, 0));


                this.removeEffectParticles();
            }
        }
        //this.removeEffectParticles();

    }


    //animations
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.unicorn.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.unicorn.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.unicorn.attack", false));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return manager;
    }
}
