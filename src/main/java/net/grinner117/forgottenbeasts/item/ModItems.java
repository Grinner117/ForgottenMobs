package net.grinner117.forgottenbeasts.item;

import net.grinner117.forgottenbeasts.base.ModArmorMaterial;
import net.grinner117.forgottenbeasts.entity.ModEntityTypes;
import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.grinner117.forgottenmobs.item.ModCreativeModeTab;
import net.grinner117.forgottenmobs.perk.Health3_Perk;
import net.grinner117.forgottenmobs.perk.Nightvison_Perk;
import net.grinner117.forgottenmobs.perk.Regeneration2_Perk;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenBeasts.MODID);

	public static final RegistryObject<Item> OWLBEARFOREST_SPAWN_EGG = ITEMS.register("owlbearforest_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenbeasts.entity.ModEntityTypes.OWLBEARFOREST, 0x9f8636, 0x9f8636,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> OWLBEARSNOW_SPAWN_EGG = ITEMS.register("owlbearsnow_spawn_egg",
			() -> new ForgeSpawnEggItem(net.grinner117.forgottenbeasts.entity.ModEntityTypes.OWLBEARSNOW, 0xc5c5c5, 0x9f8636,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> GRIFFON_SPAWN_EGG = ITEMS.register("griffon_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntityTypes.GRIFFON, 0xac8a5f, 0xe0cfba,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	public static final RegistryObject<Item> STIRGE_SPAWN_EGG = ITEMS.register("stirge_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntityTypes.STIRGE, 0xac5a5f, 0xe34fba,
					new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));


	public static final RegistryObject<Item> SNOW_OWLBEAR_FUR = ITEMS.register("snow_owlbear_fur",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> FOREST_OWLBEAR_FUR = ITEMS.register("forest_owlbear_fur",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
	public static final RegistryObject<Item> SNOW_OWLBEAR_HELMET = ITEMS.register("snow_owlbear_helmet",
			() -> new Nightvison_Perk(ArmorTiers.SNOWOWLBEARARMOR, EquipmentSlot.HEAD, props()));
	public static final RegistryObject<Item> SNOW_OWLBEAR_CHESTPLATE = ITEMS.register("snow_owlbear_chestplate",
			() -> new Health3_Perk(ArmorTiers.SNOWOWLBEARARMOR, EquipmentSlot.CHEST, props()));
	public static final RegistryObject<Item> FOREST_OWLBEAR_HELMET = ITEMS.register("forest_owlbear_helmet",
			() -> new Regeneration2_Perk(ArmorTiers.FORESTOWLBEARARMOR, EquipmentSlot.HEAD, props()));
	public static final RegistryObject<Item> FOREST_OWLBEAR_CHESTPLATE = ITEMS.register("forest_owlbear_chestplate",
			() -> new Health3_Perk(ArmorTiers.FORESTOWLBEARARMOR, EquipmentSlot.CHEST, props()));
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
		ITEMS.register(eventBus);
	}

	private static Item.Properties props() {
		return new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB);
	}


	public static class ArmorTiers {

		public static final ArmorMaterial SNOWOWLBEARARMOR = new ModArmorMaterial(
				"snow_owlbear_armor",
				1800,
				new int[]{5, 12, 10, 5},
				100,
				SoundEvents.ARMOR_EQUIP_LEATHER,
				8.0f, 0.8f,
				() -> Ingredient.of(ModItems.SNOW_OWLBEAR_FUR.get()));

		public static final ArmorMaterial FORESTOWLBEARARMOR = new ModArmorMaterial(
				"forest_owlbear_armor",
				1800,
				new int[]{5, 12, 10, 5},
				100,
				SoundEvents.ARMOR_EQUIP_LEATHER,
				8.0f, 0.8f,
				() -> Ingredient.of(ModItems.FOREST_OWLBEAR_FUR.get()));

	}
}