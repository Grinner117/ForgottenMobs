package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.IntellectDevourerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IntellectDevourerModel extends AnimatedGeoModel<IntellectDevourerEntity> {
    @Override
    public ResourceLocation getModelResource(IntellectDevourerEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/intellectdevourer.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(IntellectDevourerEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/intellectdevourer.png");
    }
    @Override
    public ResourceLocation getAnimationResource(IntellectDevourerEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/intellectdevourer.animation.json");
    }
}
