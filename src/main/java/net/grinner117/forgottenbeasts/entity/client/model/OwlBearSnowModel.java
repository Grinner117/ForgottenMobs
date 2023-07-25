package net.grinner117.forgottenbeasts.entity.client.model;

import net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity;
import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OwlBearSnowModel extends AnimatedGeoModel<net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "geo/owlbear.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity object) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/owlbearsnow.png");
    }
    @Override
    public ResourceLocation getAnimationResource(OwlBearSnowEntity animatable) {
        return new ResourceLocation(ForgottenBeasts.MODID, "animations/owlbear.animation.json");
    }
}
