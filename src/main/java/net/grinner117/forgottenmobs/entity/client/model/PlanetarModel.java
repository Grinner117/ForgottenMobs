package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.PlanetarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlanetarModel extends AnimatedGeoModel<PlanetarEntity> {
    @Override
    public ResourceLocation getModelResource(PlanetarEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/planetar.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(PlanetarEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/planetar.png");
    }
    @Override
    public ResourceLocation getAnimationResource(PlanetarEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/planetar.animation.json");
    }
}
