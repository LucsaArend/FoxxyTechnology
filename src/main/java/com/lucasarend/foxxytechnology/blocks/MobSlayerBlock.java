package com.lucasarend.foxxytechnology.blocks;

import com.lucasarend.foxxytechnology.blocks.entity.MobSlayerTile;
import com.lucasarend.foxxytechnology.blocks.entity.ModBlockEntities;
import com.lucasarend.foxxytechnology.itens.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class MobSlayerBlock extends Block implements EntityBlock {
    /*public MobSlayerBlock(AbstractBlock.Properties props) {
        super(props);
    }*/

    public MobSlayerBlock(Properties copy) {
        super(copy);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.MOB_SLAYER.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.MOB_SLAYER.get(), MobSlayerTile::tick);
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> type, BlockEntityType<E> correctType, BlockEntityTicker<? super E> ticker) {
        return correctType == type ? (BlockEntityTicker<A>)ticker : null;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide() && hand == InteractionHand.MAIN_HAND){
            BlockEntity tile = world.getBlockEntity(pos);
            if (tile instanceof MobSlayerTile){

                Item itemMao = player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
                if (itemMao == ModItems.FOXY_UPGRADE_DAMAGE.get()) {
                    ((MobSlayerTile) tile).addDamage();
                    ItemStack stktoremove = new ItemStack(itemMao);
                    player.getInventory().clearOrCountMatchingItems(p -> stktoremove.getItem() == p.getItem(), 1, player.inventoryMenu.getCraftSlots());
                }

                ((MobSlayerTile) tile).toggle();

                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
        }

        return super.use(state, world, pos, player, hand, hit);
    }

}
