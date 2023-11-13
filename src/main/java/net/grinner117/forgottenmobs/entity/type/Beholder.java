package net.grinner117.forgottenmobs.entity.type;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Beholder extends Monster implements GeoEntity {
	private float allowedHeightOffset = 0.5F;
	private int nextHeightOffsetChangeTick;
	private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
	private static final EntityDataAccessor<Integer> DATA_ID_ATTACK_TARGET = SynchedEntityData.defineId(Beholder.class, EntityDataSerializers.INT);

	public int getAttackDuration() {
		return 80;
	}

	private LivingEntity clientSideCachedAttackTarget;

	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Beholder.class, EntityDataSerializers.BYTE);

	public Beholder(EntityType<? extends Beholder> p_32219_, Level p_32220_) {
		super(p_32219_, p_32220_);
		this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
		this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
		this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
		this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
		this.xpReward = 300;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new MoveTowardsRestrictionGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.5D, 0.0F));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 64.0F));
		this.goalSelector.addGoal(2, new Beholder.BlazeAttackGoal(this));
		this.goalSelector.addGoal(2, new Beholder.BeholderAttackGoal(this));
		this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 1.0f, 30.0f));

		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Beholder.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Angel.class, true));
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 300.0D)
				.add(Attributes.ATTACK_DAMAGE, 15.0D)
				.add(Attributes.ATTACK_SPEED, 10.0F)
				.add(Attributes.MOVEMENT_SPEED, 0.3F)
				.add(Attributes.KNOCKBACK_RESISTANCE, 8.0F)
				.add(Attributes.FOLLOW_RANGE, 10.0F)
				.add(Attributes.FLYING_SPEED, 0.3F)
				.add(Attributes.ARMOR, 8.0F)
				.build();
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_FLAGS_ID, (byte) 0);
		this.entityData.define(DATA_ID_ATTACK_TARGET, 0);
	}

	void setActiveAttackTarget(int p_32818_) {
		this.entityData.set(DATA_ID_ATTACK_TARGET, p_32818_);
	}

	//sound

	//change pitch of movement sound enderman
	protected float getSoundVolume() {
		return 1.1F;
	}

	public float getVoicePitch() {
		return 0.5F;
	}
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENDERMAN_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource p_32235_) {
		return SoundEvents.ENDERMAN_SCREAM;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENDERMAN_SCREAM;
	}

	public float getLightLevelDependentMagicValue() {
		return 1.0F;
	}

	public boolean hasActiveAttackTarget() {
		return this.entityData.get(DATA_ID_ATTACK_TARGET) != 0;
	}

	private int clientSideAttackTime;

	public float getAttackAnimationScale(float p_32813_) {
		return ((float) this.clientSideAttackTime + p_32813_) / (float) this.getAttackDuration();
	}

	@Nullable
	public LivingEntity getActiveAttackTarget() {
		if (!this.hasActiveAttackTarget()) {
			return null;
		} else if (this.level.isClientSide) {
			if (this.clientSideCachedAttackTarget != null) {
				return this.clientSideCachedAttackTarget;
			} else {
				Entity entity = this.level.getEntity(this.entityData.get(DATA_ID_ATTACK_TARGET));
				if (entity instanceof LivingEntity) {
					this.clientSideCachedAttackTarget = (LivingEntity) entity;
					return this.clientSideCachedAttackTarget;
				} else {
					return null;
				}
			}
		} else {
			return this.getTarget();
		}
	}

	public void aiStep() {

		if (!this.onGround && this.getDeltaMovement().y < 0.01D) {
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.65D, 1.0D));
		}

		if (this.level.isClientSide) {
			if (this.random.nextInt(24) == 0 && !this.isSilent()) {
				this.level.playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.ENDERMAN_AMBIENT, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
			}

			for (int i = 0; i < 2; ++i) {
				this.level.addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
			}
		}
		LivingEntity livingentity = this.getActiveAttackTarget();
		if (livingentity != null) {
			this.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
			this.getLookControl().tick();
			double d5 = (double) this.getAttackAnimationScale(0.0F);
			double d0 = livingentity.getX() - this.getX();
			double d1 = livingentity.getY(0.5D) - this.getEyeY();
			double d2 = livingentity.getZ() - this.getZ();
			double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
			d0 /= d3;
			d1 /= d3;
			d2 /= d3;
			double d4 = this.random.nextDouble();

			while (d4 < d3) {
				d4 += 1.8D - d5 + this.random.nextDouble() * (2.0D - d5);
				this.level.addParticle(ParticleTypes.DRAGON_BREATH, this.getX() + d0 * d4, this.getEyeY() + d1 * d4, this.getZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
			}
		}
		super.aiStep();
	}

	public boolean isSensitiveToWater() {
		return false;
	}

	protected void customServerAiStep() {
		--this.nextHeightOffsetChangeTick;
		if (this.nextHeightOffsetChangeTick <= 0) {
			this.nextHeightOffsetChangeTick = 100;
			this.allowedHeightOffset = (float) this.random.triangle(0.5D, 6.891D);
		}

		LivingEntity livingentity = this.getTarget();
		if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double) this.allowedHeightOffset && this.canAttack(livingentity)) {
			Vec3 vec3 = this.getDeltaMovement();
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, ((double) 0.3F - vec3.y) * (double) 0.3F, 0.0D));
			this.hasImpulse = true;
		}

		super.customServerAiStep();
	}

	public boolean causeFallDamage(float p_149683_, float p_149684_, DamageSource p_149685_) {
		return false;
	}


	private PlayState predicate(AnimationState animationState) {
		if (animationState.isMoving()) {
			animationState.getController().setAnimation(RawAnimation.begin().then("animation.beholder.walk", Animation.LoopType.LOOP));
			return PlayState.CONTINUE;
		}
		animationState.getController().setAnimation(RawAnimation.begin().then("animation.beholder.idle", Animation.LoopType.LOOP));
		return PlayState.CONTINUE;
	}

	private PlayState attackPredicate(AnimationState state) {
		if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
			state.getController().forceAnimationReset();
			state.getController().setAnimation((RawAnimation.begin().then("animation.beholder.attack", Animation.LoopType.PLAY_ONCE)));
			this.swinging = false;
		}
		return PlayState.CONTINUE;
	}


	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController(this, "controller",
				0, this::predicate));
		controllers.add(new AnimationController(this, "attackController",
				0, this::attackPredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return null;
	}

	static class BeholderAttackGoal extends Goal {
		private final Beholder beholder;
		private int attackTime;

		public BeholderAttackGoal(Beholder beholder) {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
			this.beholder = beholder;
		}

		public boolean canUse() {
			LivingEntity livingentity = this.beholder.getTarget();
			return livingentity != null && livingentity.isAlive();
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && (this.beholder.getTarget() != null && this.beholder.distanceToSqr(this.beholder.getTarget()) > 9.0D);
		}

		public void start() {
			this.attackTime = -10;
			this.beholder.getNavigation().stop();
			LivingEntity livingentity = this.beholder.getTarget();
			if (livingentity != null) {
				this.beholder.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
			}

			this.beholder.hasImpulse = true;
		}

		public void stop() {
			this.beholder.setActiveAttackTarget(0);
			this.beholder.setTarget((LivingEntity) null);
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		public void tick() {
			LivingEntity livingentity = this.beholder.getTarget();
			if (livingentity != null) {
				this.beholder.getNavigation().stop();
				this.beholder.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
				if (!this.beholder.hasLineOfSight(livingentity)) {
					this.beholder.setTarget((LivingEntity) null);
				} else {
					++this.attackTime;
					if (this.attackTime == 0) {
						this.beholder.setActiveAttackTarget(livingentity.getId());
						if (!this.beholder.isSilent()) {
							this.beholder.level.broadcastEntityEvent(this.beholder, (byte) 21);
						}
					} else if (this.attackTime >= this.beholder.getAttackDuration()) {
						float f = 1.0F;
						if (this.beholder.level.getDifficulty() == Difficulty.HARD) {
							f += 2.0F;
						}
						livingentity.hurt(DamageSource.m_19364_(this.beholder), f);
						livingentity.hurt(DamageSource.m_19364_(this.beholder), (float) this.beholder.getAttributeValue(Attributes.ATTACK_DAMAGE));
						this.beholder.setTarget((LivingEntity) null);
					}

					super.tick();
				}
			}
		}
	}

	public boolean isOnFire() {
		return this.isCharged();
	}

	private boolean isCharged() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}

	void setCharged(boolean p_32241_) {
		byte b0 = this.entityData.get(DATA_FLAGS_ID);
		if (p_32241_) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		this.entityData.set(DATA_FLAGS_ID, b0);
	}

	static class BlazeAttackGoal extends Goal {
		private final Beholder blaze;
		private int attackStep;
		private int attackTime;
		private int lastSeen;

		public BlazeAttackGoal(Beholder beholder, Beholder blaze) {
			this.blaze = blaze;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));

		}

		public BlazeAttackGoal(Beholder beholder) {
			this.blaze = beholder;
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
							this.attackTime = 20;
							this.blaze.setCharged(true);
						} else if (this.attackStep <= 4) {
							this.attackTime = 6;
						} else {
							this.attackTime = 80;
							this.attackStep = 0;
							this.blaze.setCharged(false);
						}

						if (this.attackStep > 1) {
							double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
							if (!this.blaze.isSilent()) {
								this.blaze.level.levelEvent((Player) null, 1018, this.blaze.blockPosition(), 0);
							}
							for (int i = 0; i < 1; ++i) {
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
}