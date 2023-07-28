package net.grinner117.forgottendragons.entity.event;

import net.grinner117.forgottendragons.entity.ModEntityTypes;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.ShadowAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.ShadowElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.ShadowWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.ShadowYoungDragonEntity;
import net.grinner117.forgottendragons.entity.custom.WhiteAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.WhiteElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.WhiteWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.WhiteYoungDragonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenDragons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWWYRMLING.get(), ShadowWyrmlingEntity.setAttributes());
			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWYOUNGDRAGON.get(), ShadowYoungDragonEntity.setAttributes());
			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWADULTDRAGON.get(), ShadowAdultDragonEntity.setAttributes());
			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWELDERDRAGON.get(), ShadowElderDragonEntity.setAttributes());

			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEWYRMLING.get(), WhiteWyrmlingEntity.setAttributes());
			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEYOUNGDRAGON.get(), WhiteYoungDragonEntity.setAttributes());
			event.put(ModEntityTypes.WHITEADULTDRAGON.get(), WhiteAdultDragonEntity.setAttributes());
			event.put(ModEntityTypes.WHITEELDERDRAGON.get(), WhiteElderDragonEntity.setAttributes());

		}
	}
}
