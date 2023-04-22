package net.grinner117.forgottenmobs.entity.client.model.animatedarmor;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.animatedarmor.AnimatedGoldArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedGoldArmorModel extends AnimatedGeoModel<AnimatedGoldArmorEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedGoldArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/animatedarmor.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(AnimatedGoldArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animatedgoldarmor.png");
    }
    @Override
    public ResourceLocation getAnimationResource(AnimatedGoldArmorEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/animatedarmor.animation.json");
    }


}