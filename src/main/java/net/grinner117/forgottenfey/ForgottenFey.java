package net.grinner117.forgottenfey;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottenfey.curios.client.CuriosLayerDefinitions;
import net.grinner117.forgottenfey.curios.client.model.CrownModel;
import net.grinner117.forgottenfey.curios.client.renderer.CrownRenderer;
import net.grinner117.forgottenfey.curios.common.ModCurios;
import net.grinner117.forgottenfey.entity.ModEntityTypes;
import net.grinner117.forgottenfey.entity.client.renderer.*;
import net.grinner117.forgottenfey.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;

import java.util.Arrays;
import java.util.stream.Collectors;


@Mod(ForgottenFey.MODID)
public class ForgottenFey {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "forgottenfey";
	private static final Logger LOGGER = LogUtils.getLogger();

	// Directly reference a slf4j logger
	public ForgottenFey() {

		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::enqueue);
		eventBus.addListener(this::clientSetup);
		eventBus.addListener(this::registerLayers);
		MinecraftForge.EVENT_BUS.addListener(this::attributeModifier);
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.register(modEventBus);
		ModCurios.register(modEventBus);
		ModEntityTypes.register(modEventBus);
		GeckoLib.initialize();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private static void run() {
		SpawnPlacements.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINFIGHTER.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINARCHER.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINSHAMAN.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GREENHAG.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(ModEntityTypes.UNICORN.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Mob::checkMobSpawnRules);


		SpawnPlacements.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GRIMLOCK.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(ForgottenFey::run);
	}

	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {

			EntityRenderers.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINFIGHTER.get(), GoblinFighterRenderer::new);
			EntityRenderers.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINARCHER.get(), GoblinArcherRenderer::new);
			EntityRenderers.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GOBLINSHAMAN.get(), GoblinShamanRenderer::new);

			EntityRenderers.register(ModEntityTypes.GREENHAG.get(), GreenHagRenderer::new);

			EntityRenderers.register(ModEntityTypes.UNICORN.get(), UnicornRenderer::new);
			EntityRenderers.register(ModEntityTypes.GRIMLOCK.get(), GrimlockRenderer::new);

		}
	}


	private void attributeModifier(final CurioAttributeModifierEvent evt) {

		if (evt.getSlotContext().identifier().equals("curio")) {
			evt.clearModifiers();
			evt.addModifier(Attributes.MAX_HEALTH, new AttributeModifier(evt.getUuid(), "test", 10.0d,
					AttributeModifier.Operation.ADDITION));
		}
	}

	private void enqueue(final InterModEnqueueEvent evt) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> Arrays.stream(SlotTypePreset.values())
						.map(preset -> preset.getMessageBuilder().cosmetic().build())
						.collect(Collectors.toList()));
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> new SlotTypeMessage.Builder("test").build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> new SlotTypeMessage.Builder("legacy").build());
	}

	//Register the Curios Here
	private void clientSetup(final FMLClientSetupEvent evt) {

		CuriosRendererRegistry.register(ModCurios.CROWN.get(), CrownRenderer::new);
	}

	//Register the Curios Here
	private void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(CuriosLayerDefinitions.CROWN, CrownModel::createLayer);
	}

}
