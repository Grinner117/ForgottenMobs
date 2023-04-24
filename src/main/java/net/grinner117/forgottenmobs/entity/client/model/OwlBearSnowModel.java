package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.OwlBearSnowEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OwlBearSnowModel extends AnimatedGeoModel<OwlBearSnowEntity> {
    @Override
    public ResourceLocation getModelResource(OwlBearSnowEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/owlbear.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(OwlBearSnowEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/owlbearsnow.png");
    }
    @Override
    public ResourceLocation getAnimationResource(OwlBearSnowEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/owlbear.animation.json");
    }
}
