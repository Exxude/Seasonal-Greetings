package lol.exxude.seasonal_greetings.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lol.exxude.seasonal_greetings.SeasonalGreetings;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TradingMachineRecipe  implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final Integer weight;
    private final ResourceLocation id;;

    public TradingMachineRecipe(NonNullList<Ingredient> inputItems, ItemStack output, Integer weight, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.weight = weight;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if(level.isClientSide()) {
            return false;
        }
        return inputItems.get(0).test(simpleContainer.getItem(0)) && inputItems.get(1).test(simpleContainer.getItem(1));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<TradingMachineRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "trading_machine";
    }

    public static class Serializer implements RecipeSerializer<TradingMachineRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(SeasonalGreetings.MOD_ID, "trading_machine");

        @Override
        public TradingMachineRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            Integer weight = GsonHelper.getAsInt(jsonObject, "weight");

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");


            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new TradingMachineRecipe(inputs, output, weight, resourceLocation);
        }

        @Override
        public @Nullable TradingMachineRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);
            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(friendlyByteBuf));
            }

            Integer weight = friendlyByteBuf.readVarInt();

            ItemStack output = friendlyByteBuf.readItem();
            return new TradingMachineRecipe(inputs, output, weight, resourceLocation);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, TradingMachineRecipe tradingMachineRecipe) {
            friendlyByteBuf.writeInt(tradingMachineRecipe.inputItems.size());

            for(Ingredient ingredient : tradingMachineRecipe.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }

            friendlyByteBuf.writeVarInt(tradingMachineRecipe.weight);

            friendlyByteBuf.writeItemStack(tradingMachineRecipe.getResultItem(null), false);
        }
    }
}