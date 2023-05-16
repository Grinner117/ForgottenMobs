package net.grinner117.forgottenmobs.item;

import net.grinner117.forgottenmobs.ForgottenMobs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ForgottenMobs.MODID);

    public static final RegistryObject<Block> CLEANSINGSTONE = BLOCKS.register("cleansingstone",
            () -> new Block(Block.Properties.of(Material.STONE).strength(4f, 1200f)
                    .requiresCorrectToolForDrops()));
}
