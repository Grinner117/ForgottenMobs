package net.grinner117.forgottenmobs.entity;

import net.grinner117.forgottenmobs.ForgottenAngels;
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
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenAngels.MODID);
		public static final RegistryObject<EntityType<PlanetarEntity>> PLANETAR =
			ENTITY_TYPES.register("planetar",
					() -> EntityType.Builder.of(PlanetarEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 2.5F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenAngels.MODID, "planetar").toString()));

	public static final RegistryObject<EntityType<DevaEntity>> DEVA =
			ENTITY_TYPES.register("deva",
					() -> EntityType.Builder.of(DevaEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 2.5F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenAngels.MODID, "deva").toString()));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
