package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GoblinFighterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoblinFighterModel extends AnimatedGeoModel<GoblinFighterEntity> {
    @Override
    public ResourceLocation getModelResource(GoblinFighterEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/goblinfighter.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinFighterEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinfighter.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinFighterEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/goblinfighter.animation.json");
    }
}
