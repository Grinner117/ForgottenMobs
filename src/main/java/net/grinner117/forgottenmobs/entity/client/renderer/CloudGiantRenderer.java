package net.grinner117.forgottenmobs.entity.client.renderer;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.CloudGiantModel;
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

    public RenderType getRenderType(CloudGiantEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource
            bufferSource, float partialTicks) {
        return super.getRenderType(animatable, texture, bufferSource, partialTicks);
    }
}