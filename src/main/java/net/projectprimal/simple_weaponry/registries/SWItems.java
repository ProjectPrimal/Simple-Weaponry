package net.projectprimal.simple_weaponry.registries;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.projectprimal.simple_weaponry.SimpleWeaponry;
import net.projectprimal.simple_weaponry.registries.Item.Smithing.SWSmithingTemplateItem;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.*;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Dynamite.DynamiteWeapon;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.Pickaxe.HammerWeapon;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.Sword.AztecClubWeapon;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.Sword.CutlassWeapon;
import net.projectprimal.simple_weaponry.registries.Item.WeaponType.Subweapon.Sword.DaggerWeapon;

public class SWItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleWeaponry.MOD_ID);

// Release
    public static final DeferredItem<ClubWeapon> WOODEN_CLUB = ITEMS.register("wooden_club", () -> new ClubWeapon(Tiers.WOOD, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.WOOD, 4, -3.5F))));
    public static final DeferredItem<ClubWeapon> IRON_STUDDED_CLUB = ITEMS.register("iron_studded_club", () -> new ClubWeapon(Tiers.IRON, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.IRON, 4, -3.5F))));
    public static final DeferredItem<ClubWeapon> GOLD_STUDDED_CLUB = ITEMS.register("gold_studded_club", () -> new ClubWeapon(Tiers.GOLD, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.GOLD, 5, -3.2F))));
    // Create Mod
    public static final DeferredItem<ClubWeapon> COPPER_STUDDED_CLUB = ITEMS.register("copper_studded_club", () -> new ClubWeapon(Tiers.STONE, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.STONE, 4, -3.5F)).durability(190)));
    public static final DeferredItem<ClubWeapon> ZINC_STUDDED_CLUB = ITEMS.register("zinc_studded_club", () -> new ClubWeapon(Tiers.IRON, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.IRON, 4, -3.5F))));
    public static final DeferredItem<ClubWeapon> BRASS_STUDDED_CLUB = ITEMS.register("brass_studded_club", () -> new ClubWeapon(Tiers.DIAMOND, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.DIAMOND, 4, -3.5F))));

    public static final DeferredItem<DaggerWeapon> WOODEN_DAGGER = ITEMS.register("wooden_dagger", () -> new DaggerWeapon(Tiers.WOOD, new Item.Properties().attributes(DaggerWeapon.createAttributes(Tiers.WOOD, 1, -2F)), 3f));
    public static final DeferredItem<DaggerWeapon> STONE_DAGGER = ITEMS.register("stone_dagger", () -> new DaggerWeapon(Tiers.STONE, new Item.Properties().attributes(DaggerWeapon.createAttributes(Tiers.STONE, 1, -2F)), 3f));
    public static final DeferredItem<DaggerWeapon> IRON_DAGGER = ITEMS.register("iron_dagger", () -> new DaggerWeapon(Tiers.IRON, new Item.Properties().attributes(DaggerWeapon.createAttributes(Tiers.IRON, 1, -2F)), 3f));
    public static final DeferredItem<DaggerWeapon> GOLDEN_DAGGER = ITEMS.register("golden_dagger", () -> new DaggerWeapon(Tiers.GOLD, new Item.Properties().attributes(DaggerWeapon.createAttributes(Tiers.GOLD, 1, -2F)), 3f));
    public static final DeferredItem<DaggerWeapon> DIAMOND_DAGGER = ITEMS.register("diamond_dagger", () -> new DaggerWeapon(Tiers.DIAMOND, new Item.Properties().attributes(DaggerWeapon.createAttributes(Tiers.DIAMOND, 1, -2F)), 3f));
    public static final DeferredItem<DaggerWeapon> NETHERITE_DAGGER = ITEMS.register("netherite_dagger", () -> new DaggerWeapon(Tiers.NETHERITE, new Item.Properties().attributes(DaggerWeapon.createAttributes(Tiers.NETHERITE, 1, -2F)), 3f));

    public static final DeferredItem<HammerWeapon> WOODEN_HAMMER = ITEMS.register("wooden_hammer", () -> new HammerWeapon(Tiers.WOOD, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.WOOD, 5, -3.5f))));
    public static final DeferredItem<HammerWeapon> STONE_HAMMER = ITEMS.register("stone_hammer", () -> new HammerWeapon(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 5, -3.5f))));
    public static final DeferredItem<HammerWeapon> IRON_HAMMER = ITEMS.register("iron_hammer", () -> new HammerWeapon(Tiers.IRON, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 5, -3.5f))));
    public static final DeferredItem<HammerWeapon> GOLDEN_HAMMER = ITEMS.register("golden_hammer", () -> new HammerWeapon(Tiers.GOLD, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 5, -3.5f))));
    public static final DeferredItem<HammerWeapon> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () -> new HammerWeapon(Tiers.DIAMOND, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 5, -3.5f))));
    public static final DeferredItem<HammerWeapon> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () -> new HammerWeapon(Tiers.NETHERITE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 5, -3.5f))));


// More Misc (1.1.0)
    public static final DeferredItem<DynamiteWeapon> DYNAMITE = ITEMS.register("dynamite", () -> new DynamiteWeapon(new Item.Properties().stacksTo(16)));
    // Alexs Caves
    public static final DeferredItem<UraniumClubWeapon> URANIUM_STUDDED_CLUB = ITEMS.register("uranium_studded_club", () -> new UraniumClubWeapon(Tiers.DIAMOND, new Item.Properties().attributes(UraniumClubWeapon.createAttributes(Tiers.DIAMOND, 4, -3.5F))));


// Upcoming Pirate Update
    public static final DeferredItem<Item> COAST_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("coast_upgrade_smithing_template", SWSmithingTemplateItem::createCoastUpgradeTemplate);

    public static final DeferredItem<CutlassWeapon> WOODEN_CUTLASS = ITEMS.register("wooden_cutlass", () -> new CutlassWeapon(Tiers.WOOD, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.WOOD, 2, -2F)), 4f));
    public static final DeferredItem<CutlassWeapon> STONE_CUTLASS = ITEMS.register("stone_cutlass", () -> new CutlassWeapon(Tiers.STONE, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.STONE, 2, -2F)), 4f));
    public static final DeferredItem<CutlassWeapon> GOLDEN_CUTLASS = ITEMS.register("golden_cutlass", () -> new CutlassWeapon(Tiers.GOLD, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.GOLD, 2, -2F)), 4f));
    public static final DeferredItem<CutlassWeapon> IRON_CUTLASS = ITEMS.register("iron_cutlass", () -> new CutlassWeapon(Tiers.IRON, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.IRON, 2, -2F)), 4f));
    public static final DeferredItem<CutlassWeapon> DIAMOND_CUTLASS = ITEMS.register("diamond_cutlass", () -> new CutlassWeapon(Tiers.DIAMOND, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.DIAMOND, 2, -2F)), 4f));
    public static final DeferredItem<CutlassWeapon> NETHERITE_CUTLASS = ITEMS.register("netherite_cutlass", () -> new CutlassWeapon(Tiers.NETHERITE, new Item.Properties().attributes(ClubWeapon.createAttributes(Tiers.NETHERITE, 2, -2F)), 4f));


// Upcoming Jungle Update
    public static final DeferredItem<Item> AZTEC_CLUB = ITEMS.register("aztec_club", () -> new AztecClubWeapon(Tiers.DIAMOND, new Item.Properties().attributes(AztecClubWeapon.createAttributes(Tiers.DIAMOND, 5, -3F))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
