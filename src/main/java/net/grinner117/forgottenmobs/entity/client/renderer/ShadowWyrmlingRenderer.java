package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.AnimatedDiamondArmorModel;
import net.grinner117.forgottenmobs.entity.client.model.ShadowWyrmlingModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedDiamondArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.ShadowWyrmlingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShadowWyrmlingRenderer extends GeoEntityRenderer<ShadowWyrmlingEntity> {
    public ShadowWyrmlingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShadowWyrmlingModel());
        this.shadowRadius = 0.5f;
        this.scaleWidth = 1.0f;
        this.scaleHeight = 1.0f;
    }
    @Override
    public ResourceLocation getTextureLocation(ShadowWyrmlingEntity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/shadowdragon.png");
    }
    public RenderType getRenderType(ShadowWyrmlingEntity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}