package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenMobs;

import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.ChildRatEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ForgottenMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

            event.put(ModEntityTypes.CHILDRAT.get(), ChildRatEntity.setAttributes());

        }
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class ArmorHandlers {

    }
}
