package net.grinner117.forgottenaberration.entity.event;

import net.grinner117.forgottenaberration.entity.ModEntityTypes;
import net.grinner117.forgottenaberration.ForgottenAberration;
import net.grinner117.forgottenaberration.entity.custom.IDBeastEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenAberration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

			event.put(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER71.get(), net.grinner117.forgottenaberration.entity.custom.Beholder71Entity.setAttributes());
			event.put(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER72.get(), net.grinner117.forgottenaberration.entity.custom.Beholder72Entity.setAttributes());

			event.put(net.grinner117.forgottenaberration.entity.ModEntityTypes.INTELLECTDEVOURER.get(), net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity.setAttributes());
			event.put(net.grinner117.forgottenaberration.entity.ModEntityTypes.MINDFLAYER.get(), net.grinner117.forgottenaberration.entity.custom.MindflayerEntity.setAttributes());
			event.put(net.grinner117.forgottenaberration.entity.ModEntityTypes.DBEAST.get(), net.grinner117.forgottenaberration.entity.custom.DBeastEntity.setAttributes());
			event.put(ModEntityTypes.IDBEAST.get(), IDBeastEntity.setAttributes());


		}
	}
}
