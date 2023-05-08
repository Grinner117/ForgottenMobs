package net.grinner117.forgottenmobs.entity.client.renderer.beholder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.beholder.Beholder72Model;
import net.grinner117.forgottenmobs.entity.custom.Beholder72Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class Beholder72Renderer extends GeoEntityRenderer<Beholder72Entity> {
    public Beholder72Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Beholder72Model());
        this.shadowRadius = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(Beholder72Entity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/beholder72.png");
    }

    @Override
    public RenderType getRenderType(Beholder72Entity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.0f, 2.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}