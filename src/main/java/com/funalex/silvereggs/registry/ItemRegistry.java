package com.funalex.silvereggs.registry;

import com.funalex.silvereggs.SilverEggs;
import com.funalex.silvereggs.item.*;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    public static final ExplosiveEggItem EXPLOSIVE_EGG_ITEM = new ExplosiveEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(SilverEggs.MODID, "eggs"),
            () -> new ItemStack(ItemRegistry.EXPLOSIVE_EGG_ITEM));
    public static final EnderEggItem ENDER_EGG_ITEM = new EnderEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final LightningEggItem LIGHTNING_EGG_ITEM = new LightningEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final OceanEggItem OCEAN_EGG_ITEM = new OceanEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final NetherEggItem NETHER_EGG_ITEM = new NetherEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final CoalEggItem COAL_EGG_ITEM = new CoalEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final IronEggItem IRON_EGG_ITEM = new IronEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final GoldEggItem GOLD_EGG_ITEM = new GoldEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final DiamondEggItem DIAMOND_EGG_ITEM = new DiamondEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final NetheriteEggItem NETHERITE_EGG_ITEM = new NetheriteEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final MysteryEggItem MYSTERY_EGG_ITEM = new MysteryEggItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final ExplosiveBowItem EXPLOSIVE_BOW_ITEM = new ExplosiveBowItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final LightningRodItem LIGHTNING_ROD_ITEM = new LightningRodItem(new FabricItemSettings().group(ITEM_GROUP));

    public static void registerItems() {

        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "explosive_egg"), EXPLOSIVE_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "ender_egg"), ENDER_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "lightning_egg"), LIGHTNING_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "ocean_egg"), OCEAN_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "nether_egg"), NETHER_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "coal_egg"), COAL_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "iron_egg"), IRON_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "gold_egg"), GOLD_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "diamond_egg"), DIAMOND_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "netherite_egg"), NETHERITE_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "mystery_egg"), MYSTERY_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "explosive_bow"), EXPLOSIVE_BOW_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SilverEggs.MODID, "lightning_rod"), LIGHTNING_ROD_ITEM);
    }
}
