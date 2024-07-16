package net.crazymonkey68.chimeraville.datagen;

import net.crazymonkey68.chimeraville.Chimeraville;
import net.crazymonkey68.chimeraville.block.ModBlocks;
import net.crazymonkey68.chimeraville.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        cookRecipes(consumer, "minecraft:smelting",
                SimpleCookingSerializer.SMELTING_RECIPE, 250);

        cookRecipes(consumer, "minecraft:campfire_cooking",
                SimpleCookingSerializer.CAMPFIRE_COOKING_RECIPE, 700);

        cookRecipes(consumer, "minecraft:smoking",
                SimpleCookingSerializer.SMOKING_RECIPE, 120);





        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TILE_BLOCK.get(), 4)
                .pattern("RD")
                .pattern("DR")
                .define('R', Items.REDSTONE)
                .define('D', Items.RED_DYE)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_LAYLA.get())
                .pattern("###")
                .pattern("###")
                .pattern(" # ")
                .define('#', ModBlocks.LION_SQUID_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LION_SQUID_BLOCK.get()), has(ModBlocks.LION_SQUID_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SHRINE_OLEG.get())
                .pattern("###")
                .pattern(" # ")
                .pattern("###")
                .define('#', ModBlocks.LION_SQUID_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LION_SQUID_BLOCK.get()), has(ModBlocks.LION_SQUID_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CLAW_DEMIR.get())
                .pattern("  #")
                .pattern(" ##")
                .pattern("###")
                .define('#', ModBlocks.LION_SQUID_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LION_SQUID_BLOCK.get()), has(ModBlocks.LION_SQUID_BLOCK.get()))
                .save(consumer);
    }

    protected static void cookRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String pCookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, int pCookingTime) {
        simpleCookingRecipe(pFinishedRecipeConsumer, pCookingMethod, pCookingSerializer, pCookingTime, ModItems.RAW_LION_MEAT.get(), ModItems.COOKED_LION_MEAT.get(), 0.35F);
    }

    protected static void simpleCookingRecipe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String pCookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, int pCookingTime, ItemLike pIngredient, ItemLike pResult, float pExperience) {
        SimpleCookingRecipeBuilder var10000 = SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{pIngredient}), RecipeCategory.FOOD, pResult, pExperience, pCookingTime, pCookingSerializer).unlockedBy(getHasName(pIngredient), has(pIngredient));
        String var10002 = getItemName(pResult);
        var10000.save(pFinishedRecipeConsumer, var10002 + "_from_" + pCookingMethod);
    }
}
