package net.grinner117.forgottenmobs.entity.client.model.shadowdragon;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.ShadowYoungDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShadowYoungDragonModel extends AnimatedGeoModel<ShadowYoungDragonEntity> {
    @Override
    public ResourceLocation getModelResource(ShadowYoungDragonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(ShadowYoungDragonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ShadowYoungDragonEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/dragon.animation.json");
    }
}
