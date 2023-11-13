package net.grinner117.forgottenplant.item;

import net.grinner117.forgottenplant.entity.ModEntityTypes;
import net.grinner117.forgottenplant.entity.projectile.NeedleEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NeedleItem extends ArrowItem {
	public NeedleItem(Properties props) {
		super(props);
	}

	@Override
	public AbstractArrow createArrow(Level world, ItemStack ammoStack, LivingEntity shooter) {
		return new NeedleEntity(ModEntityTypes.NEEDLE.get(), shooter, world);
	}
}
