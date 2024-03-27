package lol.exxude.seasonal_greetings.compat;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.recipe.TradingMachineRecipe;
import lol.exxude.seasonal_greetings.screen.TradingMachineScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JeiSeasonalGreetingsPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(SeasonalGreetings.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TradingMachineCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<TradingMachineRecipe> tradingRecipes = recipeManager.getAllRecipesFor(TradingMachineRecipe.Type.INSTANCE);
        registration.addRecipes(TradingMachineCategory.TRADING_MACHINE_TYPE, tradingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(TradingMachineScreen.class, 88, 42, 22, 11,
                TradingMachineCategory.TRADING_MACHINE_TYPE);
    }
}
