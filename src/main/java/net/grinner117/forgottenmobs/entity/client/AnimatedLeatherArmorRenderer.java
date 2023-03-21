package net.grinner117.forgottenmobs.entity.client;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.custom.AnimatedArmorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
public class AnimatedArmorRenderer extends GeoEntityRenderer<AnimatedArmorEntity> {
    public AnimatedArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnimatedArmorModel());
        this.shadowRadius = 1.0f;
        this.scaleWidth = 1.5f;
        this.scaleHeight = 1.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(AnimatedArmorEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animatedarmorblank.png");
    }
    public RenderType getRenderType(AnimatedArmorEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}