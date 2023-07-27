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

	public static final RegistryObject<EntityType<ShadowWyrmlingEntity>> SHADOWWYRMLING =
			ENTITY_TYPES.register("shadowwyrmling",
					() -> EntityType.Builder.of(ShadowWyrmlingEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "shadowwyrmling").toString()));

	public static final RegistryObject<EntityType<ShadowYoungDragonEntity>> SHADOWYOUNGDRAGON =
			ENTITY_TYPES.register("shadowyoungdragon",
					() -> EntityType.Builder.of(ShadowYoungDragonEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "shadowyoungdragon").toString()));
	public static final RegistryObject<EntityType<ShadowAdultDragonEntity>> SHADOWADULTDRAGON =
			ENTITY_TYPES.register("shadowadultdragon",
					() -> EntityType.Builder.of(ShadowAdultDragonEntity::new, MobCategory.MONSTER)
							.sized(2.8F, 2.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "shadowadultdragon").toString()));
	public static final RegistryObject<EntityType<ShadowElderDragonEntity>> SHADOWELDERDRAGON =
			ENTITY_TYPES.register("shadowelderdragon",
					() -> EntityType.Builder.of(ShadowElderDragonEntity::new, MobCategory.MONSTER)
							.sized(3.0F, 3.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "shadowelderdragon").toString()));
	public static final RegistryObject<EntityType<WhiteWyrmlingEntity>> WHITEWYRMLING =
			ENTITY_TYPES.register("whitewyrmling",
					() -> EntityType.Builder.of(WhiteWyrmlingEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "whitewyrmling").toString()));

	public static final RegistryObject<EntityType<WhiteYoungDragonEntity>> WHITEYOUNGDRAGON =
			ENTITY_TYPES.register("whiteyoungdragon",
					() -> EntityType.Builder.of(WhiteYoungDragonEntity::new, MobCategory.MONSTER)
							.sized(4.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenMobs.MODID, "whiteyoungdragon").toString()));
	public static final RegistryObject<EntityType<WhiteAdultDragonEntity>> WHITEADULTDRAGON =
			ENTITY_TYPES.register("whiteadultdragon",
					() -> EntityType.Builder.of(WhiteAdultDragonEntity::new, MobCategory.MONSTER)
							.sized(8.8F, 2.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenMobs.MODID, "whiteadultdragon").toString()));
	public static final RegistryObject<EntityType<WhiteElderDragonEntity>> WHITEELDERDRAGON =
			ENTITY_TYPES.register("whiteelderdragon",
					() -> EntityType.Builder.of(WhiteElderDragonEntity::new, MobCategory.MONSTER)
							.sized(10.0F, 5.0F).clientTrackingRange(100)
							.build(new ResourceLocation(ForgottenMobs.MODID, "whiteelderdragon").toString()));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
