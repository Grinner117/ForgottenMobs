package net.grinner117.forgottendragons.entity.custom.shadowdragon;

import net.grinner117.forgottendragons.entity.type.ShadowDragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class ShadowWyrmlingEntity extends ShadowDragon {
    public ShadowWyrmlingEntity(EntityType<? extends ShadowWyrmlingEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 20;
    }

    public static AttributeSupplier setAttributes() {    
        return Monster.createMonsterAttributes()    
                .add(Attributes.MAX_HEALTH, 60.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ATTACK_SPEED, 1.0F)    
                .add(Attributes.MOVEMENT_SPEED, 1.0F)    
                .build();    
    }
}