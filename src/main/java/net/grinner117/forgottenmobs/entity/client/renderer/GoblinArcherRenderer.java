package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.GoblinArcherModel;
import net.grinner117.forgottenmobs.entity.custom.GoblinArcherEnity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GoblinArcherRenderer extends GeoEntityRenderer<GoblinArcherEnity> {
    public GoblinArcherRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoblinArcherModel());
        this.shadowRadius = 0.5f;
        this.scaleWidth = 1.2f;
        this.scaleHeight = 1.2f;
    }
    @Override
    public ResourceLocation getTextureLocation(GoblinArcherEnity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinarcher.png");
    }
    public RenderType getRenderType(GoblinArcherEnity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}