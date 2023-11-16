package net.grinner117.forgottenmobs.entity;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.*;
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
							.sized(0.5F, 1.5F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animateddiamondarmor").toString()));
	public static final RegistryObject<EntityType<AnimatedLeatherArmorEntity>> ANIMATEDLEATHERARMOR =
			ENTITY_TYPES.register("animatedleatherarmor",
					() -> EntityType.Builder.of(AnimatedLeatherArmorEntity::new, MobCategory.MONSTER)
							.sized(0.5F, 1.5F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animatedleatherarmor").toString()));
	public static final RegistryObject<EntityType<AnimatedIronArmorEntity>> ANIMATEDIRONARMOR =
			ENTITY_TYPES.register("animatedironarmor",
					() -> EntityType.Builder.of(AnimatedIronArmorEntity::new, MobCategory.MONSTER)
							.sized(0.5F, 1.5F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animatedironarmor").toString()));
	public static final RegistryObject<EntityType<AnimatedGoldArmorEntity>> ANIMATEDGOLDARMOR =
			ENTITY_TYPES.register("animatedgoldarmor",
					() -> EntityType.Builder.of(AnimatedGoldArmorEntity::new, MobCategory.MONSTER)
							.sized(0.5F, 1.5F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenMobs.MODID, "animatedgoldarmor").toString()));

	public static final RegistryObject<EntityType<CloudGiantEntity>> CLOUDGIANT =
			ENTITY_TYPES.register("cloudgiant",
					() -> EntityType.Builder.of(CloudGiantEntity::new, MobCategory.MONSTER)
							.sized(0.4F, 1.0F).clientTrackingRange(300)
							.build(new ResourceLocation(ForgottenMobs.MODID, "cloudgiant").toString()));
	public static final RegistryObject<EntityType<GhostEntity>> GHOST =
			ENTITY_TYPES.register("ghost",
					() -> EntityType.Builder.of(GhostEntity::new, MobCategory.MONSTER)
							.sized(0.7F, 0.7F).clientTrackingRange(300)
							.build(new ResourceLocation(ForgottenMobs.MODID, "ghost").toString()));


	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
