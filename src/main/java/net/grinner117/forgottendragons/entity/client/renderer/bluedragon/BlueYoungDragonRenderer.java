package net.grinner117.forgottendragons.entity.client.renderer.bluedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.bluedragon.BlueYoungDragonModel;
import net.grinner117.forgottendragons.entity.custom.bluedragon.BlueYoungDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BlueYoungDragonRenderer extends GeoEntityRenderer<BlueYoungDragonEntity> {
    public BlueYoungDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlueYoungDragonModel());
        this.shadowRadius = 0.5f;

    }

    @Override
    public ResourceLocation getTextureLocation(BlueYoungDragonEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/bluedragon.png");
    }

        @Override
        public RenderType getRenderType (BlueYoungDragonEntity animatable, float partialTicks, PoseStack stack,
                                         @Nullable MultiBufferSource renderTypeBuffer,
                                         @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                         ResourceLocation textureLocation){
            stack.scale(2.5f, 2.5f, 2.5f);
            return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
        }
    }