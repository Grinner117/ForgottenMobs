package net.grinner117.forgottenbeasts.entity.client.model;

import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.grinner117.forgottenbeasts.entity.custom.GriffonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GriffonModel extends AnimatedGeoModel<net.grinner117.forgottenbeasts.entity.custom.GriffonEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenbeasts.entity.custom.GriffonEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "geo/griffon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenbeasts.entity.custom.GriffonEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/griffon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GriffonEntity animatable) {
        return new ResourceLocation(ForgottenBeasts.MODID, "animations/griffon.animation.json");
    }
}
