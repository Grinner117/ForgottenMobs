package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.ShadowAdultDragonModel;
import net.grinner117.forgottenmobs.entity.client.model.ShadowElderDragonModel;
import net.grinner117.forgottenmobs.entity.custom.ShadowAdultDragonEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowElderDragonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShadowElderDragonRenderer extends GeoEntityRenderer<ShadowElderDragonEntity> {
    public ShadowElderDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShadowElderDragonModel());
        this.shadowRadius = 2.0f;
        this.scaleWidth = 6.0f;
        this.scaleHeight = 6.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(ShadowElderDragonEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }
    public RenderType getRenderType(ShadowElderDragonEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}