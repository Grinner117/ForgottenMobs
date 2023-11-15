package net.grinner117.forgottenmobs.entity.type;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;
import java.util.List;

public class Blight extends Monster implements GeoEntity {
	private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
	private ClientLevel level;

	public Blight(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Chicken.class, 0, false, false, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test));
	}
		//weak to fire
	@Override
	public boolean isOnFire() {
		return super.isOnFire();
	}

	//heals over time
	public void aiStep() {
		super.aiStep();
		if (this.tickCount % 500 == 0) {
			this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 0, false, false, false));
		}

		if (this.level.isClientSide) {
			for (int i = 0; i < 2; ++i) {
				this.level.addParticle(ParticleTypes.MYCELIUM, this.getRandomX(0.3D), this.getRandomY() - 0.23D, this.getRandomZ(0.3D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
			}
		}
		super.aiStep();
	}

	//sounds
	//Ambient
	@Override
	public void playAmbientSound() {
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent == SoundEvents.FOX_SCREECH) {
			this.playSound(soundevent, 4.0F, this.getVoicePitch());
		} else {
			super.playAmbientSound();
		}
	}

	@Nullable
	protected SoundEvent getAmbientSound() {
		if (this.isSleeping()) {
			return SoundEvents.ZOMBIE_AMBIENT;
		} else {
			if (!this.level.isDay() && this.random.nextFloat() < 0.1F) {
				List<Player> list = this.level.getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(16.0D, 16.0D, 16.0D), EntitySelector.NO_SPECTATORS);
				if (list.isEmpty()) {
					return SoundEvents.ENDERMAN_SCREAM;
				}
			}

			return SoundEvents.ZOMBIE_AMBIENT;
		}
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.GRASS_BREAK;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENDERMAN_DEATH;
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.GRASS_BREAK;

	}

	//adds animations
	private PlayState predicate(AnimationState animationState) {
		if (animationState.isMoving()) {
			animationState.getController().setAnimation(RawAnimation.begin().then("animation.blight.walk", Animation.LoopType.LOOP));
			return PlayState.CONTINUE;
		}
		animationState.getController().setAnimation(RawAnimation.begin().then("animation.blight.idle", Animation.LoopType.LOOP));
		return PlayState.CONTINUE;
	}

	private PlayState attackPredicate(AnimationState state) {
		if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
			state.getController().forceAnimationReset();
			state.getController().setAnimation((RawAnimation.begin().then("animation.blight.attack", Animation.LoopType.PLAY_ONCE)));
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
		return factory;
	}
}