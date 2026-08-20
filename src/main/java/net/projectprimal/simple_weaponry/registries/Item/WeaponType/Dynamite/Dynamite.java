package net.projectprimal.simple_weaponry.registries.Item.WeaponType.Dynamite;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Dynamite extends Snowball {
    public Dynamite(EntityType<? extends Snowball> entityType, Level level) {
        super(entityType, level);
    }

    public Dynamite(Level level, LivingEntity shooter) {
        super(level, shooter);
    }

    public Dynamite(Level level, double x, double y, double z) {
        super(level, x, y, z);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!this.level().isClientSide) {
            this.level().explode(
                    this,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    1.9F,
                    Level.ExplosionInteraction.TNT
            );
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().explode(
                    this,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    1.9F,
                    Level.ExplosionInteraction.TNT
            );
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }
}
