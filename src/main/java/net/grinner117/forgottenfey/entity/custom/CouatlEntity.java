package net.grinner117.forgottenfey.entity.custom;

import net.grinner117.radiantlibrary.effects.ModEffects;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
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

import javax.annotation.Nullable;
import java.util.EnumSet;

public class CouatlEntity extends FlyingMob implements Enemy, IAnimatable {
	AnimationFactory manager = GeckoLibUtil.createFactory(this);
	public static final float FLAP_DEGREES_PER_TICK = 7.448451F;
	public static final int TICKS_PER_FLAP = Mth.ceil(24.166098F);
	private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(CouatlEntity.class, EntityDataSerializers.INT);
	Vec3 moveTargetPoint = Vec3.ZERO;
	BlockPos anchorPoint = BlockPos.ZERO;
	CouatlEntity.AttackPhase attackPhase = CouatlEntity.AttackPhase.CIRCLE;

	public CouatlEntity(EntityType<? extends CouatlEntity> p_33101_, Level p_33102_) {
		super(p_33101_, p_33102_);
		this.xpReward = 2000;
		this.moveControl = new CouatlEntity.PhantomMoveControl(this);
		this.lookControl = new CouatlEntity.PhantomLookControl(this);
	}

	public boolean isFlapping() {
		return (this.getUniqueFlapTickOffset() + this.tickCount) % TICKS_PER_FLAP == 0;
	}

