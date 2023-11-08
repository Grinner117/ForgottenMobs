package net.grinner117.forgottenplant;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottenplant.entity.ModEntityTypes;
import net.grinner117.forgottenplant.entity.client.renderer.projectile.NeedleRenderer;
import net.grinner117.forgottenplant.entity.client.renderer.NeedleBlightRenderer;
import net.grinner117.forgottenplant.entity.client.renderer.ShamblingMoundRenderer;
import net.grinner117.forgottenplant.entity.client.renderer.TwigBlightRenderer;
import net.grinner117.forgottenplant.entity.client.renderer.VineBlightRenderer;
import net.grinner117.forgottenplant.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
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

@Mod(ForgottenPlant.MODID)
public class ForgottenPlant {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "forgottenplant";
	private static final Logger LOGGER = LogUtils.getLogger();

	// Directly reference a slf4j logger
	public ForgottenPlant() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.register(modEventBus);

		ModEntityTypes.register(modEventBus);

		GeckoLib.initialize();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private static void run() {

		SpawnPlacements.register(ModEntityTypes.NEEDLEBLIGHT.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(ModEntityTypes.TWIGBLIGHT.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(ModEntityTypes.VINEBLIGHT.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);


		SpawnPlacements.register(ModEntityTypes.SHAMBLINGMOUND.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(ForgottenPlant::run);
	}

	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

			EntityRenderers.register(ModEntityTypes.NEEDLE.get(), NeedleRenderer::new);
			EntityRenderers.register(ModEntityTypes.NEEDLEBLIGHT.get(), NeedleBlightRenderer::new);
			EntityRenderers.register(ModEntityTypes.TWIGBLIGHT.get(), TwigBlightRenderer::new);
			EntityRenderers.register(ModEntityTypes.VINEBLIGHT.get(), VineBlightRenderer::new);

			EntityRenderers.register(ModEntityTypes.SHAMBLINGMOUND.get(), ShamblingMoundRenderer::new);

		}
	}
}
