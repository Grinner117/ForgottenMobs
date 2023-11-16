package net.grinner117.forgottenmobs.entity.client.model.animatedarmor;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedDiamondArmorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedDiamondArmorModel extends GeoModel<AnimatedDiamondArmorEntity> {
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
        return new ResourceLocation(ForgottenMobs.MODID, "animations/animation.animatedarmor.json");
    }
}
