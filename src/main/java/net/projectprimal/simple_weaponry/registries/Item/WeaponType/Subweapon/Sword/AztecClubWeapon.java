package net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.Sword;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class AztecClubWeapon extends SwordItem {
    public AztecClubWeapon(Tier tier, Properties properties) {
        super(tier, properties);
    }
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));
        }
        return true;
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simple_weaponry.wip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
