/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.projectprimal.simple_weaponry.common;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class WeaponAbilities {
    /**
     * Exposed by axes to allow querying tool behaviours
     */
    public static final ItemAbility AXE_DIG = ItemAbility.get("axe_dig");

    /**
     * Exposed by pickaxes to allow querying tool behaviours
     */
    public static final ItemAbility PICKAXE_DIG = ItemAbility.get("pickaxe_dig");

    /**
     * Exposed by shovels to allow querying tool behaviours
     */
    public static final ItemAbility SHOVEL_DIG = ItemAbility.get("shovel_dig");

    /**
     * Exposed by hoes to allow querying tool behaviours
     */
    public static final ItemAbility HOE_DIG = ItemAbility.get("hoe_dig");

    /**
     * Exposed by swords to allow querying tool behaviours
     */
    public static final ItemAbility SWORD_DIG = ItemAbility.get("sword_dig");

    /**
     * Passed onto {@link IBlockExtension#getToolModifiedState} when an axe wants to strip a log
     */
    public static final ItemAbility AXE_STRIP = ItemAbility.get("axe_strip");

    /**
     * Passed onto {@link IBlockExtension#getToolModifiedState} when an axe wants to scrape oxidization off copper
     */
    public static final ItemAbility AXE_SCRAPE = ItemAbility.get("axe_scrape");

    /**
     * Passed onto {@link IBlockExtension#getToolModifiedState} when an axe wants to remove wax out of copper
     */
    public static final ItemAbility AXE_WAX_OFF = ItemAbility.get("axe_wax_off");

    /**
     * Passed onto {@link IBlockExtension#getToolModifiedState} when a shovel wants to turn dirt into path
     */
    public static final ItemAbility SHOVEL_FLATTEN = ItemAbility.get("shovel_flatten");

    /**
     * Passed onto {@link IBlockExtension#getToolModifiedState} when a shovel wants to douse a campfire
     */
    public static final ItemAbility SHOVEL_DOUSE = ItemAbility.get("shovel_douse");

    /**
     * Used during player attack to figure out if a sweep attack should be performed
     *
     * @see IItemExtension#getSweepHitBox
     */
    public static final ItemAbility SWORD_SWEEP = ItemAbility.get("sword_sweep");

    /**
     * Passed onto {@link IBlockExtension#getToolModifiedState} when a hoe wants to turn dirt into soil
     */
    public static final ItemAbility HOE_TILL = ItemAbility.get("till");

    /**
     * An item ability corresponding to the 'block' action of shields.
     * Items should expose this item ability in order to enable damage blocking when the item is being "used".
     */
    public static final ItemAbility SHIELD_BLOCK = ItemAbility.get("shield_block");

    /**
     * Exposed by trident-like items to allow querying tool behaviours for items that can be thrown like Tridents.
     */
    public static final ItemAbility TRIDENT_THROW = ItemAbility.get("trident_throw");

    // Default actions supported by each tool type
    public static final Set<ItemAbility> DEFAULT_CLUB_ACTIONS = of(SWORD_DIG, SWORD_SWEEP);
    public static final Set<ItemAbility> DEFAULT_SCYTHE_ACTIONS = of(HOE_DIG, HOE_TILL, SWORD_SWEEP);
    public static final Set<ItemAbility> DEFAULT_DAGGER_ACTIONS = of(SWORD_DIG);

    private static Set<ItemAbility> of(ItemAbility... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }
}
