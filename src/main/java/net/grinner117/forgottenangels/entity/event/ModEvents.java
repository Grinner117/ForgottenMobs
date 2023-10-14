package net.grinner117.forgottenangels.entity.event;

import net.grinner117.forgottenangels.ForgottenAngels;
import net.grinner117.forgottenangels.entity.ModEntityTypes;
import net.grinner117.forgottenangels.entity.custom.DevaEntity;
import net.grinner117.forgottenangels.entity.custom.EmpyreanEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenAngels.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			event.put(net.grinner117.forgottenangels.entity.ModEntityTypes.PLANETAR.get(), net.grinner117.forgottenangels.entity.custom.PlanetarEntity.setAttributes());
			event.put(ModEntityTypes.DEVA.get(), DevaEntity.setAttributes());
			event.put(ModEntityTypes.EMPYREAN.get(), EmpyreanEntity.setAttributes());


		}
	}
}
