package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenPlant;
import net.grinner117.forgottenmobs.entity.custom.ShamblingMoundEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShamblingMoundModel extends AnimatedGeoModel<ShamblingMoundEntity> {
    @Override
    public ResourceLocation getModelResource(ShamblingMoundEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "geo/shamblingmound.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(ShamblingMoundEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/shamblingmound.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ShamblingMoundEntity animatable) {
        return new ResourceLocation(ForgottenPlant.MODID, "animations/shamblingmound.animation.json");
    }
}
