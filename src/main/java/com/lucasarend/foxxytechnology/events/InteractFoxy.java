package com.lucasarend.foxxytechnology.events;

import com.lucasarend.foxxytechnology.FoxxyTechnology;
import com.lucasarend.foxxytechnology.itens.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

@Mod.EventBusSubscriber(modid = FoxxyTechnology.MODID)
public final class InteractFoxy
{
    @SubscribeEvent
    public static void onPlayerInteractEntity(PlayerInteractEvent.RightClickItem.EntityInteract event) {
        //Cliente side dont run event
        if (event.getLevel().isClientSide) {
            return;
        }
        if (event.getTarget().getType() == EntityType.FOX) {
            //ItemStack itemStack = event.getItemStack();
            Item itemHand = event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getItem();

            boolean removeItemHand = false;

            if (itemHand == Items.IRON_INGOT) {
                FoxxyTechnology.LOGGER.info("Clicou na raposa usando um Ferro");
                //Give a Item a Player
                ItemStack setStack = new ItemStack(ModItems.BASICFOXYINGOT.get());
                setStack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(event.getEntity(), setStack);
                //Remove a item event a player
                removeItemHand = true;
            } else if (itemHand == Items.GOLD_INGOT) {
                FoxxyTechnology.LOGGER.info("Clicou na raposa usando um Ouro");
                //Give a Item a Player
                ItemStack setStack = new ItemStack(ModItems.ADVANCEDFOXYINGOT.get());
                setStack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(event.getEntity(), setStack);
                //Remove a item event a player
                removeItemHand = true;
            } else if (itemHand == Items.DIAMOND) {
                FoxxyTechnology.LOGGER.info("Clicou na raposa usando um Diamante");
                //Give a Item a Player
                ItemStack setStack = new ItemStack(ModItems.FOXYGEM.get());
                setStack.setCount(1);
                ItemHandlerHelper.giveItemToPlayer(event.getEntity(), setStack);
                //Remove a item event a player
                removeItemHand = true;
            } else {
                FoxxyTechnology.LOGGER.info("Clicou com o direito em uma raposa com: " + itemHand );
            }

            //Remove a item event a player
            if (removeItemHand) {
                ItemStack stktoremove = new ItemStack(itemHand);
                event.getEntity().getInventory().clearOrCountMatchingItems(p -> stktoremove.getItem() == p.getItem(), 1, event.getEntity().inventoryMenu.getCraftSlots());
            }

        }
    }

}
