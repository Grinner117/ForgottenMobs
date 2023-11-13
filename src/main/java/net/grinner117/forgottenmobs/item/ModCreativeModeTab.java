package net.grinner117.forgottenmobs.item;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForgottenMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab FORGOTTENTAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.register event) {
        FORGOTTENTAB = event.registerCreativeModeTab(new ResourceLocation(ForgottenMobs.MODID, "forgottentab"),
                builder -> builder.icon(() -> new ItemStack(Items.ENDER_EYE))).tittle(Component.literal("Forgotten Mobs Tab")).build();
    }
}