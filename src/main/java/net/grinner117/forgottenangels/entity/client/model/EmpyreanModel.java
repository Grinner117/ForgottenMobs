package net.grinner117.forgottenangels.entity.client.model;

import net.grinner117.forgottenangels.ForgottenAngels;
import net.grinner117.forgottenangels.entity.custom.EmpyreanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EmpyreanModel extends AnimatedGeoModel<EmpyreanEntity> {
    @Override
    public ResourceLocation getModelResource(EmpyreanEntity object) {
        return new ResourceLocation(ForgottenAngels.MODID, "geo/empyrean.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(EmpyreanEntity object) {
        return new ResourceLocation(ForgottenAngels.MODID, "textures/entity/empyrean.png");
    }
    @Override
    public ResourceLocation getAnimationResource(EmpyreanEntity animatable) {
        return new ResourceLocation(ForgottenAngels.MODID, "animations/empyrean.animation.json");
    }
}
