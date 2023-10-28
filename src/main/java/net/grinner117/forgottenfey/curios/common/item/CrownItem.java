package net.grinner117.forgottenfey.curios.common.item;

import net.grinner117.forgottenfey.curios.common.CurioItemCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;

public class CrownItem extends Item {

	public CrownItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).defaultDurability(2000));
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
							.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, -1, true, true));
					stack.hurtAndBreak(1, livingEntity,
							damager -> CuriosApi.getCuriosHelper().onBrokenCurio(slotContext));
				}
			}
		});
	}

	@Override
	public boolean isFoil(@Nonnull ItemStack stack) {
		return true;
	}
}