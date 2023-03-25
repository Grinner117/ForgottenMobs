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
                            .sized(0.7F, 1.8F).clientTrackingRange(10)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animateddiamondarmor").toString()));

    public static final RegistryObject<EntityType<AnimatedLeatherArmorEntity>> ANIMATEDLEATHERARMOR =
            ENTITY_TYPES.register("animatedleatherarmor",
                    () -> EntityType.Builder.of(AnimatedLeatherArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(10)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedleatherarmor").toString()));
       public static final RegistryObject<EntityType<AnimatedIronArmorEntity>> ANIMATEDIRONARMOR =
            ENTITY_TYPES.register("animatedironarmor",
                    () -> EntityType.Builder.of(AnimatedIronArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(10)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedironarmor").toString()));
    public static final RegistryObject<EntityType<AnimatedGoldArmorEntity>> ANIMATEDGOLDARMOR =
            ENTITY_TYPES.register("animatedgoldarmor",
                    () -> EntityType.Builder.of(AnimatedGoldArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(10)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedgoldarmor").toString()));

    public static final RegistryObject<EntityType<ShadowWyrmlingEntity>> SHADOWWYRMLING =
            ENTITY_TYPES.register("shadowwyrmling",
                    () -> EntityType.Builder.of(ShadowWyrmlingEntity::new, MobCategory.MONSTER)
                            .sized(1.0F, 1.0F).clientTrackingRange(50)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"shadowwyrmling").toString()));

    public static final RegistryObject<EntityType<ShadowYoungDragonEntity>> SHADOWYOUNGDRAGON =
            ENTITY_TYPES.register("shadowyoungdragon",
                    () -> EntityType.Builder.of(ShadowYoungDragonEntity::new, MobCategory.MONSTER)
                            .sized(1.8F, 1.8F).clientTrackingRange(60)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"shadowyoungdragon").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
