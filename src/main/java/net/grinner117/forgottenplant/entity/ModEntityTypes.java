package net.grinner117.forgottenplant.entity;

import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.custom.NeedleBlightEntity;
import net.grinner117.forgottenplant.entity.custom.ShamblingMoundEntity;
import net.grinner117.forgottenplant.entity.custom.TwigBlightEntity;
import net.grinner117.forgottenplant.entity.custom.VineBlightEntity;
import net.grinner117.forgottenplant.entity.projectile.NeedleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenPlant.MODID);

	public static final RegistryObject<EntityType<net.grinner117.forgottenplant.entity.custom.NeedleBlightEntity>> NEEDLEBLIGHT =
			ENTITY_TYPES.register("needleblight",
					() -> EntityType.Builder.of(NeedleBlightEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 2.0F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenPlant.MODID, "needleblight").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottenplant.entity.custom.TwigBlightEntity>> TWIGBLIGHT =
			ENTITY_TYPES.register("twigblight",
					() -> EntityType.Builder.of(TwigBlightEntity::new, MobCategory.MONSTER)
							.sized(0.8F, 1.4F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenPlant.MODID, "twigblight").toString()));
	public static final RegistryObject<EntityType<net.grinner117.forgottenplant.entity.custom.VineBlightEntity>> VINEBLIGHT =
			ENTITY_TYPES.register("vineblight",
					() -> EntityType.Builder.of(VineBlightEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 1.8F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenPlant.MODID, "vineblight").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottenplant.entity.projectile.NeedleEntity>> NEEDLE = ENTITY_TYPES.register("needle",
			() -> EntityType.Builder.of((EntityType.EntityFactory<net.grinner117.forgottenplant.entity.projectile.NeedleEntity>) NeedleEntity::new, MobCategory.MISC)
					.sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
					.build(new ResourceLocation(ForgottenPlant.MODID, "needle").toString()));

	public static final RegistryObject<EntityType<net.grinner117.forgottenplant.entity.custom.ShamblingMoundEntity>> SHAMBLINGMOUND =
			ENTITY_TYPES.register("shamblingmound",
					() -> EntityType.Builder.of(ShamblingMoundEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 2.5F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenPlant.MODID, "shamblingmound").toString()));


	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
