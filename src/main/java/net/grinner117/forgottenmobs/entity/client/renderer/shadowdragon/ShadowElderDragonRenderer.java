package net.grinner117.forgottenmobs.entity.client.renderer.shadowdragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.shadowdragon.ShadowElderDragonModel;
import net.grinner117.forgottenmobs.entity.custom.ShadowElderDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ShadowElderDragonRenderer extends GeoEntityRenderer<ShadowElderDragonEntity> {
    public ShadowElderDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShadowElderDragonModel());
        this.shadowRadius = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(ShadowElderDragonEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }
    @Override
    public RenderType getRenderType(ShadowElderDragonEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(6.0f, 6.0f, 6.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
}
    }