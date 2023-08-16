package net.grinner117.forgottendragons;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottendragons.entity.ModEntityTypes;
import net.grinner117.forgottendragons.entity.client.renderer.firedragon.FireAdultDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.firedragon.FireYoungDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.firedragon.FireElderDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.firedragon.FireWyrmlingRenderer;


import net.grinner117.forgottendragons.entity.client.renderer.shadowdragon.ShadowAdultDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.shadowdragon.ShadowElderDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.shadowdragon.ShadowWyrmlingRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.shadowdragon.ShadowYoungDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.whitedragon.WhiteAdultDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.whitedragon.WhiteElderDragonRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.whitedragon.WhiteWyrmlingRenderer;
import net.grinner117.forgottendragons.entity.client.renderer.whitedragon.WhiteYoungDragonRenderer;
import net.grinner117.forgottendragons.item.ModItems;
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

@Mod(ForgottenDragons.MODID)
public class ForgottenDragons {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "forgottendragons";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Directly reference a slf4j logger
    public ForgottenDragons() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        net.grinner117.forgottendragons.entity.ModEntityTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private static void run() {

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWWYRMLING.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWYOUNGDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWADULTDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.SHADOWELDERDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEWYRMLING.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEYOUNGDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEADULTDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(net.grinner117.forgottendragons.entity.ModEntityTypes.WHITEELDERDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.FIREWYRMLING.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.FIREYOUNGDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.FIREADULTDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.FIREELDERDRAGON.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ForgottenDragons::run);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntityTypes.SHADOWWYRMLING.get(), ShadowWyrmlingRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHADOWYOUNGDRAGON.get(), ShadowYoungDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHADOWADULTDRAGON.get(), ShadowAdultDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHADOWELDERDRAGON.get(), ShadowElderDragonRenderer::new);

            EntityRenderers.register(ModEntityTypes.WHITEWYRMLING.get(), WhiteWyrmlingRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITEYOUNGDRAGON.get(), WhiteYoungDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITEADULTDRAGON.get(), WhiteAdultDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITEELDERDRAGON.get(), WhiteElderDragonRenderer::new);

            EntityRenderers.register(ModEntityTypes.FIREADULTDRAGON.get(), FireAdultDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.FIREWYRMLING.get(), FireWyrmlingRenderer::new);
            EntityRenderers.register(ModEntityTypes.FIREELDERDRAGON.get(), FireElderDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.FIREYOUNGDRAGON.get(), FireYoungDragonRenderer::new);

        }
    }
}
