package net.grinner117.forgottendragons.entity.custom.firedragon;

import net.grinner117.forgottendragons.entity.type.FireDragon;
import net.grinner117.forgottendragons.entity.type.ShadowDragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireAdultDragonEntity extends FireDragon {
    public FireAdultDragonEntity(EntityType<? extends FireAdultDragonEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 140;
    }
    public int getMaxSpawnClusterSize() {
        return 1;
    }


    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.ATTACK_DAMAGE, 16.0D)
                .add(Attributes.ATTACK_SPEED, 1.5F)
                .add(Attributes.MOVEMENT_SPEED, 1.6F)
                .add(Attributes.ARMOR_TOUGHNESS, 8.0F)
                .build();
    }


}