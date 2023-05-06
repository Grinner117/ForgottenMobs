package net.grinner117.forgottenmobs.entity.custom;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ShadowWyrmlingEntity extends FlyingMob implements Enemy, IAnimatable {

    AnimationFactory manager = GeckoLibUtil.createFactory(this);
    public static final float FLAP_DEGREES_PER_TICK = 7.448451F;
    public static final int TICKS_PER_FLAP = Mth.ceil(24.166098F);
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(ShadowWyrmlingEntity.class, EntityDataSerializers.INT);
    Vec3 moveTargetPoint = Vec3.ZERO;
    BlockPos anchorPoint = BlockPos.ZERO;
    ShadowWyrmlingEntity.AttackPhase attackPhase = ShadowWyrmlingEntity.AttackPhase.CIRCLE;

    public ShadowWyrmlingEntity(EntityType<? extends ShadowWyrmlingEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 20;
        this.moveControl = new ShadowWyrmlingEntity.PhantomMoveControl(this);
        this.lookControl = new ShadowWyrmlingEntity.PhantomLookControl(this);
    }

    public boolean isFlapping() {
        return (this.getUniqueFlapTickOffset() + this.tickCount) % TICKS_PER_FLAP == 0;
    }

    protected BodyRotationControl createBodyControl() {
        return new ShadowWyrmlingEntity.PhantomBodyRotationControl(this);
    }

    
    public static AttributeSupplier setAttributes() {    
        return Monster.createMonsterAttributes()    
                .add(Attributes.MAX_HEALTH, 80.0D)
                .add(Attributes.ATTACK_DAMAGE, 14.0D)    
                .add(Attributes.ATTACK_SPEED, 1.0F)    
                .add(Attributes.MOVEMENT_SPEED, 1.0F)    
                .build();    
    }      
                      
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new ShadowWyrmlingEntity.PhantomAttackStrategyGoal());
        this.goalSelector.addGoal(2, new ShadowWyrmlingEntity.PhantomSweepAttackGoal());
        this.goalSelector.addGoal(3, new ShadowWyrmlingEntity.PhantomCircleAroundAnchorGoal());
        this.targetSelector.addGoal(1, new ShadowWyrmlingEntity.PhantomAttackPlayerTargetGoal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_SIZE, 0);
    }

    public void setPhantomSize(int p_33109_) {
        this.entityData.set(ID_SIZE, Mth.clamp(p_33109_, 0, 64));
    }

    private void updatePhantomSizeInfo() {
        this.refreshDimensions();
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double) (6 + this.getPhantomSize()));
    }

    public int getPhantomSize() {
        return this.entityData.get(ID_SIZE);
    }

    protected float getStandingEyeHeight(Pose p_33136_, EntityDimensions p_33137_) {
        return p_33137_.height * 0.35F;
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_33134_) {
        if (ID_SIZE.equals(p_33134_)) {
            this.updatePhantomSizeInfo();
        }

        super.onSyncedDataUpdated(p_33134_);
    }

    public int getUniqueFlapTickOffset() {
        return this.getId() * 3;
    }

    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            float f = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
            float f1 = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
            if (f > 0.0F && f1 <= 0.0F) {
                this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.PHANTOM_FLAP, this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F, false);
            }

            int i = this.getPhantomSize();
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (1.3F + 0.21F * (float) i);
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (1.3F + 0.21F * (float) i);
            float f4 = (0.3F + f * 0.45F) * ((float) i * 0.2F + 1.0F);
            this.level.addParticle(ParticleTypes.MYCELIUM, this.getX() + (double) f2, this.getY() + (double) f4, this.getZ() + (double) f3, 0.0D, 0.0D, 0.0D);
            this.level.addParticle(ParticleTypes.MYCELIUM, this.getX() - (double) f2, this.getY() + (double) f4, this.getZ() - (double) f3, 0.0D, 0.0D, 0.0D);
        }

    }

    protected void customServerAiStep() {
        super.customServerAiStep();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33126_, DifficultyInstance p_33127_, MobSpawnType p_33128_, @Nullable SpawnGroupData p_33129_, @Nullable CompoundTag p_33130_) {
        this.anchorPoint = this.blockPosition().above(5);
        this.setPhantomSize(0);
        return super.finalizeSpawn(p_33126_, p_33127_, p_33128_, p_33129_, p_33130_);
    }

    public void readAdditionalSaveData(CompoundTag p_33132_) {
        super.readAdditionalSaveData(p_33132_);
        if (p_33132_.contains("AX")) {
            this.anchorPoint = new BlockPos(p_33132_.getInt("AX"), p_33132_.getInt("AY"), p_33132_.getInt("AZ"));
        }

        this.setPhantomSize(p_33132_.getInt("Size"));
    }

    public void addAdditionalSaveData(CompoundTag p_33141_) {
        super.addAdditionalSaveData(p_33141_);
        p_33141_.putInt("AX", this.anchorPoint.getX());
        p_33141_.putInt("AY", this.anchorPoint.getY());
        p_33141_.putInt("AZ", this.anchorPoint.getZ());
        p_33141_.putInt("Size", this.getPhantomSize());
    }

    public boolean shouldRenderAtSqrDistance(double p_33107_) {
        return true;
    }

    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDER_DRAGON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_33152_) {
        return SoundEvents.ENDER_DRAGON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDER_DRAGON_DEATH;
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    protected float getSoundVolume() {
        return 1.0F;
    }

    public boolean canAttackType(EntityType<?> p_33111_) {
        return true;
    }

    public EntityDimensions getDimensions(Pose p_33113_) {
        int i = this.getPhantomSize();
        EntityDimensions entitydimensions = super.getDimensions(p_33113_);
        float f = (entitydimensions.width + 0.2F * (float) i) / entitydimensions.width;
        return entitydimensions.scale(f);
    }

    static enum AttackPhase {
        CIRCLE,
        SWOOP;
    }

    class PhantomAttackPlayerTargetGoal extends Goal {
        private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);
        private int nextScanTick = reducedTickDelay(20);

        public boolean canUse() {
            if (this.nextScanTick > 0) {
                --this.nextScanTick;
                return false;
            } else {
                this.nextScanTick = reducedTickDelay(60);
                List<Player> list = ShadowWyrmlingEntity.this.level.getNearbyPlayers(this.attackTargeting, ShadowWyrmlingEntity.this, ShadowWyrmlingEntity.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
                if (!list.isEmpty()) {
                    list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());

                    for (Player player : list) {
                        if (ShadowWyrmlingEntity.this.canAttack(player, TargetingConditions.DEFAULT)) {
                            ShadowWyrmlingEntity.this.setTarget(player);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = ShadowWyrmlingEntity.this.getTarget();
            return livingentity != null ? ShadowWyrmlingEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }
    }

    class PhantomAttackStrategyGoal extends Goal {
        private int nextSweepTick;

        public boolean canUse() {
            LivingEntity livingentity = ShadowWyrmlingEntity.this.getTarget();
            return livingentity != null ? ShadowWyrmlingEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }

        public void start() {
            this.nextSweepTick = this.adjustedTickDelay(10);
            ShadowWyrmlingEntity.this.attackPhase = ShadowWyrmlingEntity.AttackPhase.CIRCLE;
            this.setAnchorAboveTarget();
        }

        public void stop() {
            ShadowWyrmlingEntity.this.anchorPoint = ShadowWyrmlingEntity.this.level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, ShadowWyrmlingEntity.this.anchorPoint).above(10 + ShadowWyrmlingEntity.this.random.nextInt(20));
        }

        public void tick() {
            if (ShadowWyrmlingEntity.this.attackPhase == ShadowWyrmlingEntity.AttackPhase.CIRCLE) {
                --this.nextSweepTick;
                if (this.nextSweepTick <= 0) {
                    ShadowWyrmlingEntity.this.attackPhase = ShadowWyrmlingEntity.AttackPhase.SWOOP;
                    this.setAnchorAboveTarget();
                    this.nextSweepTick = this.adjustedTickDelay((8 + ShadowWyrmlingEntity.this.random.nextInt(4)) * 20);
                    ShadowWyrmlingEntity.this.playSound(SoundEvents.PHANTOM_SWOOP, 10.0F, 0.95F + ShadowWyrmlingEntity.this.random.nextFloat() * 0.1F);
                }
            }

        }

        private void setAnchorAboveTarget() {
            ShadowWyrmlingEntity.this.anchorPoint = ShadowWyrmlingEntity.this.getTarget().blockPosition().above(20 + ShadowWyrmlingEntity.this.random.nextInt(20));
            if (ShadowWyrmlingEntity.this.anchorPoint.getY() < ShadowWyrmlingEntity.this.level.getSeaLevel()) {
                ShadowWyrmlingEntity.this.anchorPoint = new BlockPos(ShadowWyrmlingEntity.this.anchorPoint.getX(), ShadowWyrmlingEntity.this.level.getSeaLevel() + 1, ShadowWyrmlingEntity.this.anchorPoint.getZ());
            }

        }
    }

    class PhantomBodyRotationControl extends BodyRotationControl {
        public PhantomBodyRotationControl(Mob p_33216_) {
            super(p_33216_);
        }

        public void clientTick() {
            ShadowWyrmlingEntity.this.yHeadRot = ShadowWyrmlingEntity.this.yBodyRot;
            ShadowWyrmlingEntity.this.yBodyRot = ShadowWyrmlingEntity.this.getYRot();
        }
    }

    class PhantomCircleAroundAnchorGoal extends ShadowWyrmlingEntity.PhantomMoveTargetGoal {
        private float angle;
        private float distance;
        private float height;
        private float clockwise;

        public boolean canUse() {
            return ShadowWyrmlingEntity.this.getTarget() == null || ShadowWyrmlingEntity.this.attackPhase == ShadowWyrmlingEntity.AttackPhase.CIRCLE;
        }

        public void start() {
            this.distance = 8.0F + ShadowWyrmlingEntity.this.random.nextFloat() * 10.0F;
            this.height = -8.0F + ShadowWyrmlingEntity.this.random.nextFloat() * 9.0F;
            this.clockwise = ShadowWyrmlingEntity.this.random.nextBoolean() ? 1.0F : -1.0F;
            this.selectNext();
        }

        public void tick() {
            if (ShadowWyrmlingEntity.this.random.nextInt(this.adjustedTickDelay(350)) == 0) {
                this.height = -4.0F + ShadowWyrmlingEntity.this.random.nextFloat() * 9.0F;
            }

            if (ShadowWyrmlingEntity.this.random.nextInt(this.adjustedTickDelay(250)) == 0) {
                ++this.distance;
                if (this.distance > 15.0F) {
                    this.distance = 5.0F;
                    this.clockwise = -this.clockwise;
                }
            }

            if (ShadowWyrmlingEntity.this.random.nextInt(this.adjustedTickDelay(450)) == 0) {
                this.angle = ShadowWyrmlingEntity.this.random.nextFloat() * 2.0F * (float) Math.PI;
                this.selectNext();
            }

            if (this.touchingTarget()) {
                this.selectNext();
            }

            if (ShadowWyrmlingEntity.this.moveTargetPoint.y < ShadowWyrmlingEntity.this.getY() && !ShadowWyrmlingEntity.this.level.isEmptyBlock(ShadowWyrmlingEntity.this.blockPosition().below(1))) {
                this.height = Math.max(1.0F, this.height);
                this.selectNext();
            }

            if (ShadowWyrmlingEntity.this.moveTargetPoint.y > ShadowWyrmlingEntity.this.getY() && !ShadowWyrmlingEntity.this.level.isEmptyBlock(ShadowWyrmlingEntity.this.blockPosition().above(1))) {
                this.height = Math.min(-1.0F, this.height);
                this.selectNext();
            }

        }

        private void selectNext() {
            if (BlockPos.ZERO.equals(ShadowWyrmlingEntity.this.anchorPoint)) {
                ShadowWyrmlingEntity.this.anchorPoint = ShadowWyrmlingEntity.this.blockPosition();
            }

            this.angle += this.clockwise * 15.0F * ((float) Math.PI / 180F);
            ShadowWyrmlingEntity.this.moveTargetPoint = Vec3.atLowerCornerOf(ShadowWyrmlingEntity.this.anchorPoint).add((double) (this.distance * Mth.cos(this.angle)), (double) (-4.0F + this.height), (double) (this.distance * Mth.sin(this.angle)));
        }
    }

    class PhantomLookControl extends LookControl {
        public PhantomLookControl(Mob p_33235_) {
            super(p_33235_);
        }

        public void tick() {
        }
    }

    class PhantomMoveControl extends MoveControl {
        private float speed = 0.1F;

        public PhantomMoveControl(Mob p_33241_) {
            super(p_33241_);
        }

        public void tick() {
            if (ShadowWyrmlingEntity.this.horizontalCollision) {
                ShadowWyrmlingEntity.this.setYRot(ShadowWyrmlingEntity.this.getYRot() + 180.0F);
                this.speed = 0.1F;
            }

            double d0 = ShadowWyrmlingEntity.this.moveTargetPoint.x - ShadowWyrmlingEntity.this.getX();
            double d1 = ShadowWyrmlingEntity.this.moveTargetPoint.y - ShadowWyrmlingEntity.this.getY();
            double d2 = ShadowWyrmlingEntity.this.moveTargetPoint.z - ShadowWyrmlingEntity.this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            if (Math.abs(d3) > (double) 1.0E-5F) {
                double d4 = 1.0D - Math.abs(d1 * (double) 0.7F) / d3;
                d0 *= d4;
                d2 *= d4;
                d3 = Math.sqrt(d0 * d0 + d2 * d2);
                double d5 = Math.sqrt(d0 * d0 + d2 * d2 + d1 * d1);
                float f = ShadowWyrmlingEntity.this.getYRot();
                float f1 = (float) Mth.atan2(d2, d0);
                float f2 = Mth.wrapDegrees(ShadowWyrmlingEntity.this.getYRot() + 90.0F);
                float f3 = Mth.wrapDegrees(f1 * (180F / (float) Math.PI));
                ShadowWyrmlingEntity.this.setYRot(Mth.approachDegrees(f2, f3, 4.0F) - 90.0F);
                ShadowWyrmlingEntity.this.yBodyRot = ShadowWyrmlingEntity.this.getYRot();
                if (Mth.degreesDifferenceAbs(f, ShadowWyrmlingEntity.this.getYRot()) < 3.0F) {
                    this.speed = Mth.approach(this.speed, 1.8F, 0.005F * (1.8F / this.speed));
                } else {
                    this.speed = Mth.approach(this.speed, 0.2F, 0.025F);
                }

                float f4 = (float) (-(Mth.atan2(-d1, d3) * (double) (180F / (float) Math.PI)));
                ShadowWyrmlingEntity.this.setXRot(f4);
                float f5 = ShadowWyrmlingEntity.this.getYRot() + 90.0F;
                double d6 = (double) (this.speed * Mth.cos(f5 * ((float) Math.PI / 180F))) * Math.abs(d0 / d5);
                double d7 = (double) (this.speed * Mth.sin(f5 * ((float) Math.PI / 180F))) * Math.abs(d2 / d5);
                double d8 = (double) (this.speed * Mth.sin(f4 * ((float) Math.PI / 180F))) * Math.abs(d1 / d5);
                Vec3 vec3 = ShadowWyrmlingEntity.this.getDeltaMovement();
                ShadowWyrmlingEntity.this.setDeltaMovement(vec3.add((new Vec3(d6, d8, d7)).subtract(vec3).scale(0.2D)));
            }

        }
    }

    abstract class PhantomMoveTargetGoal extends Goal {
        public PhantomMoveTargetGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        protected boolean touchingTarget() {
            return ShadowWyrmlingEntity.this.moveTargetPoint.distanceToSqr(ShadowWyrmlingEntity.this.getX(), ShadowWyrmlingEntity.this.getY(), ShadowWyrmlingEntity.this.getZ()) < 4.0D;
        }
    }

    class PhantomSweepAttackGoal extends ShadowWyrmlingEntity.PhantomMoveTargetGoal {
        private static final int CAT_SEARCH_TICK_DELAY = 20;
        private boolean isScaredOfCat;
        private int catSearchTick;

        public boolean canUse() {
            return ShadowWyrmlingEntity.this.getTarget() != null && ShadowWyrmlingEntity.this.attackPhase == ShadowWyrmlingEntity.AttackPhase.SWOOP;
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = ShadowWyrmlingEntity.this.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                if (livingentity instanceof Player) {
                    Player player = (Player) livingentity;
                    if (livingentity.isSpectator() || player.isCreative()) {
                        return false;
                    }
                }

                if (!this.canUse()) {
                    return false;
                } else {
                    if (ShadowWyrmlingEntity.this.tickCount > this.catSearchTick) {
                        this.catSearchTick = ShadowWyrmlingEntity.this.tickCount + 20;
                        List<Cat> list = ShadowWyrmlingEntity.this.level.getEntitiesOfClass(Cat.class, ShadowWyrmlingEntity.this.getBoundingBox().inflate(16.0D), EntitySelector.ENTITY_STILL_ALIVE);

                        for (Cat cat : list) {
                            cat.hiss();
                        }

                        this.isScaredOfCat = !list.isEmpty();
                    }

                    return !this.isScaredOfCat;
                }
            }
        }

        public void start() {
        }

        public void stop() {
            ShadowWyrmlingEntity.this.setTarget((LivingEntity) null);
            ShadowWyrmlingEntity.this.attackPhase = ShadowWyrmlingEntity.AttackPhase.CIRCLE;
        }

        public void tick() {
            LivingEntity livingentity = ShadowWyrmlingEntity.this.getTarget();
            if (livingentity != null) {
                ShadowWyrmlingEntity.this.moveTargetPoint = new Vec3(livingentity.getX(), livingentity.getY(0.5D), livingentity.getZ());
                if (ShadowWyrmlingEntity.this.getBoundingBox().inflate((double) 0.2F).intersects(livingentity.getBoundingBox())) {
                    ShadowWyrmlingEntity.this.doHurtTarget(livingentity);
                    ShadowWyrmlingEntity.this.attackPhase = ShadowWyrmlingEntity.AttackPhase.CIRCLE;
                    if (!ShadowWyrmlingEntity.this.isSilent()) {
                        ShadowWyrmlingEntity.this.level.levelEvent(1039, ShadowWyrmlingEntity.this.blockPosition(), 0);
                    }
                } else if (ShadowWyrmlingEntity.this.horizontalCollision || ShadowWyrmlingEntity.this.hurtTime > 0) {
                    ShadowWyrmlingEntity.this.attackPhase = ShadowWyrmlingEntity.AttackPhase.CIRCLE;
                }

            }
        }
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("wyrmling.animation.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("wyrmling.animation.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("wyrmling.animation.attack", false));
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