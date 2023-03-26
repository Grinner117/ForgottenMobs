package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GoblinArcherEnity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoblinArcherModel extends GeoModel<GoblinArcherEnity> {
    @Override
    public ResourceLocation getModelResource(GoblinArcherEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/goblinarcher.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinArcherEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinarcher.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinArcherEnity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/goblinarcher.animation.json");
    }
}
