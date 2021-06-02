package com.funalex.silvereggs.registry;

import com.funalex.silvereggs.SilverEggs;
import com.funalex.silvereggs.entity.ExplosiveEggEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
    public static final EntityType<ExplosiveEggEntity> EXPLOSIVE_EGG_ENTITY_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(SilverEggs.MODID, "explosive_egg"),
            FabricEntityTypeBuilder.<ExplosiveEggEntity>create(SpawnGroup.MISC, ExplosiveEggEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
}
