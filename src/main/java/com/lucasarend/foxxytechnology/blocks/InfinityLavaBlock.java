package com.lucasarend.foxxytechnology.blocks;

import com.lucasarend.foxxytechnology.blocks.entity.InfinityLavaTile;
import com.lucasarend.foxxytechnology.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class InfinityLavaBlock extends Block implements EntityBlock {
    public InfinityLavaBlock(Properties copy) {
        super(copy);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.INFINITY_LAVA.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.INFINITY_LAVA.get(), InfinityLavaTile::tick);
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> type, BlockEntityType<E> correctType, BlockEntityTicker<? super E> ticker) {
        return correctType == type ? (BlockEntityTicker<A>)ticker : null;
    }

}
