package net.grinner117.forgottenaberration.entity.client.model;

import net.grinner117.forgottenaberration.entity.custom.MindflayerEntity;
import net.grinner117.forgottenaberration.ForgottenAberration;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MindflayerModel extends AnimatedGeoModel<net.grinner117.forgottenaberration.entity.custom.MindflayerEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenaberration.entity.custom.MindflayerEntity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "geo/mindflayer.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenaberration.entity.custom.MindflayerEntity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "textures/entity/mindflayer.png");
    }
    @Override
    public ResourceLocation getAnimationResource(MindflayerEntity animatable) {
        return new ResourceLocation(ForgottenAberration.MODID, "animations/mindflayer.animation.json");
    }
}
