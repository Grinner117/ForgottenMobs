package net.grinner117.forgottenmobs.entity.client.renderer.animatedarmor;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.animatedarmor.AnimatedDiamondArmorModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedDiamondArmorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AnimatedDiamondArmorRenderer extends GeoEntityRenderer<AnimatedDiamondArmorEntity> {
    public AnimatedDiamondArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnimatedDiamondArmorModel());
        this.shadowRadius = 0.5f;

    }
    @Override
    public ResourceLocation getTextureLocation(AnimatedDiamondArmorEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animateddiamondarmor.png");
    }
    @Override
    public RenderType getRenderType(AnimatedDiamondArmorEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.9f, 1.6f, 1.9f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}