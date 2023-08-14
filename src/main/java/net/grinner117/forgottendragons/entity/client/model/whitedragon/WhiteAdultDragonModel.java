package net.grinner117.forgottendragons.entity.client.model.whitedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteAdultDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteAdultDragonModel extends AnimatedGeoModel<WhiteAdultDragonEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(WhiteAdultDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/whitedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(WhiteAdultDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
