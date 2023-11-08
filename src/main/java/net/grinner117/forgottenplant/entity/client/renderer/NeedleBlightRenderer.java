package net.grinner117.forgottenplant.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.client.model.NeedleBlightModel;
import net.grinner117.forgottenplant.entity.custom.NeedleBlightEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NeedleBlightRenderer extends GeoEntityRenderer<net.grinner117.forgottenplant.entity.custom.NeedleBlightEntity> {
    public NeedleBlightRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NeedleBlightModel());
        this.shadowRadius = 0.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(net.grinner117.forgottenplant.entity.custom.NeedleBlightEntity instance) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/blight.png");
    }
    @Override
    public RenderType getRenderType(NeedleBlightEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.8f, 3.0f, 1.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}