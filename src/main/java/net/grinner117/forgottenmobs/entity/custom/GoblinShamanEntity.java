package net.grinner117.forgottenmobs.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.EnumSet;

public class GoblinShamanEntity extends Monster implements IAnimatable {

    AnimationFactory manager = GeckoLibUtil.createFactory(this);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(GoblinShamanEntity.class, EntityDataSerializers.BYTE);

    public GoblinShamanEntity(EntityType<? extends GoblinShamanEntity> p_32219_, Level p_32220_) {
        super(p_32219_, p_32220_);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        this.xpReward = 100;
    }

    //ai goals
    //are afraid of owlbears
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new GoblinShamanEntity.BlazeAttackGoal(this));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 64.0F));
        this.goalSelector.addGoal(7, new AvoidEntityGoal<>(this, OwlBearForestEntity.class, 6.0F, 1.0D, 1.2D));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Chicken.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Slime.class, true));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());


    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 14.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ATTACK_SPEED, 0.5F)
                .add(Attributes.MOVEMENT_SPEED, 0.8F)
                .add(Attributes.FOLLOW_RANGE, 48.0D)
                .build();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }


    public void aiStep() {
        if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }

        if (this.level.isClientSide) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level.playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for(int i = 0; i < 2; ++i) {
                this.level.addParticle(ParticleTypes.ASH, this.getRandomX(0.2D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }
        super.aiStep();
    }

     void setCharged(boolean p_32241_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_32241_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    static class BlazeAttackGoal extends Goal {
        private final GoblinShamanEntity blaze;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public BlazeAttackGoal(GoblinShamanEntity p_32247_) {
            this.blaze = p_32247_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.blaze.getTarget();
            return livingentity != null && livingentity.isAlive() && this.blaze.canAttack(livingentity);
        }

        public void start() {
            this.attackStep = 0;
        }

        public void stop() {
            this.blaze.setCharged(false);
            this.lastSeen = 0;
        }
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.blaze.getTarget();
            if (livingentity != null) {
                boolean flag = this.blaze.getSensing().hasLineOfSight(livingentity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }
                double d0 = this.blaze.distanceToSqr(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 10;
                        this.blaze.doHurtTarget(livingentity);
                    }

                    this.blaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getX() - this.blaze.getX();
                    double d2 = livingentity.getY(0.5D) - this.blaze.getY(0.5D);
                    double d3 = livingentity.getZ() - this.blaze.getZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 30;
                            this.blaze.setCharged(true);
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 30;
                            this.attackStep = 0;
                            this.blaze.setCharged(false);
                        }

                        if (this.attackStep > 1) {
                            double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                            if (!this.blaze.isSilent()) {
                                this.blaze.level.levelEvent((Player)null, 1018, this.blaze.blockPosition(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                SmallFireball smallfireball = new SmallFireball(this.blaze.level, this.blaze, this.blaze.getRandom().triangle(d1, 2.297D * d4), d2, this.blaze.getRandom().triangle(d3, 2.297D * d4));
                                smallfireball.setPos(smallfireball.getX(), this.blaze.getY(0.5D) + 0.5D, smallfireball.getZ());
                                this.blaze.level.addFreshEntity(smallfireball);
                            }
                        }
                    }

                    this.blaze.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.blaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.blaze.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
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

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinshaman.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinshaman.idle", true));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinshaman.attack", false));
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