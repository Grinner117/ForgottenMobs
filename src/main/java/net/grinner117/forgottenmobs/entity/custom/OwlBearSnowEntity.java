package net.grinner117.forgottenmobs.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class OwlBearSnowEntity extends OwlBearForestEntity {

    public OwlBearSnowEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.xpReward = 80;

    }
}
