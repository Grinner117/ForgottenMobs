package net.grinner117.forgottendragons.entity.client.model.whitedragon;

import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.custom.whitedragon.WhiteWyrmlingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteWyrmlingModel extends AnimatedGeoModel<WhiteWyrmlingEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteWyrmlingEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(WhiteWyrmlingEntity object) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/whitedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(WhiteWyrmlingEntity animatable) {
        return new ResourceLocation(ForgottenDragons.MODID, "animations/dragon.animation.json");
    }
}
