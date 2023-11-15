package net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor;


import com.mojang.blaze3d.vertex.PoseStack;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.animatedarmor.AnimatedIronArmorModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedGoldArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.AnimatedIronArmorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class AnimatedIronArmorRenderer extends GeoEntityRenderer<AnimatedIronArmorEntity> {
    public AnimatedIronArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnimatedIronArmorModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(AnimatedIronArmorEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animatedironarmor.png");
    }
    @Override
    public void render(AnimatedIronArmorEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
    public RenderType getRenderType(AnimatedIronArmorEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource
            bufferSource, float partialTicks) {
        return super.getRenderType(animatable, texture, bufferSource, partialTicks);
    }
}