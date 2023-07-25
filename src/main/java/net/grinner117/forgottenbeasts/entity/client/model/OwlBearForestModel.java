package net.grinner117.forgottenbeasts.entity.client.model;

import net.grinner117.forgottenbeasts.entity.custom.OwlBearForestEntity;
import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OwlBearForestModel extends AnimatedGeoModel<net.grinner117.forgottenbeasts.entity.custom.OwlBearForestEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenbeasts.entity.custom.OwlBearForestEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "geo/owlbear.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenbeasts.entity.custom.OwlBearForestEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/owlbearforest.png");
    }
    @Override
    public ResourceLocation getAnimationResource(OwlBearForestEntity animatable) {
        return new ResourceLocation(ForgottenBeasts.MODID, "animations/owlbear.animation.json");
    }
}
