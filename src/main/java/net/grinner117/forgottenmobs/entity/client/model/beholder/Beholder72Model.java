package net.grinner117.forgottenmobs.entity.client.model.beholder;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.beholder.Beholder72Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Beholder72Model extends AnimatedGeoModel<Beholder72Entity> {
    @Override
    public ResourceLocation getModelResource(Beholder72Entity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/beholder7.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(Beholder72Entity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/beholder72.png");
    }
    @Override
    public ResourceLocation getAnimationResource(Beholder72Entity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/beholder.animation.json");
    }
}
