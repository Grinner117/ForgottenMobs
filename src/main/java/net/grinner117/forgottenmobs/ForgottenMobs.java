package net.grinner117.forgottenmobs;


import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.client.renderer.AnimatedGoldArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.AnimatedDiamondArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.AnimatedLeatherArmorRenderer;
import net.grinner117.forgottenmobs.entity.client.renderer.AnimatedIronArmorRenderer;
import net.grinner117.forgottenmobs.item.ModCreativeModeTab;
import net.grinner117.forgottenmobs.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;

@Mod(ForgottenMobs.MODID)
public class ForgottenMobs {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "forgottenmobs";

    // Directly reference a slf4j logger
    public ForgottenMobs() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModEntityTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {


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
        });
    }
    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.FORGOTTENTAB) {

            event.accept(ModItems.ANIMATEDIRONARMOR_SPAWN_EGG);
            event.accept(ModItems.ANIMATEDLEATHERARMOR_SPAWN_EGG);
            event.accept(ModItems.ANIMATEDGOLDARMOR_SPAWN_EGG);
            event.accept(ModItems.ANIMATEDDIAMONDARMOR_SPAWN_EGG);

        }
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.ANIMATEDLEATHERARMOR.get(), AnimatedLeatherArmorRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANIMATEDIRONARMOR.get(), AnimatedIronArmorRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANIMATEDGOLDARMOR.get(), AnimatedGoldArmorRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANIMATEDDIAMONDARMOR.get(), AnimatedDiamondArmorRenderer::new);



        }
    }
}
