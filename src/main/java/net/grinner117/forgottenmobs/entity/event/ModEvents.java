package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenAngels;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenAngels.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			event.put(ModEntityTypes.PLANETAR.get(), PlanetarEntity.setAttributes());
			event.put(ModEntityTypes.DEVA.get(), DevaEntity.setAttributes());


		}
	}
}
