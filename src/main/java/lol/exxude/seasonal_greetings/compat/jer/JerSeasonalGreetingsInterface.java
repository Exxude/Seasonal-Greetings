package lol.exxude.seasonal_greetings.compat.jer;

import jeresources.api.*;
import org.jetbrains.annotations.NotNull;

public interface JerSeasonalGreetingsInterface {
    void registerMob(IMobRegistry registry) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError;

    void registerWorldGen(IWorldGenRegistry registry) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError;

    void registerPlant(IPlantRegistry registry) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError;

    void registerDungeon(IDungeonRegistry registry) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError;

    default void register(@NotNull IJERAPI jerApi) throws IllegalStateException, NoSuchFieldException, NoSuchMethodException, NoClassDefFoundError {
        registerMob(jerApi.getMobRegistry());
        registerWorldGen(jerApi.getWorldGenRegistry());
        registerPlant(jerApi.getPlantRegistry());
        registerDungeon(jerApi.getDungeonRegistry());
    }
}
