package net.grinner117.forgottenmobs.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class CloudGiantEntity extends Monster implements Enemy, IAnimatable {
    AnimationFactory manager = GeckoLibUtil.createFactory(this);

    public CloudGiantEntity(EntityType<? extends CloudGiantEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 20000;
    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 1000.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 200.0D)
                .add(Attributes.ATTACK_SPEED, 0.05F)
                .add(Attributes.MOVEMENT_SPEED, 0.05F)
                .add(Attributes.FOLLOW_RANGE, 200.0D)
                .build();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(5, new FloatGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 200.0F));


        this.targetSelector.addGoal(1, new HurtByTargetGoal(this ));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Chicken.class, 0, false, false, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test));
    }

    public SoundSource getSoundSource() {
        return SoundSource.NEUTRAL;
    }

    protected SoundEvent getHurtSound(DamageSource p_33152_) {
        return SoundEvents.TRIDENT_THUNDER;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDER_DRAGON_DEATH;
    }
    protected float getSoundVolume() {
        return 2.0F;
    }

    public boolean causeFallDamage(float p_149683_, float p_149684_, DamageSource p_149685_) {
        return false;
    }

//immune to fire
    protected boolean isBurning() {
        return false;
    }

    //immune to lava
    public boolean isInvulnerableTo(DamageSource p_149698_) {
        return p_149698_.isFire() || super.isInvulnerableTo(p_149698_);
    }



    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cloudgiant.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cloudgiant.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cloudgiant.attack", false));
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