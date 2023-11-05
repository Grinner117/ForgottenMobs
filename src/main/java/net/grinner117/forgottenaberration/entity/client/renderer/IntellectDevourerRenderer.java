package net.grinner117.forgottenaberration.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenaberration.ForgottenAberration;
import net.grinner117.forgottenaberration.entity.client.model.IntellectDevourerModel;
import net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class IntellectDevourerRenderer extends GeoEntityRenderer<net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity> {
    public IntellectDevourerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IntellectDevourerModel());
        this.shadowRadius = 0.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(net.grinner117.forgottenaberration.entity.custom.IntellectDevourerEntity instance) {
        return new ResourceLocation(ForgottenAberration.MODID, "textures/entity/intellectdevourer.png");
    }
    @Override
    public RenderType getRenderType(IntellectDevourerEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}