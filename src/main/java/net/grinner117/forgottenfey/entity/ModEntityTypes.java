package net.grinner117.forgottenfey.entity;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenFey.MODID);
	public static final RegistryObject<EntityType<GoblinFighterEntity>> GOBLINFIGHTER =
			ENTITY_TYPES.register("goblinfighter",
					() -> EntityType.Builder.of(GoblinFighterEntity::new, MobCategory.MONSTER)
							.sized(0.8F, 0.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenFey.MODID, "goblinfighter").toString()));
	public static final RegistryObject<EntityType<CouatlEntity>> COUATL =
			ENTITY_TYPES.register("couatl",
					() -> EntityType.Builder.of(CouatlEntity::new, MobCategory.MONSTER)
							.sized(12.0F, 4.0F).clientTrackingRange(120)
							.build(new ResourceLocation(ForgottenFey.MODID, "couatl").toString()));
	public static final RegistryObject<EntityType<GoblinArcherEntity>> GOBLINARCHER =
			ENTITY_TYPES.register("goblinarcher",
					() -> EntityType.Builder.of(GoblinArcherEntity::new, MobCategory.MONSTER)
							.sized(0.8F, 0.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenFey.MODID, "goblinarcher").toString()));

	public static final RegistryObject<EntityType<GoblinShamanEntity>> GOBLINSHAMAN =
			ENTITY_TYPES.register("goblinshaman",
					() -> EntityType.Builder.of(GoblinShamanEntity::new, MobCategory.MONSTER)
							.sized(0.8F, 0.8F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenFey.MODID, "goblinshaman").toString()));

	public static final RegistryObject<EntityType<GreenHagEntity>> GREENHAG =
			ENTITY_TYPES.register("greenhag",
					() -> EntityType.Builder.of(GreenHagEntity::new, MobCategory.MONSTER)
							.sized(1.0F, 2.0F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenFey.MODID, "greenhag").toString()));

	public static final RegistryObject<EntityType<UnicornEntity>> UNICORN =
			ENTITY_TYPES.register("unicorn",
					() -> EntityType.Builder.of(UnicornEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 1.6F).clientTrackingRange(60)
							.build(new ResourceLocation(ForgottenFey.MODID, "unicorn").toString()));

	public static final RegistryObject<EntityType<GrimlockEntity>> GRIMLOCK =
			ENTITY_TYPES.register("grimlock",
					() -> EntityType.Builder.of(GrimlockEntity::new, MobCategory.MONSTER)
							.sized(1.8F, 2.5F).clientTrackingRange(80)
							.build(new ResourceLocation(ForgottenFey.MODID, "grimlock").toString()));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
