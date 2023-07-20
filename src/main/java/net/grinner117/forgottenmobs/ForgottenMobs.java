package net.grinner117.forgottenmobs;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.client.renderer.*;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedDiamondArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedGoldArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedIronArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor.AnimatedLeatherArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.beholder.Beholder71Renderer;
import net.grinner117.forgottenmobs.entity.client.renderer.beholder.Beholder72Renderer;
import net.grinner117.forgottenmobs.entity.client.renderer.goblin.GoblinArcherRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.goblin.GoblinFighterRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.goblin.GoblinShamanRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.projectile.NeedleRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.shadowdragon.ShadowAdultDragonRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.shadowdragon.ShadowElderDragonRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.shadowdragon.ShadowWyrmlingRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.shadowdragon.ShadowYoungDragonRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.whitedragon.WhiteAdultDragonRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.whitedragon.WhiteElderDragonRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.whitedragon.WhiteWyrmlingRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.whitedragon.WhiteYoungDragonRenderer;
import net.grinner117.forgottenmobs.block.ModBlocks;
import net.grinner117.forgottenmobs.item.ModItems;
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
        ModBlocks.BLOCKS.register(modEventBus);


        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private static void run() {
        SpawnPlacements.register(ModEntityTypes.ANIMATEDLEATHERARMOR.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.ANIMATEDIRONARMOR.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.ANIMATEDGOLDARMOR.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.ANIMATEDDIAMONDARMOR.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.SHADOWWYRMLING.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.SHADOWYOUNGDRAGON.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.SHADOWADULTDRAGON.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.WHITEELDERDRAGON.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);
        SpawnPlacements.register(ModEntityTypes.WHITEWYRMLING.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.WHITEYOUNGDRAGON.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.WHITEADULTDRAGON.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.WHITEELDERDRAGON.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.GOBLINFIGHTER.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.GOBLINARCHER.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.GOBLINSHAMAN.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);


        SpawnPlacements.register(ModEntityTypes.BEHOLDER71.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.BEHOLDER72.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.GREENHAG.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.OWLBEARFOREST.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.OWLBEARSNOW.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.NEEDLEBLIGHT.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.TWIGBLIGHT.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);


        SpawnPlacements.register(ModEntityTypes.VINEBLIGHT.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);


        SpawnPlacements.register(ModEntityTypes.UNICORN.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.GRIFFON.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.COUATL.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

        SpawnPlacements.register(ModEntityTypes.INTELLECTDEVOURER.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.CLOUDGIANT.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.GHOST.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.MINDFLAYER.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.DBEAST.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.GRIMLOCK.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.SHAMBLINGMOUND.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ForgottenMobs::run);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.ANIMATEDLEATHERARMOR.get(), AnimatedLeatherArmorRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANIMATEDIRONARMOR.get(), AnimatedIronArmorRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANIMATEDGOLDARMOR.get(), AnimatedGoldArmorRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANIMATEDDIAMONDARMOR.get(), AnimatedDiamondArmorRenderer::new);

            EntityRenderers.register(ModEntityTypes.SHADOWWYRMLING.get(), ShadowWyrmlingRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHADOWYOUNGDRAGON.get(), ShadowYoungDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHADOWADULTDRAGON.get(), ShadowAdultDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHADOWELDERDRAGON.get(), ShadowElderDragonRenderer::new);

            EntityRenderers.register(ModEntityTypes.WHITEWYRMLING.get(), WhiteWyrmlingRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITEYOUNGDRAGON.get(), WhiteYoungDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITEADULTDRAGON.get(), WhiteAdultDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.WHITEELDERDRAGON.get(), WhiteElderDragonRenderer::new);

            EntityRenderers.register(ModEntityTypes.GOBLINFIGHTER.get(), GoblinFighterRenderer::new);
            EntityRenderers.register(ModEntityTypes.GOBLINARCHER.get(), GoblinArcherRenderer::new);
            EntityRenderers.register(ModEntityTypes.GOBLINSHAMAN.get(), GoblinShamanRenderer::new);

            EntityRenderers.register(ModEntityTypes.BEHOLDER71.get(), Beholder71Renderer::new);
            EntityRenderers.register(ModEntityTypes.BEHOLDER72.get(), Beholder72Renderer::new);

            EntityRenderers.register(ModEntityTypes.GREENHAG.get(), GreenHagRenderer::new);

            EntityRenderers.register(ModEntityTypes.OWLBEARFOREST.get(), OwlBearForestRenderer::new);
            EntityRenderers.register(ModEntityTypes.OWLBEARSNOW.get(), OwlBearSnowRenderer::new);

            EntityRenderers.register(ModEntityTypes.NEEDLE.get(), NeedleRenderer::new);
            EntityRenderers.register(ModEntityTypes.NEEDLEBLIGHT.get(), NeedleBlightRenderer::new);
            EntityRenderers.register(ModEntityTypes.TWIGBLIGHT.get(), TwigBlightRenderer::new);
            EntityRenderers.register(ModEntityTypes.VINEBLIGHT.get(), VineBlightRenderer::new);

            EntityRenderers.register(ModEntityTypes.UNICORN.get(), UnicornRenderer::new);
            EntityRenderers.register(ModEntityTypes.GRIFFON.get(), GriffonRenderer::new);
            EntityRenderers.register(ModEntityTypes.COUATL.get(), CouatlRenderer::new);
            EntityRenderers.register(ModEntityTypes.INTELLECTDEVOURER.get(), IntellectDevourerRenderer::new);
            EntityRenderers.register(ModEntityTypes.MINDFLAYER.get(),MindflayerRenderer::new);
            EntityRenderers.register(ModEntityTypes.CLOUDGIANT.get(),CloudGiantRenderer::new);
            EntityRenderers.register(ModEntityTypes.GHOST.get(),GhostRenderer::new);
            EntityRenderers.register(ModEntityTypes.DBEAST.get(),DBeastRenderer::new);
            EntityRenderers.register(ModEntityTypes.IDBEAST.get(),IDBeastRenderer::new);
            EntityRenderers.register(ModEntityTypes.GRIMLOCK.get(),GrimlockRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHAMBLINGMOUND.get(),ShamblingMoundRenderer::new);

        }
    }
}
