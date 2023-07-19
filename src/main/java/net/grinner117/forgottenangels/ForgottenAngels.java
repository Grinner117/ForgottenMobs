package net.grinner117.forgottenangels;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottenangels.block.ModBlocks;
import net.grinner117.forgottenangels.entity.ModEntityTypes;
import net.grinner117.forgottenangels.entity.client.renderer.DevaRenderer;
import net.grinner117.forgottenangels.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.SpawnPlacements;
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

@Mod(ForgottenAngels.MODID)
public class ForgottenAngels {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "forgottenangels";
	private static final Logger LOGGER = LogUtils.getLogger();

	// Directly reference a slf4j logger
	public ForgottenAngels() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.register(modEventBus);

		net.grinner117.forgottenangels.entity.ModEntityTypes.register(modEventBus);
		ModBlocks.BLOCKS.register(modEventBus);


		GeckoLib.initialize();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private static void run() {
		SpawnPlacements.register(net.grinner117.forgottenangels.entity.ModEntityTypes.PLANETAR.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				FlyingMob::checkMobSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenangels.entity.ModEntityTypes.DEVA.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				FlyingMob::checkMobSpawnRules);

	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(ForgottenAngels::run);
	}

	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			EntityRenderers.register(net.grinner117.forgottenangels.entity.ModEntityTypes.PLANETAR.get(), net.grinner117.forgottenangels.entity.client.renderer.PlanetarRenderer::new);
			EntityRenderers.register(ModEntityTypes.DEVA.get(), DevaRenderer::new);
		}
	}
}
