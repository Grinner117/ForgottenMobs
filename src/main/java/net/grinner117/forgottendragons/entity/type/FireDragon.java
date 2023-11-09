package net.grinner117.forgottendragons.entity.type;

import net.grinner117.forgottenmobs.entity.type.Dragon;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireDragon extends Dragon {
	private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(Ghast.class, EntityDataSerializers.BOOLEAN);

	public FireDragon(EntityType<? extends Dragon> p_33101_, Level p_33102_) {
		super(p_33101_, p_33102_);
	}

	private int explosionPower = 1;

	public int getMaxSpawnClusterSize() {
		return 1;
	}


	public void setCharging(boolean pCharging) {
		this.entityData.set(DATA_IS_CHARGING, pCharging);
	}

	//	particle effect
	@Override
	public void aiStep() {
		super.aiStep();
		if (this.level.isClientSide) {
			float f = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			float f1 = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), this.getY() + 0.5D + (double) (this.random.nextFloat() * this.getBbHeight()), this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), 1.0D, 1.0D, 1.0D);
			}
		}
		//has mobeffect

	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(5, new FireDragon.ShootFireballGoal(this));

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
					this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(0.2D), this.getRandomY(), this.getRandomZ(10.0D), 0.4D, 0.4D, 0.4D);
				}
			}
		}
		//has fire restance

		if (level.isClientSide()) {
			this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 100, false, false, true));
		}
	}

	//give fireball attack
	static class ShootFireballGoal extends Goal {
		private final FireDragon ghast;
		public int chargeTime;

		public ShootFireballGoal(FireDragon pGhast) {
			this.ghast = pGhast;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.ghast.getTarget() != null;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.chargeTime = 0;
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by another one
		 */
		public void stop() {
			this.ghast.setCharging(false);
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			LivingEntity livingentity = this.ghast.getTarget();
			if (livingentity != null) {
				double d0 = 64.0D;
				if (livingentity.distanceToSqr(this.ghast) < 4096.0D && this.ghast.hasLineOfSight(livingentity)) {
					Level level = this.ghast.level;
					++this.chargeTime;
					if (this.chargeTime == 10 && !this.ghast.isSilent()) {
						level.levelEvent((Player) null, 1015, this.ghast.blockPosition(), 0);
					}

					if (this.chargeTime == 20) {
						double d1 = 4.0D;
						Vec3 vec3 = this.ghast.getViewVector(1.0F);
						double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
						double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
						double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
						if (!this.ghast.isSilent()) {
							level.levelEvent((Player) null, 1016, this.ghast.blockPosition(), 0);
						}

						LargeFireball largefireball = new LargeFireball(level, this.ghast, d2, d3, d4, this.ghast.getExplosionPower());
						largefireball.setPos(this.ghast.getX() + vec3.x * 4.0D, this.ghast.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
						level.addFreshEntity(largefireball);
						this.chargeTime = -40;
					}
				} else if (this.chargeTime > 0) {
					--this.chargeTime;
				}

				this.ghast.setCharging(this.chargeTime > 10);
			}
		}
	}

	public int getExplosionPower() {
		return this.explosionPower;
	}

}