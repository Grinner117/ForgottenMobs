package net.grinner117.forgottenmobs.entity.client.model;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GoblinShamanEnity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class GoblinShamanModel extends AnimatedGeoModel<GoblinShamanEnity> {
    @Override
    public ResourceLocation getModelResource(GoblinShamanEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/goblinshaman.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinShamanEnity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinshaman.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinShamanEnity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/goblinshaman.animation.json");
    }
}
