package net.grinner117.forgottenmobs.entity.client.renderer;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.grinner117.forgottenmobs.entity.client.model.GoblinFighterModel;
import net.grinner117.forgottenmobs.entity.client.model.GoblinShamanModel;
import net.grinner117.forgottenmobs.entity.custom.GoblinFighterEnity;
import net.grinner117.forgottenmobs.entity.custom.GoblinShamanEnity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GoblinShamanRenderer extends GeoEntityRenderer<GoblinShamanEnity> {
    public GoblinShamanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoblinShamanModel());
        this.shadowRadius = 0.5f;
        this.scaleWidth = 1.2f;
        this.scaleHeight = 1.2f;
    }
    @Override
    public ResourceLocation getTextureLocation(GoblinShamanEnity instance) {
        return new ResourceLocation(ForgottenMobs.MODID, "textures/entity/goblinshaman.png");
    }
    public RenderType getRenderType(GoblinShamanEnity animatable, ResourceLocation texture,
                                    @Nullable MultiBufferSource bufferSource,
                                    float particalTick) {
        return super.getRenderType(animatable, texture, bufferSource, particalTick);
    }
}