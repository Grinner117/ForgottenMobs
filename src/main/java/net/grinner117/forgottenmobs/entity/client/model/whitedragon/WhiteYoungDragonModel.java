package net.grinner117.forgottenmobs.entity.client.model.whitedragon;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.WhiteYoungDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteYoungDragonModel extends AnimatedGeoModel<WhiteYoungDragonEntity> {
    @Override
    public ResourceLocation getModelResource(WhiteYoungDragonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(WhiteYoungDragonEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/whitedragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(WhiteYoungDragonEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/dragon.animation.json");
    }
}
