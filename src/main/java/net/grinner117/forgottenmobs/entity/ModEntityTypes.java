package net.grinner117.forgottenmobs.entity;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.grinner117.forgottenmobs.entity.projectile.NeedleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenMobs.MODID);
	public static final RegistryObject<EntityType<AnimatedDiamondArmorEntity>> ANIMATEDDIAMONDARMOR =
			ENTITY_TYPES.register("animateddiamondarmor",
					() -> EntityType.Builder.of(AnimatedDiamondArmorEntity::new, MobCategory.MONSTER)
							.sized(0.7F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animateddiamondarmor").toString()));

	public static final RegistryObject<EntityType<AnimatedLeatherArmorEntity>> ANIMATEDLEATHERARMOR =
			ENTITY_TYPES.register("animatedleatherarmor",
					() -> EntityType.Builder.of(AnimatedLeatherArmorEntity::new, MobCategory.MONSTER)
							.sized(0.7F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animatedleatherarmor").toString()));
	public static final RegistryObject<EntityType<AnimatedIronArmorEntity>> ANIMATEDIRONARMOR =
			ENTITY_TYPES.register("animatedironarmor",
					() -> EntityType.Builder.of(AnimatedIronArmorEntity::new, MobCategory.MONSTER)
							.sized(0.7F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animatedironarmor").toString()));
	public static final RegistryObject<EntityType<AnimatedGoldArmorEntity>> ANIMATEDGOLDARMOR =
			ENTITY_TYPES.register("animatedgoldarmor",
					() -> EntityType.Builder.of(AnimatedGoldArmorEntity::new, MobCategory.MONSTER)
							.sized(0.7F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animatedgoldarmor").toString()));

	public static final RegistryObject<EntityType<CouatlEntity>> COUATL =
			ENTITY_TYPES.register("couatl",
					() -> EntityType.Builder.of(CouatlEntity::new, MobCategory.MONSTER)
							.sized(12.0F, 4.0F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenMobs.MODID, "couatl").toString()));

	public static final RegistryObject<EntityType<Beholder71Entity>> BEHOLDER71 =
			ENTITY_TYPES.register("beholder71",
					() -> EntityType.Builder.of(Beholder71Entity::new, MobCategory.MONSTER)
							.sized(2.0F, 3.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "beholder71").toString()));

	public static final RegistryObject<EntityType<Beholder72Entity>> BEHOLDER72 =
			ENTITY_TYPES.register("beholder72",
					() -> EntityType.Builder.of(Beholder72Entity::new, MobCategory.MONSTER)
							.sized(2.0F, 3.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "beholder72").toString()));

	public static final RegistryObject<EntityType<GreenHagEntity>> GREENHAG =
			ENTITY_TYPES.register("greenhag",
					() -> EntityType.Builder.of(GreenHagEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 2.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "greenhag").toString()));


	public static final RegistryObject<EntityType<NeedleBlightEntity>> NEEDLEBLIGHT =
			ENTITY_TYPES.register("needleblight",
					() -> EntityType.Builder.of(NeedleBlightEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 2.0F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "needleblight").toString()));
	public static final RegistryObject<EntityType<TwigBlightEntity>> TWIGBLIGHT =
			ENTITY_TYPES.register("twigblight",
					() -> EntityType.Builder.of(TwigBlightEntity::new, MobCategory.MONSTER)
							.sized(0.8F, 1.4F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "twigblight").toString()));
	public static final RegistryObject<EntityType<VineBlightEntity>> VINEBLIGHT =
			ENTITY_TYPES.register("vineblight",
					() -> EntityType.Builder.of(VineBlightEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 1.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "vineblight").toString()));

	public static final RegistryObject<EntityType<NeedleEntity>> NEEDLE = ENTITY_TYPES.register("needle",
			() -> EntityType.Builder.of((EntityType.EntityFactory<NeedleEntity>) NeedleEntity::new, MobCategory.MISC)
					.sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
					.build(new ResourceLocation(ForgottenMobs.MODID, "needle").toString()));

	public static final RegistryObject<EntityType<IntellectDevourerEntity>> INTELLECTDEVOURER =
			ENTITY_TYPES.register("intellectdevourer",
					() -> EntityType.Builder.of(IntellectDevourerEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "intellectdevourer").toString()));
	public static final RegistryObject<EntityType<CloudGiantEntity>> CLOUDGIANT =
			ENTITY_TYPES.register("cloudgiant",
					() -> EntityType.Builder.of(CloudGiantEntity::new, MobCategory.MONSTER)
							.sized(5.0F, 10.0F).clientTrackingRange(100)
							.build(new ResourceLocation(ForgottenMobs.MODID, "cloudgiant").toString()));
	public static final RegistryObject<EntityType<MindflayerEntity>> MINDFLAYER =
			ENTITY_TYPES.register("mindflayer",
					() -> EntityType.Builder.of(MindflayerEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 2.0F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "mindflayer").toString()));
	public static final RegistryObject<EntityType<GhostEntity>> GHOST =
			ENTITY_TYPES.register("ghost",
					() -> EntityType.Builder.of(GhostEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 2.0F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "ghost").toString()));
	public static final RegistryObject<EntityType<DBeastEntity>> DBEAST =
			ENTITY_TYPES.register("dbeast",
					() -> EntityType.Builder.of(DBeastEntity::new, MobCategory.MONSTER)
							.sized(2.0F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "dbeast").toString()));
	public static final RegistryObject<EntityType<IDBeastEntity>> IDBEAST =
			ENTITY_TYPES.register("idbeast",
					() -> EntityType.Builder.of(IDBeastEntity::new, MobCategory.MONSTER)
							.sized(2.0F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "idbeast").toString()));
	public static final RegistryObject<EntityType<GrimlockEntity>> GRIMLOCK =
			ENTITY_TYPES.register("grimlock",
					() -> EntityType.Builder.of(GrimlockEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 2.5F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "grimlock").toString()));
	public static final RegistryObject<EntityType<ShamblingMoundEntity>> SHAMBLINGMOUND =
			ENTITY_TYPES.register("shamblingmound",
					() -> EntityType.Builder.of(ShamblingMoundEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 2.5F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "shamblingmound").toString()));


	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
