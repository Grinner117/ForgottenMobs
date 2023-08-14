package net.grinner117.forgottendragons.entity;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireYoungDragonEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteYoungDragonEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowYoungDragonEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteWyrmlingEntity;
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

	public static final RegistryObject<EntityType<ShadowWyrmlingEntity>> SHADOWWYRMLING =
			ENTITY_TYPES.register("shadowwyrmling",
					() -> EntityType.Builder.of(ShadowWyrmlingEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowwyrmling").toString()));

	public static final RegistryObject<EntityType<ShadowYoungDragonEntity>> SHADOWYOUNGDRAGON =
			ENTITY_TYPES.register("shadowyoungdragon",
					() -> EntityType.Builder.of(ShadowYoungDragonEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 1.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowyoungdragon").toString()));
	public static final RegistryObject<EntityType<ShadowAdultDragonEntity>> SHADOWADULTDRAGON =
			ENTITY_TYPES.register("shadowadultdragon",
					() -> EntityType.Builder.of(ShadowAdultDragonEntity::new, MobCategory.MONSTER)
							.sized(2.8F, 2.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowadultdragon").toString()));
	public static final RegistryObject<EntityType<ShadowElderDragonEntity>> SHADOWELDERDRAGON =
			ENTITY_TYPES.register("shadowelderdragon",
					() -> EntityType.Builder.of(ShadowElderDragonEntity::new, MobCategory.MONSTER)
							.sized(3.0F, 3.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "shadowelderdragon").toString()));
	public static final RegistryObject<EntityType<WhiteWyrmlingEntity>> WHITEWYRMLING =
			ENTITY_TYPES.register("whitewyrmling",
					() -> EntityType.Builder.of(WhiteWyrmlingEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whitewyrmling").toString()));

	public static final RegistryObject<EntityType<WhiteYoungDragonEntity>> WHITEYOUNGDRAGON =
			ENTITY_TYPES.register("whiteyoungdragon",
					() -> EntityType.Builder.of(WhiteYoungDragonEntity::new, MobCategory.MONSTER)
							.sized(4.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whiteyoungdragon").toString()));
	public static final RegistryObject<EntityType<WhiteAdultDragonEntity>> WHITEADULTDRAGON =
			ENTITY_TYPES.register("whiteadultdragon",
					() -> EntityType.Builder.of(WhiteAdultDragonEntity::new, MobCategory.MONSTER)
							.sized(8.8F, 2.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whiteadultdragon").toString()));
	public static final RegistryObject<EntityType<WhiteElderDragonEntity>> WHITEELDERDRAGON =
			ENTITY_TYPES.register("whiteelderdragon",
					() -> EntityType.Builder.of(WhiteElderDragonEntity::new, MobCategory.MONSTER)
							.sized(10.0F, 5.0F).clientTrackingRange(100)
							.build(new ResourceLocation(ForgottenDragons.MODID, "whiteelderdragon").toString()));
	public static final RegistryObject<EntityType<FireWyrmlingEntity>> FIREWYRMLING =
			ENTITY_TYPES.register("firewyrmling",
					() -> EntityType.Builder.of(FireWyrmlingEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "firewyrmling").toString()));

	public static final RegistryObject<EntityType<FireYoungDragonEntity>> FIREYOUNGDRAGON =
			ENTITY_TYPES.register("fireyoungdragon",
					() -> EntityType.Builder.of(FireYoungDragonEntity::new, MobCategory.MONSTER)
							.sized(4.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenDragons.MODID, "fireyoungdragon").toString()));
	public static final RegistryObject<EntityType<FireAdultDragonEntity>> FIREADULTDRAGON =
			ENTITY_TYPES.register("fireadultdragon",
					() -> EntityType.Builder.of(FireAdultDragonEntity::new, MobCategory.MONSTER)
							.sized(8.8F, 2.8F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenDragons.MODID, "fireadultdragon").toString()));
	public static final RegistryObject<EntityType<FireElderDragonEntity>> FIREELDERDRAGON =
			ENTITY_TYPES.register("fireelderdragon",
					() -> EntityType.Builder.of(FireElderDragonEntity::new, MobCategory.MONSTER)
							.sized(10.0F, 5.0F).clientTrackingRange(100)
							.build(new ResourceLocation(ForgottenDragons.MODID, "fireelderdragon").toString()));
	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
