package com.lucasarend.foxxytechnology.blocks;

import com.lucasarend.foxxytechnology.FoxxyTechnology;
import com.lucasarend.foxxytechnology.creativetabs.ModCreativeModeTab;
import com.lucasarend.foxxytechnology.itens.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FoxxyTechnology.MODID);
    /* Blocos */
    public static final RegistryObject<Block> BASICINGOT_BLOCK = registerBlock("basicingot_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f)), ModCreativeModeTab.FOXXYTECHNOLOGY_TAB);

    public static final RegistryObject<Block> ADVANCEDFOXYINGOT_BLOCK = registerBlock("advancedfoxyingot_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f)), ModCreativeModeTab.FOXXYTECHNOLOGY_TAB);

    public static final RegistryObject<Block> FOXYGEM_BLOCK = registerBlock("foxygem_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)), ModCreativeModeTab.FOXXYTECHNOLOGY_TAB);

    public static final RegistryObject<Block> DEEPSLATE_MERCURY_ORE = registerBlock("deepslate_mercury_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)), ModCreativeModeTab.FOXXYTECHNOLOGY_TAB);
    public static final RegistryObject<Block> MOB_SLAYER = registerBlock("mob_slayer",
            () -> new MobSlayerBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f)), ModCreativeModeTab.FOXXYTECHNOLOGY_TAB);
    public static final RegistryObject<Block> INFINITY_WATER = registerBlock("infinity_water",
            () -> new InfinityWaterBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f)), ModCreativeModeTab.FOXXYTECHNOLOGY_TAB);
    public static final RegistryObject<Block> INFINITY_LAVA = registerBlock("infinity_lava",
            () -> new InfinityLavaBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f)), ModCreativeModeTab.FOXXYTECHNOLOGY_TAB);

    /* Registra o Bloco */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    /* Registra o Bloco Item */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
