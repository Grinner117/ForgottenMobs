package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GoblinArcherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoblinArcherModel extends AnimatedGeoModel<GoblinArcherEntity> {
    @Override
    public ResourceLocation getModelResource(GoblinArcherEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/goblinarcher.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinArcherEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinarcher.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinArcherEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/goblinarcher.animation.json");
    }
}
