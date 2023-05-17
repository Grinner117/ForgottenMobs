package net.grinner117.forgottenmobs.block;


import net.grinner117.forgottenmobs.entity.ModEntityTypes;
import net.grinner117.forgottenmobs.entity.custom.VineBlightEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class BlightedSoil extends SpreadingSnowyDirtBlock {
    public BlightedSoil(Block.Properties properties) {
        super(properties);
    }
    public void animateTick(BlockState p_221789_, Level p_221790_, BlockPos p_221791_, RandomSource p_221792_) {
        super.animateTick(p_221789_, p_221790_, p_221791_, p_221792_);
        if (p_221792_.nextInt(10) == 0) {
            p_221790_.addParticle(ParticleTypes.MYCELIUM, (double)p_221791_.getX() + p_221792_.nextDouble(), (double)p_221791_.getY() + 1.1D, (double)p_221791_.getZ() + p_221792_.nextDouble(), 0.0D, 0.0D, 0.0D);
        }

    }
    @Override
    public boolean randomTick(BlockState state) {
        super.isRandomlyTicking(state);
        if(state.
        return true;
    }


    //every 300 ticks, spawns a blight
@Override
public void randomTick(BlockState p_222508_, ServerLevel p_222509_, BlockPos p_222510_, RandomSource p_222511_) {
    if (p_222508_, p_222509_, p_222510_) {
        if (!p_222509_.isAreaLoaded(p_222510_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
        p_222509_.setBlockAndUpdate(p_222510_, Blocks.DIRT.defaultBlockState());
    } else {
        if (!p_222509_.isAreaLoaded(p_222510_, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
        if (p_222509_.getMaxLocalRawBrightness(p_222510_.above()) >= 9) {
            BlockState blockstate = this.defaultBlockState();

            for(int i = 0; i < 4; ++i) {
                BlockPos blockpos = p_222510_.offset(p_222511_.nextInt(3) - 1, p_222511_.nextInt(5) - 3, p_222511_.nextInt(3) - 1);
                if (p_222509_.getBlockState(blockpos).is(Blocks.DIRT) && canPropagate(blockstate, p_222509_, blockpos)) {
                    p_222509_.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, Boolean.valueOf(p_222509_.getBlockState(blockpos.above()).is(Blocks.SNOW))));
                }
            }
        }

    }
}


}
