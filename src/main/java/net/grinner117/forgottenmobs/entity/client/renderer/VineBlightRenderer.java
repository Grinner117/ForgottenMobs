package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenPlant;
import net.grinner117.forgottenmobs.entity.client.model.VineBlightModel;
import net.grinner117.forgottenmobs.entity.custom.VineBlightEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class VineBlightRenderer extends GeoEntityRenderer<VineBlightEntity> {
    public VineBlightRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new VineBlightModel());
        this.shadowRadius = 0.2f;
    }
    @Override
    public ResourceLocation getTextureLocation(VineBlightEntity instance) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/blight.png");
    }
    @Override
    public RenderType getRenderType(VineBlightEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.8f, 2.6f, 2.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}