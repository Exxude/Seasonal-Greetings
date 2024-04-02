package lol.exxude.seasonal_greetings.compat.jer;

import jeresources.api.IDungeonRegistry;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class SeasonalGreetingsDungeonRegistry extends DungeonIntegration {
    @Override
    public void registerDungeon(@NotNull IDungeonRegistry registry) {
        registry.registerChest("Easter Basket", ModBlocks.EASTER_BASKET_WG.get().getLootTable());
        registry.registerChest("Easter Basket Medium", ModBlocks.EASTER_BASKET_MEDIUM_WG.get().getLootTable());
        registry.registerChest("Easter Basket Large", ModBlocks.EASTER_BASKET_LARGE_WG.get().getLootTable());
    }
}
