package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.GhostModel;
import net.grinner117.forgottenmobs.entity.custom.GhostEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GhostRenderer extends GeoEntityRenderer<GhostEntity> {
    public GhostRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GhostModel());
        this.shadowRadius = 0.2f;
    }
    @Override
    public ResourceLocation getTextureLocation(GhostEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/ghost.png");
    }
    @Override
    public RenderType getRenderType(GhostEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.8f, 2.6f, 2.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}