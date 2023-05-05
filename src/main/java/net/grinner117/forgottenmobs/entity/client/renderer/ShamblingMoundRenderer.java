package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.ShamblingMoundModel;
import net.grinner117.forgottenmobs.entity.custom.ShamblingMoundEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ShamblingMoundRenderer extends GeoEntityRenderer<ShamblingMoundEntity> {
    public ShamblingMoundRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShamblingMoundModel());
        this.shadowRadius = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(ShamblingMoundEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shamblingmound.png");
    }
    @Override
    public RenderType getRenderType(ShamblingMoundEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(3.0f, 3.0f, 3.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}