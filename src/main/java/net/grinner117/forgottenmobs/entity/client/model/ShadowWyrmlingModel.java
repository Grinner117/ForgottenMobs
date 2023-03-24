package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedDiamondArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowWyrmlingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShadowWyrmlingModel extends GeoModel<ShadowWyrmlingEntity> {
    @Override
    public ResourceLocation getModelResource(ShadowWyrmlingEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/dragon.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(ShadowWyrmlingEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ShadowWyrmlingEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/dragon.animation.json");
    }
}
