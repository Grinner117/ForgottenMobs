package net.grinner117.forgottenangels.entity.custom;

import net.grinner117.forgottenangels.entity.type.Angel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class DevaEntity extends Angel {

    public DevaEntity(EntityType<? extends DevaEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 100;
    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 16.0D)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ATTACK_SPEED, 1.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.FLYING_SPEED, 0.6F)
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .build();
    }
}