package lol.exxude.seasonal_greetings.datagen;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final List<RegistryObject<Block>> EASTER_EGG_BLOCKS = List.of(ModBlocks.EASTER_EGG_RED_BLOCK, ModBlocks.EASTER_EGG_BLUE_BLOCK,
            ModBlocks.EASTER_EGG_GREEN_BLOCK, ModBlocks.EASTER_EGG_YELLOW_BLOCK, ModBlocks.EASTER_EGG_ORANGE_BLOCK, ModBlocks.EASTER_EGG_BROWN_BLOCK,
            ModBlocks.EASTER_EGG_LIME_BLOCK, ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK, ModBlocks.EASTER_EGG_BLACK_BLOCK, ModBlocks.EASTER_EGG_PURPLE_BLOCK,
            ModBlocks.EASTER_EGG_CYAN_BLOCK, ModBlocks.EASTER_EGG_WHITE_BLOCK, ModBlocks.EASTER_EGG_PINK_BLOCK, ModBlocks.EASTER_EGG_MAGENTA_BLOCK,
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK, ModBlocks.EASTER_EGG_GRAY_BLOCK, ModBlocks.EASTER_EGG_WILD_BLOCK, ModBlocks.EASTER_EGG_GOLDEN_BLOCK,

            ModBlocks.EASTER_EGG_RED_BLOCK_DUAL, ModBlocks.EASTER_EGG_BLUE_BLOCK_DUAL,
            ModBlocks.EASTER_EGG_GREEN_BLOCK_DUAL, ModBlocks.EASTER_EGG_YELLOW_BLOCK_DUAL, ModBlocks.EASTER_EGG_ORANGE_BLOCK_DUAL, ModBlocks.EASTER_EGG_BROWN_BLOCK_DUAL,
            ModBlocks.EASTER_EGG_LIME_BLOCK_DUAL, ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_DUAL, ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL, ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL,
            ModBlocks.EASTER_EGG_CYAN_BLOCK_DUAL, ModBlocks.EASTER_EGG_WHITE_BLOCK_DUAL, ModBlocks.EASTER_EGG_PINK_BLOCK_DUAL, ModBlocks.EASTER_EGG_MAGENTA_BLOCK_DUAL,
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_DUAL, ModBlocks.EASTER_EGG_GRAY_BLOCK_DUAL, ModBlocks.EASTER_EGG_WILD_BLOCK_DUAL, ModBlocks.EASTER_EGG_GOLDEN_BLOCK_DUAL,

            ModBlocks.EASTER_EGG_RED_BLOCK_THRICE, ModBlocks.EASTER_EGG_BLUE_BLOCK_THRICE,
            ModBlocks.EASTER_EGG_GREEN_BLOCK_THRICE, ModBlocks.EASTER_EGG_YELLOW_BLOCK_THRICE, ModBlocks.EASTER_EGG_ORANGE_BLOCK_THRICE, ModBlocks.EASTER_EGG_BROWN_BLOCK_THRICE,
            ModBlocks.EASTER_EGG_LIME_BLOCK_THRICE, ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_THRICE, ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE, ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE,
            ModBlocks.EASTER_EGG_CYAN_BLOCK_THRICE, ModBlocks.EASTER_EGG_WHITE_BLOCK_THRICE, ModBlocks.EASTER_EGG_PINK_BLOCK_THRICE, ModBlocks.EASTER_EGG_MAGENTA_BLOCK_THRICE,
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_THRICE, ModBlocks.EASTER_EGG_GRAY_BLOCK_THRICE, ModBlocks.EASTER_EGG_WILD_BLOCK_THRICE, ModBlocks.EASTER_EGG_GOLDEN_BLOCK_THRICE
    );

    private static final List<RegistryObject<Block>> EASTER_STRAW_BLOCKS = List.of(ModBlocks.EASTER_STRAW_BLACK, ModBlocks.EASTER_STRAW_BLUE,
            ModBlocks.EASTER_STRAW_BROWN, ModBlocks.EASTER_STRAW_CYAN, ModBlocks.EASTER_STRAW_GOLDEN, ModBlocks.EASTER_STRAW_GRAY,
            ModBlocks.EASTER_STRAW_GREEN, ModBlocks.EASTER_STRAW_LIGHT_BLUE, ModBlocks.EASTER_STRAW_LIGHT_GRAY, ModBlocks.EASTER_STRAW_LIME,
            ModBlocks.EASTER_STRAW_MAGENTA, ModBlocks.EASTER_STRAW_ORANGE, ModBlocks.EASTER_STRAW_PINK, ModBlocks.EASTER_STRAW_PURPLE,
            ModBlocks.EASTER_STRAW_RED, ModBlocks.EASTER_STRAW_WHITE, ModBlocks.EASTER_STRAW_WILD, ModBlocks.EASTER_STRAW_YELLOW);

    private static final List<RegistryObject<Block>> EASTER_EGG_BLOCKS_HELD = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK_HELD, ModBlocks.EASTER_EGG_PURPLE_BLOCK_HELD, ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL_HELD, ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL_HELD,
            ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE_HELD, ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE_HELD);

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SeasonalGreetings.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(int i = 0; i < EASTER_EGG_BLOCKS_HELD.size(); i++) {
            customBlockWithItem(EASTER_EGG_BLOCKS_HELD.get(i).get(), EASTER_EGG_BLOCKS_HELD.get(i), "enderman_held/");
        }

        for(int i = 0; i < EASTER_EGG_BLOCKS.size(); i++) {
            customBlockWithItem(EASTER_EGG_BLOCKS.get(i).get(), EASTER_EGG_BLOCKS.get(i), "");
        }

        for(int i = 0; i < EASTER_STRAW_BLOCKS.size(); i++) {
            customBlockWithItem(EASTER_STRAW_BLOCKS.get(i).get(), EASTER_STRAW_BLOCKS.get(i), "");
        }

        customBlockWithItem(ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY.get(), ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY, "");


        customBlockWithItem(ModBlocks.EASTER_BASKET.get(), ModBlocks.EASTER_BASKET, "");
        customBlockWithItem(ModBlocks.EASTER_BASKET_WG.get(), ModBlocks.EASTER_BASKET, "");

        customBlockWithItem(ModBlocks.EASTER_BASKET_MEDIUM.get(), ModBlocks.EASTER_BASKET_MEDIUM, "");
        customBlockWithItem(ModBlocks.EASTER_BASKET_MEDIUM_WG.get(), ModBlocks.EASTER_BASKET_MEDIUM, "");

        customBlockWithItem(ModBlocks.EASTER_BASKET_LARGE.get(), ModBlocks.EASTER_BASKET_LARGE, "");
        customBlockWithItem(ModBlocks.EASTER_BASKET_LARGE_WG.get(), ModBlocks.EASTER_BASKET_LARGE, "");

        customBlockWithItem(ModBlocks.EASTER_ISLAND_HEAD.get(), ModBlocks.EASTER_ISLAND_HEAD, "");
        customBlockWithItem(ModBlocks.EASTER_ISLAND_HEAD_TOP.get(), ModBlocks.EASTER_ISLAND_HEAD_TOP, "");
        customBlockWithItem(ModBlocks.EASTER_ISLAND_HEAD_BOTTOM.get(), ModBlocks.EASTER_ISLAND_HEAD_BOTTOM, "");

        simpleBlockItem(ModBlocks.EASTER_ISLAND_GRASS_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.EASTER_ISLAND_GRASS_BLOCK.getId().getPath())));
        simpleBlockItem(ModBlocks.EASTER_ISLAND_GRASS_BLOCK_FULL.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.EASTER_ISLAND_GRASS_BLOCK_FULL.getId().getPath())));
        simpleBlockItem(ModBlocks.EASTER_ISLAND_GRASS.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.EASTER_ISLAND_GRASS.getId().getPath())));

        simpleBlockItem(ModBlocks.EASTER_BUNNY_NEST.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.EASTER_BUNNY_NEST.getId().getPath())));
        simpleBlockItem(ModBlocks.EASTER_BUNNY_NEST_WG.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.EASTER_BUNNY_NEST.getId().getPath())));


        simpleBlockItem(ModBlocks.TRADING_MACHINE.get(), new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.TRADING_MACHINE.getId().getPath())));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockFacesWithItem(Block block, RegistryObject<Block> blockRegistryObject, String front, String side, String top) {
        horizontalBlock(block,
                new ResourceLocation(SeasonalGreetings.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + front),
                new ResourceLocation(SeasonalGreetings.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + side),
                new ResourceLocation(SeasonalGreetings.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + top));

        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + blockRegistryObject.getId().getPath())));
    }

    private void customBlockWithItem(Block block, RegistryObject<Block> blockRegistryObject, String folderStructure) {
        horizontalBlock(block,
                new ModelFile.UncheckedModelFile(modLoc("block/" + folderStructure + blockRegistryObject.getId().getPath())));

        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + folderStructure + blockRegistryObject.getId().getPath())));
    }
}
