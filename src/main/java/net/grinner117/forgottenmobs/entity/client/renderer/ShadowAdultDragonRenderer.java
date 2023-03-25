package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.ShadowAdultDragonModel;
import net.grinner117.forgottenmobs.entity.custom.ShadowAdultDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowYoungDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShadowAdultDragonRenderer extends GeoEntityRenderer<ShadowAdultDragonEntity> {
    public ShadowAdultDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShadowAdultDragonModel());
        this.shadowRadius = 0.5f;
        this.scaleWidth = 2.5f;
        this.scaleHeight = 2.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(ShadowAdultDragonEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }
    public RenderType getRenderType(ShadowAdultDragonEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}