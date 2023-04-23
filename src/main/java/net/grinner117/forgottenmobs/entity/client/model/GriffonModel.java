package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GriffonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GriffonModel extends AnimatedGeoModel<GriffonEntity> {
    @Override
    public ResourceLocation getModelResource(GriffonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/griffon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GriffonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/griffon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GriffonEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/griffon.animation.json");
    }
}
