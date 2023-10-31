package net.grinner117.forgottenfey.curios.common.item;

import net.grinner117.forgottenfey.curios.common.CurioItemCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;

import static top.theillusivec4.curios.api.CuriosApi.getCuriosHelper;

public class GoblinNecklace extends Item implements ICurio {


	public GoblinNecklace() {
		super(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
				.stacksTo(1).defaultDurability(2000));
	}

	@Override
	public ItemStack getStack() {
		return null;
	}


	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag unused) {
		return CurioItemCapability.createProvider(new ICurio() {

			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void curioTick(SlotContext slotContext) {
				LivingEntity livingEntity = slotContext.entity();
				if (!livingEntity.level.isClientSide() && livingEntity.tickCount % 20 == 0) {
					livingEntity
							.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2, false, false, true));
					stack.hurtAndBreak(1, livingEntity,
							damager -> getCuriosHelper().onBrokenCurio(slotContext));
				}
			}
		});
	}

	@Nonnull
	public ICurio.SoundInfo getEquipSound(SlotContext slotContext) {
		return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_CHAIN, 1.0f, 1.5f);
	}


	//equip on use
	@Override
	public boolean canEquipFromUse(SlotContext slotContext) {
		return true;
	}

}
