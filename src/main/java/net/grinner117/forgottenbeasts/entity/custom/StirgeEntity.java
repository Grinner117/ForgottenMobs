package net.grinner117.forgottenbeasts.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
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


public class StirgeEntity extends Monster implements IAnimatable, FlyingAnimal {
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(StirgeEntity.class, EntityDataSerializers.INT);
	AnimationFactory manager = GeckoLibUtil.createFactory(this);

	public StirgeEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		this.xpReward = 3;

	}


	//can fly like bee/ moves like a bee
	public boolean isFlying() {
		return !this.onGround;
	}


	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 1.0D)
				.add(Attributes.ATTACK_DAMAGE, 1.0D)
				.add(Attributes.ATTACK_SPEED, 0.1F)
				.add(Attributes.FOLLOW_RANGE, 32.0D)
				.add(Attributes.MOVEMENT_SPEED, 1.0F)
				.add(Attributes.FLYING_SPEED, 1.0F)
				.build();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0F, true));

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


	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
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
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.stirge.walk", true));
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
