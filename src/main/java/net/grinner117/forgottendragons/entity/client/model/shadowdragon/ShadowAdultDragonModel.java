package net.grinner117.forgottendragons.entity.client.model.shadowdragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.ShadowAdultDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShadowAdultDragonModel extends AnimatedGeoModel<ShadowAdultDragonEntity> {
    @Override
    public ResourceLocation getModelResource(ShadowAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(ShadowAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/shadowdragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ShadowAdultDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
