package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.DBeastEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DBeastModel extends AnimatedGeoModel<DBeastEntity> {
    @Override
    public ResourceLocation getModelResource(DBeastEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/dbeast.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(DBeastEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/dbeast.png");
    }
    @Override
    public ResourceLocation getAnimationResource(DBeastEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/dbeast.animation.json");
    }
}
