package com.lucasarend.foxxytechnology.blocks.entity;

import com.lucasarend.foxxytechnology.FoxxyTechnology;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.lucasarend.foxxytechnology.blocks.ModBlocks;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FoxxyTechnology.MODID);

    public static final RegistryObject<BlockEntityType<MobSlayerTile>> MOB_SLAYER =
            BLOCK_ENTITIES.register("mob_slayer", () ->
                    BlockEntityType.Builder.of(MobSlayerTile::new,
                            ModBlocks.MOB_SLAYER.get()).build(null));

    /*public static final RegistryObject<BlockEntityType<AdvancedSpawnBlockEntity>> ADVANCED_SPAWN_BLOCK =
            BLOCK_ENTITIES.register("advanced_spawn_block", () ->
                    BlockEntityType.Builder.of(AdvancedSpawnBlockEntity::new,
                            ModBlocks.ADVANCED_SPAWN_BLOCK.get()).build(null));*/


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
