package net.grinner117.forgottenbeasts.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenbeasts.ForgottenBeasts;
import net.grinner117.forgottenbeasts.entity.client.model.OwlBearSnowModel;
import net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OwlBearSnowRenderer extends GeoEntityRenderer<net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity> {
    public OwlBearSnowRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OwlBearSnowModel());
        this.shadowRadius = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(net.grinner117.forgottenbeasts.entity.custom.OwlBearSnowEntity instance) {
        return new ResourceLocation(ForgottenBeasts.MODID, "textures/entity/owlbearsnow.png");
    }
    @Override
    public RenderType getRenderType(OwlBearSnowEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(3.0f, 3.0f, 3.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}