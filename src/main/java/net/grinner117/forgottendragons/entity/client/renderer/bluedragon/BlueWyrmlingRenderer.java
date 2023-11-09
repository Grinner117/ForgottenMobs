package net.grinner117.forgottendragons.entity.client.renderer.bluedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.bluedragon.BlueWyrmlingModel;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueWyrmlingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BlueWyrmlingRenderer extends GeoEntityRenderer<BlueWyrmlingEntity> {
    public BlueWyrmlingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlueWyrmlingModel());
        this.shadowRadius = 0.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(BlueWyrmlingEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/bluedragon.png");
    }
    @Override
    public RenderType getRenderType(BlueWyrmlingEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}