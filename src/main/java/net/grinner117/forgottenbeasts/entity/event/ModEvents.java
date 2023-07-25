package net.grinner117.forgottenbeasts.entity.event;

import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.grinner117.forgottenbeasts.entity.ModEntityTypes;
import net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenBeasts.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

			event.put(ModEntityTypes.OWLBEARFOREST.get(), net.grinner117.forgottenbeasts.entity.custom.OwlBearForestEntity.setAttributes());
			event.put(ModEntityTypes.OWLBEARSNOW.get(), OwlBearSnowEntity.setAttributes());
			event.put(ModEntityTypes.STIRGE.get(), net.grinner117.forgottenbeasts.entity.custom.StirgeEntity.setAttributes());

			event.put(ModEntityTypes.GRIFFON.get(), net.grinner117.forgottenbeasts.entity.custom.GriffonEntity.setAttributes());
		}
	}
}
