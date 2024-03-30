package lol.exxude.seasonal_greetings.worldgen.biome;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(SeasonalGreetings.MOD_ID, "overworld"), 5));
    }
}
