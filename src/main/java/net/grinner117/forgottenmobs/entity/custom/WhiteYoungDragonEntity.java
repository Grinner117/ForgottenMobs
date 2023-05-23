package net.grinner117.forgottenmobs.entity.custom;

import net.grinner117.forgottenmobs.entity.type.Dragon;
import net.grinner117.forgottenmobs.entity.type.WhiteDragon;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class WhiteYoungDragonEntity extends WhiteDragon {
    public WhiteYoungDragonEntity(EntityType<? extends WhiteYoungDragonEntity> p_33101_, Level p_33102_) {
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
    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            float f = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
            float f1 = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
            if (f > 0.0F && f1 <= 0.0F) {
                this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.PHANTOM_FLAP, this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F, false);
            }

            super.tick();
            if (this.level.isClientSide) {
                for (int i = 0; i < 8; ++i) {
                    this.level.addParticle(ParticleTypes.SNOWFLAKE, this.getRandomX(0.2D), this.getRandomY(), this.getRandomZ(8.0D), 0.5D, 0.5D, 0.5D);
                }
            }
        }
    }
}