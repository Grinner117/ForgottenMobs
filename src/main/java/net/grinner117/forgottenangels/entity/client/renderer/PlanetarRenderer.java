package net.grinner117.forgottenangels.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenangels.ForgottenAngels;
import net.grinner117.forgottenangels.entity.client.model.PlanetarModel;
import net.grinner117.forgottenangels.entity.custom.PlanetarEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PlanetarRenderer extends GeoEntityRenderer<PlanetarEntity> {
    public PlanetarRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PlanetarModel());
        this.shadowRadius = 0.1f;
    }
    @Override
    public ResourceLocation getTextureLocation(PlanetarEntity instance) {
        return new ResourceLocation(ForgottenAngels.MODID, "textures/entity/planetar.png");
    }
    @Override
    public RenderType getRenderType(PlanetarEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.0f, 2.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}