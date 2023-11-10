package net.grinner117.forgottendragons.entity.event;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.ModEntityTypes;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueYoungDragonEntity;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireYoungDragonEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.shadowdragon.ShadowYoungDragonEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteAdultDragonEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteElderDragonEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteWyrmlingEntity;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteYoungDragonEntity;
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

			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.FIREWYRMLING.get(), FireWyrmlingEntity.setAttributes());
			event.put(net.grinner117.forgottendragons.entity.ModEntityTypes.FIREYOUNGDRAGON.get(), FireYoungDragonEntity.setAttributes());
			event.put(ModEntityTypes.FIREADULTDRAGON.get(), FireAdultDragonEntity.setAttributes());
			event.put(ModEntityTypes.FIREELDERDRAGON.get(), FireElderDragonEntity.setAttributes());

			event.put(ModEntityTypes.BLUEWYRMLING.get(), BlueWyrmlingEntity.setAttributes());
			event.put(ModEntityTypes.BLUEYOUNGDRAGON.get(), BlueYoungDragonEntity.setAttributes());
			event.put(ModEntityTypes.BLUEADULTDRAGON.get(), BlueAdultDragonEntity.setAttributes());
			event.put(ModEntityTypes.BLUEELDERDRAGON.get(), BlueElderDragonEntity.setAttributes());

		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
	public class ArmorHandlers {

	}

}
