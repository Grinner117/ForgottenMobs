package net.grinner117.forgottenmobs.entity.client.model.whitedragon;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.WhiteAdultDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteAdultDragonModel extends AnimatedGeoModel<WhiteAdultDragonEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteAdultDragonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(WhiteAdultDragonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/whitedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(WhiteAdultDragonEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/dragon.animation.json");
    }
}
