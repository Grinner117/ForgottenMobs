//package net.grinner117.forgottenmobs.item;
//
//
//import net.grinner117.forgottenmobs.ForgottenMobs;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.RegistryObject;
//import net.minecraft.core.registries.Registries;
//
//
//public class ModCreativeModeTab {
//    //add a creative mode tab
//
//
//    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
//            ForgottenMobs.MODID);
//
//    public static RegistryObject<CreativeModeTab> FORGOTTENTAB = CREATIVE_MODE_TABS.register("forgottentab", () ->
//            CreativeModeTab.builder().icon(() -> new ItemStack(Items.ENDER_EYE))
//                    .title(Component.translatable("Forgotten Mobs Tab")).build());
//
//    public static void register(IEventBus eventBus) {
//        CREATIVE_MODE_TABS.register(eventBus);
//    }
//}
