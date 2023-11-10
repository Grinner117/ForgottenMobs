package net.grinner117.forgottendragons.entity.type;

import net.grinner117.forgottenmobs.entity.type.Dragon;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class BlueDragon extends Dragon {
	private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(Ghast.class, EntityDataSerializers.BOOLEAN);

	public BlueDragon(EntityType<? extends Dragon> p_33101_, Level p_33102_) {
		super(p_33101_, p_33102_);
	}

	public int getMaxSpawnClusterSize() {
		return 1;
	}

	private float allowedHeightOffset = 2.5F;
	private int nextHeightOffsetChangeTick;
	AnimationFactory manager = GeckoLibUtil.createFactory(this);
	private static final EntityDataAccessor<Integer> DATA_ID_ATTACK_TARGET = SynchedEntityData.defineId(BlueDragon.class, EntityDataSerializers.INT);

	public int getAttackDuration() {
		return 80;
	}

	private LivingEntity clientSideCachedAttackTarget;
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(BlueDragon.class, EntityDataSerializers.BYTE);

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_FLAGS_ID, (byte) 0);
		this.entityData.define(DATA_ID_ATTACK_TARGET, 0);
	}

	void setActiveAttackTarget(int p_32818_) {
		this.entityData.set(DATA_ID_ATTACK_TARGET, p_32818_);
	}

	public float getLightLevelDependentMagicValue() {
		return 1.0F;
	}

	public boolean hasActiveAttackTarget() {
		return this.entityData.get(DATA_ID_ATTACK_TARGET) != 0;
	}

	private int clientSideAttackTime;

	public void setCharging(boolean pCharging) {
		this.entityData.set(DATA_IS_CHARGING, pCharging);
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
				this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.LIGHTNING_BOLT_THUNDER, this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F, false);
			}

			super.tick();
			if (this.level.isClientSide) {
				for (int i = 0; i < 8; ++i) {
					this.level.addParticle(ParticleTypes.ELECTRIC_SPARK, this.getRandomX(0.2D), this.getRandomY(), this.getRandomZ(8.0D), 0.5D, 0.5D, 0.5D);
				}
			}
		}
	}


	//add goal
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BlueDragon.LightningAttackGoal(this));
	}

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
		if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
		}
		if (this.level.isClientSide) {
			if (this.random.nextInt(24) == 0 && !this.isSilent()) {
				this.level.playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.LIGHTNING_BOLT_THUNDER, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
			}
			for (int i = 0; i < 2; ++i) {
				this.level.addParticle(ParticleTypes.ELECTRIC_SPARK, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
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
				this.level.addParticle(ParticleTypes.ELECTRIC_SPARK, this.getX() + d0 * d4, this.getEyeY() + d1 * d4, this.getZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
			}
		}
		super.aiStep();
	}

	protected void customServerAiStep() {
		--this.nextHeightOffsetChangeTick;
		if (this.nextHeightOffsetChangeTick <= 0) {
			this.nextHeightOffsetChangeTick = 100;
			this.allowedHeightOffset = (float) this.random.triangle(2.5D, 6.0D);
		}

		LivingEntity livingentity = this.getTarget();
		if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double) this.allowedHeightOffset && this.canAttack(livingentity)) {
			Vec3 vec3 = this.getDeltaMovement();
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, ((double) 0.3F - vec3.y) * (double) 0.3F, 0.0D));
			this.hasImpulse = true;
		}

		super.customServerAiStep();
	}

	static class LightningAttackGoal extends Goal {
		private final BlueDragon guardian;
		private int attackTime;


		public LightningAttackGoal(BlueDragon p_32871_) {
			this.guardian = p_32871_;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			LivingEntity livingentity = this.guardian.getTarget();
			return livingentity != null && livingentity.isAlive();
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && (this.guardian.getTarget() != null && this.guardian.distanceToSqr(this.guardian.getTarget()) > 9.0D);
		}

		public void start() {
			this.attackTime = -10;
			this.guardian.getNavigation().stop();
			LivingEntity livingentity = this.guardian.getTarget();
			if (livingentity != null) {
				this.guardian.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
			}

			this.guardian.hasImpulse = true;
		}

		public void stop() {
			this.guardian.setActiveAttackTarget(0);
			this.guardian.setTarget((LivingEntity) null);
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		public void tick() {
			LivingEntity livingentity = this.guardian.getTarget();
			if (livingentity != null) {
				this.guardian.getNavigation().stop();
				this.guardian.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
				if (!this.guardian.hasLineOfSight(livingentity)) {
					this.guardian.setTarget((LivingEntity) null);
				} else {
					++this.attackTime;
					if (this.attackTime == 0) {
						this.guardian.setActiveAttackTarget(livingentity.getId());
						if (!this.guardian.isSilent()) {
							this.guardian.level.broadcastEntityEvent(this.guardian, (byte) 21);
						}
					} else if (this.attackTime >= this.guardian.getAttackDuration()) {
						float f = 1.0F;
						if (this.guardian.level.getDifficulty() == Difficulty.HARD) {
							f += 2.0F;
						}
						livingentity.hurt(DamageSource.indirectMagic(this.guardian, this.guardian), f);
						livingentity.hurt(DamageSource.mobAttack(this.guardian), (float) this.guardian.getAttributeValue(Attributes.ATTACK_DAMAGE));
						this.guardian.setTarget((LivingEntity) null);
					}

					super.tick();
				}
			}
		}
	}
}