	protected BodyRotationControl createBodyControl() {
		return new CouatlEntity.PhantomBodyRotationControl(this);
	}


	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 400.0D)
				.add(Attributes.ARMOR_TOUGHNESS, 16.0D)
				.add(Attributes.ATTACK_DAMAGE, 14.0D)
				.add(Attributes.ATTACK_SPEED, 1.0F)
				.add(Attributes.MOVEMENT_SPEED, 0.1F)
				.build();
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(3, new CouatlEntity.PhantomCircleAroundAnchorGoal());
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 64.0F));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Mob.class, 64.0F));
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

	//give neaby players mob effect
	public void customServerAiStep() {
		super.customServerAiStep();
		if (this.tickCount % 30 == 0) {
			for (Player player : this.level.getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(200.0D))) {
				if (!player.isCreative() && !player.isSpectator()) {
					player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0, false, false, false));
					player.addEffect(new MobEffectInstance(MobEffects.HEAL, 100, 0, false, false, false));
					player.addEffect(new MobEffectInstance(ModEffects.RECOVERY_EFFECT.get(), 100, 1, false, false, false));
				}
			}
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33126_, DifficultyInstance p_33127_, MobSpawnType p_33128_, @Nullable SpawnGroupData p_33129_, @Nullable CompoundTag p_33130_) {
		this.anchorPoint = this.blockPosition().above(10);
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
		return SoundSource.NEUTRAL;
	}

	protected SoundEvent getHurtSound(DamageSource p_33152_) {
		return SoundEvents.TRIDENT_THUNDER;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENDER_DRAGON_DEATH;
	}

	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected float getSoundVolume() {
		return 10.0F;
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

	class PhantomBodyRotationControl extends BodyRotationControl {
		public PhantomBodyRotationControl(Mob p_33216_) {
			super(p_33216_);
		}

		public void clientTick() {
			CouatlEntity.this.yHeadRot = CouatlEntity.this.yBodyRot;
			CouatlEntity.this.yBodyRot = CouatlEntity.this.getYRot();
		}
	}

	class PhantomCircleAroundAnchorGoal extends CouatlEntity.PhantomMoveTargetGoal {
		private float angle;
		private float distance;
		private float height;
		private float clockwise;

		public boolean canUse() {
			return CouatlEntity.this.getTarget() == null || CouatlEntity.this.attackPhase == CouatlEntity.AttackPhase.CIRCLE;
		}

		public void start() {
			this.distance = 64.0F + CouatlEntity.this.random.nextFloat() * 10.0F;
			this.height = 40.0F + CouatlEntity.this.random.nextFloat() * 9.0F;
			this.clockwise = CouatlEntity.this.random.nextBoolean() ? 1.0F : -1.0F;
			this.selectNext();
		}

		public void tick() {
			if (CouatlEntity.this.random.nextInt(this.adjustedTickDelay(350)) == 0) {
				this.height = 50.0F + CouatlEntity.this.random.nextFloat() * 9.0F;
			}

			if (CouatlEntity.this.random.nextInt(this.adjustedTickDelay(250)) == 0) {
				++this.distance;
				if (this.distance > 45.0F) {
					this.distance = 50.0F;
					this.clockwise = -this.clockwise;
				}
			}

			if (CouatlEntity.this.random.nextInt(this.adjustedTickDelay(450)) == 0) {
				this.angle = CouatlEntity.this.random.nextFloat() * 2.0F * (float) Math.PI;
				this.selectNext();
			}

			if (this.touchingTarget()) {
				this.selectNext();
			}

			if (CouatlEntity.this.moveTargetPoint.y < CouatlEntity.this.getY() && !CouatlEntity.this.level.isEmptyBlock(CouatlEntity.this.blockPosition().below(1))) {
				this.height = Math.max(1.0F, this.height);
				this.selectNext();
			}

			if (CouatlEntity.this.moveTargetPoint.y > CouatlEntity.this.getY() && !CouatlEntity.this.level.isEmptyBlock(CouatlEntity.this.blockPosition().above(1))) {
				this.height = Math.min(-1.0F, this.height);
				this.selectNext();
			}

		}

		private void selectNext() {
			if (BlockPos.ZERO.equals(CouatlEntity.this.anchorPoint)) {
				CouatlEntity.this.anchorPoint = CouatlEntity.this.blockPosition();
			}

			this.angle += this.clockwise * 15.0F * ((float) Math.PI / 180F);
			CouatlEntity.this.moveTargetPoint = Vec3.atLowerCornerOf(CouatlEntity.this.anchorPoint).add((double) (this.distance * Mth.cos(this.angle)), (double) (-4.0F + this.height), (double) (this.distance * Mth.sin(this.angle)));
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
		private float speed = 0.09F;

		public PhantomMoveControl(Mob p_33241_) {
			super(p_33241_);
		}

		public void tick() {
			if (CouatlEntity.this.horizontalCollision) {
				CouatlEntity.this.setYRot(CouatlEntity.this.getYRot() + 180.0F);
				this.speed = 0.06F;
			}
			double d0 = CouatlEntity.this.moveTargetPoint.x - CouatlEntity.this.getX();
			double d1 = CouatlEntity.this.moveTargetPoint.y - CouatlEntity.this.getY();
			double d2 = CouatlEntity.this.moveTargetPoint.z - CouatlEntity.this.getZ();
			double d3 = Math.sqrt(d0 * d0 + d2 * d2);
			if (Math.abs(d3) > (double) 1.0E-5F) {
				double d4 = 1.0D - Math.abs(d1 * (double) 0.7F) / d3;
				d0 *= d4;
				d2 *= d4;
				d3 = Math.sqrt(d0 * d0 + d2 * d2);
				double d5 = Math.sqrt(d0 * d0 + d2 * d2 + d1 * d1);
				float f = CouatlEntity.this.getYRot();
				float f1 = (float) Mth.atan2(d2, d0);
				float f2 = Mth.wrapDegrees(CouatlEntity.this.getYRot() + 90.0F);
				float f3 = Mth.wrapDegrees(f1 * (180F / (float) Math.PI));
				CouatlEntity.this.setYRot(Mth.approachDegrees(f2, f3, 4.0F) - 90.0F);
				CouatlEntity.this.yBodyRot = CouatlEntity.this.getYRot();
				if (Mth.degreesDifferenceAbs(f, CouatlEntity.this.getYRot()) < 3.0F) {
					this.speed = Mth.approach(this.speed, 1.8F, 0.005F * (1.8F / this.speed));
				} else {
					this.speed = Mth.approach(this.speed, 0.2F, 0.025F);
				}

				float f4 = (float) (-(Mth.atan2(-d1, d3) * (double) (180F / (float) Math.PI)));
				CouatlEntity.this.setXRot(f4);
				float f5 = CouatlEntity.this.getYRot() + 90.0F;
				double d6 = (double) (this.speed * Mth.cos(f5 * ((float) Math.PI / 180F))) * Math.abs(d0 / d5);
				double d7 = (double) (this.speed * Mth.sin(f5 * ((float) Math.PI / 180F))) * Math.abs(d2 / d5);
				double d8 = (double) (this.speed * Mth.sin(f4 * ((float) Math.PI / 180F))) * Math.abs(d1 / d5);
				Vec3 vec3 = CouatlEntity.this.getDeltaMovement();
				CouatlEntity.this.setDeltaMovement(vec3.add((new Vec3(d6, d8, d7)).subtract(vec3).scale(0.2D)));
			}

		}
	}

	abstract class PhantomMoveTargetGoal extends Goal {
		public PhantomMoveTargetGoal() {
			this.setFlags(EnumSet.of(Flag.MOVE));
		}

		protected boolean touchingTarget() {
			return CouatlEntity.this.moveTargetPoint.distanceToSqr(CouatlEntity.this.getX(), CouatlEntity.this.getY(), CouatlEntity.this.getZ()) < 4.0D;
		}
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.couatl.walk", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.couatl.idle", true));
		return PlayState.CONTINUE;
	}

	private PlayState attackPredicate(AnimationEvent event) {
		if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
			event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.couatl.attack", false));
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

	//if stuck in a wall, tp up 10 blocks
	public void stuckInTheGround() {
		this.teleportTo(this.getX(), this.getY() + 20, this.getZ());
	}

	//if taking suffocation damage tp up 10 blocks
	//if under 100 blocks in the world, tp up 10 blocks

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isInWall()) {
			this.stuckInTheGround();
		}
		if (this.getY() < 100) {
			this.stuckInTheGround();
		}
	}

	//if in water tp up 10 blocks
	@Override
	public void travel(Vec3 p_33094_) {
		if (this.isEffectiveAi() && this.isInWater()) {
			this.stuckInTheGround();
		} else {
			super.travel(p_33094_);
		}
	}

	//spawn above y 120
	@Override
	public boolean checkSpawnRules(LevelAccessor p_33099_, MobSpawnType p_33100_) {
		return this.getY() > 120 && super.checkSpawnRules(p_33099_, p_33100_);
	}
//despawn at night
	@Override
	public boolean removeWhenFarAway(double p_33096_) {
		return this.isPersistenceRequired() && !this.isEffectiveAi() && this.level.isNight();
	}

}