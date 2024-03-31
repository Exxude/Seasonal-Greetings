package lol.exxude.seasonal_greetings.item;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SeasonalGreetings.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EASTER_TAB = CREATIVE_MODE_TABS.register("easter_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EASTER_EGG_RED.get()))
                    .title(Component.translatable("creativetab.easter_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.TRADING_MACHINE.get());
                        pOutput.accept(ModItems.TRADING_MACHINE_TEMPLATE.get());

                        pOutput.accept(ModBlocks.EASTER_ISLAND_GRASS_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_ISLAND_GRASS_BLOCK_FULL.get());
//                        pOutput.accept(ModBlocks.EASTER_ISLAND_GRASS.get());

                        pOutput.accept(ModItems.EASTER_EGG_RED.get());
                        pOutput.accept(ModItems.EASTER_EGG_BLUE.get());
                        pOutput.accept(ModItems.EASTER_EGG_GREEN.get());
                        pOutput.accept(ModItems.EASTER_EGG_YELLOW.get());
                        pOutput.accept(ModItems.EASTER_EGG_ORANGE.get());
                        pOutput.accept(ModItems.EASTER_EGG_BLACK.get());
                        pOutput.accept(ModItems.EASTER_EGG_PURPLE.get());
                        pOutput.accept(ModItems.EASTER_EGG_BROWN.get());
                        pOutput.accept(ModItems.EASTER_EGG_LIME.get());
                        pOutput.accept(ModItems.EASTER_EGG_LIGHT_BLUE.get());
                        pOutput.accept(ModItems.EASTER_EGG_CYAN.get());
                        pOutput.accept(ModItems.EASTER_EGG_WHITE.get());
                        pOutput.accept(ModItems.EASTER_EGG_PINK.get());
                        pOutput.accept(ModItems.EASTER_EGG_MAGENTA.get());
                        pOutput.accept(ModItems.EASTER_EGG_LIGHT_GRAY.get());
                        pOutput.accept(ModItems.EASTER_EGG_GRAY.get());
                        pOutput.accept(ModItems.EASTER_EGG_WILD.get());
                        pOutput.accept(ModItems.EASTER_EGG_GOLDEN.get());

                        pOutput.accept(ModItems.EASTER_CHOCOLATE_BUNNY.get());
                        pOutput.accept(ModItems.EASTER_CHOCOLATE_EGG.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_RED.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_BLUE.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_GREEN.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_YELLOW.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_ORANGE.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_BLACK.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_PURPLE.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_BROWN.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_LIME.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_LIGHT_BLUE.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_CYAN.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_WHITE.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_PINK.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_MAGENTA.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_LIGHT_GRAY.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_GRAY.get());
                        pOutput.accept(ModItems.EASTER_COTTON_CANDY_GOLDEN.get());

                        pOutput.accept(ModItems.EASTER_CARROT_SWORD.get());

                        pOutput.accept(ModBlocks.EASTER_BUNNY_NEST.get());

                        pOutput.accept(ModBlocks.EASTER_BASKET.get());
                        pOutput.accept(ModBlocks.EASTER_BASKET_MEDIUM.get());
                        pOutput.accept(ModBlocks.EASTER_BASKET_LARGE.get());

                        pOutput.accept(ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_RED_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_RED_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_RED_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_BLUE_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_BLUE_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_BLUE_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_GREEN_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_GREEN_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_GREEN_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_YELLOW_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_YELLOW_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_YELLOW_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_ORANGE_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_ORANGE_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_ORANGE_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_BLACK_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_PURPLE_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_BROWN_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_BROWN_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_BROWN_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_LIME_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_LIME_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_LIME_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_CYAN_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_CYAN_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_CYAN_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_WHITE_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_WHITE_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_WHITE_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_PINK_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_PINK_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_PINK_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_MAGENTA_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_MAGENTA_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_MAGENTA_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_GRAY_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_GRAY_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_GRAY_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_WILD_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_WILD_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_WILD_BLOCK_THRICE.get());

                        pOutput.accept(ModBlocks.EASTER_EGG_GOLDEN_BLOCK.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_GOLDEN_BLOCK_DUAL.get());
                        pOutput.accept(ModBlocks.EASTER_EGG_GOLDEN_BLOCK_THRICE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
