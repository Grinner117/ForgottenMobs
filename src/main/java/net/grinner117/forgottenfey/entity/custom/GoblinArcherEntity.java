package net.grinner117.forgottenfey.entity.custom;

import net.grinner117.forgottenmobs.entity.custom.Beholder71Entity;
import net.grinner117.forgottenmobs.entity.custom.Beholder72Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
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
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class GoblinArcherEntity extends Monster implements RangedAttackMob, IAnimatable {
	AnimationFactory manager = GeckoLibUtil.createFactory(this);
	private final RangedBowAttackGoal<GoblinArcherEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
	private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
		public void stop() {
			super.stop();
			GoblinArcherEntity.this.setAggressive(false);
		}

		public void start() {
			super.start();
			GoblinArcherEntity.this.setAggressive(true);
		}
	};


	//class constructor
	public GoblinArcherEntity(EntityType<? extends GoblinArcherEntity> p_32133_, Level p_32134_) {
		super(p_32133_, p_32134_);
		this.xpReward = 20;
	}

	//stat block
	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 3.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D)
				.add(Attributes.ATTACK_SPEED, 0.8F)
				.add(Attributes.MOVEMENT_SPEED, 0.4F)
				.add(Attributes.FOLLOW_RANGE, 32.0D)
				.build();
	}


	//goals overide
	@Override
	protected void registerGoals() {

		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 6.0F, 1.0D, 1.0D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Beholder71Entity.class, 6.0F, 1.0D, 1.0D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Beholder72Entity.class, 6.0F, 1.0D, 1.0D));
		this.goalSelector.addGoal(1, new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Chicken.class, 0, false, false, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test));

	}

	public void reassessWeaponGoal() {
		if (this.level != null && !this.level.isClientSide) {
			this.goalSelector.removeGoal(this.meleeGoal);
			this.goalSelector.removeGoal(this.bowGoal);
			ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem));
			if (itemstack.is(Items.BOW)) {
				int i = 20;
				if (this.level.getDifficulty() != Difficulty.HARD) {
					i = 40;
				}

				this.bowGoal.setMinAttackInterval(i);
				this.goalSelector.addGoal(4, this.bowGoal);
			} else {
				this.goalSelector.addGoal(4, this.meleeGoal);
			}

		}
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
		pSpawnData = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
		RandomSource randomsource = pLevel.getRandom();
		this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
		this.populateDefaultEquipmentEnchantments(randomsource, pDifficulty);
		this.reassessWeaponGoal();
		this.setCanPickUpLoot(randomsource.nextFloat() < 0.55F * pDifficulty.getSpecialMultiplier());

		return pSpawnData;
	}
    public void setItemSlot(EquipmentSlot pSlot, ItemStack pStack) {
        super.setItemSlot(pSlot, pStack);
        if (!this.level.isClientSide) {
            this.reassessWeaponGoal();
        }

    }

	//immune to arrow damage
	public boolean hurt(DamageSource pSource, float pAmount) {
		if (pSource.getDirectEntity() instanceof AbstractArrow) {
			return false;
		} else {
			return super.hurt(pSource, pAmount);
		}
	}
	protected AbstractArrow getArrow(ItemStack pArrowStack, float pVelocity) {
		return ProjectileUtil.getMobArrow(this, pArrowStack, pVelocity);
	}

	public boolean canFireProjectileWeapon(ProjectileWeaponItem pProjectileWeapon) {
		return pProjectileWeapon == Items.BOW;
	}

	protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
		super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
	}

	//sounds
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

	//animations
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinarcher.walk", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinarcher.idle", true));
		return PlayState.CONTINUE;
	}

	private PlayState attackPredicate(AnimationEvent event) {
		if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
			event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblinarcher.attack", false));
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

	@Override
	public void performRangedAttack(LivingEntity pTarget, float pDistanceFactor) {
		ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem)));
		AbstractArrow abstractarrow = this.getArrow(itemstack, pDistanceFactor);
		if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
			abstractarrow = ((net.minecraft.world.item.BowItem) this.getMainHandItem().getItem()).customArrow(abstractarrow);
		double d0 = pTarget.getX() - this.getX();
		double d1 = pTarget.getY(0.3333333333333333D) - abstractarrow.getY();
		double d2 = pTarget.getZ() - this.getZ();
		double d3 = Math.sqrt(d0 * d0 + d2 * d2);
		abstractarrow.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
		this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
		this.level.addFreshEntity(abstractarrow);
	}
}
