package net.grinner117.forgottendragons.item;

import net.grinner117.forgottendragons.base.ModArmorMaterial;
import net.grinner117.forgottendragons.entity.ModEntityTypes;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.perk.*;
import net.grinner117.forgottenmobs.item.ModCreativeModeTab;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
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
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenDragons.MODID);

    public static final RegistryObject<Item> SHADOWWYRMLING_SPAWN_EGG = ITEMS.register("shadowwyrmling_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWWYRMLING, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWYOUNGDRAGON_SPAWN_EGG = ITEMS.register("shadowyoungdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWYOUNGDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWADULTDRAGON_SPAWN_EGG = ITEMS.register("shadowadultdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWADULTDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOWELDERDRAGON_SPAWN_EGG = ITEMS.register("shadowelderdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWELDERDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEWYRMLING_SPAWN_EGG = ITEMS.register("whitewyrmling_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEWYRMLING, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEYOUNGDRAGON_SPAWN_EGG = ITEMS.register("whiteyoungdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEYOUNGDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEADULTDRAGON_SPAWN_EGG = ITEMS.register("whiteadultdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEADULTDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITEELDERDRAGON_SPAWN_EGG = ITEMS.register("whiteelderdragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WHITEELDERDRAGON, 0x1eff3f, 0x000000,
                    new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
     public static final RegistryObject<Item> NEEDLE = ITEMS.register("needle",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> WHITE_DRAGON_SOUL = ITEMS.register("white_dragon_soul",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOW_DRAGON_SOUL = ITEMS.register("shadow_dragon_soul",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> WHITE_DRAGON_SCALES = ITEMS.register("white_dragon_scales",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));
    public static final RegistryObject<Item> SHADOW_DRAGON_SCALES = ITEMS.register("shadow_dragon_scales",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB)));

    public static final RegistryObject<ArmorItem> SHADOWDRAGONARMOR_HELMET = ITEMS.register("shadowdragonarmor_helmet",
            () -> new Nightvison_Perk(ArmorTiers.SHADOWDRAGONARMOR, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> SHADOWDRAGONARMOR_CHESTPLATE = ITEMS.register("shadowdragonarmor_chestplate",
            () -> new DamageRes2_Perk(ArmorTiers.SHADOWDRAGONARMOR, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> SHADOWDRAGONARMOR_LEGGINGS = ITEMS.register("shadowdragonarmor_leggings",
            () -> new Invisibility_Perk(ArmorTiers.SHADOWDRAGONARMOR, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> SHADOWDRAGONARMOR_BOOTS = ITEMS.register("shadowdragonarmor_boots",
            () -> new Damage3_Perk(ArmorTiers.SHADOWDRAGONARMOR, EquipmentSlot.FEET, props()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    private static Item.Properties props(){return new Item.Properties().tab(ModCreativeModeTab.FORGOTTENTAB); }

    public static class ArmorTiers{
        public static final ArmorMaterial SHADOWDRAGONARMOR = new ModArmorMaterial(
                "shadowdragonarmor",
                2200,
                new int[]{7,15,12,7},
                200,
                SoundEvents.ARMOR_EQUIP_NETHERITE,
                10.0f, 0.8f,
                () -> Ingredient.of(ModItems.SHADOW_DRAGON_SOUL.get()));

    }

}