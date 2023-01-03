package com.lucasarend.foxxytechnology.paintings;

import com.lucasarend.foxxytechnology.FoxxyTechnology;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {

    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, FoxxyTechnology.MODID);

    public static final RegistryObject<PaintingVariant> PLANT = PAINTING_VARIANTS.register("fox_01",
            () -> new PaintingVariant(128, 96));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
