package net.projectprimal.simple_weaponry.registries;

import net.projectprimal.simple_weaponry.SimpleWeaponry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SWTags {
    public static class Items {
        public static final TagKey<Item> BLUNT_WEAPON = createTag("enchantable/blunt_weapon");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SimpleWeaponry.MOD_ID, name));
        }
    }
}