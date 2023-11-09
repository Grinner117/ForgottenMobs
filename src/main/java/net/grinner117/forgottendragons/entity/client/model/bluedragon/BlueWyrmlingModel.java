package net.grinner117.forgottendragons.entity.client.model.bluedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueWyrmlingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlueWyrmlingModel extends AnimatedGeoModel<BlueWyrmlingEntity> {
    @Override
    public ResourceLocation getModelResource(BlueWyrmlingEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueWyrmlingEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/bluedragon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueWyrmlingEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
