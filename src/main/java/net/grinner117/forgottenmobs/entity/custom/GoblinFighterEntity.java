package net.grinner117.forgottenmobs.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class GoblinFighterEntity extends Monster implements CrossbowAttackMob, InventoryCarrier, IAnimatable {
    private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(GoblinFighterEntity.class, EntityDataSerializers.BOOLEAN);
    private final SimpleContainer inventory = new SimpleContainer(8);
    AnimationFactory manager = GeckoLibUtil.createFactory(this);
    private int eatAnimationTick;
    private EatBlockGoal eatBlockGoal;
    public GoblinFighterEntity(EntityType<? extends Monster> p_34683_, Level p_34684_) {
        super(p_34683_, p_34684_);
        this.xpReward = 5;
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.ATTACK_SPEED, 0.5F)
                .add(Attributes.MOVEMENT_SPEED, 1.1F)
                .add(Attributes.FOLLOW_RANGE, 48.0D)
                .build();
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.30F, false));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 64.0F));
        this.eatBlockGoal = new EatBlockGoal(this);
        this.goalSelector.addGoal(4, this.eatBlockGoal);
        this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, OwlBearForestEntity.class, 6.0F, 1.0D, 1.2D));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Chicken.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Slime.class, true));

    }


    protected void customServerAiStep() {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }
@Override
    public void aiStep() {
        if (this.level.isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }

        super.aiStep();
    }
    public void readAdditionalSaveData(CompoundTag p_34725_) {
        super.readAdditionalSaveData(p_34725_);
        this.readInventoryFromTag(p_34725_);
    }

    private void readInventoryFromTag(CompoundTag p34725) {
    }

    @VisibleForDebug
    public SimpleContainer getInventory() {
        return this.inventory;
    }

    protected ItemStack addToInventory(ItemStack p_34779_) {
        return this.inventory.addItem(p_34779_);
    }

    protected boolean canAddToInventory(ItemStack p_34781_) {
        return this.inventory.canAddItem(p_34781_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IS_CHARGING_CROSSBOW, false);
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219189_, DifficultyInstance p_219190_) {

            this.maybeWearArmor(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET), p_219189_);
            this.maybeWearArmor(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE), p_219189_);
            this.maybeWearArmor(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS), p_219189_);
            this.maybeWearArmor(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS), p_219189_);
            }
    private void maybeWearArmor(EquipmentSlot p_219192_, ItemStack p_219193_, RandomSource p_219194_) {
        if (p_219194_.nextFloat() < 0.8F) {
            this.setItemSlot(p_219192_, p_219193_);
        }

    }

    protected float getStandingEyeHeight(Pose p_34740_, EntityDimensions p_34741_) {
        float f = super.getStandingEyeHeight(p_34740_, p_34741_);
        return this.isBaby() ? f - 0.62F : f;
    }



    private ItemStack createSpawnWeapon() {
        return (double)this.random.nextFloat() < 0.5D ? new ItemStack(Items.CROSSBOW) : new ItemStack(Items.IRON_SWORD);
    }

    private boolean isChargingCrossbow() {
        return this.entityData.get(DATA_IS_CHARGING_CROSSBOW);
    }

    public void setChargingCrossbow(boolean p_34753_) {
        this.entityData.set(DATA_IS_CHARGING_CROSSBOW, p_34753_);
    }

    public void onCrossbowAttackPerformed() {
        this.noActionTime = 0;
    }

    public void performRangedAttack(LivingEntity p_34704_, float p_34705_) {
        this.performCrossbowAttack(this, 1.6F);
    }

    public void shootCrossbowProjectile(LivingEntity p_34707_, ItemStack p_34708_, Projectile p_34709_, float p_34710_) {
        this.shootCrossbowProjectile(this, p_34707_, p_34709_, p_34710_, 1.6F);
    }

    public boolean canFireProjectileWeapon(ProjectileWeaponItem p_34715_) {
        return p_34715_ == Items.CROSSBOW;
    }

    protected void holdInMainHand(ItemStack p_34784_) {
        this.setItemSlotAndDropWhenKilled(EquipmentSlot.MAINHAND, p_34784_);
    }

    public boolean wantsToPickUp(ItemStack p_34777_) {
        return net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) && this.canPickUpLoot();
    }

    protected boolean canReplaceCurrentItem(ItemStack p_34788_) {
        EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(p_34788_);
        ItemStack itemstack = this.getItemBySlot(equipmentslot);
        return this.canReplaceCurrentItem(p_34788_, itemstack);
    }


    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(SoundEvents.PIG_AMBIENT, 1.0F, 0.5F);
    }
    protected SoundEvent getHurtSound(DamageSource p_32527_) {
        return SoundEvents.PIG_HURT;
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.HOGLIN_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.PIG_STEP;
    }

    protected float getSoundVolume() {
        return 0.8F;
    }
    public boolean isSensitiveToWater() {
        return true;
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinfighter.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinfighter.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinfighter.attack", false));
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
