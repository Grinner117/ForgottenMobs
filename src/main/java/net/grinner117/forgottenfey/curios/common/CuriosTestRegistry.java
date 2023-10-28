package net.grinner117.forgottenfey.curios.common;

import net.grinner117.forgottenfey.ForgottenFey;
import net.grinner117.forgottenfey.curios.common.item.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = ForgottenFey.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CuriosTestRegistry {

	private static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenFey.MODID);

	public static final RegistryObject<Item> CROWN = ITEMS.register("crown", CrownItem::new);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}