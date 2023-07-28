package net.grinner117.forgottendragons.entity.custom;

import net.grinner117.forgottenmobs.entity.type.WhiteDragon;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class WhiteAdultDragonEntity extends WhiteDragon {

	public WhiteAdultDragonEntity(EntityType<? extends WhiteAdultDragonEntity> p_33101_, Level p_33102_) {
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