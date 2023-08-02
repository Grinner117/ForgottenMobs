package net.grinner117.forgottenfey.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.client.model.GrimlockModel;
import net.grinner117.forgottenfey.entity.custom.GrimlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GrimlockRenderer extends GeoEntityRenderer<GrimlockEntity> {
    public GrimlockRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GrimlockModel());
        this.shadowRadius = 0.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(GrimlockEntity instance) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/grimlock.png");
    }
    @Override
    public RenderType getRenderType(GrimlockEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.0f, 2.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}