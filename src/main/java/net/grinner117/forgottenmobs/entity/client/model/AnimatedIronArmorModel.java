package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedIronArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedIronArmorModel extends GeoModel<AnimatedIronArmorEntity> {
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
