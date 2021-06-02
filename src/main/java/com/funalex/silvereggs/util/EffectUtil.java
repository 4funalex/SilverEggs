package com.funalex.silvereggs.util;

import com.funalex.silvereggs.registry.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public final class EffectUtil {
    private static final Random random = new Random();

    public static void explosiveEffect(World world, HitResult hitResult) {
        final int chargedCreepers = random.nextInt(1) + 1;
        final int creepers = random.nextInt(2) + 2;
        final int bowChance = random.nextInt(5);

        world.createExplosion(null, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z, 4.5f, Explosion.DestructionType.DESTROY);

        for (int i = 0; i <= creepers; i++) {
            float xMult = random.nextFloat() * 2;
            float yMult = random.nextFloat() * 2;
            float zMult = random.nextFloat() * 2;

            if (random.nextBoolean())
                xMult = -xMult;
            if (random.nextBoolean())
                zMult = -zMult;

            CreeperEntity creeperEntity = EntityType.CREEPER.create(world);
            creeperEntity.refreshPositionAndAngles(hitResult.getPos().x + xMult, hitResult.getPos().y + yMult, hitResult.getPos().z + zMult, 0, 0);
            world.spawnEntity(creeperEntity);
        }

        for (int i = 0; i <= chargedCreepers; i++) {
            float xMult = random.nextFloat() * 2;
            float yMult = random.nextFloat() * 2;
            float zMult = random.nextFloat() * 2;

            if (random.nextBoolean())
                xMult = -xMult;
            if (random.nextBoolean())
                zMult = -zMult;

            CreeperEntity creeperEntity = EntityType.CREEPER.create(world);
            creeperEntity.refreshPositionAndAngles(hitResult.getPos().x + xMult, hitResult.getPos().y + yMult, hitResult.getPos().z + zMult, 0, 0);
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putBoolean("powered", true);
            creeperEntity.writeCustomDataToTag(compoundTag.copy());
            creeperEntity.readCustomDataFromTag(compoundTag);

            world.spawnEntity(creeperEntity);
        }
        LootContext.Builder builder = (new LootContext.Builder(world.getServer().getWorld(world.getRegistryKey()))).optionalParameter(LootContextParameters.THIS_ENTITY, null).parameter(LootContextParameters.ORIGIN, hitResult.getPos());
        LootTable lootTable = builder.build(LootContextTypes.CHEST).getSupplier(LootTables.DESERT_PYRAMID_CHEST);

        for (ItemStack itemStack : lootTable.generateLoot(builder.build(LootContextTypes.CHEST))) {
            float xMult = random.nextFloat() * 2;
            float zMult = random.nextFloat() * 2;

            if (random.nextBoolean())
                xMult = -xMult;
            if (random.nextBoolean())
                zMult = -zMult;
            ItemEntity itemEntity = new ItemEntity(world, hitResult.getPos().x + xMult, hitResult.getPos().y + 0.5, hitResult.getPos().z + zMult, itemStack);
            itemEntity.setToDefaultPickupDelay();
            world.spawnEntity(itemEntity);
        }

        if (bowChance == 4) {

        }
    }

    public static Item getRandomEgg() {
        int egg = random.nextInt(12);

        switch (egg) {
            case 0:
                return ItemRegistry.EXPLOSIVE_EGG_ITEM;
            case 1:
                return ItemRegistry.ENDER_EGG_ITEM;
            case 2:
                return ItemRegistry.LIGHTNING_EGG_ITEM;
            case 3:
                return ItemRegistry.OCEAN_EGG_ITEM;
            case 4:
                return ItemRegistry.NETHER_EGG_ITEM;
            case 5:
                return ItemRegistry.COAL_EGG_ITEM;
            case 6:
                return ItemRegistry.IRON_EGG_ITEM;
            case 7:
                return ItemRegistry.GOLD_EGG_ITEM;
            case 8:
                return ItemRegistry.DIAMOND_EGG_ITEM;
            case 9:
                return ItemRegistry.NETHERITE_EGG_ITEM;
            case 10:
                return Items.EGG;
            default:
                return ItemRegistry.MYSTERY_EGG_ITEM;
        }
    }
}
