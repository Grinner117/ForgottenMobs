package net.grinner117.forgottenangels.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenangels.ForgottenAngels;
import net.grinner117.forgottenangels.entity.client.model.EmpyreanModel;
import net.grinner117.forgottenangels.entity.custom.EmpyreanEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EmpyreanRenderer extends GeoEntityRenderer<EmpyreanEntity> {
    public EmpyreanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EmpyreanModel());
        this.shadowRadius = 0.1f;
    }
    @Override
    public ResourceLocation getTextureLocation(EmpyreanEntity instance) {
        return new ResourceLocation(ForgottenAngels.MODID, "textures/entity/empyrean.png");
    }
    @Override
    public RenderType getRenderType(EmpyreanEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(8.0f, 8.0f, 8.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}