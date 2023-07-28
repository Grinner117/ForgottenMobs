package net.grinner117.forgottendragons.entity;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.WhiteYoungDragonEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenDragons.MODID);

	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.ShadowWyrmlingEntity>> SHADOWWYRMLING =
			ENTITY_TYPES.register("shadowwyrmling",
					() -> EntityType.Builder.of(net.grinner117.forgottendragons.entity.custom.ShadowWyrmlingEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowwyrmling").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.ShadowYoungDragonEntity>> SHADOWYOUNGDRAGON =
			ENTITY_TYPES.register("shadowyoungdragon",
					() -> EntityType.Builder.of(net.grinner117.forgottendragons.entity.custom.ShadowYoungDragonEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowyoungdragon").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.ShadowAdultDragonEntity>> SHADOWADULTDRAGON =
			ENTITY_TYPES.register("shadowadultdragon",
					() -> EntityType.Builder.of(net.grinner117.forgottendragons.entity.custom.ShadowAdultDragonEntity::new, MobCategory.MONSTER)
							.sized(2.8F, 2.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowadultdragon").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.ShadowElderDragonEntity>> SHADOWELDERDRAGON =
			ENTITY_TYPES.register("shadowelderdragon",
					() -> EntityType.Builder.of(net.grinner117.forgottendragons.entity.custom.ShadowElderDragonEntity::new, MobCategory.MONSTER)
							.sized(3.0F, 3.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowelderdragon").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.WhiteWyrmlingEntity>> WHITEWYRMLING =
			ENTITY_TYPES.register("whitewyrmling",
					() -> EntityType.Builder.of(net.grinner117.forgottendragons.entity.custom.WhiteWyrmlingEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whitewyrmling").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.WhiteYoungDragonEntity>> WHITEYOUNGDRAGON =
			ENTITY_TYPES.register("whiteyoungdragon",
					() -> EntityType.Builder.of(WhiteYoungDragonEntity::new, MobCategory.MONSTER)
							.sized(4.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whiteyoungdragon").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.WhiteAdultDragonEntity>> WHITEADULTDRAGON =
			ENTITY_TYPES.register("whiteadultdragon",
					() -> EntityType.Builder.of(net.grinner117.forgottendragons.entity.custom.WhiteAdultDragonEntity::new, MobCategory.MONSTER)
							.sized(8.8F, 2.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whiteadultdragon").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottendragons.entity.custom.WhiteElderDragonEntity>> WHITEELDERDRAGON =
			ENTITY_TYPES.register("whiteelderdragon",
					() -> EntityType.Builder.of(net.grinner117.forgottendragons.entity.custom.WhiteElderDragonEntity::new, MobCategory.MONSTER)
							.sized(10.0F, 5.0F).clientTrackingRange(100)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whiteelderdragon").toString()));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
