package net.grinner117.forgottenmobs.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.CloudGiantModel;
import net.grinner117.forgottenmobs.entity.custom.CloudGiantEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

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
    public RenderType getRenderType(CloudGiantEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.5f, 2.5f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}