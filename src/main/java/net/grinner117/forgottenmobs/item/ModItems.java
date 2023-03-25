package net.grinner117.forgottenmobs.item;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
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
    public static final RegistryObject<Item> SHADOWWYRMLING_SPAWN_EGG = ITEMS.register("shadowwyrmling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWWYRMLING, 0x1eff3f, 0x000000,
                    new Item.Properties()));

    public static final RegistryObject<Item> SHADOWYOUNGDRAGON_SPAWN_EGG = ITEMS.register("shadowyoungdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWYOUNGDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties()));
    public static final RegistryObject<Item> SHADOWADULTDRAGON_SPAWN_EGG = ITEMS.register("shadowadultdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWADULTDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties()));
    public static final RegistryObject<Item> SHADOWELDERDRAGON_SPAWN_EGG = ITEMS.register("shadowelderdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWELDERDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties()));
    private static Item.Properties props(){return new Item.Properties(); }
       public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);    }

}