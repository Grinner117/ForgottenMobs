package net.grinner117.forgottenaberration.entity.client.model.beholder;

import net.grinner117.forgottenaberration.ForgottenAberration;
import net.grinner117.forgottenaberration.entity.custom.Beholder71Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Beholder71Model extends AnimatedGeoModel<net.grinner117.forgottenaberration.entity.custom.Beholder71Entity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenaberration.entity.custom.Beholder71Entity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "geo/beholder7.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenaberration.entity.custom.Beholder71Entity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "textures/entity/beholder71.png");
    }
    @Override
    public ResourceLocation getAnimationResource(Beholder71Entity animatable) {
        return new ResourceLocation(ForgottenAberration.MODID, "animations/beholder.animation.json");
    }
}
