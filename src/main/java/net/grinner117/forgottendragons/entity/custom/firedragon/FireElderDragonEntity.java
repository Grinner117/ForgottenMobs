package net.grinner117.forgottendragons.entity.custom.firedragon;

import net.grinner117.forgottendragons.entity.type.FireDragon;
import net.grinner117.forgottendragons.entity.type.ShadowDragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class FireElderDragonEntity extends FireDragon {

    public FireElderDragonEntity(EntityType<? extends FireElderDragonEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 140;
    }
    public static AttributeSupplier setAttributes() {    
        return Monster.createMonsterAttributes()    
                .add(Attributes.MAX_HEALTH, 400.0D)
                .add(Attributes.ATTACK_DAMAGE, 32.0D)
                .add(Attributes.ATTACK_SPEED, 1.8F)
                .add(Attributes.MOVEMENT_SPEED, 1.8F)
                .build();    
    }
}