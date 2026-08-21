package net.projectprimal.simple_weaponry.registries.Item.WeaponType;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Properties.BludgeonWeapon;

import java.util.List;
import java.util.Optional;

import static net.minecraft.world.item.TridentItem.createToolProperties;

public class UraniumClubWeapon extends BludgeonWeapon {

    private static final ResourceLocation IRRADIATED = ResourceLocation.fromNamespaceAndPath("alexscaves", "irradiated");

    public UraniumClubWeapon(Tier tier, Properties properties) {
        super(tier, properties.component(DataComponents.TOOL, createToolProperties()));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            if (attacker instanceof Player player) {
                if (player.getAttackStrengthScale(0.5F) >= 0.9F) {

                    Optional<Holder.Reference<MobEffect>> moddedEffect = BuiltInRegistries.MOB_EFFECT.getHolder(IRRADIATED);

                    moddedEffect.ifPresent(mobEffectReference -> target.addEffect(new MobEffectInstance(mobEffectReference, 100, 0)));
                }
            }
        }
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simple_weaponry.uranium_studded_club"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
