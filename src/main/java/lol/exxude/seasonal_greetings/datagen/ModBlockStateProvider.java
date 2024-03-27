package lol.exxude.seasonal_greetings.datagen;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.block.custom.StuffedAnimalBunnyBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final List<RegistryObject<Block>> EASTER_EGG_BLOCKS = List.of(ModBlocks.EASTER_EGG_RED_BLOCK, ModBlocks.EASTER_EGG_BLUE_BLOCK,
            ModBlocks.EASTER_EGG_GREEN_BLOCK, ModBlocks.EASTER_EGG_YELLOW_BLOCK, ModBlocks.EASTER_EGG_ORANGE_BLOCK, ModBlocks.EASTER_EGG_BLACK_BLOCK,
            ModBlocks.EASTER_EGG_PURPLE_BLOCK, ModBlocks.EASTER_EGG_BROWN_BLOCK, ModBlocks.EASTER_EGG_LIME_BLOCK, ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK,
            ModBlocks.EASTER_EGG_CYAN_BLOCK, ModBlocks.EASTER_EGG_WHITE_BLOCK, ModBlocks.EASTER_EGG_PINK_BLOCK, ModBlocks.EASTER_EGG_MAGENTA_BLOCK,
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK, ModBlocks.EASTER_EGG_GRAY_BLOCK, ModBlocks.EASTER_EGG_WILD_BLOCK, ModBlocks.EASTER_EGG_GOLDEN_BLOCK);

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SeasonalGreetings.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(int i = 0; i < EASTER_EGG_BLOCKS.size(); i++) {
            int index = i;
            simpleBlockWithItem(EASTER_EGG_BLOCKS.get(index).get(),
                    new ModelFile.UncheckedModelFile(modLoc("block/" + EASTER_EGG_BLOCKS.get(index).getId().getPath())));
        }

        customBlockWithItem(ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY.get(), ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY);

        horizontalBlock(ModBlocks.EASTER_BASKET.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.EASTER_BASKET.getId().getPath())));

        horizontalBlock(ModBlocks.EASTER_BASKET_WG.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/" + ModBlocks.EASTER_BASKET_WG.getId().getPath())));

        blockFacesWithItem(ModBlocks.TRADING_MACHINE.get(), ModBlocks.TRADING_MACHINE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockFacesWithItem(Block block, RegistryObject<Block> blockRegistryObject) {
        horizontalBlock(block,
                new ResourceLocation(SeasonalGreetings.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + "_front"),
                new ResourceLocation(SeasonalGreetings.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + "_side"),
                new ResourceLocation(SeasonalGreetings.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + "_top"));

        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + blockRegistryObject.getId().getPath())));
    }

    private void customBlockWithItem(Block block, RegistryObject<Block> blockRegistryObject) {
        horizontalBlock(block,
                new ModelFile.UncheckedModelFile(modLoc("block/" + blockRegistryObject.getId().getPath())));

        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + blockRegistryObject.getId().getPath())));
    }
}