package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedGoldArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedGoldArmorModel extends GeoModel<AnimatedGoldArmorEntity> {
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
