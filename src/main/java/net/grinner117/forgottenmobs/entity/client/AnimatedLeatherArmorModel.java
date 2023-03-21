package net.grinner117.forgottenmobs.entity.client;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedArmorModel extends GeoModel<AnimatedArmorEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/animatedarmor.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(AnimatedArmorEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animatedarmorblank.png");
    }
    @Override
    public ResourceLocation getAnimationResource(AnimatedArmorEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/animatedarmor.animation.json");
    }
}
