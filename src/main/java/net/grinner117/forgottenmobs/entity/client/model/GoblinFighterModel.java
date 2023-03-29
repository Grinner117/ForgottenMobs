package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GoblinFighterEnity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoblinFighterModel extends AnimatedGeoModel<GoblinFighterEnity> {
    @Override
    public ResourceLocation getModelResource(GoblinFighterEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/goblinfighter.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinFighterEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinfighter.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinFighterEnity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/goblinfighter.animation.json");
    }
}
