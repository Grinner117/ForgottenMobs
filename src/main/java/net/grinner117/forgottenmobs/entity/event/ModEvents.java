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

            event.put(ModEntityTypes.GOBLINFIGHTER.get(), GoblinFighterEntity.setAttributes());
            event.put(ModEntityTypes.GOBLINARCHER.get(), GoblinArcherEntity.setAttributes());
            event.put(ModEntityTypes.GOBLINSHAMAN.get(), GoblinShamanEntity.setAttributes());


            event.put(ModEntityTypes.BEHOLDER71.get(), Beholder71Entity.setAttributes());
            event.put(ModEntityTypes.BEHOLDER72.get(), Beholder72Entity.setAttributes());

            event.put(ModEntityTypes.GREENHAG.get(), GreenHagEntity.setAttributes());


            event.put(ModEntityTypes.NEEDLEBLIGHT.get(), NeedleBlightEntity.setAttributes());
            event.put(ModEntityTypes.TWIGBLIGHT.get(), TwigBlightEntity.setAttributes());
            event.put(ModEntityTypes.VINEBLIGHT.get(), VineBlightEntity.setAttributes());


            event.put(ModEntityTypes.UNICORN.get(), UnicornEntity.setAttributes());
            event.put(ModEntityTypes.COUATL.get(), CouatlEntity.setAttributes());
            event.put(ModEntityTypes.INTELLECTDEVOURER.get(), IntellectDevourerEntity.setAttributes());
            event.put(ModEntityTypes.CLOUDGIANT.get(), CloudGiantEntity.setAttributes());
            event.put(ModEntityTypes.GHOST.get(), GhostEntity.setAttributes());
            event.put(ModEntityTypes.MINDFLAYER.get(), MindflayerEntity.setAttributes());
            event.put(ModEntityTypes.DBEAST.get(), DBeastEntity.setAttributes());
            event.put(ModEntityTypes.IDBEAST.get(), IDBeastEntity.setAttributes());
            event.put(ModEntityTypes.GRIMLOCK.get(), GrimlockEntity.setAttributes());
            event.put(ModEntityTypes.SHAMBLINGMOUND.get(), ShamblingMoundEntity.setAttributes());



        }
    }
}
