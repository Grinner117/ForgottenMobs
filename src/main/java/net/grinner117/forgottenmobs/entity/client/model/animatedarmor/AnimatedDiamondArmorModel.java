package net.grinner117.forgottenmobs.entity.client.model.animatedarmor;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedDiamondArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedDiamondArmorModel extends AnimatedGeoModel<AnimatedDiamondArmorEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedDiamondArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/animatedarmor.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(AnimatedDiamondArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animateddiamondarmor.png");
    }
    @Override
    public ResourceLocation getAnimationResource(AnimatedDiamondArmorEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/animatedarmor.animation.json");
    }
}
