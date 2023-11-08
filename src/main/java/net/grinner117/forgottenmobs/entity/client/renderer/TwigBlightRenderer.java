package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenPlant;
import net.grinner117.forgottenmobs.entity.client.model.TwigBlightModel;
import net.grinner117.forgottenmobs.entity.custom.TwigBlightEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TwigBlightRenderer extends GeoEntityRenderer<TwigBlightEntity> {
    public TwigBlightRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TwigBlightModel());
        this.shadowRadius = 0.2f;
    }
    @Override
    public ResourceLocation getTextureLocation(TwigBlightEntity instance) {
        return new ResourceLocation(ForgottenPlant.MODID, "textures/entity/blight.png");
    }
    @Override
    public RenderType getRenderType(TwigBlightEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.5f, 2.0f, 1.5f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}