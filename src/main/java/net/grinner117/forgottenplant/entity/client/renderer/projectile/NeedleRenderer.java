package net.grinner117.forgottenplant.entity.client.renderer.projectile;

import net.grinner117.forgottenplant.ForgottenPlant;
import net.grinner117.forgottenplant.entity.projectile.NeedleEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class NeedleRenderer extends ArrowRenderer<net.grinner117.forgottenplant.entity.projectile.NeedleEntity> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(ForgottenPlant.MODID, "textures/entity/needle.png");

	public NeedleRenderer(EntityRendererProvider.Context manager) {
		super(manager);
	}

	public ResourceLocation getTextureLocation(NeedleEntity arrow) {
		return TEXTURE;
	}
}
