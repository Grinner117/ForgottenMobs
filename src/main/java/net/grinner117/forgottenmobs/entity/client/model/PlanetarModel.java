package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenAngels;
import net.grinner117.forgottenmobs.entity.custom.PlanetarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlanetarModel extends AnimatedGeoModel<PlanetarEntity> {
    @Override
    public ResourceLocation getModelResource(PlanetarEntity object) {
        return new ResourceLocation(ForgottenAngels.MODID, "geo/planetar.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(PlanetarEntity object) {
        return new ResourceLocation(ForgottenAngels.MODID, "textures/entity/planetar.png");
    }
    @Override
    public ResourceLocation getAnimationResource(PlanetarEntity animatable) {
        return new ResourceLocation(ForgottenAngels.MODID, "animations/planetar.animation.json");
    }
}
