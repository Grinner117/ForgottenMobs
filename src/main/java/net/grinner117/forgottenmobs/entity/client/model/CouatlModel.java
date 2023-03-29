package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.CouatlEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CouatlModel extends AnimatedGeoModel<CouatlEntity> {
    @Override
    public ResourceLocation getModelResource(CouatlEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/couatl.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(CouatlEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/couatl.png");
    }
    @Override
    public ResourceLocation getAnimationResource(CouatlEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/couatl.animation.json");
    }
}
