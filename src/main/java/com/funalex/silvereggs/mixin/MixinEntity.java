package com.funalex.silvereggs.mixin;

import com.funalex.silvereggs.util.EffectUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public class MixinEntity {
    @Shadow
    public World world;
    @Shadow
    private Vec3d pos;

    /**
     * @author Mojang/Minecraft/Microsoft
     */
    @Overwrite
    @Nullable
    public ItemEntity dropStack(ItemStack stack, float yOffset) {
        if (stack.isEmpty()) {
            return null;
        } else if (this.world.isClient) {
            return null;
        } else {
            ItemEntity itemEntity;
            if (stack.getItem().equals(Items.EGG)) {
                itemEntity = new ItemEntity(this.world, this.pos.x, this.pos.y + (double) yOffset, this.pos.z, new ItemStack(EffectUtil.getRandomEgg()));
                itemEntity.setToDefaultPickupDelay();
                this.world.spawnEntity(itemEntity);
            } else {
                itemEntity = new ItemEntity(this.world, this.pos.x, this.pos.y + (double) yOffset, this.pos.z, stack);
                itemEntity.setToDefaultPickupDelay();
                this.world.spawnEntity(itemEntity);
            }
            return itemEntity;
        }
    }
}
