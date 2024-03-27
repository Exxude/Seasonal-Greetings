package lol.exxude.seasonal_greetings.worldgen.features;

import com.mojang.serialization.Codec;
import lol.exxude.seasonal_greetings.util.ModTags;
import lol.exxude.seasonal_greetings.worldgen.config.EasterEggConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.checkerframework.checker.nullness.qual.NonNull;

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

        TagKey<Block> easterEggs = ModTags.Blocks.EASTER_EGGS;
        TagKey<Block> dirtTag = BlockTags.DIRT;

        if(level.getBlockState(pos).isAir()) {
            if(state.is(easterEggs)) {
                if(level.isEmptyBlock(pos.above())); {
                    if(!level.getBlockState(pos.below()).is(dirtTag)) {

                        return false;

                    }
                    level.setBlock(pos, state, Block.UPDATE_CLIENTS);
                }
            }

            return true;

        } else {

            return false;
        }
    }
}
