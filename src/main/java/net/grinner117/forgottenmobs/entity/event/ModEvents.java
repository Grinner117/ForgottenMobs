package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.grinner117.forgottenmobs.entity.custom.AnimatedLeatherArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowAdultDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowElderDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowWyrmlingEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowYoungDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.WhiteAdultDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.WhiteElderDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.WhiteWyrmlingEntity;
import net.grinner117.forgottenmobs.entity.custom.WhiteYoungDragonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ForgottenMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

                  event.put(ModEntityTypes.SHADOWWYRMLING.get(), ShadowWyrmlingEntity.setAttributes());
            event.put(ModEntityTypes.SHADOWYOUNGDRAGON.get(), ShadowYoungDragonEntity.setAttributes());
            event.put(ModEntityTypes.SHADOWADULTDRAGON.get(), ShadowAdultDragonEntity.setAttributes());
            event.put(ModEntityTypes.SHADOWELDERDRAGON.get(), ShadowElderDragonEntity.setAttributes());

            event.put(ModEntityTypes.WHITEWYRMLING.get(), WhiteWyrmlingEntity.setAttributes());
            event.put(ModEntityTypes.WHITEYOUNGDRAGON.get(), WhiteYoungDragonEntity.setAttributes());
            event.put(ModEntityTypes.WHITEADULTDRAGON.get(), WhiteAdultDragonEntity.setAttributes());
            event.put(ModEntityTypes.WHITEELDERDRAGON.get(), WhiteElderDragonEntity.setAttributes());

                   }
    }
}
