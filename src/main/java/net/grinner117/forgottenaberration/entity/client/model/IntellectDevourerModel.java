package net.grinner117.forgottenaberration.entity.client.model;

import net.grinner117.forgottenaberration.ForgottenAberration;
import net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IntellectDevourerModel extends AnimatedGeoModel<net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "geo/intellectdevourer.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "textures/entity/intellectdevourer.png");
    }
    @Override
    public ResourceLocation getAnimationResource(IntellectDevourerEntity animatable) {
        return new ResourceLocation(ForgottenAberration.MODID, "animations/intellectdevourer.animation.json");
    }
}
