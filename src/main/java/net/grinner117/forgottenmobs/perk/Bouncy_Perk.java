package net.grinner117.forgottenmobs.perk;

import net.grinner117.radiantlibrary.effects.ModEffects;
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

public class Bouncy_Perk extends ArmorItem {
	public Bouncy_Perk(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
		super(pMaterial, pSlot, pProperties);
	}

	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		if (!world.isClientSide()) {
			player.addEffect(new MobEffectInstance(ModEffects.BOUNCE_EFFECT.get(), 200, 1, false, false, true));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1, false, false, true));

		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componets, TooltipFlag flag) {
		if (Screen.hasShiftDown()) {
			componets.add(Component.literal("Bounce and Jump Effect").withStyle(ChatFormatting.DARK_AQUA));
		} else {
			componets.add(Component.literal("Weeeeeeee!!!").withStyle(ChatFormatting.YELLOW));
		}
		super.appendHoverText(stack, level, componets, flag);
	}
}
}
