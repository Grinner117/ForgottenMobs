package net.grinner117.forgottendragons.entity.client.model.shadowdragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.ShadowElderDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShadowElderDragonModel extends AnimatedGeoModel<ShadowElderDragonEntity> {
    @Override
    public ResourceLocation getModelResource(ShadowElderDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(ShadowElderDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/shadowdragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ShadowElderDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
