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

        public static final RegistryObject<Item> GOBLINFIGHTER_SPAWN_EGG = ITEMS.register("goblinfighter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOBLINFIGHTER, 0x9f8636, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> GOBLINARCHER_SPAWN_EGG = ITEMS.register("goblinarcher_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOBLINARCHER, 0x9f8636, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> GOBLINSHAMAN_SPAWN_EGG = ITEMS.register("goblinshaman_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GOBLINSHAMAN, 0x9f8636, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
        public static final RegistryObject<Item> GREENHAG_SPAWN_EGG = ITEMS.register("greenhag_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GREENHAG, 0x7d512e, 0x9f8636,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
        public static final RegistryObject<Item> NEEDLE = ITEMS.register("needle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNICORN_SPAWN_EGG = ITEMS.register("unicorn_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.UNICORN, 0xf0e97f, 0xfbfbfb,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
        public static final RegistryObject<Item> GRIMLOCK_SPAWN_EGG = ITEMS.register("grimlock_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GRIMLOCK, 0xaa9fae, 0xbebc9b,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> GOBLINFANG = ITEMS.register("goblinfang",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)
                    .food(new FoodProperties.Builder().nutrition(-1).saturationMod(-1)
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 2), 1.0F)
                            .build())));

    public static final RegistryObject<Item> UNICORNHORN = ITEMS.register("unicorn_horn",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> COUATL_WINGS = ITEMS.register("couatl_wings",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}