package net.grinner117.forgottenfey.entity.event;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ForgottenFey.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

            event.put(ModEntityTypes.GOBLINFIGHTER.get(), GoblinFighterEntity.setAttributes());
            event.put(ModEntityTypes.GOBLINARCHER.get(), GoblinArcherEntity.setAttributes());
            event.put(ModEntityTypes.GOBLINSHAMAN.get(), GoblinShamanEntity.setAttributes());

            event.put(ModEntityTypes.GREENHAG.get(), GreenHagEntity.setAttributes());

            event.put(ModEntityTypes.UNICORN.get(), UnicornEntity.setAttributes());

            event.put(ModEntityTypes.GRIMLOCK.get(), GrimlockEntity.setAttributes());

        }
    }
}
