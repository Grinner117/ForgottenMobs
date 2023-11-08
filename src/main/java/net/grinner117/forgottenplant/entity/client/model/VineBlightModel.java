package net.grinner117.forgottenplant.entity.client.model;

import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.custom.VineBlightEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VineBlightModel extends AnimatedGeoModel<net.grinner117.forgottenplant.entity.custom.VineBlightEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenplant.entity.custom.VineBlightEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "geo/blight.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenplant.entity.custom.VineBlightEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/blight.png");
    }
    @Override
    public ResourceLocation getAnimationResource(VineBlightEntity animatable) {
        return new ResourceLocation(ForgottenPlant.MODID, "animations/blight.animation.json");
    }
}
