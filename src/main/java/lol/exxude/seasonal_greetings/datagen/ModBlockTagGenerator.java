package lol.exxude.seasonal_greetings.datagen;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.item.ModItems;
import lol.exxude.seasonal_greetings.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SeasonalGreetings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.EASTER_EGGS)
                .add(ModBlocks.EASTER_EGG_RED_BLOCK.get(), ModBlocks.EASTER_EGG_BLUE_BLOCK.get(), ModBlocks.EASTER_EGG_GREEN_BLOCK.get(),
                ModBlocks.EASTER_EGG_YELLOW_BLOCK.get(), ModBlocks.EASTER_EGG_ORANGE_BLOCK.get(), ModBlocks.EASTER_EGG_BLACK_BLOCK.get(),
                ModBlocks.EASTER_EGG_PURPLE_BLOCK.get(), ModBlocks.EASTER_EGG_BROWN_BLOCK.get(), ModBlocks.EASTER_EGG_LIME_BLOCK.get(),
                ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK.get(), ModBlocks.EASTER_EGG_CYAN_BLOCK.get(), ModBlocks.EASTER_EGG_WHITE_BLOCK.get(),
                ModBlocks.EASTER_EGG_PINK_BLOCK.get(), ModBlocks.EASTER_EGG_MAGENTA_BLOCK.get(), ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK.get(),
                ModBlocks.EASTER_EGG_GRAY_BLOCK.get(), ModBlocks.EASTER_EGG_WILD_BLOCK.get(), ModBlocks.EASTER_EGG_GOLDEN_BLOCK.get());
    }
}
