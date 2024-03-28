package lol.exxude.seasonal_greetings.worldgen.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record EasterEggConfiguration(BlockStateProvider toPlace) implements FeatureConfiguration {
    public static final Codec<EasterEggConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("to_place").forGetter(EasterEggConfiguration::toPlace)
    ).apply(instance, EasterEggConfiguration::new));
}
