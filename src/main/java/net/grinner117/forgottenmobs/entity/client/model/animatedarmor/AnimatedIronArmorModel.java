package net.grinner117.forgottenmobs.entity.client.model.animatedarmor;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedIronArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedIronArmorModel extends AnimatedGeoModel<AnimatedIronArmorEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedIronArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/animatedarmor.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(AnimatedIronArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animatedironarmor.png");
    }
    @Override
    public ResourceLocation getAnimationResource(AnimatedIronArmorEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/animatedarmor.animation.json");
    }
}