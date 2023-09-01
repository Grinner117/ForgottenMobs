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

public class FreeRunner_Perk extends ArmorItem {
    public FreeRunner_Perk(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);

    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 1,false, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1,false, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200, 0,false, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1,false, false, false));

        }

    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componets, TooltipFlag flag){
        if(Screen.hasShiftDown()){
            componets.add(Component.literal("Slowfalling, Jump, Saturation, Speed 2").withStyle(ChatFormatting.DARK_AQUA));
        } else{
            componets.add(Component.literal("Free Runner").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(stack, level, componets,flag);
    }
}