package com.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class TestItem  extends ArrowItem {
    public TestItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter)
    {
        TestArrow arrowEntity = new TestArrow(world, shooter, stack.copyWithCount(1));
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
    {
        float x;
        float z;

        Random rng = new Random(System.currentTimeMillis());

        x = rng.nextFloat();
        z = rng.nextFloat();

        playerEntity.teleport(x, playerEntity.getY(), z);
        playerEntity.setVelocity(0,0,0);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
