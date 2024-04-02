package lol.exxude.seasonal_greetings.compat.jer;

import jeresources.api.*;
import org.jetbrains.annotations.NotNull;

public class DungeonIntegration implements JerSeasonalGreetingsInterface {
    @Deprecated
    @Override
    public void registerMob(IMobRegistry registry) {}

    @Deprecated
    @Override
    public void registerPlant(IPlantRegistry registry) {}

    @Deprecated
    @Override
    public void registerDungeon(IDungeonRegistry registry) {}

    @Deprecated
    @Override
    public void registerWorldGen(IWorldGenRegistry registry) {}

    @Override
    public void register(@NotNull IJERAPI jerApi) throws NoSuchFieldException, NoSuchMethodException {
        registerDungeon(jerApi.getDungeonRegistry());
    }
}
