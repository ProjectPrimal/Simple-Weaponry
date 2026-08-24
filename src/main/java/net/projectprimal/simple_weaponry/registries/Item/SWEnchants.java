package net.projectprimal.simple_weaponry.registries.Item;

import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.projectprimal.simple_weaponry.SimpleWeaponry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.projectprimal.simple_weaponry.registries.SWTags;

public class SWEnchants {
    public static final ResourceKey<Enchantment> SMASHING = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID, "smashing"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, SMASHING, Enchantment.enchantment(Enchantment.definition(items.getOrThrow(SWTags.Items.BLUNT_WEAPON),
                items.getOrThrow(SWTags.Items.BLUNT_WEAPON), 10, 5, Enchantment.dynamicCost(1, 11),
                Enchantment.dynamicCost(21, 11), 1, new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND}))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE)).withEffect(EnchantmentEffectComponents.DAMAGE,
                        new AddValue(LevelBasedValue.perLevel(1.0F, 0.5F))));
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}