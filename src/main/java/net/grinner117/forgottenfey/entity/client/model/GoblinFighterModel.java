package net.grinner117.forgottenfey.entity.client.model;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.custom.GoblinFighterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoblinFighterModel extends AnimatedGeoModel<GoblinFighterEntity> {
    @Override
    public ResourceLocation getModelResource(GoblinFighterEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "geo/goblinfighter.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinFighterEntity object) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/goblinfighter.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinFighterEntity animatable) {
        return new ResourceLocation(ForgottenFey.MODID, "animations/goblinfighter.animation.json");
    }
}
