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
    public static final RegistryObject<Item> SHADOWWYRMLING_SPAWN_EGG = ITEMS.register("shadowwyrmling_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWWYRMLING, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> SHADOWYOUNGDRAGON_SPAWN_EGG = ITEMS.register("shadowyoungdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWYOUNGDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWADULTDRAGON_SPAWN_EGG = ITEMS.register("shadowadultdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWADULTDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWELDERDRAGON_SPAWN_EGG = ITEMS.register("shadowelderdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SHADOWELDERDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> GOBLINFIGHTER_SPAWN_EGG = ITEMS.register("goblinfighter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOBLINFIGHTER, 0x9f8636, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> GOBLINARCHER_SPAWN_EGG = ITEMS.register("goblinarcher_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOBLINARCHER, 0x9f8636, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> GOBLINSHAMAN_SPAWN_EGG = ITEMS.register("goblinshaman_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOBLINSHAMAN, 0x9f8636, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> COUATL_SPAWN_EGG = ITEMS.register("couatl_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COUATL, 0x14499b, 0xff923c,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));


    public static final RegistryObject<Item> BEHOLDER71_SPAWN_EGG = ITEMS.register("beholder71_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEHOLDER71, 0x7d512e, 0xd22f00,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> BEHOLDER72_SPAWN_EGG = ITEMS.register("beholder72_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEHOLDER72, 0x7d512e, 0x010913,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> GREENHAG_SPAWN_EGG = ITEMS.register("greenhag_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GREENHAG, 0x7d512e, 0x9f8636,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> OWLBEARFOREST_SPAWN_EGG = ITEMS.register("owlbearforest_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.OWLBEARFOREST, 0x9f8636, 0x9f8636,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> OWLBEARSNOW_SPAWN_EGG = ITEMS.register("owlbearsnow_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.OWLBEARSNOW, 0xc5c5c5, 0x9f8636,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> NEEDLEBLIGHT_SPAWN_EGG = ITEMS.register("needleblight_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NEEDLEBLIGHT, 0x231c06, 0x6b5411,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> TWIGBLIGHT_SPAWN_EGG = ITEMS.register("twigblight_spawn_egg",
        () -> new ForgeSpawnEggItem(ModEntityTypes.TWIGBLIGHT, 0x231c06, 0x6b5411,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> NEEDLE = ITEMS.register("needle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNICORN_SPAWN_EGG = ITEMS.register("unicorn_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.UNICORN, 0xf0e97f, 0xfbfbfb,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> GRIFFON_SPAWN_EGG = ITEMS.register("griffon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GRIFFON, 0xac8a5f, 0xe0cfba,
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

    public static final RegistryObject<Item> GOBLINFANG = ITEMS.register("goblinfang",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)
                    .food(new FoodProperties.Builder().nutrition(-1).saturationMod(-1)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 2), 1.0F)
                            .build())));

    public static final RegistryObject<Item> BEHOLDERHIDE = ITEMS.register("beholderhide",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> GRIFFONFEATHER = ITEMS.register("griffonfeather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<Item> GRIFFONBEAK = ITEMS.register("griffonbeak",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)
                    .food(new FoodProperties.Builder().nutrition(-1).saturationMod(-1)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 2), 1.0F)
                            .build())));

    public static final RegistryObject<Item> OWLBEARBEAK = ITEMS.register("owlbearbeak",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)
                    .food(new FoodProperties.Builder().nutrition(-1).saturationMod(-1)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 2), 1.0F)
                            .build())));


     public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);    }

}