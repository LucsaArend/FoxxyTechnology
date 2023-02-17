package com.lucasarend.foxxytechnology.blocks.entity;

import com.lucasarend.foxxytechnology.itens.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class MobSlayerTile extends BlockEntity {

    int timer = 0;
    int damage = 2;
    int range = 5;

    int instalDamageUp = 0;
    int instalRangeUp = 0;
    boolean isActive = true;

    public MobSlayerTile(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MOB_SLAYER.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, MobSlayerTile tile) {
        if (!level.isClientSide() && tile.isActive){
            tile.timer++;
            if (tile.timer > 20){
                tile.timer = 0;

                // only do this once per second
                tile.hurtMobs();
            }
        }
    }
    private void hurtMobs() {
        BlockPos topCorner = this.worldPosition.offset(range, range, range);
        BlockPos bottomCorner = this.worldPosition.offset(-range, -range, -range);
        AABB box = new AABB(topCorner, bottomCorner);

        List<Entity> entities = this.level.getEntities(null, box);
        for (Entity target : entities){
            if (target instanceof LivingEntity && !(target instanceof Player)){
                target.hurt(DamageSource.MAGIC, damage);
            }
        }
    }

    public void toggle(){
        this.isActive = !this.isActive;
    }

    public void addDamage()
    {
        this.damage += 2;
        this.instalDamageUp += 1;
    }

    public void addRange(){
        this.range += 1;
        this.instalRangeUp += 1;
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putBoolean("active", this.isActive);
        nbt.putInt("damage", this.damage);
        nbt.putInt("range", this.range);
        nbt.putInt("instalRangeUp", this.instalRangeUp);
        nbt.putInt("instalDamageUp", this.instalDamageUp);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.isActive = nbt.getBoolean("active");
        this.damage = nbt.getInt("damage");
        this.range = nbt.getInt("range");
        this.instalDamageUp = nbt.getInt("instalDamageUp");
        this.instalRangeUp = nbt.getInt("instalRangeUp");
    }

    public int getDamage() {
        return this.damage;
    }

    public int getRage(){
        return this.range;
    }

    public void drops(Level pLevel,BlockPos pBlock) {

        if (!pLevel.isClientSide()) {

            ItemEntity damageItem = new ItemEntity(pLevel, pBlock.getX() ,pBlock.getY(),pBlock.getZ(), new ItemStack(ModItems.FOXY_UPGRADE_DAMAGE.get()));
            ItemEntity rangeItem = new ItemEntity(pLevel, pBlock.getX() ,pBlock.getY(),pBlock.getZ(), new ItemStack(ModItems.FOXY_UPGRADE_RAGE.get()));

            for (int i=0;i<this.instalDamageUp;i++) {
                pLevel.addFreshEntity(damageItem);
            }
            for (int i=0;i<this.instalRangeUp;i++) {
                pLevel.addFreshEntity(rangeItem);
            }

        }

        /*if (world instanceof Level _level && !_level.isClientSide()) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.COAL_ORE));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
        }*/

    }
}
