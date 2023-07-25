package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenBeasts;
import net.grinner117.forgottenmobs.entity.client.model.GriffonModel;
import net.grinner117.forgottenmobs.entity.custom.GriffonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GriffonRenderer extends GeoEntityRenderer<GriffonEntity> {
    public GriffonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GriffonModel());
        this.shadowRadius = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(GriffonEntity instance) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/griffon.png");
    }
    @Override
    public RenderType getRenderType(GriffonEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.8f, 1.8f, 1.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}