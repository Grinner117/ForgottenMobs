package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ForgottenMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

            event.put(ModEntityTypes.ANIMATEDIRONARMOR.get(), AnimatedIronArmorEntity.setAttributes());
            event.put(ModEntityTypes.ANIMATEDLEATHERARMOR.get(), AnimatedLeatherArmorEntity.setAttributes());
            event.put(ModEntityTypes.ANIMATEDGOLDARMOR.get(), AnimatedGoldArmorEntity.setAttributes());
            event.put(ModEntityTypes.ANIMATEDDIAMONDARMOR.get(), AnimatedDiamondArmorEntity.setAttributes());

            event.put(ModEntityTypes.SHADOWWYRMLING.get(), ShadowWyrmlingEntity.setAttributes());
            event.put(ModEntityTypes.SHADOWYOUNGDRAGON.get(), ShadowYoungDragonEntity.setAttributes());
            event.put(ModEntityTypes.SHADOWADULTDRAGON.get(), ShadowAdultDragonEntity.setAttributes());
            event.put(ModEntityTypes.SHADOWELDERDRAGON.get(), ShadowElderDragonEntity.setAttributes());

            event.put(ModEntityTypes.GOBLINFIGHTER.get(), GoblinFighterEnity.setAttributes());
            event.put(ModEntityTypes.GOBLINARCHER.get(), GoblinArcherEnity.setAttributes());
            event.put(ModEntityTypes.GOBLINSHAMAN.get(), GoblinShamanEnity.setAttributes());



        }
    }
}
