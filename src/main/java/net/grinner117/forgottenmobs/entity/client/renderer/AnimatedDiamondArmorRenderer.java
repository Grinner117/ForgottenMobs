package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.AnimatedDiamondArmorModel;
import net.grinner117.forgottenmobs.entity.client.model.AnimatedLeatherArmorModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedDiamondArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.AnimatedLeatherArmorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnimatedDiamondArmorRenderer extends GeoEntityRenderer<AnimatedDiamondArmorEntity> {
    public AnimatedDiamondArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnimatedDiamondArmorModel());
        this.shadowRadius = 0.5f;
        this.scaleWidth = 1.8f;
        this.scaleHeight = 1.5f;
    }
    @Override
    public ResourceLocation getTextureLocation(AnimatedDiamondArmorEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/animateddiamondarmor.png");
    }
    public RenderType getRenderType(AnimatedDiamondArmorEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}