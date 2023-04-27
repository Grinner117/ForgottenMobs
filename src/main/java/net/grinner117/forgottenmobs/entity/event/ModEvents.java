package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedDiamondArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedGoldArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedIronArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedLeatherArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.beholder.Beholder71Entity;
import net.grinner117.forgottenmobs.entity.custom.beholder.Beholder72Entity;
import net.grinner117.forgottenmobs.entity.custom.goblin.GoblinArcherEntity;
import net.grinner117.forgottenmobs.entity.custom.goblin.GoblinFighterEntity;
import net.grinner117.forgottenmobs.entity.custom.goblin.GoblinShamanEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowAdultDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowElderDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowWyrmlingEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowYoungDragonEntity;
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

            event.put(ModEntityTypes.GOBLINFIGHTER.get(), GoblinFighterEntity.setAttributes());
            event.put(ModEntityTypes.GOBLINARCHER.get(), GoblinArcherEntity.setAttributes());
            event.put(ModEntityTypes.GOBLINSHAMAN.get(), GoblinShamanEntity.setAttributes());


            event.put(ModEntityTypes.BEHOLDER71.get(), Beholder71Entity.setAttributes());
            event.put(ModEntityTypes.BEHOLDER72.get(), Beholder72Entity.setAttributes());

            event.put(ModEntityTypes.GREENHAG.get(), GreenHagEntity.setAttributes());

            event.put(ModEntityTypes.OWLBEARFOREST.get(), OwlBearForestEntity.setAttributes());
            event.put(ModEntityTypes.OWLBEARSNOW.get(), OwlBearSnowEntity.setAttributes());

            event.put(ModEntityTypes.NEEDLEBLIGHT.get(), NeedleBlightEntity.setAttributes());
            event.put(ModEntityTypes.TWIGBLIGHT.get(), TwigBlightEntity.setAttributes());


            event.put(ModEntityTypes.UNICORN.get(), UnicornEntity.setAttributes());
            event.put(ModEntityTypes.GRIFFON.get(), GriffonEntity.setAttributes());
            event.put(ModEntityTypes.COUATL.get(), CouatlEntity.setAttributes());


        }
    }
}
