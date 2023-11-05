package net.grinner117.forgottenaberration.entity.client.model;

import net.grinner117.forgottenaberration.entity.custom.DBeastEntity;
import net.grinner117.forgottenaberration.ForgottenAberration;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DBeastModel extends AnimatedGeoModel<net.grinner117.forgottenaberration.entity.custom.DBeastEntity> {
    @Override
    public ResourceLocation getModelResource(net.grinner117.forgottenaberration.entity.custom.DBeastEntity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "geo/dbeast.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(net.grinner117.forgottenaberration.entity.custom.DBeastEntity object) {
        return new ResourceLocation(ForgottenAberration.MODID, "textures/entity/dbeast.png");
    }
    @Override
    public ResourceLocation getAnimationResource(DBeastEntity animatable) {
        return new ResourceLocation(ForgottenAberration.MODID, "animations/dbeast.animation.json");
    }
}
