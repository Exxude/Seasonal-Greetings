package lol.exxude.seasonal_greetings.datagen;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.item.ModItems;
import lol.exxude.seasonal_greetings.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SeasonalGreetings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.EASTER_EGGS)
                .add(ModItems.EASTER_EGG_RED.get(), ModItems.EASTER_EGG_BLUE.get(), ModItems.EASTER_EGG_GREEN.get(),
                    ModItems.EASTER_EGG_YELLOW.get(), ModItems.EASTER_EGG_ORANGE.get(), ModItems.EASTER_EGG_BLACK.get(),
                    ModItems.EASTER_EGG_PURPLE.get(), ModItems.EASTER_EGG_BROWN.get(), ModItems.EASTER_EGG_LIME.get(),
                    ModItems.EASTER_EGG_LIGHT_BLUE.get(), ModItems.EASTER_EGG_CYAN.get(), ModItems.EASTER_EGG_WHITE.get(),
                    ModItems.EASTER_EGG_PINK.get(), ModItems.EASTER_EGG_MAGENTA.get(), ModItems.EASTER_EGG_LIGHT_GRAY.get(),
                    ModItems.EASTER_EGG_GRAY.get());

        this.tag(ModTags.Items.EASTER_EGGS_SPECIAL)
                .add(ModItems.EASTER_EGG_WILD.get(), ModItems.EASTER_EGG_GOLDEN.get());

        this.tag(ModTags.Items.SWEETS)
                .add(ModItems.EASTER_COTTON_CANDY_RED.get(), ModItems.EASTER_COTTON_CANDY_BLUE.get(), ModItems.EASTER_COTTON_CANDY_GREEN.get(),
                        ModItems.EASTER_COTTON_CANDY_YELLOW.get(), ModItems.EASTER_COTTON_CANDY_ORANGE.get(), ModItems.EASTER_COTTON_CANDY_BLACK.get(),
                        ModItems.EASTER_COTTON_CANDY_PURPLE.get(), ModItems.EASTER_COTTON_CANDY_BROWN.get(), ModItems.EASTER_COTTON_CANDY_LIME.get(),
                        ModItems.EASTER_COTTON_CANDY_LIGHT_BLUE.get(), ModItems.EASTER_COTTON_CANDY_CYAN.get(), ModItems.EASTER_COTTON_CANDY_WHITE.get(),
                        ModItems.EASTER_COTTON_CANDY_PINK.get(), ModItems.EASTER_COTTON_CANDY_MAGENTA.get(), ModItems.EASTER_COTTON_CANDY_LIGHT_GRAY.get(),
                        ModItems.EASTER_COTTON_CANDY_GRAY.get(), ModItems.EASTER_COTTON_CANDY_GOLDEN.get());

        this.tag(ModTags.Items.TRADABLE_ITEMS)
                .addTag(ModTags.Items.EASTER_EGGS).add(ModItems.EASTER_EGG_GOLDEN.get());

        this.tag(ModTags.Items.TRADABLE_CATALYSTS)
                .add(ModItems.EASTER_EGG_WILD.get()).add(ModItems.EASTER_EGG_GOLDEN.get());
    };
}
