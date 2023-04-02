package net.grinner117.forgottenmobs.entity.client.model.beholder;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.beholder.Beholder71Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Beholder71Model extends AnimatedGeoModel<Beholder71Entity> {
    @Override
    public ResourceLocation getModelResource(Beholder71Entity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/beholder7.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(Beholder71Entity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/beholder71.png");
    }
    @Override
    public ResourceLocation getAnimationResource(Beholder71Entity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/beholder.animation.json");
    }
}
