package net.grinner117.forgottenfey.entity.client.model;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.custom.UnicornEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UnicornModel extends AnimatedGeoModel<UnicornEntity> {
    @Override
    public ResourceLocation getModelResource(UnicornEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "geo/unicorn.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(UnicornEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/unicorn.png");
    }
    @Override
    public ResourceLocation getAnimationResource(UnicornEntity animatable) {
        return new ResourceLocation(ForgottenFey.MODID, "animations/unicorn.animation.json");
    }
}
