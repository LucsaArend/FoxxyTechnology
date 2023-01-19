package com.lucasarend.foxxytechnology.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class MobSlayerTile extends BlockEntity {

    int timer = 0;
    int damage = 2;
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

    final int RANGE = 5;
    private void hurtMobs() {
        BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
        BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
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
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putBoolean("active", this.isActive);
        nbt.putInt("damage", this.damage);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.isActive = nbt.getBoolean("active");
        this.damage = nbt.getInt("damage");
    }
}