package net.grinner117.forgottenmobs.item;

import net.grinner117.forgottenmobs.ForgottenAngels;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenAngels.MODID);
        public static final RegistryObject<Item> PLANETAR_SPAWN_EGG = ITEMS.register("planetar_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PLANETAR, 0xea261c, 0x39843e,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> DEVA_SPAWN_EGG = ITEMS.register("deva_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DEVA, 0xea261c, 0x39843e,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}