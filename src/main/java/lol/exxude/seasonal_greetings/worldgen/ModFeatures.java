package lol.exxude.seasonal_greetings.worldgen;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.worldgen.config.EasterEggConfiguration;
import lol.exxude.seasonal_greetings.worldgen.features.EasterEggFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, SeasonalGreetings.MOD_ID);

    public static final RegistryObject<Feature<EasterEggConfiguration>> TEST_LAKE = FEATURES.register("easter_egg",
            () -> new EasterEggFeature(EasterEggConfiguration.CODEC));

    public static void register(IEventBus eventBus) { FEATURES.register(eventBus); }
}
