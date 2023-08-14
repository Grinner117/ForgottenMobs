package net.grinner117.forgottendragons.entity.custom.shadowdragon;

import net.grinner117.forgottendragons.entity.type.ShadowDragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class ShadowYoungDragonEntity extends ShadowDragon {
    public ShadowYoungDragonEntity(EntityType<? extends ShadowYoungDragonEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 60;
    }
    public static AttributeSupplier setAttributes() {    
        return Monster.createMonsterAttributes()    
                .add(Attributes.MAX_HEALTH, 120.0D)
                .add(Attributes.ATTACK_DAMAGE, 22.0D)
                .add(Attributes.ATTACK_SPEED, 1.2F)
                .add(Attributes.MOVEMENT_SPEED, 1.5F)
                .build();    
    }
}