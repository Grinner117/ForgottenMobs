package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.CloudGiantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CloudGiantModel extends AnimatedGeoModel<CloudGiantEntity> {
    @Override
    public ResourceLocation getModelResource(CloudGiantEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/cloudgiant.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(CloudGiantEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/cloudgiant.png");
    }
    @Override
    public ResourceLocation getAnimationResource(CloudGiantEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/cloudgiant.animation.json");
    }
}
