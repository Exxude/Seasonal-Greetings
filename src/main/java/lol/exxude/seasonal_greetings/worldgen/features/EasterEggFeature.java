package lol.exxude.seasonal_greetings.worldgen.features;

import com.mojang.serialization.Codec;
import lol.exxude.seasonal_greetings.SeasonalGreetingsConfig;
import lol.exxude.seasonal_greetings.util.ModTags;
import lol.exxude.seasonal_greetings.worldgen.config.EasterEggConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class EasterEggFeature extends Feature<EasterEggConfiguration> {
    public EasterEggFeature(Codec<EasterEggConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(@NonNull FeaturePlaceContext<EasterEggConfiguration> featurePlaceContext) {
        EasterEggConfiguration config = featurePlaceContext.config();
        WorldGenLevel level = featurePlaceContext.level();
        BlockPos pos = featurePlaceContext.origin();
        BlockState state = config.toPlace().getState(featurePlaceContext.random(), pos);

        if(SeasonalGreetingsConfig.ACTIVATE_EASTER.get()) {
            if (!SeasonalGreetingsConfig.DISABLE_EASTER_WORLD_GENERATION.get()) {
                if (level.getBlockState(pos).isAir()) {
                    if (level.isEmptyBlock(pos.above())) {
                        if (level.getBlockState(pos.below()).is(ModTags.Blocks.EASTER_EGG_SPAWNABLES)) {

                            level.setBlock(pos, state, Block.UPDATE_CLIENTS);
                            return true;

                        } else {
                            return false;
                        }

                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
