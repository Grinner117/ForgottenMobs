package net.grinner117.forgottenmobs.item;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab FORGOTTENTAB = new CreativeModeTab("forgottentab") {
        @Override
        public ItemStack makeIcon () {
            return new ItemStack(Items.ENDER_EYE);
        }
    };
}