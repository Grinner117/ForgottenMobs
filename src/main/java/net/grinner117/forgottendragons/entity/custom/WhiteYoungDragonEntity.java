package net.grinner117.forgottendragons.entity.custom;

import net.grinner117.forgottendragons.entity.type.WhiteDragon;
import net.grinner117.forgottenmobs.entity.type.Dragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class WhiteYoungDragonEntity extends WhiteDragon {

    public WhiteYoungDragonEntity(EntityType<? extends Dragon> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 110;
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