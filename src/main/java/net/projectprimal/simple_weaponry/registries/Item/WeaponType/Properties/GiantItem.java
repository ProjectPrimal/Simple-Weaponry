package net.projectprimal.simple_weaponry.registries.Item.WeaponType.Properties;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface GiantItem {

    default void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide() && entity instanceof LivingEntity livingEntity) {
            if (livingEntity.getMainHandItem() == stack || livingEntity.getOffhandItem() == stack) {
                livingEntity.addEffect(new MobEffectInstance(
                        MobEffects.MOVEMENT_SLOWDOWN,
                        1,
                        1,
                        true,
                        false,
                        false
                ));
            }
        }
    }
}