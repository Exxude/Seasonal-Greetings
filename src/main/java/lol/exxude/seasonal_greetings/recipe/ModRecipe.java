package lol.exxude.seasonal_greetings.recipe;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipe {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SeasonalGreetings.MOD_ID);

    public static final RegistryObject<RecipeSerializer<TradingMachineRecipe>> TRADING_MACHINE_SERIALIZER =
            SERIALIZERS.register("trading_machine", () -> TradingMachineRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

}
