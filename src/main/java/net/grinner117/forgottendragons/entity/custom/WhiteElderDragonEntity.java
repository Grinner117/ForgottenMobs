package net.grinner117.forgottendragons.entity.custom;

import net.grinner117.forgottendragons.entity.type.WhiteDragon;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class WhiteElderDragonEntity extends WhiteDragon {

    public WhiteElderDragonEntity(EntityType<? extends WhiteElderDragonEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 140;
    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 400.0D)
                .add(Attributes.ATTACK_DAMAGE, 100.0D)
                .add(Attributes.ATTACK_SPEED, 1.8F)
                .add(Attributes.MOVEMENT_SPEED, 1.8F)
                .build();
    }
}