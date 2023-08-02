package net.grinner117.forgottenfey;

import com.mojang.logging.LogUtils;
import net.grinner117.forgottenfey.entity.ModEntityTypes;
import net.grinner117.forgottenfey.item.ModItems;
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

@Mod(ForgottenFey.MODID)
public class ForgottenFey {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "forgottenfey";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Directly reference a slf4j logger
    public ForgottenFey() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        net.grinner117.forgottenfey.entity.ModEntityTypes.register(modEventBus);
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

        SpawnPlacements.register(net.grinner117.forgottenfey.entity.ModEntityTypes.UNICORN.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FlyingMob::checkMobSpawnRules);

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

            EntityRenderers.register(net.grinner117.forgottenfey.entity.ModEntityTypes.GREENHAG.get(), GreenHagRenderer::new);

            EntityRenderers.register(net.grinner117.forgottenfey.entity.ModEntityTypes.UNICORN.get(), UnicornRenderer::new);
            EntityRenderers.register(ModEntityTypes.GRIMLOCK.get(), GrimlockRenderer::new);

        }
    }
}
