package net.grinner117.forgottenmobs.entity.client.model.whitedragon;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.WhiteWyrmlingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteWyrmlingModel extends AnimatedGeoModel<WhiteWyrmlingEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteWyrmlingEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(WhiteWyrmlingEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/whitedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(WhiteWyrmlingEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/dragon.animation.json");
    }
}
