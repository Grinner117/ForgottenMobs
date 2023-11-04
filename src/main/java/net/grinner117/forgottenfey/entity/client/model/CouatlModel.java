package net.grinner117.forgottenfey.entity.client.model;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.custom.CouatlEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CouatlModel extends AnimatedGeoModel<CouatlEntity> {
    @Override
    public ResourceLocation getModelResource(CouatlEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "geo/couatl.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(CouatlEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/couatl.png");
    }
    @Override
    public ResourceLocation getAnimationResource(CouatlEntity animatable) {
        return new ResourceLocation(ForgottenFey.MODID, "animations/couatl.animation.json");
    }
}
