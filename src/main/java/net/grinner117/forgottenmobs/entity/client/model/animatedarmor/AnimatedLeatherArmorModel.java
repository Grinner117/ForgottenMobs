package net.grinner117.forgottenmobs.entity.client.model.animatedarmor;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedLeatherArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedLeatherArmorModel extends AnimatedGeoModel<AnimatedLeatherArmorEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedLeatherArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/animatedarmor.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(AnimatedLeatherArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animatedleatherarmor.png");
    }
    @Override
    public ResourceLocation getAnimationResource(AnimatedLeatherArmorEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/animatedarmor.animation.json");
    }
}
