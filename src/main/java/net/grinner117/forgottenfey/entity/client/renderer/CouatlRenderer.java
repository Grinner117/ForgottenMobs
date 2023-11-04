package net.grinner117.forgottenfey.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.client.model.CouatlModel;
import net.grinner117.forgottenfey.entity.custom.CouatlEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CouatlRenderer extends GeoEntityRenderer<CouatlEntity> {
    public CouatlRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CouatlModel());
        this.shadowRadius = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(CouatlEntity instance) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/couatl.png");
    }
    @Override
    public RenderType getRenderType(CouatlEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.5f, 2.5f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}