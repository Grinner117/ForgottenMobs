package net.grinner117.forgottenangels.item;

import net.grinner117.forgottenangels.ForgottenAngels;
import net.grinner117.forgottenangels.entity.ModEntityTypes;
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
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(0).saturationMod(0)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 200, 20), 1.0F)
							.build())));

	//angel heart
	public static final RegistryObject<Item> ANGELHEART = ITEMS.register("angelheart",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(0).saturationMod(0)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 200, 20), 1.0F)
							.build())));
	//angel bone
	public static final RegistryObject<Item> ANGELBONE = ITEMS.register("angelbone",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(0).saturationMod(0)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 200, 20), 1.0F)
							.build())));
	//angel flesh
	public static final RegistryObject<Item> ANGELFLESH = ITEMS.register("angelflesh",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(0).saturationMod(0)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 200, 20), 1.0F)
							.build())));
	//angel eye
	public static final RegistryObject<Item> ANGELEYE = ITEMS.register("angeleye",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(0).saturationMod(0)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 200, 20), 1.0F)
							.build())));
	//angel tear
	public static final RegistryObject<Item> ANGELTEAR = ITEMS.register("angeltear",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

	//angel blood, can be consumed will restore all health to player
	public static final RegistryObject<Item> ANGELBLOOD = ITEMS.register("angelblood",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
					.food(new FoodProperties.Builder().nutrition(1).saturationMod(1)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 20), 0.5F)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 20, 3), 0.5F)
							.build())));
	public static final RegistryObject<Item> DILUTIED_ANGEL_BLOOD_POTION = ITEMS.register("diluted_angel_blood_potion",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB).stacksTo(1)
					.food(new FoodProperties.Builder().nutrition(2).saturationMod(2)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 10), 0.4F)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 20, 3), 0.6F)
							.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 20, 2), 0.2F)
							.build())));
	public static final RegistryObject<Item> PART_ANGEL_BLOOD_POTION = ITEMS.register("part_angel_blood_potion",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB).stacksTo(1)
					.food(new FoodProperties.Builder().nutrition(2).saturationMod(2)
							.effect(() -> new MobEffectInstance(MobEffects.HARM, 40, 5), 0.2F)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 40, 4), 0.8F)
							.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 40, 3), 0.5F)
							.build())));

	public static final RegistryObject<Item> ANGEL_BLOOD_POTION = ITEMS.register("angel_blood_potion",
			() -> new Item(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB).stacksTo(1)
					.food(new FoodProperties.Builder().nutrition(2).saturationMod(2)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 100, 5), 0.9F)
							.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 100, 5), 0.9F)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2), 0.3F)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200, 2), 0.1F)
							.effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1200, 2), 0.1F)
							.build())));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}