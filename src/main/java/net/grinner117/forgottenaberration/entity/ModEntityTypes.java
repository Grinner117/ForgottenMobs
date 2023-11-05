package net.grinner117.forgottenaberration.entity;

import net.grinner117.forgottenaberration.ForgottenAberration;
import net.grinner117.forgottenaberration.entity.custom.IDBeastEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenAberration.MODID);


	public static final RegistryObject<EntityType<net.grinner117.forgottenaberration.entity.custom.Beholder71Entity>> BEHOLDER71 =
			ENTITY_TYPES.register("beholder71",
					() -> EntityType.Builder.of(net.grinner117.forgottenaberration.entity.custom.Beholder71Entity::new, MobCategory.MONSTER)
							.sized(2.0F, 3.0F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenAberration.MODID, "beholder71").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottenaberration.entity.custom.Beholder72Entity>> BEHOLDER72 =
			ENTITY_TYPES.register("beholder72",
					() -> EntityType.Builder.of(net.grinner117.forgottenaberration.entity.custom.Beholder72Entity::new, MobCategory.MONSTER)
							.sized(2.0F, 3.0F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenAberration.MODID, "beholder72").toString()));


	public static final RegistryObject<EntityType<net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity>> INTELLECTDEVOURER =
			ENTITY_TYPES.register("intellectdevourer",
					() -> EntityType.Builder.of(net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenAberration.MODID, "intellectdevourer").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottenaberration.entity.custom.MindflayerEntity>> MINDFLAYER =
			ENTITY_TYPES.register("mindflayer",
					() -> EntityType.Builder.of(net.grinner117.forgottenaberration.entity.custom.MindflayerEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 2.0F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenAberration.MODID, "mindflayer").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottenaberration.entity.custom.DBeastEntity>> DBEAST =
			ENTITY_TYPES.register("dbeast",
					() -> EntityType.Builder.of(net.grinner117.forgottenaberration.entity.custom.DBeastEntity::new, MobCategory.MONSTER)
							.sized(2.0F, 1.8F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenAberration.MODID, "dbeast").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottenaberration.entity.custom.IDBeastEntity>> IDBEAST =
			ENTITY_TYPES.register("idbeast",
					() -> EntityType.Builder.of(IDBeastEntity::new, MobCategory.MONSTER)
							.sized(2.0F, 1.8F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenAberration.MODID, "idbeast").toString()));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
