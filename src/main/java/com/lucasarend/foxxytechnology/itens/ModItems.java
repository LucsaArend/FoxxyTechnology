package com.lucasarend.foxxytechnology.itens;

import com.lucasarend.foxxytechnology.FoxxyTechnology;
import com.lucasarend.foxxytechnology.creativetabs.ModCreativeModeTab;
import com.lucasarend.foxxytechnology.itens.sword.BasicFoxySword;
import com.lucasarend.foxxytechnology.itens.tools.axe.BasicFoxyAxe;
import com.lucasarend.foxxytechnology.itens.tools.pickaxe.BasicFoxyPickaxe;
import com.lucasarend.foxxytechnology.itens.tools.shovel.BasicFoxyShovel;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //Itens
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FoxxyTechnology.MODID);

    public static final RegistryObject<Item> BASICFOXYINGOT = ITEMS.register("basicfoxyingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));

    public static final RegistryObject<Item> ADVANCEDFOXYINGOT = ITEMS.register("advancedfoxyingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));

    public static final RegistryObject<Item> FOXYGEM = ITEMS.register("foxygem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));

    public static final RegistryObject<Item> MERCURY = ITEMS.register("mercury",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));

    //Upgrade Itens
    public static final RegistryObject<Item> FOXY_UPGRADE_RAGE = ITEMS.register("foxyupgraderage",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));
    public static final RegistryObject<Item> FOXY_UPGRADE_DAMAGE = ITEMS.register("foxyupgradamage",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));
    //Tools
    public static final RegistryObject<Item> FOXY_BASIC_PICKAXE = ITEMS.register("foxybasicpickaxe",
            () -> new BasicFoxyPickaxe());

    public static final RegistryObject<Item> FOXY_BASIC_AXE = ITEMS.register("foxybasicaxe",
            () -> new BasicFoxyAxe());

    public static final RegistryObject<Item> FOXY_BASIC_SHOVEL = ITEMS.register("foxybasicshovel",
            () -> new BasicFoxyShovel());

    public static final RegistryObject<Item> FOXY_BASIC_SWORD = ITEMS.register("foxybasicsword",
            () -> new BasicFoxySword());


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
