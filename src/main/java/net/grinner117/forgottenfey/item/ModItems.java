package net.grinner117.forgottenfey.item;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.item.ModCreativeModeTab;
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
			DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenFey.MODID);

	public static final RegistryObject<Item> GOBLINFIGHTER_SPAWN_EGG = ITEMS.register("goblinfighter_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINFIGHTER, 0x9f8536, 0x000000,
					new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> GOBLINARCHER_SPAWN_EGG = ITEMS.register("goblinarcher_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINARCHER, 0x9f8626, 0x000000,
					new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> GOBLINSHAMAN_SPAWN_EGG = ITEMS.register("goblinshaman_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINSHAMAN, 0x9f8646, 0x000000,
					new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> GREENHAG_SPAWN_EGG = ITEMS.register("greenhag_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenfey.entity.ModEntityTypes.GREENHAG, 0x7d512e, 0x9f8636,
					new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> UNICORN_SPAWN_EGG = ITEMS.register("unicorn_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenfey.entity.ModEntityTypes.UNICORN, 0xf0e97f, 0xfbfbfb,
					new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> GRIMLOCK_SPAWN_EGG = ITEMS.register("grimlock_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntityTypes.GRIMLOCK, 0xaa9fae, 0xbebc9b,
					new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> GOBLINFANG = ITEMS.register("goblinfang",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(-1).saturationMod(-1)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 2), 1.0F)
							.build())));
	public static final RegistryObject<Item> GOBLINHEART = ITEMS.register("goblinheart",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(-1).saturationMod(-1)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 2), 1.0F)
							.build())));

	public static final RegistryObject<Item> UNICORNHORN = ITEMS.register("unicorn_horn",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}