package net.grinner117.forgottenbeasts.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.horse.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
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


public class StirgeEntity extends Monster implements IAnimatable {
	AnimationFactory manager = GeckoLibUtil.createFactory(this);
	public static final int TICKS_PER_FLAP = Mth.ceil(2.4166098F);
	private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(net.minecraft.world.entity.ambient.Bat.class, EntityDataSerializers.BYTE);
	private static final TargetingConditions BAT_RESTING_TARGETING = TargetingConditions.forNonCombat().range(4.0D);
	@Nullable
	private BlockPos targetPosition;

	public StirgeEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		this.setResting(true);
		this.xpReward = 5;
	}

	public boolean isFlapping() {
		return !this.isResting() && this.tickCount % TICKS_PER_FLAP == 0;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_FLAGS, (byte) 0);
	}

	public boolean isPushable() {
		return false;
	}

	protected void doPush(Entity pEntity) {
	}

	protected void pushEntities() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D);
	}

	public boolean isResting() {
		return (this.entityData.get(DATA_ID_FLAGS) & 1) != 0;
	}

	public void setResting(boolean pIsResting) {
		byte b0 = this.entityData.get(DATA_ID_FLAGS);
		if (pIsResting) {
			this.entityData.set(DATA_ID_FLAGS, (byte) (b0 | 1));
		} else {
			this.entityData.set(DATA_ID_FLAGS, (byte) (b0 & -2));
		}

	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.isResting()) {
			this.setDeltaMovement(Vec3.ZERO);
			this.setPosRaw(this.getX(), (double) Mth.floor(this.getY()) + 1.0D - (double) this.getBbHeight(), this.getZ());
		} else {
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
		}

	}

	protected void customServerAiStep() {
		super.customServerAiStep();
		BlockPos blockpos = this.blockPosition();
		BlockPos blockpos1 = blockpos.above();
		if (this.isResting()) {
			boolean flag = this.isSilent();
			if (this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos)) {
				if (this.random.nextInt(200) == 0) {
					this.yHeadRot = (float) this.random.nextInt(360);
				}

				if (this.level.getNearestPlayer(BAT_RESTING_TARGETING, this) != null) {
					this.setResting(false);
					if (!flag) {
						this.level.levelEvent((Player) null, 1025, blockpos, 0);
					}
				}
			} else {
				this.setResting(false);
				if (!flag) {
					this.level.levelEvent((Player) null, 1025, blockpos, 0);
				}
			}
		} else {
			if (this.targetPosition != null && (!this.level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() <= this.level.getMinBuildHeight())) {
				this.targetPosition = null;
			}

			if (this.targetPosition == null || this.random.nextInt(30) == 0 || this.targetPosition.closerToCenterThan(this.position(), 2.0D)) {
				this.targetPosition = new BlockPos(this.getX() + (double) this.random.nextInt(7) - (double) this.random.nextInt(7), this.getY() + (double) this.random.nextInt(6) - 2.0D, this.getZ() + (double) this.random.nextInt(7) - (double) this.random.nextInt(7));
			}

			double d2 = (double) this.targetPosition.getX() + 0.4D - this.getX();
			double d0 = (double) this.targetPosition.getY() + 0.2D - this.getY();
			double d1 = (double) this.targetPosition.getZ() + 0.4D - this.getZ();
			Vec3 vec3 = this.getDeltaMovement();
			Vec3 vec31 = vec3.add((Math.signum(d2) * 0.5D - vec3.x) * (double) 0.1F, (Math.signum(d0) * (double) 0.7F - vec3.y) * (double) 0.1F, (Math.signum(d1) * 0.5D - vec3.z) * (double) 0.1F);
			this.setDeltaMovement(vec31);
			float f = (float) (Mth.atan2(vec31.z, vec31.x) * (double) (180F / (float) Math.PI)) - 90.0F;
			float f1 = Mth.wrapDegrees(f - this.getYRot());
			this.zza = 0.5F;
			this.setYRot(this.getYRot() + f1);
			if (this.random.nextInt(100) == 0 && this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos1)) {
				this.setResting(true);
			}
		}

	}

	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.EVENTS;
	}


	protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
	}

	/**
	 * Return whether this entity should NOT trigger a pressure plate or a tripwire.
	 */
	public boolean isIgnoringBlockTriggers() {
		return true;
	}

	public boolean hurt(DamageSource pSource, float pAmount) {
		if (this.isInvulnerableTo(pSource)) {
			return false;
		} else {
			if (!this.level.isClientSide && this.isResting()) {
				this.setResting(false);
			}

			return super.hurt(pSource, pAmount);
		}
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.entityData.set(DATA_ID_FLAGS, pCompound.getByte("BatFlags"));
	}

	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putByte("BatFlags", this.entityData.get(DATA_ID_FLAGS));
	}
	protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
		return pSize.height / 2.0F;
	}


	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 2.0D)
				.add(Attributes.ATTACK_DAMAGE, 1.0D)
				.add(Attributes.ATTACK_SPEED, 0.1F)
				.add(Attributes.FOLLOW_RANGE, 32.0D)
				.build();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 16.0F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0F, true));

		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractHorse.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Donkey.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mule.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Llama.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, TraderLlama.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Cow.class, true));

	}

	//when attack give player poison effect
	public boolean doHurtTarget(Entity entityIn) {
		boolean flag = super.doHurtTarget(entityIn);
		if (flag && this.getMainHandItem().isEmpty() && entityIn instanceof LivingEntity) {
			float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
			((LivingEntity) entityIn).addEffect(new MobEffectInstance(MobEffects.POISON, 20, 0));
		}
		return flag;
	}
	//Sound
	protected SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return SoundEvents.BEE_LOOP_AGGRESSIVE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		super.getHurtSound(damageSourceIn);
		return SoundEvents.BEE_HURT;
	}

	protected SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.BEE_DEATH;
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.BEE_LOOP_AGGRESSIVE;
	}

	protected SoundEvent getSwimSound() {
		return SoundEvents.BEE_LOOP_AGGRESSIVE;
	}

	//entity is immune to damage from falling
	public boolean causeFallDamage(float p_70097_, float p_70098_, DamageSource p_70099_) {
		return false;
	}


	//animations
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.stirge.move", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.stirge.idle", true));
		return PlayState.CONTINUE;
	}

	private PlayState attackPredicate(AnimationEvent event) {
		if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
			event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.stirge.attack", false));
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
