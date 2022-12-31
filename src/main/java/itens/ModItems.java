package itens;

import com.lucasarend.foxxytechnology.FoxxyTechnology;
import com.lucasarend.foxxytechnology.creativetabs.ModCreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FoxxyTechnology.MODID);

    public static final RegistryObject<Item> BASICFOXYINGOT = ITEMS.register("basicfoxyingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));

    public static final RegistryObject<Item> ADVANCEDFOXYINGOT = ITEMS.register("advancedfoxyingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));

    public static final RegistryObject<Item> FOXYGEM = ITEMS.register("foxygem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
