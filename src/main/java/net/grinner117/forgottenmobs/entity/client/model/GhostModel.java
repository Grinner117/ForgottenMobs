package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GhostEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhostModel extends AnimatedGeoModel<GhostEntity> {
    @Override
    public ResourceLocation getModelResource(GhostEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/ghost.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GhostEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/ghost.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GhostEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/ghost.animation.json");
    }
}
