package net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ItemAbility;
import net.projectprimal.simple_weaponry.common.WeaponAbilities;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Properties.GiantItem;

import java.util.List;

public class ScytheWeapon extends HoeItem implements GiantItem {
    public ScytheWeapon(Tier tier, Properties properties) {
        super(tier, properties);
    }
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_SCYTHE_ACTIONS.contains(itemAbility);
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simple_weaponry.scythe"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        GiantItem.super.inventoryTick(stack, level, entity, slotId, isSelected);
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }
}