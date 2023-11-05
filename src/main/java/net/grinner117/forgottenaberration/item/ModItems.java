package net.grinner117.forgottenaberration.item;

import net.grinner117.forgottenaberration.entity.ModEntityTypes;
import net.grinner117.forgottenaberration.ForgottenAberration;
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
			DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenAberration.MODID);

	public static final RegistryObject<Item> BEHOLDER71_SPAWN_EGG = ITEMS.register("beholder71_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER71, 0x7d512e, 0xd22f00,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> BEHOLDER72_SPAWN_EGG = ITEMS.register("beholder72_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER72, 0x7d512e, 0x010913,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	public static final RegistryObject<Item> INTELLECTDEVOURER_SPAWN_EGG = ITEMS.register("intellectdevourer_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenaberration.entity.ModEntityTypes.INTELLECTDEVOURER, 0xac8a5f, 0xe0cfba,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	public static final RegistryObject<Item> MINDFLAYER_SPAWN_EGG = ITEMS.register("mindflayer_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenaberration.entity.ModEntityTypes.MINDFLAYER, 0xac8a5f, 0xe0cfba,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> DBEAST_SPAWN_EGG = ITEMS.register("dbeast_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntityTypes.DBEAST, 0x3d3045, 0xb1b901,
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


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}