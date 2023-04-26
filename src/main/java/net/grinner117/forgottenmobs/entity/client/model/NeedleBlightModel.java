package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.NeedleBlightEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NeedleBlightModel extends AnimatedGeoModel<NeedleBlightEntity> {
    @Override
    public ResourceLocation getModelResource(NeedleBlightEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/blight.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(NeedleBlightEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/blight.png");
    }
    @Override
    public ResourceLocation getAnimationResource(NeedleBlightEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/blight.animation.json");
    }
}
