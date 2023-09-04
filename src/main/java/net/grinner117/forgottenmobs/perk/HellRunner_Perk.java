package net.grinner117.forgottenmobs.perk;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class HellRunner_Perk extends ArmorItem {
	public HellRunner_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);

	}

	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		if (!world.isClientSide()) {
			player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0, false, false, false));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 0, false, false, false));
			player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200, 0, false, false, false));
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, false, false, false));
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 2, false, false, true));

		}

	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componets, TooltipFlag flag) {
		if (Screen.hasShiftDown()) {
			componets.add(Component.literal("Slowfalling, Jump, Saturation, Speed, Fire Resistance").withStyle(ChatFormatting.DARK_AQUA));
		} else {
			componets.add(Component.literal("Hell Runner").withStyle(ChatFormatting.YELLOW));
		}
		super.appendHoverText(stack, level, componets, flag);
	}
}