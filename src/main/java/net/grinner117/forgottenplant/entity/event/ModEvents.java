package net.grinner117.forgottenplant.entity.event;

import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.ModEntityTypes;
import net.grinner117.forgottenplant.entity.custom.NeedleBlightEntity;
import net.grinner117.forgottenplant.entity.custom.ShamblingMoundEntity;
import net.grinner117.forgottenplant.entity.custom.TwigBlightEntity;
import net.grinner117.forgottenplant.entity.custom.VineBlightEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenPlant.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			event.put(net.grinner117.forgottenplant.entity.ModEntityTypes.NEEDLEBLIGHT.get(), NeedleBlightEntity.setAttributes());
			event.put(net.grinner117.forgottenplant.entity.ModEntityTypes.TWIGBLIGHT.get(), TwigBlightEntity.setAttributes());
			event.put(net.grinner117.forgottenplant.entity.ModEntityTypes.VINEBLIGHT.get(), VineBlightEntity.setAttributes());

			event.put(ModEntityTypes.SHAMBLINGMOUND.get(), ShamblingMoundEntity.setAttributes());


		}
	}
}
