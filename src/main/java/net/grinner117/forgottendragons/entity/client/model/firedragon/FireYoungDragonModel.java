package net.grinner117.forgottendragons.entity.client.model.firedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireYoungDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FireYoungDragonModel extends AnimatedGeoModel<FireYoungDragonEntity> {
    @Override
    public ResourceLocation getModelResource(FireYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(FireYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/firedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(FireYoungDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
