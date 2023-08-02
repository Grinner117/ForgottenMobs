package net.grinner117.forgottenfey.entity.client.model;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.custom.GoblinShamanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class GoblinShamanModel extends AnimatedGeoModel<GoblinShamanEntity> {
    @Override
    public ResourceLocation getModelResource(GoblinShamanEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "geo/goblinshaman.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinShamanEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/goblinshaman.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinShamanEntity animatable) {
        return new ResourceLocation(ForgottenFey.MODID, "animations/goblinshaman.animation.json");
    }
}
