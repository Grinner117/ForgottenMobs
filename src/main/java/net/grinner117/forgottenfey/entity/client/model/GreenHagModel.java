package net.grinner117.forgottenfey.entity.client.model;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.custom.GreenHagEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenHagModel extends AnimatedGeoModel<GreenHagEntity> {
    @Override
    public ResourceLocation getModelResource(GreenHagEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "geo/hag.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GreenHagEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/greenhag.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GreenHagEntity animatable) {
        return new ResourceLocation(ForgottenFey.MODID, "animations/hag.animation.json");
    }
}
