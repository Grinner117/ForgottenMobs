package net.grinner117.forgottendragons.entity.client.model.firedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireAdultDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FireAdultDragonModel extends AnimatedGeoModel<FireAdultDragonEntity> {
    @Override
    public ResourceLocation getModelResource(FireAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(FireAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/firedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(FireAdultDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
