package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.UnicornModel;
import net.grinner117.forgottenmobs.entity.custom.UnicornEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class UnicornRenderer extends GeoEntityRenderer<UnicornEntity> {
    public UnicornRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UnicornModel());
        this.shadowRadius = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(UnicornEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/unicorn.png");
    }
    @Override
    public RenderType getRenderType(UnicornEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.5f, 2.5f, 2.5f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}