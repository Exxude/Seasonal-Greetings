package lol.exxude.seasonal_greetings.datagen;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.item.ModItems;
import lol.exxude.seasonal_greetings.recipe.ModRecipe;
import lol.exxude.seasonal_greetings.recipe.TradingMachineRecipe;
import lol.exxude.seasonal_greetings.recipe.TradingMachineRecipeBuilder;
import lol.exxude.seasonal_greetings.util.ModTags;
import net.minecraft.core.NonNullList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> EASTER_EGGS = List.of(ModItems.EASTER_EGG_RED.get(), ModItems.EASTER_EGG_BLUE.get(),
            ModItems.EASTER_EGG_GREEN.get(), ModItems.EASTER_EGG_YELLOW.get(), ModItems.EASTER_EGG_ORANGE.get(), ModItems.EASTER_EGG_BLACK.get(),
            ModItems.EASTER_EGG_PURPLE.get(), ModItems.EASTER_EGG_BROWN.get(), ModItems.EASTER_EGG_LIME.get(), ModItems.EASTER_EGG_LIGHT_BLUE.get(),
            ModItems.EASTER_EGG_CYAN.get(), ModItems.EASTER_EGG_WHITE.get(), ModItems.EASTER_EGG_PINK.get(), ModItems.EASTER_EGG_MAGENTA.get(),
            ModItems.EASTER_EGG_LIGHT_GRAY.get(), ModItems.EASTER_EGG_GRAY.get());

    private static final List<ItemLike> EASTER_COTTON_CANDYS = List.of(ModItems.EASTER_COTTON_CANDY_RED.get(), ModItems.EASTER_COTTON_CANDY_BLUE.get(),
            ModItems.EASTER_COTTON_CANDY_GREEN.get(), ModItems.EASTER_COTTON_CANDY_YELLOW.get(), ModItems.EASTER_COTTON_CANDY_ORANGE.get(), ModItems.EASTER_COTTON_CANDY_BLACK.get(),
            ModItems.EASTER_COTTON_CANDY_PURPLE.get(), ModItems.EASTER_COTTON_CANDY_BROWN.get(), ModItems.EASTER_COTTON_CANDY_LIME.get(), ModItems.EASTER_COTTON_CANDY_LIGHT_BLUE.get(),
            ModItems.EASTER_COTTON_CANDY_CYAN.get(), ModItems.EASTER_COTTON_CANDY_WHITE.get(), ModItems.EASTER_COTTON_CANDY_PINK.get(), ModItems.EASTER_COTTON_CANDY_MAGENTA.get(),
            ModItems.EASTER_COTTON_CANDY_LIGHT_GRAY.get(), ModItems.EASTER_COTTON_CANDY_GRAY.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EASTER_EGG_WILD.get())
                .requires(ModTags.Items.EASTER_EGGS).requires(ModTags.Items.EASTER_EGGS).requires(ModTags.Items.EASTER_EGGS)
                .requires(ModTags.Items.EASTER_EGGS).requires(ModTags.Items.EASTER_EGGS)
                .unlockedBy(getHasName(ModItems.EASTER_EGG_WILD.get()), has(ModTags.Items.EASTER_EGGS))
                .save(consumer, "any_to_" + getItemName(ModItems.EASTER_EGG_WILD.get()));

        for(int i = 0; i < EASTER_EGGS.size(); i++) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EASTER_EGGS.get(i), 3)
                    .requires(EASTER_EGGS.get(i)).requires(ModBlocks.EASTER_EGG_WILD_BLOCK.get())
                    .unlockedBy(getHasName(EASTER_EGGS.get(i)), has(EASTER_EGGS.get(i)))
                    .save(consumer, "wild_triple_" + getItemName(EASTER_EGGS.get(i)));
        }

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EASTER_EGG_WILD.get(), 9)
                .requires(ModItems.EASTER_EGG_GOLDEN.get())
                .unlockedBy(getHasName(ModItems.EASTER_EGG_GOLDEN.get()), has(ModItems.EASTER_EGG_GOLDEN.get()))
                .save(consumer, "golden_to_" + getItemName(ModItems.EASTER_EGG_WILD.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EASTER_EGG_GOLDEN.get())
                .requires(ModItems.EASTER_EGG_WILD.get(), 9)
                .unlockedBy(getHasName(ModItems.EASTER_EGG_WILD.get()), has(ModItems.EASTER_EGG_WILD.get()))
                .save(consumer, "wild_to_" + getItemName(ModItems.EASTER_EGG_GOLDEN.get()));

        copySmithingTemplate(consumer, ModItems.TRADING_MACHINE_TEMPLATE.get(), Items.IRON_BLOCK);

        smithing(consumer, ModItems.TRADING_MACHINE_TEMPLATE.get(), Items.IRON_BLOCK, Items.EMERALD, RecipeCategory.MISC, ModBlocks.TRADING_MACHINE.get().asItem());

        for(int i = 0; i < EASTER_EGGS.size(); i++) {
            itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                    NonNullList.of(null, EASTER_EGGS.get(i).asItem(), ModItems.EASTER_EGG_WILD.get().asItem()),
                    false, false, EASTER_COTTON_CANDYS.get(i).asItem(), 50, 6, "wild_");
        }

        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModTags.Items.EASTER_EGGS, ModItems.EASTER_EGG_WILD.get().asItem()),
                true, false, ModItems.EASTER_CHOCOLATE_EGG.get(), 50, 4, "wild_");
        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModTags.Items.EASTER_EGGS, ModItems.EASTER_EGG_WILD.get().asItem()),
                true, false, ModItems.EASTER_CHOCOLATE_BUNNY.get(), 50, 4, "wild_");
        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModTags.Items.EASTER_EGGS, ModItems.EASTER_EGG_WILD.get().asItem()),
                true, false, ModItems.EASTER_EGG_GOLDEN.get(), 1, 1, "wild_");

        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModItems.EASTER_EGG_WILD.get().asItem(), ModItems.EASTER_EGG_GOLDEN.get().asItem()),
                false, false, ModItems.EASTER_CARROT_SWORD.get(), 10, 1, "golden_");
        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModItems.EASTER_EGG_WILD.get().asItem(), ModItems.EASTER_EGG_GOLDEN.get().asItem()),
                false, false, ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY.get().asItem(), 10, 1, "golden_");
        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModItems.EASTER_EGG_WILD.get().asItem(), ModItems.EASTER_EGG_GOLDEN.get().asItem()),
                false, false, ModItems.EASTER_CHOCOLATE_EGG.get(), 10, 32, "golden_");
        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModItems.EASTER_EGG_WILD.get().asItem(), ModItems.EASTER_EGG_GOLDEN.get().asItem()),
                false, false, ModItems.EASTER_CHOCOLATE_BUNNY.get(), 10, 32, "golden_");
        itemTrading(consumer, ModRecipe.TRADING_MACHINE_SERIALIZER.get(),
                NonNullList.of(null, ModItems.EASTER_EGG_WILD.get().asItem(), ModItems.EASTER_EGG_GOLDEN.get().asItem()),
                false, false, ModItems.EASTER_COTTON_CANDY_GOLDEN.get(), 10, 6, "golden_");

    }

    protected static void smithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pIngredientItem, Item pTemplateItem, Item pUpgradeItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{pTemplateItem}), Ingredient.of(new ItemLike[]{pIngredientItem}), Ingredient.of(new ItemLike[]{pUpgradeItem}), pCategory, pResultItem).unlocks("has_" + getItemName(pUpgradeItem), has((ItemLike)pUpgradeItem)).save(pFinishedRecipeConsumer, getItemName(pResultItem) + "_smithing");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SeasonalGreetings.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    protected static void itemTrading(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends TradingMachineRecipe> pTradingSerializer, NonNullList<Object> inputItems, Boolean inputOneTag, Boolean inputTwoTag, ItemLike output, Integer weight, Integer outputCount, String additionalFileText) {
        TradingMachineRecipeBuilder.generic(inputItems, inputOneTag, inputTwoTag, output, weight, outputCount, pTradingSerializer)
                .save(pFinishedRecipeConsumer, SeasonalGreetings.MOD_ID + ":" + additionalFileText + getItemName(output) + "_trading_machine");
    }
}
