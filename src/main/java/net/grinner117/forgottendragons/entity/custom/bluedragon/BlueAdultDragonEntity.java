package net.grinner117.forgottendragons.entity.custom.bluedragon;

import net.grinner117.forgottendragons.entity.type.BlueDragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class BlueAdultDragonEntity extends BlueDragon {

	public BlueAdultDragonEntity(EntityType<? extends BlueAdultDragonEntity> p_33101_, Level p_33102_) {
		super(p_33101_, p_33102_);
		this.xpReward = 180;
	}

	//attributes
	public static AttributeSupplier setAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 200.0D)
				.add(Attributes.ATTACK_DAMAGE, 35.0D)
				.add(Attributes.ATTACK_SPEED, 1.5F)
				.add(Attributes.MOVEMENT_SPEED, 1.6F)
				.add(Attributes.ARMOR_TOUGHNESS, 8.0F)
				.build();
	}

}