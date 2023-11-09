package net.grinner117.forgottendragons.entity.client.model.bluedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueAdultDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlueAdultDragonModel extends AnimatedGeoModel<BlueAdultDragonEntity> {
    @Override
    public ResourceLocation getModelResource(BlueAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(BlueAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/bluedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(BlueAdultDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
