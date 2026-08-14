package net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class DaggerWeapon extends SwordItem {
    private final float backstabDamage;

    public DaggerWeapon(Tier tier, Properties properties, float backstabDamage) {
        super(tier, properties);
        this.backstabDamage = backstabDamage;
    }
    public float getBackstabMultiplier() {
        return this.backstabDamage;
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simple_weaponry.dagger"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}