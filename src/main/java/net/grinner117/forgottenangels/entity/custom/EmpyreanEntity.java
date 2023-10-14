package net.grinner117.forgottenangels.entity.custom;

import net.grinner117.forgottenmobs.entity.type.Angel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EmpyreanEntity extends Angel {

    public EmpyreanEntity(EntityType<? extends EmpyreanEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 300;
    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 300.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 32.0D)
                .add(Attributes.ATTACK_DAMAGE, 30.0D)
                .add(Attributes.ATTACK_SPEED, 0.8F)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.FLYING_SPEED, 0.65F)
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .build();
    }
}