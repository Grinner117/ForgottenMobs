package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.AnimatedLeatherArmorModel;
import net.grinner117.forgottenmobs.entity.client.model.GoblinFighterModel;
import net.grinner117.forgottenmobs.entity.custom.AnimatedLeatherArmorEntity;
import net.grinner117.forgottenmobs.entity.custom.GoblinFighterEnity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GoblinFighterRenderer extends GeoEntityRenderer<GoblinFighterEnity> {
    public GoblinFighterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoblinFighterModel());
        this.shadowRadius = 0.1f;
        this.scaleWidth = 1.2f;
        this.scaleHeight = 1.2f;
    }
    @Override
    public ResourceLocation getTextureLocation(GoblinFighterEnity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinfighter.png");
    }
    public RenderType getRenderType(GoblinFighterEnity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}