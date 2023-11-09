package net.grinner117.forgottendragons.entity.client.renderer.bluedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.bluedragon.BlueAdultDragonModel;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueAdultDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BlueAdultDragonRenderer extends GeoEntityRenderer<BlueAdultDragonEntity> {
    public BlueAdultDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlueAdultDragonModel());
        this.shadowRadius = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(BlueAdultDragonEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/Bluedragon.png");
    }
    @Override
    public RenderType getRenderType(BlueAdultDragonEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(4.0f, 4.0f, 4.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}