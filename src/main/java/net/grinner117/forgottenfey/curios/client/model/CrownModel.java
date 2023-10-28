package net.grinner117.forgottenfey.curios.client.model;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class CrownModel<T extends LivingEntity> extends AgeableListModel<T> {

	public ModelPart crown;

	public CrownModel(ModelPart part) {
		this.crown = part.getChild("crown");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition part = mesh.getRoot();
		CubeDeformation cube = new CubeDeformation(1.0F);
		part.addOrReplaceChild("crown",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -12.0F, -3.0F, 6, 4, 6, cube),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(mesh, 32, 32);
	}

	@Override
	@Nonnull
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.crown);
	}

	@Override
	@Nonnull
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of();
	}

	@Override
	public void setupAnim(@Nonnull T t, float v, float v1, float v2, float v3, float v4) {
		// NO-OP
	}
}