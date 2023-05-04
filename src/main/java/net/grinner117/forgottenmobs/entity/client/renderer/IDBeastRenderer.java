package net.grinner117.forgottenmobs.entity.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.DBeastModel;
import net.grinner117.forgottenmobs.entity.client.model.IDBeastModel;
import net.grinner117.forgottenmobs.entity.custom.DBeastEntity;
import net.grinner117.forgottenmobs.entity.custom.IDBeastEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class IDBeastRenderer extends GeoEntityRenderer<IDBeastEntity> {
    public IDBeastRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IDBeastModel());
        this.shadowRadius = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(IDBeastEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/dbeast.png");
    }
    @Override
    public RenderType getRenderType(IDBeastEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.0f, 2.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}