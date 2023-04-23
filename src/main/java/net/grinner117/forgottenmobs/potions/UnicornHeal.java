package net.grinner117.forgottenmobs.potions;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;


//extends MobEffects Healing without the particles
public class UnicornHeal extends MobEffect {

//effect heals effected entity
    protected UnicornHeal() {
        super(MobEffectCategory.BENEFICIAL, 0xf0e97f);
    }

        public void applyEffectTick (LivingEntity p_19467_,int p_19468_){
            if (this == MobEffects.REGENERATION) {
                if (p_19467_.getHealth() < p_19467_.getMaxHealth()) {
                    p_19467_.heal(1.0F);
                }
            }

        }

    }



