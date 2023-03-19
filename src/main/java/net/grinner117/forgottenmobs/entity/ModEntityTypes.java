package net.grinner117.forgottenmobs.entity;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.ChildRatEntity;
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
    public static final RegistryObject<EntityType<ChildRatEntity>> CHILDRAT =
            ENTITY_TYPES.register("childrat",
                    () -> EntityType.Builder.of(ChildRatEntity::new, MobCategory.MONSTER)
                            .sized(0.5F, 0.5F).clientTrackingRange(20)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"childrat").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
