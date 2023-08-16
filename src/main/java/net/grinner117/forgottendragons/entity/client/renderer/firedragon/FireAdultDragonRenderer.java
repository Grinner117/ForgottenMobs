package net.grinner117.forgottendragons.entity.client.renderer.firedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.firedragon.FireAdultDragonModel;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireAdultDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FireAdultDragonRenderer extends GeoEntityRenderer<FireAdultDragonEntity> {
    public FireAdultDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireAdultDragonModel());
        this.shadowRadius = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(FireAdultDragonEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/firedragon.png");
    }
    @Override
    public RenderType getRenderType(FireAdultDragonEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(4.0f, 4.0f, 4.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}