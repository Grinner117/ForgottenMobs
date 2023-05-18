package net.grinner117.forgottenmobs.block;


import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.VineBlightEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.MyceliumBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class BlightedSoil extends MyceliumBlock {
    public BlightedSoil(BlockBehaviour.Properties p_54898_) {
        super(p_54898_);
    }

    public void tick(BlockState state, Level world, BlockPos pos, Random random) {
        super.tick(state, (ServerLevel) world, pos, (RandomSource) random);
        VineBlightEntity vineblight = new VineBlightEntity(ModEntityTypes.VINEBLIGHT.get(), world);
        if (random.nextInt(30) == 0) {
            // Spawn a pig at the block's location.
            world.addFreshEntity(vineblight);
            vineblight.moveTo(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
        }
    }
}
