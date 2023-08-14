package net.grinner117.forgottendragons.entity.client.model.whitedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteYoungDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteYoungDragonModel extends AnimatedGeoModel<WhiteYoungDragonEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(WhiteYoungDragonEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/whitedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(WhiteYoungDragonEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
