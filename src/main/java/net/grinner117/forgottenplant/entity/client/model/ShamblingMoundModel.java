package net.grinner117.forgottenplant.entity.client.model;

import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.custom.ShamblingMoundEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShamblingMoundModel extends AnimatedGeoModel<net.grinner117.forgottenplant.entity.custom.ShamblingMoundEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenplant.entity.custom.ShamblingMoundEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "geo/shamblingmound.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenplant.entity.custom.ShamblingMoundEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/shamblingmound.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ShamblingMoundEntity animatable) {
        return new ResourceLocation(ForgottenPlant.MODID, "animations/shamblingmound.animation.json");
    }
}
