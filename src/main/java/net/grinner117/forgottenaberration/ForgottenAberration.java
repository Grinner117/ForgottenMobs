package net.grinner117.forgottenaberration;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottenaberration.entity.ModEntityTypes;
import net.grinner117.forgottenaberration.item.ModItems;
import net.grinner117.forgottenaberration.entity.client.renderer.DBeastRenderer;
import net.grinner117.forgottenaberration.entity.client.renderer.IDBeastRenderer;
import net.grinner117.forgottenaberration.entity.client.renderer.IntellectDevourerRenderer;
import net.grinner117.forgottenaberration.entity.client.renderer.MindflayerRenderer;
import net.grinner117.forgottenaberration.entity.client.renderer.beholder.Beholder71Renderer;
import net.grinner117.forgottenaberration.entity.client.renderer.beholder.Beholder72Renderer;
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

@Mod(ForgottenAberration.MODID)
public class ForgottenAberration {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "forgottenaberration";
	private static final Logger LOGGER = LogUtils.getLogger();

	// Directly reference a slf4j logger
	public ForgottenAberration() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.register(modEventBus);

		net.grinner117.forgottenaberration.entity.ModEntityTypes.register(modEventBus);

		GeckoLib.initialize();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private static void run() {


		SpawnPlacements.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER71.get(),
				SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				FlyingMob::checkMobSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER72.get(),
				SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				FlyingMob::checkMobSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.INTELLECTDEVOURER.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);


		SpawnPlacements.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.MINDFLAYER.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.DBEAST.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);


	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(ForgottenAberration::run);
	}

	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			EntityRenderers.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER71.get(), Beholder71Renderer::new);
			EntityRenderers.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.BEHOLDER72.get(), Beholder72Renderer::new);

			EntityRenderers.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.INTELLECTDEVOURER.get(), IntellectDevourerRenderer::new);
			EntityRenderers.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.MINDFLAYER.get(), MindflayerRenderer::new);

			EntityRenderers.register(net.grinner117.forgottenaberration.entity.ModEntityTypes.DBEAST.get(), DBeastRenderer::new);
			EntityRenderers.register(ModEntityTypes.IDBEAST.get(), IDBeastRenderer::new);

		}
	}
}
