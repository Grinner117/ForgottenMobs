package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.ShadowWyrmlingModel;
import net.grinner117.forgottenmobs.entity.client.model.ShadowYoungDragonModel;
import net.grinner117.forgottenmobs.entity.custom.ShadowWyrmlingEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowYoungDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShadowYoungDragonRenderer extends GeoEntityRenderer<ShadowYoungDragonEntity> {
    public ShadowYoungDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShadowYoungDragonModel());
        this.shadowRadius = 0.5f;
        this.scaleWidth = 1.8f;
        this.scaleHeight = 1.8f;
    }
    @Override
    public ResourceLocation getTextureLocation(ShadowYoungDragonEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }
    public RenderType getRenderType(ShadowYoungDragonEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}