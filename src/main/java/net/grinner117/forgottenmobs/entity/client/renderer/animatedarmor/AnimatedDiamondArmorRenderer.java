package net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.animatedarmor.AnimatedDiamondArmorModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedDiamondArmorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class AnimatedDiamondArmorRenderer extends GeoEntityRenderer<AnimatedDiamondArmorEntity> {
    public AnimatedDiamondArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnimatedDiamondArmorModel());
        this.shadowRadius = 0.5f;

    }
    @Override
    public ResourceLocation getTextureLocation(AnimatedDiamondArmorEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animateddiamondarmor.png");
    }

    public RenderType getRenderType(AnimatedDiamondArmorEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource
            bufferSource, float partialTicks) {
        return super.getRenderType(animatable, texture, bufferSource, partialTicks);
    }
}