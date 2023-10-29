package net.grinner117.forgottenfey.curios.common.item;

import net.grinner117.forgottenfey.curios.common.CurioItemCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;

import static top.theillusivec4.curios.api.CuriosApi.getCuriosHelper;

public class CrownItem extends Item {

	public CrownItem() {
		super(new Item.Properties().tab(net.grinner117.forgottenmobs.item.ModCreativeModeTab.FORGOTTENTAB)
				.stacksTo(1).defaultDurability(2000));

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
							damager -> getCuriosHelper().onBrokenCurio(slotContext));
				}
			}
		});
	}

	@Override
	public boolean isFoil(@Nonnull ItemStack stack) {
		return true;
	}

	@Nonnull
	public ICurio.SoundInfo getEquipSound(SlotContext slotContext) {
		return new ICurio.SoundInfo(SoundEvents.ARMOR_EQUIP_GOLD, 1.0f, 1.0f);
	}

	public boolean canEquipFromUse(SlotContext slot) {
		return true;
	}

	public boolean makesPiglinsNeutral(SlotContext slotContext) {
		return true;
	}

	public boolean isEnderMask(SlotContext slotContext, EnderMan enderMan) {
		return true;
	}

	public int getFortuneLevel(SlotContext slotContext, @Nullable LootContext lootContext) {
		return 3;
	}

}