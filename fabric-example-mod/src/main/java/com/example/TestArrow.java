package com.example;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.world.World;

public class TestArrow extends ArrowEntity {

    public TestArrow(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public TestArrow(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z, stack);
    }

    public TestArrow(World world, LivingEntity owner, ItemStack stack) {
        super(world, owner, stack);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
        } else if (this.inGround && this.inGroundTime != 0 && this.inGroundTime >= 600) {
            this.getWorld().sendEntityStatus(this, (byte)0);
            this.getWorld().spawnEntity(new TntEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), this.getWorld().getClosestPlayer(this, 100)));
        }
    }
}
