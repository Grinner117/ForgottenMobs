package net.grinner117.forgottendragons.entity.client.model.shadowdragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.ShadowYoungDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShadowYoungDragonModel extends AnimatedGeoModel<ShadowYoungDragonEntity> {
    @Override
    public ResourceLocation getModelResource(ShadowYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(ShadowYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/shadowdragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ShadowYoungDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
