package lol.exxude.seasonal_greetings.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import javax.swing.text.html.HTML;
import java.util.Iterator;
import java.util.function.Consumer;

public class TradingMachineRecipeBuilder implements RecipeBuilder {
    private final NonNullList<Object> inputItems;
    private final Boolean inputOneTag;
    private final Boolean inputTwoTag;
    private final ItemLike output;
    private final Integer weight;
    private final Integer outputCount;
    private final RecipeSerializer<? extends TradingMachineRecipe> serializer;

    @javax.annotation.Nullable
    private String group;

    public TradingMachineRecipeBuilder(NonNullList<Object> inputItems, Boolean inputOneTag, Boolean inputTwoTag, ItemLike output, Integer weight, Integer outputCount, RecipeSerializer<? extends TradingMachineRecipe> serializer) {
        this.inputItems = inputItems;
        this.inputOneTag = inputOneTag;
        this.inputTwoTag = inputTwoTag;
        this.output = output;
        this.weight = weight;
        this.outputCount = outputCount;
        this.serializer = serializer;
    }

    public static TradingMachineRecipeBuilder generic(NonNullList<Object> inputItems, Boolean inputOneTag, Boolean inputTwoTag, ItemLike output, Integer weight, Integer outputCount, RecipeSerializer<? extends TradingMachineRecipe> serializer) {
        return new TradingMachineRecipeBuilder(inputItems, inputOneTag, inputTwoTag, output, weight, outputCount, serializer);
    }

    @Override
    public RecipeBuilder unlockedBy(String s, CriterionTriggerInstance criterionTriggerInstance) {
        return null;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.output.asItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation pRecipeId) {
        consumer.accept(new TradingMachineRecipeBuilder.Result(this.inputItems, this.inputOneTag, this.inputTwoTag, this.group == null ? "" : this.group, this.output, this.weight, pRecipeId, this.outputCount, this.serializer));
    }

    static class Result implements FinishedRecipe {
        private final NonNullList<Object> inputItems;
        private final Boolean inputOneTag;
        private final Boolean inputTwoTag;
        private final ItemLike output;
        private final Integer weight;
        private final ResourceLocation id;
        private String group;
        private Integer outputCount;
        private final RecipeSerializer<? extends TradingMachineRecipe> serializer;

        public Result(NonNullList<Object> inputItems, Boolean inputOneTag, Boolean inputTwoTag, String pGroup, ItemLike output, Integer weight, ResourceLocation id, Integer outputCount, RecipeSerializer<? extends TradingMachineRecipe> serializer) {
            this.inputItems = inputItems;
            this.inputOneTag = inputOneTag;
            this.inputTwoTag = inputTwoTag;
            this.group = pGroup;
            this.output = output;
            this.weight = weight;
            this.id = id;
            this.outputCount = outputCount;
            this.serializer = serializer;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }

            JsonArray inJson = new JsonArray();

            if(this.inputOneTag) {
                inJson.add(Ingredient.of((TagKey<Item>) this.inputItems.get(0)).toJson());
            } else {
                inJson.add(Ingredient.of((ItemLike) this.inputItems.get(0)).toJson());
            }
            if(this.inputTwoTag) {
                inJson.add(Ingredient.of((TagKey<Item>) this.inputItems.get(1)).toJson());
            } else {
                inJson.add(Ingredient.of((ItemLike) this.inputItems.get(1)).toJson());
            }

            pJson.add("ingredients", inJson);


            pJson.addProperty("weight", this.weight);


            JsonObject outJson = new JsonObject();
            outJson.addProperty("item", BuiltInRegistries.ITEM.getKey(this.output.asItem()).toString());
            if(this.outputCount > 1) {
                outJson.addProperty("count", this.outputCount);
            }

            pJson.add("output", outJson);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
