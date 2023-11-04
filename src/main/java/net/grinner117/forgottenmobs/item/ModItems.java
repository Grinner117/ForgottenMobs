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
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> ANIMATEDLEATHERARMOR_SPAWN_EGG = ITEMS.register("animatedleatherarmor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANIMATEDLEATHERARMOR, 0x22b541, 0x19732e,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> ANIMATEDIRONARMOR_SPAWN_EGG = ITEMS.register("animatedironarmor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANIMATEDIRONARMOR, 0x226841, 0x19562e,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> ANIMATEDGOLDARMOR_SPAWN_EGG = ITEMS.register("animatedgoldarmor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANIMATEDGOLDARMOR, 0x1eff3f, 0xe9921a,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> BEHOLDER71_SPAWN_EGG = ITEMS.register("beholder71_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEHOLDER71, 0x7d512e, 0xd22f00,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> BEHOLDER72_SPAWN_EGG = ITEMS.register("beholder72_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEHOLDER72, 0x7d512e, 0x010913,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> NEEDLEBLIGHT_SPAWN_EGG = ITEMS.register("needleblight_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NEEDLEBLIGHT, 0x231c06, 0x6b5411,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> TWIGBLIGHT_SPAWN_EGG = ITEMS.register("twigblight_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TWIGBLIGHT, 0x231c06, 0x6b5411,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> VINEBLIGHT_SPAWN_EGG = ITEMS.register("vineblight_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.VINEBLIGHT, 0x231c06, 0x6b5411,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> NEEDLE = ITEMS.register("needle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INTELLECTDEVOURER_SPAWN_EGG = ITEMS.register("intellectdevourer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.INTELLECTDEVOURER, 0xac8a5f, 0xe0cfba,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> CLOUDGIANT_SPAWN_EGG = ITEMS.register("cloudgiant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CLOUDGIANT, 0xbb1b42, 0xdc1541,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> GHOST_SPAWN_EGG = ITEMS.register("ghost_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GHOST, 0xac8a5f, 0xe0cfba,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> MINDFLAYER_SPAWN_EGG = ITEMS.register("mindflayer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MINDFLAYER, 0xac8a5f, 0xe0cfba,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DBEAST_SPAWN_EGG = ITEMS.register("dbeast_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DBEAST, 0x3d3045, 0xb1b901,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHAMBLINGMOUND_SPAWN_EGG = ITEMS.register("shamblingmound_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHAMBLINGMOUND, 0xea261c, 0x39843e,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> EYESTALK = ITEMS.register("eyestalk",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2)
                            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 80, 0), 0.3F)
                            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 80, 0), 0.3F)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 0), 0.3F)
                            .build())));
    public static final RegistryObject<Item> BEHOLDERFANG = ITEMS.register("beholderfang",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)
                    .food(new FoodProperties.Builder().nutrition(-1).saturationMod(-1)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 5), 1.0F)
                            .build())));
    public static final RegistryObject<Item> BEHOLDERHIDE = ITEMS.register("beholderhide",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> GHOST_ASH = ITEMS.register("ghost_ash",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> COUATL_FEATHER = ITEMS.register("couatlfeather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> COUATL_WINGS = ITEMS.register("couatl_wings",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}