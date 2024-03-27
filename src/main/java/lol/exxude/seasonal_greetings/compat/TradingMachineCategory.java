package lol.exxude.seasonal_greetings.compat;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.recipe.TradingMachineRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class TradingMachineCategory implements IRecipeCategory<TradingMachineRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(SeasonalGreetings.MOD_ID, "trading_machine");
    public static final ResourceLocation TEXTURE = new ResourceLocation(SeasonalGreetings.MOD_ID,
            "textures/screens/trading_machine_gui_jei.png");

    public static final RecipeType<TradingMachineRecipe> TRADING_MACHINE_TYPE =
            new RecipeType<>(UID, TradingMachineRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public TradingMachineCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 96);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TRADING_MACHINE.get()));
    }

    @Override
    public RecipeType<TradingMachineRecipe> getRecipeType() {
        return TRADING_MACHINE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.seasonal_greetings.trading_machine");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, TradingMachineRecipe tradingMachineRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 35, 40).addIngredients(tradingMachineRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 53, 40).addIngredients(tradingMachineRecipe.getIngredients().get(1));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 134, 40).addItemStack(tradingMachineRecipe.getResultItem(null));

    }
}
