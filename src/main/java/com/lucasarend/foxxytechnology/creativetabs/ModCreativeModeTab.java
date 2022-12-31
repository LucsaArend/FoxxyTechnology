package com.lucasarend.foxxytechnology.creativetabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab FOXXYTECHNOLOGY_TAB = new CreativeModeTab("foxxytechnologytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);
            //return new ItemStack(ModItems.ZIRCON.get());
        }
    };
}
