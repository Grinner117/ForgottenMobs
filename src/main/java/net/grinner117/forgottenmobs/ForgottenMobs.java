package net.grinner117.forgottenmobs;


import com.mojang.logging.LogUtils;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.client.renderer.CloudGiantRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.GhostRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedDiamondArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedGoldArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedIronArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedLeatherArmorRenderer;
import net.grinner117.forgottenmobs.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(ForgottenMobs.MODID)
public class ForgottenMobs {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "forgottenmobs";
	private static final Logger LOGGER = LogUtils.getLogger();

	// Directly reference a slf4j logger
	public ForgottenMobs() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.register(modEventBus);

		ModEntityTypes.register(modEventBus);

		GeckoLib.initialize();

		modEventBus.addListener(this::commonSetup);
		MinecraftForge.EVENT_BUS.register(this);

//		modEventBus.addListener(this::addCreative);
//
//		ModCreativeModeTab.register(modEventBus);

	}

//	private void addCreative(BuildCreativeModeTabContentsEvent event) {
//		if (event.getTabKey() == CreativeModeTab.FORGOTTENTAB) {
//			event.accept(ModItems.ANIMATEDDIAMONDARMOR_SPAWN_EGG.get());
//			event.accept(ModItems.ANIMATEDLEATHERARMOR_SPAWN_EGG.get());
//			event.accept(ModItems.ANIMATEDIRONARMOR_SPAWN_EGG.get());
//			event.accept(ModItems.ANIMATEDGOLDARMOR_SPAWN_EGG.get());
//			event.accept(ModItems.NEEDLE.get());
//			event.accept(ModItems.CLOUDGIANT_SPAWN_EGG.get());
//			event.accept(ModItems.GHOST_SPAWN_EGG.get());
//			event.accept(ModItems.GHOST_ASH.get());
//
//		}
//}




		private void commonSetup ( final FMLCommonSetupEvent event){
		}

		@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
		public static class ClientModEvents {
			@SubscribeEvent
			public static void onClientSetup(FMLClientSetupEvent event) {
				EntityRenderers.register(ModEntityTypes.ANIMATEDLEATHERARMOR.get(), AnimatedLeatherArmorRenderer::new);
				EntityRenderers.register(ModEntityTypes.ANIMATEDIRONARMOR.get(), AnimatedIronArmorRenderer::new);
				EntityRenderers.register(ModEntityTypes.ANIMATEDGOLDARMOR.get(), AnimatedGoldArmorRenderer::new);
				EntityRenderers.register(ModEntityTypes.ANIMATEDDIAMONDARMOR.get(), AnimatedDiamondArmorRenderer::new);

				EntityRenderers.register(ModEntityTypes.CLOUDGIANT.get(), CloudGiantRenderer::new);
				EntityRenderers.register(ModEntityTypes.GHOST.get(), GhostRenderer::new);

			}
		}
	}
