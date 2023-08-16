package net.grinner117.forgottendragons.entity.client.renderer.firedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.firedragon.FireElderDragonModel;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireElderDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FireElderDragonRenderer extends GeoEntityRenderer<FireElderDragonEntity> {
    public FireElderDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireElderDragonModel());
        this.shadowRadius = 2.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(FireElderDragonEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/shadowdragon.png");
    }
    @Override
    public RenderType getRenderType(FireElderDragonEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(6.0f, 6.0f, 6.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
}
    }