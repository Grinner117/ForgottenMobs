package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.DevaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DevaModel extends AnimatedGeoModel<DevaEntity> {
    @Override
    public ResourceLocation getModelResource(DevaEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/deva.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(DevaEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/deva.png");
    }
    @Override
    public ResourceLocation getAnimationResource(DevaEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/planetar.animation.json");
    }
}
