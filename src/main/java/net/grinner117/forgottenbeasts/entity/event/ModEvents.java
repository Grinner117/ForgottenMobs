package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenBeasts;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenBeasts.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

			event.put(ModEntityTypes.OWLBEARFOREST.get(), OwlBearForestEntity.setAttributes());
			event.put(ModEntityTypes.OWLBEARSNOW.get(), OwlBearSnowEntity.setAttributes());

			event.put(ModEntityTypes.GRIFFON.get(), GriffonEntity.setAttributes());
		}
	}
}
