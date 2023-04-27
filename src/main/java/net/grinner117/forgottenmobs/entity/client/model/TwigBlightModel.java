package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.TwigBlightEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TwigBlightModel extends AnimatedGeoModel<TwigBlightEntity> {
    @Override
    public ResourceLocation getModelResource(TwigBlightEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/blight.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(TwigBlightEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/blight.png");
    }
    @Override
    public ResourceLocation getAnimationResource(TwigBlightEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/blight.animation.json");
    }
}
