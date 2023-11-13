package net.grinner117.forgottenmobs.entity.event;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = ForgottenMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModEventBusEvents {
		@SubscribeEvent
		public static void entityAttributeEvent(EntityAttributeCreationEvent event) {

			event.put(ModEntityTypes.ANIMATEDIRONARMOR.get(), AnimatedIronArmorEntity.setAttributes());
			event.put(ModEntityTypes.ANIMATEDLEATHERARMOR.get(), AnimatedLeatherArmorEntity.setAttributes());
			event.put(ModEntityTypes.ANIMATEDGOLDARMOR.get(), AnimatedGoldArmorEntity.setAttributes());
			event.put(ModEntityTypes.ANIMATEDDIAMONDARMOR.get(), AnimatedDiamondArmorEntity.setAttributes());
			event.put(ModEntityTypes.CLOUDGIANT.get(), CloudGiantEntity.setAttributes());
			event.put(ModEntityTypes.GHOST.get(), GhostEntity.setAttributes());


		}
	}
@SubscribeEvent
	public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {

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


		SpawnPlacements.register(ModEntityTypes.CLOUDGIANT.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

		SpawnPlacements.register(ModEntityTypes.GHOST.get(),
				SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				Monster::checkMonsterSpawnRules);

	}

}
