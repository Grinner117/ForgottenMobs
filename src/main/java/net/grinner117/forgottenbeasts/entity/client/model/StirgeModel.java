package net.grinner117.forgottenbeasts.entity.client.model;

import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StirgeModel extends AnimatedGeoModel<StirgeEntity> {
    @Override
    public ResourceLocation getModelResource(StirgeEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "geo/stirge.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(StirgeEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/stirge.png");
    }
    @Override
    public ResourceLocation getAnimationResource(StirgeEntity animatable) {
        return new ResourceLocation(ForgottenBeasts.MODID, "animations/stirge.animation.json");
    }
}
