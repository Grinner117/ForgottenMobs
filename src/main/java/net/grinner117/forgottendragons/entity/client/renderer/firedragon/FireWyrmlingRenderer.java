package net.grinner117.forgottendragons.entity.client.renderer.firedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.firedragon.FireWyrmlingModel;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireWyrmlingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FireWyrmlingRenderer extends GeoEntityRenderer<FireWyrmlingEntity> {
    public FireWyrmlingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireWyrmlingModel());
        this.shadowRadius = 0.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(FireWyrmlingEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/firedragon.png");
    }
    @Override
    public RenderType getRenderType(FireWyrmlingEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}