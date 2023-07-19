package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenAngels;
import net.grinner117.forgottenmobs.entity.client.model.DevaModel;
import net.grinner117.forgottenmobs.entity.custom.DevaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DevaRenderer extends GeoEntityRenderer<DevaEntity> {
    public DevaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DevaModel());
        this.shadowRadius = 0.1f;
    }
    @Override
    public ResourceLocation getTextureLocation(DevaEntity instance) {
        return new ResourceLocation(ForgottenAngels.MODID, "textures/entity/deva.png");
    }
    @Override
    public RenderType getRenderType(DevaEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.0f, 2.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}