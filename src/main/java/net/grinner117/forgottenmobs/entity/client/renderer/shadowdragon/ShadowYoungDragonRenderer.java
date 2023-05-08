package net.grinner117.forgottenmobs.entity.client.renderer.shadowdragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.shadowdragon.ShadowYoungDragonModel;
import net.grinner117.forgottenmobs.entity.custom.ShadowYoungDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ShadowYoungDragonRenderer extends GeoEntityRenderer<ShadowYoungDragonEntity> {
    public ShadowYoungDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShadowYoungDragonModel());
        this.shadowRadius = 0.5f;

    }

    @Override
    public ResourceLocation getTextureLocation(ShadowYoungDragonEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }

        @Override
        public RenderType getRenderType (ShadowYoungDragonEntity animatable, float partialTicks, PoseStack stack,
                                         @Nullable MultiBufferSource renderTypeBuffer,
                                         @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                         ResourceLocation textureLocation){
            stack.scale(2.5f, 2.5f, 2.5f);
            return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
        }
    }