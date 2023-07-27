package net.grinner117.forgottenmobs.entity.client.renderer.projectile;

import net.grinner117.forgottenmobs.ForgottenMobs;

import net.grinner117.forgottenmobs.entity.projectile.NeedleEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class NeedleRenderer extends ArrowRenderer<NeedleEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(ForgottenMobs.MODID, "textures/entity/needle.png");

	public NeedleRenderer(EntityRendererProvider.Context manager) {
		super(manager);
	}

	public ResourceLocation getTextureLocation(NeedleEntity arrow) {
		return TEXTURE;
	}
}
