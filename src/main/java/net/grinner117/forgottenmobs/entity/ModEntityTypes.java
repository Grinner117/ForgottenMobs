package net.grinner117.forgottenmobs.entity;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedArmorEntity;
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
    public static final RegistryObject<EntityType<AnimatedArmorEntity>> ANIMATEDARMOR =
            ENTITY_TYPES.register("animatedarmor",
                    () -> EntityType.Builder.of(AnimatedArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(10)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedarmor").toString()));

    public static final RegistryObject<EntityType<AnimatedArmorEntity>> ANIMATEDLEATHERARMOR =
            ENTITY_TYPES.register("animatedleatherarmor",
                    () -> EntityType.Builder.of(AnimatedArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(10)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedleatherarmor").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
