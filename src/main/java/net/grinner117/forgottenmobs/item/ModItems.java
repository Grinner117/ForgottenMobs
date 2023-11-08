package net.grinner117.forgottenmobs.item;

import net.grinner117.forgottenmobs.ForgottenPlant;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenPlant.MODID);

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
	public static final RegistryObject<Item> SHAMBLINGMOUND_SPAWN_EGG = ITEMS.register("shamblingmound_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntityTypes.SHAMBLINGMOUND, 0xea261c, 0x39843e,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}