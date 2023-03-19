package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.ChildRatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChildRatModel extends GeoModel<ChildRatEntity> {
    @Override
    public ResourceLocation getModelResource(ChildRatEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/rat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChildRatEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/childrat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChildRatEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/rat.animation.json");

    }
}
