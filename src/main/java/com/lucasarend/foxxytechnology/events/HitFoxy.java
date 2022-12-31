package com.lucasarend.foxxytechnology.events;

import com.lucasarend.foxxytechnology.FoxxyTechnology;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
@Mod.EventBusSubscriber(modid = FoxxyTechnology.MODID)
public final class HitFoxy {
    @SubscribeEvent
    public static void onPlayerAttacked(AttackEntityEvent e) {
        if (e.getTarget().getType() == EntityType.FOX) {
            FoxxyTechnology.LOGGER.info("Não bata em uma raposa!");
            //Make a Spawn Cave Spider
            Entity entityToSpawn = new CaveSpider(EntityType.CAVE_SPIDER, e.getTarget().getLevel());
            Entity entityToSpawn2 = new Creeper(EntityType.CREEPER, e.getTarget().getLevel());
            //Get Fox Position
            Vec3 positionSpawn = e.getTarget().position();
            //Add 1 in y
            positionSpawn.add(0,1,0);
            //Set Position to Spawn Cave Spider
            entityToSpawn.setPos( positionSpawn );
            entityToSpawn2.setPos( positionSpawn );
            //Spawn Cave Spider
            e.getTarget().getLevel().addFreshEntity(entityToSpawn);
            e.getTarget().getLevel().addFreshEntity(entityToSpawn2);
        }
    }

}
