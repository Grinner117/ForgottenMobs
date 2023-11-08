package net.grinner117.forgottenplant.entity.client.model;

import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.custom.TwigBlightEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TwigBlightModel extends AnimatedGeoModel<net.grinner117.forgottenplant.entity.custom.TwigBlightEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenplant.entity.custom.TwigBlightEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "geo/blight.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenplant.entity.custom.TwigBlightEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/blight.png");
    }
    @Override
    public ResourceLocation getAnimationResource(TwigBlightEntity animatable) {
        return new ResourceLocation(ForgottenPlant.MODID, "animations/blight.animation.json");
    }
}
