package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GrimlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GrimlockModel extends AnimatedGeoModel<GrimlockEntity> {
    @Override
    public ResourceLocation getModelResource(GrimlockEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/grimlock.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GrimlockEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/grimlock.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GrimlockEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/grimlock.animation.json");
    }
}
