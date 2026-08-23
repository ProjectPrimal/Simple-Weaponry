package net.projectprimal.simple_weaponry.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.projectprimal.simple_weaponry.SimpleWeaponry;
import net.projectprimal.simple_weaponry.registries.SWItems;

public class SWItemModelProvider extends ItemModelProvider {
    public SWItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SimpleWeaponry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // Release
        handheldItem(SWItems.WOODEN_CLUB.get());
        handheldItem(SWItems.IRON_STUDDED_CLUB.get());
        handheldItem(SWItems.GOLD_STUDDED_CLUB.get());

        handheldItem(SWItems.WOODEN_DAGGER.get());
        handheldItem(SWItems.STONE_DAGGER.get());
        handheldItem(SWItems.IRON_DAGGER.get());
        handheldItem(SWItems.GOLDEN_DAGGER.get());
        handheldItem(SWItems.DIAMOND_DAGGER.get());
        handheldItem(SWItems.NETHERITE_DAGGER.get());

        handheldItem(SWItems.WOODEN_HAMMER.get());
        handheldItem(SWItems.STONE_HAMMER.get());
        handheldItem(SWItems.IRON_HAMMER.get());
        handheldItem(SWItems.GOLDEN_HAMMER.get());
        handheldItem(SWItems.DIAMOND_HAMMER.get());
        handheldItem(SWItems.NETHERITE_HAMMER.get());


        // Upcoming Pirate Update
        handheldItem(SWItems.COAST_UPGRADE_SMITHING_TEMPLATE.get());

        handheldItem(SWItems.WOODEN_CUTLASS.get());
        handheldItem(SWItems.STONE_CUTLASS.get());
        handheldItem(SWItems.IRON_CUTLASS.get());
        handheldItem(SWItems.GOLDEN_CUTLASS.get());
        handheldItem(SWItems.DIAMOND_CUTLASS.get());
        handheldItem(SWItems.NETHERITE_CUTLASS.get());

        handheldItem(SWItems.DYNAMITE.get());


        // Upcoming Jungle Update
        handheldItem(SWItems.AZTEC_CLUB.get());
    }
}
