package net.grinner117.forgottendragons.entity.client.model.whitedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteElderDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteElderDragonModel extends AnimatedGeoModel<WhiteElderDragonEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteElderDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(WhiteElderDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/whitedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(WhiteElderDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
