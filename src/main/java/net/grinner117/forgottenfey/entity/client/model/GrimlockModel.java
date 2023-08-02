package net.grinner117.forgottenfey.entity.client.model;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.custom.GrimlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GrimlockModel extends AnimatedGeoModel<GrimlockEntity> {
    @Override
    public ResourceLocation getModelResource(GrimlockEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "geo/grimlock.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GrimlockEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/grimlock.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GrimlockEntity animatable) {
        return new ResourceLocation(ForgottenFey.MODID, "animations/grimlock.animation.json");
    }
}
