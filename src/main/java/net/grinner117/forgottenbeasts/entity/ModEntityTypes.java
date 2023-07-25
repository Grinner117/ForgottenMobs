package net.grinner117.forgottenbeasts.entity;

import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.grinner117.forgottenbeasts.entity.custom.GriffonEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenBeasts.MODID);

	public static final RegistryObject<EntityType<net.grinner117.forgottenbeasts.entity.custom.OwlBearForestEntity>> OWLBEARFOREST =
			ENTITY_TYPES.register("owlbearforest",
					() -> EntityType.Builder.of(net.grinner117.forgottenbeasts.entity.custom.OwlBearForestEntity::new, MobCategory.MONSTER)
							.sized(1.6F, 2.6F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenBeasts.MODID, "owlbearforest").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity>> OWLBEARSNOW =
			ENTITY_TYPES.register("owlbearsnow",
					() -> EntityType.Builder.of(net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity::new, MobCategory.MONSTER)
							.sized(1.6F, 2.6F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenBeasts.MODID, "owlbearsnow").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottenbeasts.entity.custom.StirgeEntity>> STIRGE =
			ENTITY_TYPES.register("stirge",
					() -> EntityType.Builder.of(net.grinner117.forgottenbeasts.entity.custom.StirgeEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 1.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenBeasts.MODID, "stirge").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottenbeasts.entity.custom.GriffonEntity>> GRIFFON =
			ENTITY_TYPES.register("griffon",
					() -> EntityType.Builder.of(GriffonEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 1.6F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenBeasts.MODID, "griffon").toString()));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
