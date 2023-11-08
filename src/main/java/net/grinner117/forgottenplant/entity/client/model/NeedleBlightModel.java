package net.grinner117.forgottenplant.entity.client.model;

import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.custom.NeedleBlightEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NeedleBlightModel extends AnimatedGeoModel<NeedleBlightEntity> {
    @Override
    public ResourceLocation getModelResource(NeedleBlightEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "geo/blight.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(NeedleBlightEntity object) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/blight.png");
    }
    @Override
    public ResourceLocation getAnimationResource(NeedleBlightEntity animatable) {
        return new ResourceLocation(ForgottenPlant.MODID, "animations/blight.animation.json");
    }
}
