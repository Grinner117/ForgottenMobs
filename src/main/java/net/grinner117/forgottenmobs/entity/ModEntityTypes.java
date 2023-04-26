package net.grinner117.forgottenmobs.entity;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.*;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedDiamondArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedGoldArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedIronArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedLeatherArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.beholder.Beholder71Entity;
import net.grinner117.forgottenmobs.entity.custom.beholder.Beholder72Entity;
import net.grinner117.forgottenmobs.entity.custom.goblin.GoblinArcherEntity;
import net.grinner117.forgottenmobs.entity.custom.goblin.GoblinFighterEntity;
import net.grinner117.forgottenmobs.entity.custom.goblin.GoblinShamanEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowAdultDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowElderDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowWyrmlingEntity;
import net.grinner117.forgottenmobs.entity.custom.shadowdragon.ShadowYoungDragonEntity;
import net.grinner117.forgottenmobs.entity.projectile.NeedleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ForgottenMobs.MODID);
    public static final RegistryObject<EntityType<AnimatedDiamondArmorEntity>> ANIMATEDDIAMONDARMOR =
            ENTITY_TYPES.register("animateddiamondarmor",
                    () -> EntityType.Builder.of(AnimatedDiamondArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animateddiamondarmor").toString()));

    public static final RegistryObject<EntityType<AnimatedLeatherArmorEntity>> ANIMATEDLEATHERARMOR =
            ENTITY_TYPES.register("animatedleatherarmor",
                    () -> EntityType.Builder.of(AnimatedLeatherArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedleatherarmor").toString()));
       public static final RegistryObject<EntityType<AnimatedIronArmorEntity>> ANIMATEDIRONARMOR =
            ENTITY_TYPES.register("animatedironarmor",
                    () -> EntityType.Builder.of(AnimatedIronArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedironarmor").toString()));
    public static final RegistryObject<EntityType<AnimatedGoldArmorEntity>> ANIMATEDGOLDARMOR =
            ENTITY_TYPES.register("animatedgoldarmor",
                    () -> EntityType.Builder.of(AnimatedGoldArmorEntity::new, MobCategory.MONSTER)
                            .sized(0.7F, 1.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"animatedgoldarmor").toString()));

    public static final RegistryObject<EntityType<ShadowWyrmlingEntity>> SHADOWWYRMLING =
            ENTITY_TYPES.register("shadowwyrmling",
                    () -> EntityType.Builder.of(ShadowWyrmlingEntity::new, MobCategory.MONSTER)
                            .sized(1.0F, 1.0F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"shadowwyrmling").toString()));

    public static final RegistryObject<EntityType<ShadowYoungDragonEntity>> SHADOWYOUNGDRAGON =
            ENTITY_TYPES.register("shadowyoungdragon",
                    () -> EntityType.Builder.of(ShadowYoungDragonEntity::new, MobCategory.MONSTER)
                            .sized(1.8F, 1.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"shadowyoungdragon").toString()));
    public static final RegistryObject<EntityType<ShadowAdultDragonEntity>> SHADOWADULTDRAGON =
            ENTITY_TYPES.register("shadowadultdragon",
                    () -> EntityType.Builder.of(ShadowAdultDragonEntity::new, MobCategory.MONSTER)
                            .sized(2.8F, 2.8F).clientTrackingRange(60)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"shadowadultdragon").toString()));
    public static final RegistryObject<EntityType<ShadowElderDragonEntity>> SHADOWELDERDRAGON =
            ENTITY_TYPES.register("shadowelderdragon",
                    () -> EntityType.Builder.of(ShadowElderDragonEntity::new, MobCategory.MONSTER)
                            .sized(3.0F, 3.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"shadowelderdragon").toString()));

    public static final RegistryObject<EntityType<GoblinFighterEntity>> GOBLINFIGHTER =
            ENTITY_TYPES.register("goblinfighter",
                    () -> EntityType.Builder.of(GoblinFighterEntity::new, MobCategory.MONSTER)
                            .sized(0.8F, 0.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"goblinfighter").toString()));

    public static final RegistryObject<EntityType<GoblinArcherEntity>> GOBLINARCHER =
            ENTITY_TYPES.register("goblinarcher",
                    () -> EntityType.Builder.of(GoblinArcherEntity::new, MobCategory.MONSTER)
                            .sized(0.8F, 0.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"goblinarcher").toString()));

    public static final RegistryObject<EntityType<GoblinShamanEntity>> GOBLINSHAMAN =
            ENTITY_TYPES.register("goblinshaman",
                    () -> EntityType.Builder.of(GoblinShamanEntity::new, MobCategory.MONSTER)
                            .sized(0.8F, 0.8F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"goblinshaman").toString()));

    public static final RegistryObject<EntityType<CouatlEntity>> COUATL =
            ENTITY_TYPES.register("couatl",
                    () -> EntityType.Builder.of(CouatlEntity::new, MobCategory.MONSTER)
                            .sized(12.0F, 4.0F).clientTrackingRange(120)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"couatl").toString()));

    public static final RegistryObject<EntityType<Beholder71Entity>> BEHOLDER71 =
            ENTITY_TYPES.register("beholder71",
                    () -> EntityType.Builder.of(Beholder71Entity::new, MobCategory.MONSTER)
                            .sized(2.0F, 3.0F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"beholder71").toString()));

    public static final RegistryObject<EntityType<Beholder72Entity>> BEHOLDER72 =
            ENTITY_TYPES.register("beholder72",
                    () -> EntityType.Builder.of(Beholder72Entity::new, MobCategory.MONSTER)
                            .sized(2.0F, 3.0F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"beholder72").toString()));

    public static final RegistryObject<EntityType<GreenHagEntity>> GREENHAG =
            ENTITY_TYPES.register("greenhag",
                    () -> EntityType.Builder.of(GreenHagEntity::new, MobCategory.MONSTER)
                            .sized(1.0F, 2.0F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"greenhag").toString()));

    public static final RegistryObject<EntityType<OwlBearForestEntity>> OWLBEARFOREST =
            ENTITY_TYPES.register("owlbearforest",
                    () -> EntityType.Builder.of(OwlBearForestEntity::new, MobCategory.MONSTER)
                            .sized(1.6F, 2.6F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"owlbearforest").toString()));

    public static final RegistryObject<EntityType<OwlBearSnowEntity>> OWLBEARSNOW =
            ENTITY_TYPES.register("owlbearsnow",
                    () -> EntityType.Builder.of(OwlBearSnowEntity::new, MobCategory.MONSTER)
                            .sized(1.6F, 2.6F).clientTrackingRange(80)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"owlbearsnow").toString()));

    public static final RegistryObject<EntityType<UnicornEntity>> UNICORN =
            ENTITY_TYPES.register("unicorn",
                    () -> EntityType.Builder.of(UnicornEntity::new, MobCategory.MONSTER)
                            .sized(1.8F, 1.6F).clientTrackingRange(60)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"unicorn").toString()));

    public static final RegistryObject<EntityType<GriffonEntity>> GRIFFON =
            ENTITY_TYPES.register("griffin",
                    () -> EntityType.Builder.of(GriffonEntity::new, MobCategory.MONSTER)
                            .sized(1.8F, 1.6F).clientTrackingRange(60)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"griffin").toString()));

    public static final RegistryObject<EntityType<NeedleBlightEntity>> NEEDLEBLIGHT =
            ENTITY_TYPES.register("needleblight",
                    () -> EntityType.Builder.of(NeedleBlightEntity::new, MobCategory.MONSTER)
                            .sized(1.0F, 1.0F).clientTrackingRange(60)
                            .build(new ResourceLocation(ForgottenMobs.MODID,"needleblight").toString()));

    public static final RegistryObject<EntityType<NeedleEntity>> NEEDLE = ENTITY_TYPES.register("needle",
            () -> EntityType.Builder.of((EntityType.EntityFactory<NeedleEntity>) NeedleEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(ForgottenMobs.MODID,"needle").toString()));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
