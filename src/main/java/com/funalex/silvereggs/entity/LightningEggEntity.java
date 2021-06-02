package com.funalex.silvereggs.entity;

import com.funalex.silvereggs.client.SilverEggsClient;
import com.funalex.silvereggs.packet.EntitySpawnPacket;
import com.funalex.silvereggs.registry.EntityRegistry;
import com.funalex.silvereggs.registry.ItemRegistry;
import com.funalex.silvereggs.util.EffectUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class LightningEggEntity extends ThrownItemEntity {
    public LightningEggEntity(EntityType<? extends LightningEggEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightningEggEntity(World world, LivingEntity owner) {
        super(EntityRegistry.EXPLOSIVE_EGG_ENTITY_ENTITY_TYPE, owner, world);
    }

    public LightningEggEntity(World world, double x, double y, double z) {
        super(EntityRegistry.EXPLOSIVE_EGG_ENTITY_ENTITY_TYPE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.EXPLOSIVE_EGG_ITEM;
    }

    @Override
    public Packet createSpawnPacket() {
        return EntitySpawnPacket.create(this, SilverEggsClient.PacketID);
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()), this.getX(), this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 0.0F);
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            EffectUtil.explosiveEffect(this.world, hitResult);
            this.world.sendEntityStatus(this, (byte) 3);
            this.remove();
        }
    }
}
