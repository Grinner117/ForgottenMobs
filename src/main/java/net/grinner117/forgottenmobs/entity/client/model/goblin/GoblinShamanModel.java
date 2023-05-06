package net.grinner117.forgottenmobs.entity.client.model.goblin;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.GoblinShamanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class GoblinShamanModel extends AnimatedGeoModel<GoblinShamanEntity> {
    @Override
    public ResourceLocation getModelResource(GoblinShamanEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "geo/goblinshaman.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(GoblinShamanEntity object) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinshaman.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GoblinShamanEntity animatable) {
        return new ResourceLocation(ForgottenMobs.MODID, "animations/goblinshaman.animation.json");
    }
}
