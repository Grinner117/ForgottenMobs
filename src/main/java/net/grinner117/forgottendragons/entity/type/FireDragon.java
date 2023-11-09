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
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireDragon extends Dragon {
	private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(Ghast.class, EntityDataSerializers.BOOLEAN);

	public FireDragon(EntityType<? extends Dragon> p_33101_, Level p_33102_) {
		super(p_33101_, p_33102_);
	}
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_IS_CHARGING, false);
	}
	private int explosionPower = 30;

	public int getMaxSpawnClusterSize() {
		return 1;
	}

	public void setCharging(boolean pCharging) {
		this.entityData.set(DATA_IS_CHARGING, pCharging);
	}

	protected boolean shouldDespawnInPeaceful() {
		return true;
	}

	//	particle effect
	@Override
	public void aiStep() {
		super.aiStep();
		if (this.level.isClientSide) {
			float f = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			float f1 = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), this.getY() + 0.5D + (double) (this.random.nextFloat() * this.getBbHeight()), this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 1.0F) - (double) this.getBbWidth(), 1.0D, 1.0D, 1.0D);
			}
		}
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

	}

	//immune to fireball damage source
	public boolean hurtByFireball(LargeFireball p_38398_) {
		this.teleport();
		this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1.0F, 1.0F);
		return false;
	}

	//immune to magic damage source
	public boolean hurtByMagic(LivingEntity p_38394_) {
		this.teleport();
		return false;
	}

	//immune to fire damage source
	public boolean hurtByFire() {
		this.teleport();
		return false;
	}

	//immune to suffocation damage source
	public boolean hurtByBlock() {
		this.teleport();
		this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1.0F, 1.0F);

		return false;
	}

	//if it takes arrow damage, tp away
	public boolean hurtByArrow() {
		this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 0.2F, 1.0F);
		return false;
	}

	//if it takes damage from player, tp away
	public boolean hurtByPlayer(Player p_38396_) {
		this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 0.2F, 1.0F);
		return true;
	}

	//define teleport
	public void teleport() {
		Vec3 vec3 = this.getDeltaMovement();
		this.setDeltaMovement(-vec3.x, vec3.y, -vec3.z);
		this.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1.0F, 1.0F);
	}

	//give fireball attack
	static class ShootFireballGoal extends Goal {
		private final FireDragon ghast;
		public int chargeTime;

		public ShootFireballGoal(FireDragon pGhast) {
			this.ghast = pGhast;
		}

		public boolean canUse() {
			return this.ghast.getTarget() != null;
		}

		public void start() {
			this.chargeTime = 0;
		}

		public void stop() {
			this.ghast.setCharging(false);
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

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