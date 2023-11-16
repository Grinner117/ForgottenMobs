package net.grinner117.forgottenmobs.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.CloudGiantModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedLeatherArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.CloudGiantEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class CloudGiantRenderer extends GeoEntityRenderer<CloudGiantEntity> {
    public CloudGiantRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CloudGiantModel());
        this.shadowRadius = 2.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(CloudGiantEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/cloudgiant.png");
    }
    @Override
    public void render(CloudGiantEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
            poseStack.scale(25.0f, 25.0f, 25.0f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
    public RenderType getRenderType(CloudGiantEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource
            bufferSource, float partialTicks) {
        return super.getRenderType(animatable, texture, bufferSource, partialTicks);
    }
}