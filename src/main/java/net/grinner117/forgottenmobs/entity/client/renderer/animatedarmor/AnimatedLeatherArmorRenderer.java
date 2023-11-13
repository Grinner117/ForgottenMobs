package net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.animatedarmor.AnimatedLeatherArmorModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedLeatherArmorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class AnimatedLeatherArmorRenderer extends GeoEntityRenderer<AnimatedLeatherArmorEntity> {
    public AnimatedLeatherArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnimatedLeatherArmorModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(AnimatedLeatherArmorEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animatedleatherarmor.png");
    }

    public RenderType getRenderType(AnimatedLeatherArmorEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource
            bufferSource, float partialTicks) {
        return super.getRenderType(animatable, texture, bufferSource, partialTicks);
    }
}