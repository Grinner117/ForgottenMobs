package net.grinner117.forgottendragons.entity.type;

import net.grinner117.forgottenmobs.entity.type.Dragon;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ShadowDragon extends Dragon {

    public ShadowDragon(EntityType<? extends Dragon> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
    }

    //particle effect
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level.isClientSide) {
            float f = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
            float f1 = Mth.cos((float) (this.getUniqueFlapTickOffset() + this.tickCount + 1) * 7.448451F * ((float) Math.PI / 180F) + (float) Math.PI);
            if (f > 0.0F && f1 <= 0.0F) {
                this.level.addParticle(ParticleTypes.MYCELIUM, this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), this.getY() + 0.5D + (double) (this.random.nextFloat() * this.getBbHeight()), this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), 1.0D, 1.0D, 1.0D);
            }
        }
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
                    this.level.addParticle(ParticleTypes.MYCELIUM, this.getRandomX(0.2D), this.getRandomY(), this.getRandomZ(8.0D), 0.5D, 0.5D, 0.5D);
                }
            }
        }
    }
}