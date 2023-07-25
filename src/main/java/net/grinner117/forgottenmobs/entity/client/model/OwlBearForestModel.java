package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenBeasts;
import net.grinner117.forgottenmobs.entity.custom.OwlBearForestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OwlBearForestModel extends AnimatedGeoModel<OwlBearForestEntity> {
    @Override
    public ResourceLocation getModelResource(OwlBearForestEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "geo/owlbear.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(OwlBearForestEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/owlbearforest.png");
    }
    @Override
    public ResourceLocation getAnimationResource(OwlBearForestEntity animatable) {
        return new ResourceLocation(ForgottenBeasts.MODID, "animations/owlbear.animation.json");
    }
}
