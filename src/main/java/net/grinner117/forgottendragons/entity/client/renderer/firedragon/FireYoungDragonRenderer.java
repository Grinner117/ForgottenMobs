package net.grinner117.forgottendragons.entity.client.renderer.firedragon;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.grinner117.forgottendragons.ForgottenDragons;
import net.grinner117.forgottendragons.entity.client.model.firedragon.FireYoungDragonModel;
import net.grinner117.forgottendragons.entity.custom.firedragon.FireYoungDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FireYoungDragonRenderer extends GeoEntityRenderer<FireYoungDragonEntity> {
    public FireYoungDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireYoungDragonModel());
        this.shadowRadius = 0.5f;

    }

    @Override
    public ResourceLocation getTextureLocation(FireYoungDragonEntity instance) {
        return new ResourceLocation(ForgottenDragons.MODID, "textures/entity/shadowdragon.png");
    }

        @Override
        public RenderType getRenderType (FireYoungDragonEntity animatable, float partialTicks, PoseStack stack,
                                         @Nullable MultiBufferSource renderTypeBuffer,
                                         @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                         ResourceLocation textureLocation){
            stack.scale(2.5f, 2.5f, 2.5f);
            return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
        }
    }