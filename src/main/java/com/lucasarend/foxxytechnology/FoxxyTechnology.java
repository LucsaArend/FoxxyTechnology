package com.lucasarend.foxxytechnology;

import com.lucasarend.foxxytechnology.blocks.ModBlocks;
import com.lucasarend.foxxytechnology.blocks.entity.ModBlockEntities;
import com.lucasarend.foxxytechnology.paintings.ModPaintings;
import com.lucasarend.foxxytechnology.screen.ModMenuTypes;
import com.mojang.logging.LogUtils;
import com.lucasarend.foxxytechnology.itens.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FoxxyTechnology.MODID)
public class FoxxyTechnology
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "foxxytechnology";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public FoxxyTechnology()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModPaintings.register(modEventBus);
        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        //modEventBus.addGenericListener(Entity.class, ExampleMod::forgeEventHandler);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("FoxxyTechnology init Common Setup");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        //MinecraftForge.EVENT_BUS.register(new HitFoxy());
        LOGGER.info("FoxxyTechnology finish Common Setup");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("FoxxyTechnology init Server Starting");
        // Do something when the server starts
        LOGGER.info("FoxxyTechnology finish Server Starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("FoxxyTechnology init Client Setup");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            LOGGER.info("FoxxyTechnology finish Client Setup");
        }
    }
}
