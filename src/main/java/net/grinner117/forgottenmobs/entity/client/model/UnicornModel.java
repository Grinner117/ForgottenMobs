package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.UnicornEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UnicornModel extends AnimatedGeoModel<UnicornEntity> {
    @Override
    public ResourceLocation getModelResource(UnicornEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/unicorn.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(UnicornEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/unicorn.png");
    }
    @Override
    public ResourceLocation getAnimationResource(UnicornEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/unicorn.animation.json");
    }
}
