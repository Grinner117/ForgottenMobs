package net.grinner117.forgottenfey.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.entity.client.model.GoblinArcherModel;
import net.grinner117.forgottenfey.entity.custom.GoblinArcherEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GoblinArcherRenderer extends GeoEntityRenderer<GoblinArcherEntity> {
    public GoblinArcherRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoblinArcherModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinArcherEntity instance) {
        return new ResourceLocation(ForgottenFey.MODID, "textures/entity/goblinarcher.png");
    }

    @Override
    public RenderType getRenderType(GoblinArcherEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.2f, 1.2f, 1.2f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}