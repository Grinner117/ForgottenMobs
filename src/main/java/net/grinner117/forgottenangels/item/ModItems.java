package net.grinner117.forgottenangels.item;

import net.grinner117.forgottenangels.entity.ModEntityTypes;
import net.grinner117.forgottenangels.ForgottenAngels;
import net.grinner117.forgottenmobs.item.ModCreativeModeTab;
import net.minecraft.world.food.FoodProperties;
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
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenangels.entity.ModEntityTypes.PLANETAR, 0xea261c, 0x39843e,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> DEVA_SPAWN_EGG = ITEMS.register("deva_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntityTypes.DEVA, 0xea261c, 0x39843e,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	public static final RegistryObject<Item> ANGELFEATHER = ITEMS.register("angelfeather",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	//angel soul
	public static final RegistryObject<Item> ANGELSOUL = ITEMS.register("angelsoul",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	//angel blood, can be consumed, causes damage to undead, will restore all health to player
	public static final RegistryObject<Item> ANGELBLOOD = ITEMS.register("angelblood",
			() -> new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder()
							.nutrition(8)
							.saturationMod(2).build());


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}