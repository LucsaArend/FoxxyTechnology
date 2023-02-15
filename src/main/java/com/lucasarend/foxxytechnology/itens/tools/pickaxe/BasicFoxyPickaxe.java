package com.lucasarend.foxxytechnology.itens.tools.pickaxe;

import com.lucasarend.foxxytechnology.creativetabs.ModCreativeModeTab;
import com.lucasarend.foxxytechnology.itens.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class BasicFoxyPickaxe extends PickaxeItem
{
    public BasicFoxyPickaxe()
    {
        super(new Tier() {
            public int getUses() {
                return 550;
            }
            public float getSpeed() {
                return 7f;
            }
            public float getAttackDamageBonus() {
                return 3f;
            }
            public int getLevel() {
                return 3;
            }
            public int getEnchantmentValue() {
                return 2;
            }
            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(ModItems.BASICFOXYINGOT.get()));
            }
        }, 1, -2.7f, new Item.Properties().tab(ModCreativeModeTab.FOXXYTECHNOLOGY_TAB));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if ((selected) || (entity != null)) {

            if (entity.getType() != EntityType.PLAYER) {
                return;
            }

            if (entity instanceof LivingEntity _entity) {

                Player player = (Player)entity;
                Item itemHand = player.getItemInHand(InteractionHand.MAIN_HAND).getItem();

                if (itemHand == ModItems.FOXY_BASIC_PICKAXE.get()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 1));
                }
            }

        }
    }


}
