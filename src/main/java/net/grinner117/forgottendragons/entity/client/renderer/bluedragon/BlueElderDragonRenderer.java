package net.grinner117.forgottendragons.entity.client.renderer.bluedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.bluedragon.BlueElderDragonModel;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueElderDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BlueElderDragonRenderer extends GeoEntityRenderer<BlueElderDragonEntity> {
    public BlueElderDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlueElderDragonModel());
        this.shadowRadius = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(BlueElderDragonEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/bluedragon.png");
    }
    @Override
    public RenderType getRenderType(BlueElderDragonEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(12.0f, 12.0f, 12.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
}
    }