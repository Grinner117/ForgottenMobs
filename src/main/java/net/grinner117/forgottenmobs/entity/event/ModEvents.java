package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.NeedleBlightEntity;
import net.grinner117.forgottenmobs.entity.custom.ShamblingMoundEntity;
import net.grinner117.forgottenmobs.entity.custom.TwigBlightEntity;
import net.grinner117.forgottenmobs.entity.custom.VineBlightEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
			event.put(ModEntityTypes.NEEDLEBLIGHT.get(), NeedleBlightEntity.setAttributes());
			event.put(ModEntityTypes.TWIGBLIGHT.get(), TwigBlightEntity.setAttributes());
			event.put(ModEntityTypes.VINEBLIGHT.get(), VineBlightEntity.setAttributes());

			event.put(ModEntityTypes.SHAMBLINGMOUND.get(), ShamblingMoundEntity.setAttributes());


		}
	}
}
