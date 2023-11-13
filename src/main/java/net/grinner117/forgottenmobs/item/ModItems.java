package net.grinner117.forgottenmobs.item;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenMobs.MODID);

    public static final RegistryObject<Item> ANIMATEDDIAMONDARMOR_SPAWN_EGG = ITEMS.register("animateddiamondarmor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANIMATEDDIAMONDARMOR, 0x155d69, 0x05d5e1,
                    new Item.Properties()));
    public static final RegistryObject<Item> ANIMATEDLEATHERARMOR_SPAWN_EGG = ITEMS.register("animatedleatherarmor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANIMATEDLEATHERARMOR, 0x22b541, 0x19732e,
                    new Item.Properties()));
    public static final RegistryObject<Item> ANIMATEDIRONARMOR_SPAWN_EGG = ITEMS.register("animatedironarmor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANIMATEDIRONARMOR, 0x226841, 0x19562e,
                    new Item.Properties()));
    public static final RegistryObject<Item> ANIMATEDGOLDARMOR_SPAWN_EGG = ITEMS.register("animatedgoldarmor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANIMATEDGOLDARMOR, 0x1eff3f, 0xe9921a,
                    new Item.Properties()));
    public static final RegistryObject<Item> NEEDLE = ITEMS.register("needle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLOUDGIANT_SPAWN_EGG = ITEMS.register("cloudgiant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CLOUDGIANT, 0xbb1b42, 0xdc1541,
                    new Item.Properties()));
    public static final RegistryObject<Item> GHOST_SPAWN_EGG = ITEMS.register("ghost_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GHOST, 0xac8a5f, 0xe0cfba,
                    new Item.Properties()));
    public static final RegistryObject<Item> GHOST_ASH = ITEMS.register("ghost_ash",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}