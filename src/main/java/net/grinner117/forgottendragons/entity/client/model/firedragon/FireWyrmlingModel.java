package net.grinner117.forgottendragons.entity.client.model.firedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireWyrmlingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FireWyrmlingModel extends AnimatedGeoModel<FireWyrmlingEntity> {
    @Override
    public ResourceLocation getModelResource(FireWyrmlingEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(FireWyrmlingEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/firedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(FireWyrmlingEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
