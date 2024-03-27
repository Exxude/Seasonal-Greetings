package lol.exxude.seasonal_greetings.datagen;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SeasonalGreetings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.EASTER_EGG_RED);
        simpleItem(ModItems.EASTER_EGG_BLUE);
        simpleItem(ModItems.EASTER_EGG_GREEN);
        simpleItem(ModItems.EASTER_EGG_YELLOW);
        simpleItem(ModItems.EASTER_EGG_ORANGE);
        simpleItem(ModItems.EASTER_EGG_BLACK);
        simpleItem(ModItems.EASTER_EGG_PURPLE);
        simpleItem(ModItems.EASTER_EGG_BROWN);
        simpleItem(ModItems.EASTER_EGG_LIME);
        simpleItem(ModItems.EASTER_EGG_LIGHT_BLUE);
        simpleItem(ModItems.EASTER_EGG_CYAN);
        simpleItem(ModItems.EASTER_EGG_WHITE);
        simpleItem(ModItems.EASTER_EGG_PINK);
        simpleItem(ModItems.EASTER_EGG_MAGENTA);
        simpleItem(ModItems.EASTER_EGG_LIGHT_GRAY);
        simpleItem(ModItems.EASTER_EGG_GRAY);
        simpleItem(ModItems.EASTER_EGG_WILD);
        simpleItem(ModItems.EASTER_EGG_GOLDEN);

        simpleItem(ModItems.EASTER_COTTON_CANDY_RED);
        simpleItem(ModItems.EASTER_COTTON_CANDY_BLUE);
        simpleItem(ModItems.EASTER_COTTON_CANDY_GREEN);
        simpleItem(ModItems.EASTER_COTTON_CANDY_YELLOW);
        simpleItem(ModItems.EASTER_COTTON_CANDY_ORANGE);
        simpleItem(ModItems.EASTER_COTTON_CANDY_BLACK);
        simpleItem(ModItems.EASTER_COTTON_CANDY_PURPLE);
        simpleItem(ModItems.EASTER_COTTON_CANDY_BROWN);
        simpleItem(ModItems.EASTER_COTTON_CANDY_LIME);
        simpleItem(ModItems.EASTER_COTTON_CANDY_LIGHT_BLUE);
        simpleItem(ModItems.EASTER_COTTON_CANDY_CYAN);
        simpleItem(ModItems.EASTER_COTTON_CANDY_WHITE);
        simpleItem(ModItems.EASTER_COTTON_CANDY_PINK);
        simpleItem(ModItems.EASTER_COTTON_CANDY_MAGENTA);
        simpleItem(ModItems.EASTER_COTTON_CANDY_LIGHT_GRAY);
        simpleItem(ModItems.EASTER_COTTON_CANDY_GRAY);
        simpleItem(ModItems.EASTER_COTTON_CANDY_GOLDEN);

        simpleItem(ModItems.EASTER_CHOCOLATE_BUNNY);
        simpleItem(ModItems.EASTER_CHOCOLATE_EGG);

        simpleItem(ModItems.EASTER_CARROT_SWORD);
        simpleItem(ModItems.TRADING_MACHINE_TEMPLATE);

        simpleBlockItem(ModBlocks.EASTER_BASKET);

        simpleBlockItemDummy(ModBlocks.EASTER_BASKET_WG, ModBlocks.EASTER_BASKET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SeasonalGreetings.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SeasonalGreetings.MOD_ID, "item/" + block.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemDummy(RegistryObject<Block> block, RegistryObject<Block> realBlock) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SeasonalGreetings.MOD_ID, "item/" + realBlock.getId().getPath()));
    }

    private ItemModelBuilder simpleItemRefrenceFromBlock(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("block/" + block.getId().getPath()));
    }
}
