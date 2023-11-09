package net.grinner117.forgottendragons.entity.client.model.bluedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueElderDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlueElderDragonModel extends AnimatedGeoModel<BlueElderDragonEntity> {
    @Override
    public ResourceLocation getModelResource(BlueElderDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(BlueElderDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/bluedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(BlueElderDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
