package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedLeatherArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.GoblinFighterEnity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoblinFighterModel extends GeoModel<GoblinFighterEnity> {
    @Override
    public ResourceLocation getModelResource(GoblinFighterEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/goblinfighter.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinFighterEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinfighter.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinFighterEnity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/goblinfighter.animation.json");
    }
}
