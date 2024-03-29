package lol.exxude.seasonal_greetings.block;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.custom.EasterBasketBlock;
import lol.exxude.seasonal_greetings.block.custom.EasterEggBlock;
import lol.exxude.seasonal_greetings.block.custom.StuffedAnimalBunnyBlock;
import lol.exxude.seasonal_greetings.block.custom.TradingMachineBlock;
import lol.exxude.seasonal_greetings.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SeasonalGreetings.MOD_ID);
    public static final RegistryObject<Block> EASTER_BASKET = registerBlock("easter_basket",
            () -> new EasterBasketBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).destroyTime(0).noOcclusion()));


    public static final RegistryObject<Block> EASTER_EGG_RED_BLOCK = registerBlock("easter_egg_red_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLUE_BLOCK = registerBlock("easter_egg_blue_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GREEN_BLOCK = registerBlock("easter_egg_green_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_YELLOW_BLOCK = registerBlock("easter_egg_yellow_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_ORANGE_BLOCK = registerBlock("easter_egg_orange_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLACK_BLOCK = registerBlock("easter_egg_black_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PURPLE_BLOCK = registerBlock("easter_egg_purple_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BROWN_BLOCK = registerBlock("easter_egg_brown_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIME_BLOCK = registerBlock("easter_egg_lime_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIGHT_BLUE_BLOCK = registerBlock("easter_egg_light_blue_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_CYAN_BLOCK = registerBlock("easter_egg_cyan_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_WHITE_BLOCK = registerBlock("easter_egg_white_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PINK_BLOCK = registerBlock("easter_egg_pink_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_MAGENTA_BLOCK = registerBlock("easter_egg_magenta_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIGHT_GRAY_BLOCK = registerBlock("easter_egg_light_gray_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GRAY_BLOCK = registerBlock("easter_egg_gray_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_WILD_BLOCK = registerBlock("easter_egg_wild_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GOLDEN_BLOCK = registerBlock("easter_egg_golden_block",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));

    // DOUBLES

    public static final RegistryObject<Block> EASTER_EGG_RED_BLOCK_DUAL = registerBlock("easter_egg_red_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLUE_BLOCK_DUAL = registerBlock("easter_egg_blue_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GREEN_BLOCK_DUAL = registerBlock("easter_egg_green_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_YELLOW_BLOCK_DUAL = registerBlock("easter_egg_yellow_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_ORANGE_BLOCK_DUAL = registerBlock("easter_egg_orange_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLACK_BLOCK_DUAL = registerBlock("easter_egg_black_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PURPLE_BLOCK_DUAL = registerBlock("easter_egg_purple_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BROWN_BLOCK_DUAL = registerBlock("easter_egg_brown_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIME_BLOCK_DUAL = registerBlock("easter_egg_lime_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIGHT_BLUE_BLOCK_DUAL = registerBlock("easter_egg_light_blue_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_CYAN_BLOCK_DUAL = registerBlock("easter_egg_cyan_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_WHITE_BLOCK_DUAL = registerBlock("easter_egg_white_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PINK_BLOCK_DUAL = registerBlock("easter_egg_pink_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_MAGENTA_BLOCK_DUAL = registerBlock("easter_egg_magenta_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIGHT_GRAY_BLOCK_DUAL = registerBlock("easter_egg_light_gray_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GRAY_BLOCK_DUAL = registerBlock("easter_egg_gray_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_WILD_BLOCK_DUAL = registerBlock("easter_egg_wild_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GOLDEN_BLOCK_DUAL = registerBlock("easter_egg_golden_block_dual",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));

    // TRIPLES

    public static final RegistryObject<Block> EASTER_EGG_RED_BLOCK_THRICE = registerBlock("easter_egg_red_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLUE_BLOCK_THRICE = registerBlock("easter_egg_blue_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GREEN_BLOCK_THRICE = registerBlock("easter_egg_green_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_YELLOW_BLOCK_THRICE = registerBlock("easter_egg_yellow_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_ORANGE_BLOCK_THRICE = registerBlock("easter_egg_orange_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLACK_BLOCK_THRICE = registerBlock("easter_egg_black_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PURPLE_BLOCK_THRICE = registerBlock("easter_egg_purple_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BROWN_BLOCK_THRICE = registerBlock("easter_egg_brown_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIME_BLOCK_THRICE = registerBlock("easter_egg_lime_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIGHT_BLUE_BLOCK_THRICE = registerBlock("easter_egg_light_blue_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_CYAN_BLOCK_THRICE = registerBlock("easter_egg_cyan_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_WHITE_BLOCK_THRICE = registerBlock("easter_egg_white_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PINK_BLOCK_THRICE = registerBlock("easter_egg_pink_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_MAGENTA_BLOCK_THRICE = registerBlock("easter_egg_magenta_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_LIGHT_GRAY_BLOCK_THRICE = registerBlock("easter_egg_light_gray_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GRAY_BLOCK_THRICE = registerBlock("easter_egg_gray_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_WILD_BLOCK_THRICE = registerBlock("easter_egg_wild_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_GOLDEN_BLOCK_THRICE = registerBlock("easter_egg_golden_block_thrice",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));

    // UNUSUAL VARIANTS

    public static final RegistryObject<Block> EASTER_BASKET_WG = registerBlock("easter_basket_wg",
            () -> new EasterBasketBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLACK_BLOCK_HELD = registerBlock("easter_egg_black_block_held",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PURPLE_BLOCK_HELD = registerBlock("easter_egg_purple_block_held",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLACK_BLOCK_DUAL_HELD = registerBlock("easter_egg_black_block_dual_held",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PURPLE_BLOCK_DUAL_HELD = registerBlock("easter_egg_purple_block_dual_held",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_BLACK_BLOCK_THRICE_HELD = registerBlock("easter_egg_black_block_thrice_held",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));
    public static final RegistryObject<Block> EASTER_EGG_PURPLE_BLOCK_THRICE_HELD = registerBlock("easter_egg_purple_block_thrice_held",
            () -> new EasterEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG).destroyTime(0).noOcclusion()));


    public static final RegistryObject<Block> TRADING_MACHINE = registerBlock("trading_machine",
            () -> new TradingMachineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).strength(5.0F, 6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> EASTER_STUFFED_ANIMAL_BUNNY = registerBlock("easter_stuffed_animal_bunny",
            () -> new StuffedAnimalBunnyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.25F, 4.2F)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
