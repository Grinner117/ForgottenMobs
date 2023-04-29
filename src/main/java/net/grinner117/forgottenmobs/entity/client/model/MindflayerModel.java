package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.MindflayerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MindflayerModel extends AnimatedGeoModel<MindflayerEntity> {
    @Override
    public ResourceLocation getModelResource(MindflayerEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/mindflayer.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(MindflayerEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/mindflayer.png");
    }
    @Override
    public ResourceLocation getAnimationResource(MindflayerEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/mindflayer.animation.json");
    }
}
