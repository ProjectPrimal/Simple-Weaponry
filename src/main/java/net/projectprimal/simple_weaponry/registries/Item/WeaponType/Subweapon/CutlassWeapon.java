package net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class CutlassWeapon extends SwordItem {
    private final float waterDamage;

    public CutlassWeapon(Tier tier, Properties properties, float waterDamage) {
        super(tier, properties);
        this.waterDamage = waterDamage;
    }
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.isInWater()) {
            float waterBonusDamage = waterDamage;

            int safetyTimer = target.invulnerableTime;
            target.invulnerableTime = 0;

            target.hurt(attacker.damageSources().mobAttack(attacker), waterDamage);

            if (target.invulnerableTime == 0) {
                target.invulnerableTime = safetyTimer;
            }
        }
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simple_weaponry.wip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
