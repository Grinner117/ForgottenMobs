package net.grinner117.forgottenbeasts.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.grinner117.forgottenbeasts.entity.client.model.StirgeModel;
import net.grinner117.forgottenbeasts.entity.custom.StirgeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class StirgeRenderer extends GeoEntityRenderer<StirgeEntity> {
    public StirgeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StirgeModel());
        this.shadowRadius = 0.3f;
    }
    @Override
    public ResourceLocation getTextureLocation(StirgeEntity instance) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/stirge.png");
    }
    @Override
    public RenderType getRenderType(StirgeEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.2f, 1.2f, 1.2f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}