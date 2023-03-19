package net.grinner117.forgottenmobs.item;


import net.grinner117.forgottenmobs.ForgottenMobs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenMobs.MODID);

  private static Item.Properties props(){return new Item.Properties(); }
       public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);    }

}