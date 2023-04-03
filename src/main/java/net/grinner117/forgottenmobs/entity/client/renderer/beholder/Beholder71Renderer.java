package net.grinner117.forgottenmobs.entity.client.renderer.beholder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.beholder.Beholder71Model;
import net.grinner117.forgottenmobs.entity.custom.beholder.Beholder71Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class Beholder71Renderer extends GeoEntityRenderer<Beholder71Entity> {
    public Beholder71Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Beholder71Model());
        this.shadowRadius = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(Beholder71Entity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/beholder71.png");
    }
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public RenderType getRenderType(Beholder71Entity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(2.0f, 2.0f, 2.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}