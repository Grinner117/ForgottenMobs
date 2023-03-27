package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.CouatlModel;
import net.grinner117.forgottenmobs.entity.custom.CouatlEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CouatlRenderer extends GeoEntityRenderer<CouatlEntity> {
    public CouatlRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CouatlModel());
        this.shadowRadius = 2.0f;
        this.scaleWidth = 2.5f;
        this.scaleHeight = 2.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(CouatlEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/couatl.png");
    }
    public RenderType getRenderType(CouatlEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}