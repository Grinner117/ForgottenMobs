package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GreenHagEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenHagModel extends AnimatedGeoModel<GreenHagEntity> {
    @Override
    public ResourceLocation getModelResource(GreenHagEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/hag.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GreenHagEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/greenhag.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GreenHagEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/hag.animation.json");
    }
}
