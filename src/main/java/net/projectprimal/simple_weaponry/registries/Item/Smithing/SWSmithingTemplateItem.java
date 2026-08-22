package net.projectprimal.simple_weaponry.registries.Item.Smithing;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.TooltipFlag;
import net.projectprimal.simple_weaponry.SimpleWeaponry;

public class SWSmithingTemplateItem extends Item {
    private static final ChatFormatting TITLE_FORMAT;
    private static final ChatFormatting DESCRIPTION_FORMAT;
    private static final Component INGREDIENTS_TITLE;
    private static final Component APPLIES_TO_TITLE;
    private static final Component COAST_UPGRADE;
    private static final Component COAST_UPGRADE_APPLIES_TO;
    private static final Component COAST_UPGRADE_INGREDIENTS;
    private static final Component COAST_UPGRADE_BASE_SLOT_DESCRIPTION;
    private static final Component COAST_UPGRADE_ADDITIONS_SLOT_DESCRIPTION;
    private static final ResourceLocation EMPTY_SLOT_HELMET;
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE;
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS;
    private static final ResourceLocation EMPTY_SLOT_BOOTS;
    private static final ResourceLocation EMPTY_SLOT_HOE;
    private static final ResourceLocation EMPTY_SLOT_AXE;
    private static final ResourceLocation EMPTY_SLOT_SWORD;
    private static final ResourceLocation EMPTY_SLOT_SHOVEL;
    private static final ResourceLocation EMPTY_SLOT_PICKAXE;
    private static final ResourceLocation EMPTY_SLOT_INGOT;
    private static final ResourceLocation EMPTY_SLOT_REDSTONE_DUST;
    private static final ResourceLocation EMPTY_SLOT_QUARTZ;
    private static final ResourceLocation EMPTY_SLOT_EMERALD;
    private static final ResourceLocation EMPTY_SLOT_DIAMOND;
    private static final ResourceLocation EMPTY_SLOT_LAPIS_LAZULI;
    private static final ResourceLocation EMPTY_SLOT_AMETHYST_SHARD;
    private static final ResourceLocation EMPTY_SLOT_PRISMARINE;
    private final Component appliesTo;
    private final Component ingredients;
    private final Component upgradeDescription;
    private final Component baseSlotDescription;
    private final Component additionsSlotDescription;
    private final List<ResourceLocation> baseSlotEmptyIcons;
    private final List<ResourceLocation> additionalSlotEmptyIcons;

    public SWSmithingTemplateItem(Component appliesTo, Component ingredients, Component upgradeDescription, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons, FeatureFlag... requiredFeatures) {
        super((new Item.Properties()).requiredFeatures(requiredFeatures));
        this.appliesTo = appliesTo;
        this.ingredients = ingredients;
        this.upgradeDescription = upgradeDescription;
        this.baseSlotDescription = baseSlotDescription;
        this.additionsSlotDescription = additionsSlotDescription;
        this.baseSlotEmptyIcons = baseSlotEmptyIcons;
        this.additionalSlotEmptyIcons = additionalSlotEmptyIcons;
    }

    public static SmithingTemplateItem createCoastUpgradeTemplate() {
        return new SmithingTemplateItem(COAST_UPGRADE_APPLIES_TO, COAST_UPGRADE_INGREDIENTS, COAST_UPGRADE, COAST_UPGRADE_BASE_SLOT_DESCRIPTION, COAST_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createCoastUpgradeIconList(), createCoastUpgradeMaterialList(), new FeatureFlag[0]);
    }

    private static List<ResourceLocation> createCoastUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD);
    }

    private static List<ResourceLocation> createCoastUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_PRISMARINE);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(this.upgradeDescription);
        tooltipComponents.add(CommonComponents.EMPTY);
        tooltipComponents.add(APPLIES_TO_TITLE);
        tooltipComponents.add(CommonComponents.space().append(this.appliesTo));
        tooltipComponents.add(INGREDIENTS_TITLE);
        tooltipComponents.add(CommonComponents.space().append(this.ingredients));
    }

    public Component getBaseSlotDescription() {
        return this.baseSlotDescription;
    }

    public Component getAdditionSlotDescription() {
        return this.additionsSlotDescription;
    }

    public List<ResourceLocation> getBaseSlotEmptyIcons() {
        return this.baseSlotEmptyIcons;
    }

    public List<ResourceLocation> getAdditionalSlotEmptyIcons() {
        return this.additionalSlotEmptyIcons;
    }

    static {
        TITLE_FORMAT = ChatFormatting.GRAY;
        DESCRIPTION_FORMAT = ChatFormatting.BLUE;
        INGREDIENTS_TITLE = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.ingredients"))).withStyle(TITLE_FORMAT);
        APPLIES_TO_TITLE = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.withDefaultNamespace("smithing_template.applies_to"))).withStyle(TITLE_FORMAT);
        COAST_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID,"coast_upgrade"))).withStyle(TITLE_FORMAT);
        COAST_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID,"smithing_template.coast_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
        COAST_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID,"smithing_template.coast_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
        COAST_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID,"smithing_template.coast_upgrade.base_slot_description")));
        COAST_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID,"smithing_template.coast_upgrade.additions_slot_description")));
        EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
        EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
        EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
        EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
        EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
        EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");
        EMPTY_SLOT_REDSTONE_DUST = ResourceLocation.withDefaultNamespace("item/empty_slot_redstone_dust");
        EMPTY_SLOT_QUARTZ = ResourceLocation.withDefaultNamespace("item/empty_slot_quartz");
        EMPTY_SLOT_EMERALD = ResourceLocation.withDefaultNamespace("item/empty_slot_emerald");
        EMPTY_SLOT_DIAMOND = ResourceLocation.withDefaultNamespace("item/empty_slot_diamond");
        EMPTY_SLOT_LAPIS_LAZULI = ResourceLocation.withDefaultNamespace("item/empty_slot_lapis_lazuli");
        EMPTY_SLOT_AMETHYST_SHARD = ResourceLocation.withDefaultNamespace("item/empty_slot_amethyst_shard");
        EMPTY_SLOT_PRISMARINE =ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID,"item/empty_slot_prismarine_shard");
    }
}
