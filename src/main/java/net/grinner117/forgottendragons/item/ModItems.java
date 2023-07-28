package net.grinner117.forgottendragons.item;

import net.grinner117.forgottendragons.entity.ModEntityTypes;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottenmobs.item.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenDragons.MODID);

    public static final RegistryObject<Item> SHADOWWYRMLING_SPAWN_EGG = ITEMS.register("shadowwyrmling_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWWYRMLING, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWYOUNGDRAGON_SPAWN_EGG = ITEMS.register("shadowyoungdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWYOUNGDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWADULTDRAGON_SPAWN_EGG = ITEMS.register("shadowadultdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWADULTDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWELDERDRAGON_SPAWN_EGG = ITEMS.register("shadowelderdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWELDERDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEWYRMLING_SPAWN_EGG = ITEMS.register("whitewyrmling_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEWYRMLING, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEYOUNGDRAGON_SPAWN_EGG = ITEMS.register("whiteyoungdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEYOUNGDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEADULTDRAGON_SPAWN_EGG = ITEMS.register("whiteadultdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEADULTDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEELDERDRAGON_SPAWN_EGG = ITEMS.register("whiteelderdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WHITEELDERDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
     public static final RegistryObject<Item> NEEDLE = ITEMS.register("needle",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> WHITE_DRAGON_SOUL = ITEMS.register("white_dragon_soul",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOW_DRAGON_SOUL = ITEMS.register("shadow_dragon_soul",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITE_DRAGON_SCALES = ITEMS.register("white_dragon_scales",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOW_DRAGON_SCALES = ITEMS.register("shadow_dragon_scales",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
      public static final RegistryObject<Item> DRAGON_HELEMET = ITEMS.register("dragon_helemet",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DRAGON_CHESTPLATE = ITEMS.register("dragon_chestplate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DRAGON_LEGGINGS = ITEMS.register("dragon_leggings",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DRAGON_BOOTS = ITEMS.register("dragon_boots",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DRAGON_PICKAXE = ITEMS.register("dragon_pickaxe",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DRAGON_SHOVEL = ITEMS.register("dragon_shovel",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DRAGON_HOE = ITEMS.register("dragon_hoe",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DRAGON_SWORD = ITEMS.register("dragon_sword",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}