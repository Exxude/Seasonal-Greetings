package lol.exxude.seasonal_greetings.worldgen.features;

import com.mojang.serialization.Codec;
import lol.exxude.seasonal_greetings.SeasonalGreetingsConfig;
import lol.exxude.seasonal_greetings.block.ModBlocks;
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
import java.util.Random;

public class EasterEggFeature extends Feature<EasterEggConfiguration> {
    public EasterEggFeature(Codec<EasterEggConfiguration> pCodec) {
        super(pCodec);
    }

    private static final List<Block> EASTER_BLOCKS_SINGLE = List.of(ModBlocks.EASTER_EGG_RED_BLOCK.get().defaultBlockState().getBlock().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_BLUE_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_GREEN_BLOCK.get().defaultBlockState().getBlock(),
            ModBlocks.EASTER_EGG_YELLOW_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_ORANGE_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_BLACK_BLOCK.get().defaultBlockState().getBlock(),
            ModBlocks.EASTER_EGG_PURPLE_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_BROWN_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_LIME_BLOCK.get().defaultBlockState().getBlock(),
            ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_CYAN_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_WHITE_BLOCK.get().defaultBlockState().getBlock(),
            ModBlocks.EASTER_EGG_PINK_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_MAGENTA_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK.get().defaultBlockState().getBlock(),
            ModBlocks.EASTER_EGG_GRAY_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_WILD_BLOCK.get().defaultBlockState().getBlock(), ModBlocks.EASTER_EGG_GOLDEN_BLOCK.get().defaultBlockState().getBlock(),
            ModBlocks.EASTER_BASKET_WG.get().defaultBlockState().getBlock());

    private static final List<Block> EASTER_BLOCKS_DUAL = List.of(ModBlocks.EASTER_EGG_RED_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_BLUE_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_GREEN_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_YELLOW_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_ORANGE_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_BROWN_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_LIME_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_CYAN_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_WHITE_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_PINK_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_MAGENTA_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_GRAY_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_WILD_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_GOLDEN_BLOCK_DUAL.get(), ModBlocks.EASTER_BASKET_MEDIUM_WG.get());

    private static final List<Block> EASTER_BLOCKS_THRICE = List.of(ModBlocks.EASTER_EGG_RED_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_BLUE_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_GREEN_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_YELLOW_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_ORANGE_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_BROWN_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_LIME_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_CYAN_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_WHITE_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_PINK_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_MAGENTA_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_GRAY_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_WILD_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_GOLDEN_BLOCK_THRICE.get(), ModBlocks.EASTER_BASKET_LARGE_WG.get());

    @Override
    public boolean place(@NonNull FeaturePlaceContext<EasterEggConfiguration> featurePlaceContext) {
        EasterEggConfiguration config = featurePlaceContext.config();
        WorldGenLevel level = featurePlaceContext.level();
        BlockPos pos = featurePlaceContext.origin();

        if(SeasonalGreetingsConfig.ACTIVATE_EASTER.get()) {
            if (!SeasonalGreetingsConfig.DISABLE_EASTER_WORLD_GENERATION.get()) {
                if (level.getBlockState(pos).isAir()) {
                    if (level.isEmptyBlock(pos.above())) {
                        if (level.getBlockState(pos.below()).is(ModTags.Blocks.EASTER_EGG_SPAWNABLES)) {
                            Double dbl = Math.random();
                            Float chance = dbl.floatValue();
                            if(chance > 0.5f) {
                                BlockState state = config.toPlace().getState(featurePlaceContext.random(), pos);
                                level.setBlock(pos, state, Block.UPDATE_CLIENTS);
                            } else if(chance > 0.15f) {
                                Integer index = EASTER_BLOCKS_SINGLE.indexOf(config.toPlace().getState(featurePlaceContext.random(), pos).getBlock());
                                BlockState state = EASTER_BLOCKS_DUAL.get(index).defaultBlockState();
                                level.setBlock(pos, state, Block.UPDATE_CLIENTS);
                            } else {
                                Integer index = EASTER_BLOCKS_SINGLE.indexOf(config.toPlace().getState(featurePlaceContext.random(), pos).getBlock());
                                BlockState state = EASTER_BLOCKS_THRICE.get(index).defaultBlockState();
                                level.setBlock(pos, state, Block.UPDATE_CLIENTS);
                            }
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
