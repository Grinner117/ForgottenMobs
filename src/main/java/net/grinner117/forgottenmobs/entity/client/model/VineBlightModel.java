package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.VineBlightEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VineBlightModel extends AnimatedGeoModel<VineBlightEntity> {
    @Override
    public ResourceLocation getModelResource(VineBlightEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/blight.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(VineBlightEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/blight.png");
    }
    @Override
    public ResourceLocation getAnimationResource(VineBlightEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/blight.animation.json");
    }
}
