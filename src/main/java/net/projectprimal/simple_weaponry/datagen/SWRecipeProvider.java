package net.projectprimal.simple_weaponry.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.projectprimal.simple_weaponry.registries.SWItems;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SWRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public SWRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Clubs
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.WOODEN_CLUB.get())
                .pattern(" T")
                .pattern("S ")
                .define('S', Items.STICK)
                .define('T', ItemTags.LOGS)
                .unlockedBy("has_log", has(ItemTags.LOGS)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.IRON_STUDDED_CLUB.get())
                .pattern("NNN")
                .pattern("NCN")
                .pattern("NNN")
                .define('C', SWItems.WOODEN_CLUB.get())
                .define('N', Items.IRON_NUGGET)
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.GOLD_STUDDED_CLUB.get())
                .pattern("NNN")
                .pattern("NCN")
                .pattern("NNN")
                .define('C', SWItems.WOODEN_CLUB.get())
                .define('N', Items.GOLD_NUGGET)
                .unlockedBy("has_gold_nugget", has(Items.GOLD_NUGGET)).save(recipeOutput);
        // Daggers
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.WOODEN_DAGGER.get())
                .pattern("T")
                .pattern("S")
                .define('S', Items.STICK)
                .define('T', ItemTags.PLANKS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.STONE_DAGGER.get())
                .pattern("T")
                .pattern("S")
                .define('S', Items.STICK)
                .define('T', ItemTags.STONE_TOOL_MATERIALS)
                .unlockedBy("has_stone", has(ItemTags.STONE_TOOL_MATERIALS)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.IRON_DAGGER.get())
                .pattern("T")
                .pattern("S")
                .define('S', Items.STICK)
                .define('T', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.GOLDEN_DAGGER.get())
                .pattern("T")
                .pattern("S")
                .define('S', Items.STICK)
                .define('T', Items.GOLD_INGOT)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWItems.DIAMOND_DAGGER.get())
                .pattern("T")
                .pattern("S")
                .define('S', Items.STICK)
                .define('T', Items.DIAMOND)
                .unlockedBy("has_diamond", has(Items.DIAMOND)).save(recipeOutput);

    }
}