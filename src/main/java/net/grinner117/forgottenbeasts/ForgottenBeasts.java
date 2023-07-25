package net.grinner117.forgottenbeasts;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottenbeasts.entity.ModEntityTypes;
import net.grinner117.forgottenbeasts.entity.client.renderer.OwlBearSnowRenderer;
import net.grinner117.forgottenbeasts.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(ForgottenBeasts.MODID)
public class ForgottenBeasts {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "forgottenbeasts";
	private static final Logger LOGGER = LogUtils.getLogger();

	// Directly reference a slf4j logger
	public ForgottenBeasts() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.register(modEventBus);

		net.grinner117.forgottenbeasts.entity.ModEntityTypes.register(modEventBus);

		GeckoLib.initialize();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private static void run() {


		SpawnPlacements.register(net.grinner117.forgottenbeasts.entity.ModEntityTypes.OWLBEARFOREST.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenbeasts.entity.ModEntityTypes.OWLBEARSNOW.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenbeasts.entity.ModEntityTypes.GRIFFON.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				FlyingMob::checkMobSpawnRules);

		SpawnPlacements.register(ModEntityTypes.STIRGE.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				FlyingMob::checkMobSpawnRules);

	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(ForgottenBeasts::run);
	}

	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

			EntityRenderers.register(net.grinner117.forgottenbeasts.entity.ModEntityTypes.OWLBEARFOREST.get(), net.grinner117.forgottenbeasts.entity.client.renderer.OwlBearForestRenderer::new);
			EntityRenderers.register(net.grinner117.forgottenbeasts.entity.ModEntityTypes.OWLBEARSNOW.get(), OwlBearSnowRenderer::new);
			EntityRenderers.register(ModEntityTypes.STIRGE.get(), net.grinner117.forgottenbeasts.entity.client.renderer.StirgeRenderer::new);

			EntityRenderers.register(ModEntityTypes.GRIFFON.get(), net.grinner117.forgottenbeasts.entity.client.renderer.GriffonRenderer::new);

		}
	}
}
