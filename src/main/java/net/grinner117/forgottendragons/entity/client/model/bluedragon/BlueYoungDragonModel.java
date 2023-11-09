package net.grinner117.forgottendragons.entity.client.model.bluedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueYoungDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlueYoungDragonModel extends AnimatedGeoModel<BlueYoungDragonEntity> {
    @Override
    public ResourceLocation getModelResource(BlueYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/bluedragon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueYoungDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
