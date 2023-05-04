package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.IDBeastEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IDBeastModel extends AnimatedGeoModel<IDBeastEntity> {
    @Override
    public ResourceLocation getModelResource(IDBeastEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/dbeast.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(IDBeastEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/dbeast.png");
    }
    @Override
    public ResourceLocation getAnimationResource(IDBeastEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/dbeast.animation.json");
    }
}
