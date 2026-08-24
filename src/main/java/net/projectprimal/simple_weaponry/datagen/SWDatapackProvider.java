package net.projectprimal.simple_weaponry.datagen;

import net.projectprimal.simple_weaponry.SimpleWeaponry;
import net.projectprimal.simple_weaponry.registries.Item.SWEnchants;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SWDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, SWEnchants::bootstrap);
    public SWDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SimpleWeaponry.MOD_ID));
    }
}