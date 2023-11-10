package net.grinner117.forgottendragons.entity.type;

import net.grinner117.forgottenmobs.entity.type.Dragon;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BlueDragon extends Dragon {
	private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(Ghast.class, EntityDataSerializers.BOOLEAN);

	public BlueDragon(EntityType<? extends Dragon> p_33101_, Level p_33102_) {
		super(p_33101_, p_33102_);
	}

	public int getMaxSpawnClusterSize() {
		return 1;
	}

	//particle effect
	@Override
	public void aiStep() {
		super.aiStep();
		if (this.level.isClientSide) {
			float f = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			float f1 = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.level.addParticle(ParticleTypes.BUBBLE, this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), this.getY() + 0.5D + (double) (this.random.nextFloat() * this.getBbHeight()), this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), 1.0D, 1.0D, 1.0D);
			}
		}
	}

	public void tick() {
		super.tick();
		if (this.level.isClientSide) {
			float f = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			float f1 = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.PHANTOM_FLAP, this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F, false);
			}

			super.tick();
			if (this.level.isClientSide) {
				for (int i = 0; i < 8; ++i) {
					this.level.addParticle(ParticleTypes.ELECTRIC_SPARK, this.getRandomX(0.2D), this.getRandomY(), this.getRandomZ(8.0D), 0.5D, 0.5D, 0.5D);
				}
			}
		}
	}
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_IS_CHARGING, false);
	}

	public void setCharging(boolean pCharging) {
		this.entityData.set(DATA_IS_CHARGING, pCharging);
	}

	protected boolean shouldDespawnInPeaceful() {
		return true;
	}



	//add goal
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BlueDragon.LightningAttackGoal(this));
	}

	//custom lighting attack
	class LightningAttackGoal extends Goal {
		private final BlueDragon parentEntity;
		public int attackTimer;

		public LightningAttackGoal(BlueDragon ghast) {
			this.parentEntity = ghast;
		}

		public boolean canUse() {
			return this.parentEntity.getTarget() != null;
		}

		public void start() {
			this.attackTimer = 0;
		}

		public void stop() {
			this.parentEntity.setCharging(false);
		}

		public void tick() {
			LivingEntity livingentity = this.parentEntity.getTarget();
			double d0 = 64.0D;
			if (livingentity.distanceToSqr(this.parentEntity) < 4096.0D && this.parentEntity.hasLineOfSight(livingentity)) {
				Level level = this.parentEntity.level;
				++this.attackTimer;
				if (this.attackTimer == 10) {
					level.levelEvent((Player) null, 1015, this.parentEntity.blockPosition(), 0);
				}

				if (this.attackTimer == 20) {
					double d1 = 4.0D;
					Vec3 vec3d = this.parentEntity.getViewVector(1.0F);
					double d2 = livingentity.getX() - (this.parentEntity.getX() + vec3d.x * 4.0D);
					double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
					double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vec3d.z * 4.0D);
					level.levelEvent((Player) null, 1016, this.parentEntity.blockPosition(), 0);
					BlueDragon.this.performRangedAttack();
					BlueDragon.this.setCharging(false);
					this.attackTimer = -40;
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}

			this.parentEntity.setCharging(this.attackTimer > 10);
		}
	}
	public void performRangedAttack() {
		double d0 = this.getAttackReachSqr(this.getTarget());
		double d1 = this.getX() - this.getTarget().getX();
		double d2 = this.getY(0.5D) - this.getTarget().getY(0.5D);
		double d3 = this.getZ() - this.getTarget().getZ();
		double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
		d1 = d1 / d4;
		d2 = d2 / d4;
		d3 = d3 / d4;
		double d5 = this.random.nextDouble();
		while (d5 < d4) {
			d5 += 1.8D - d0 + this.random.nextDouble() * (1.7D - d0);
			this.level.addParticle(ParticleTypes.ELECTRIC_SPARK, this.getX() + d1 * d5, this.getY(0.5D) + d2 * d5, this.getZ() + d3 * d5, 0.01D, 0.01D, 0.01D);
		}
	}

	private double getAttackReachSqr(LivingEntity target) {
		return (double) (this.getBbWidth() * 2.0F * this.getBbWidth() * 2.0F + target.getBbWidth());

	}

}