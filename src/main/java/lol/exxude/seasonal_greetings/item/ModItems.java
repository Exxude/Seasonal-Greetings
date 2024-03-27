package lol.exxude.seasonal_greetings.item;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeasonalGreetings.MOD_ID);

    public static final RegistryObject<Item> TRADING_MACHINE_TEMPLATE = ITEMS.register("trading_machine_template",
            () -> new Item(new Item.Properties()));

    // EASTER EGGS
    public static final RegistryObject<Item> EASTER_EGG_RED = ITEMS.register("easter_egg_red",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_BLUE = ITEMS.register("easter_egg_blue",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_GREEN = ITEMS.register("easter_egg_green",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_YELLOW = ITEMS.register("easter_egg_yellow",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_ORANGE = ITEMS.register("easter_egg_orange",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_BLACK = ITEMS.register("easter_egg_black",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_PURPLE = ITEMS.register("easter_egg_purple",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_BROWN = ITEMS.register("easter_egg_brown",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_LIME = ITEMS.register("easter_egg_lime",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_LIGHT_BLUE = ITEMS.register("easter_egg_light_blue",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_CYAN = ITEMS.register("easter_egg_cyan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_WHITE = ITEMS.register("easter_egg_white",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_PINK = ITEMS.register("easter_egg_pink",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_MAGENTA = ITEMS.register("easter_egg_magenta",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_LIGHT_GRAY = ITEMS.register("easter_egg_light_gray",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_GRAY = ITEMS.register("easter_egg_gray",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_WILD = ITEMS.register("easter_egg_wild",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EASTER_EGG_GOLDEN = ITEMS.register("easter_egg_golden",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EASTER_CHOCOLATE_BUNNY = ITEMS.register("easter_chocolate_bunny",
            () -> new Item(new Item.Properties().food(ModFoods.EASTER_CHOCOLATE_BUNNY)));
    public static final RegistryObject<Item> EASTER_CHOCOLATE_EGG = ITEMS.register("easter_chocolate_egg",
            () -> new Item(new Item.Properties().food(ModFoods.EASTER_CHOCOLATE_EGG)));

    public static final RegistryObject<Item> EASTER_COTTON_CANDY_RED = ITEMS.register("easter_cotton_candy_red",
            () -> new CottonCandyRedItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_RED)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_BLUE = ITEMS.register("easter_cotton_candy_blue",
            () -> new CottonCandyBlueItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_BLUE)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_GREEN = ITEMS.register("easter_cotton_candy_green",
            () -> new CottonCandyGreenItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_GREEN)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_YELLOW = ITEMS.register("easter_cotton_candy_yellow",
            () -> new CottonCandyYellowItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_YELLOW)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_ORANGE = ITEMS.register("easter_cotton_candy_orange",
            () -> new CottonCandyOrangeItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_ORANGE)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_BLACK = ITEMS.register("easter_cotton_candy_black",
            () -> new CottonCandyBlackItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_BLACK)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_PURPLE = ITEMS.register("easter_cotton_candy_purple",
            () -> new CottonCandyPurpleItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_PURPLE)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_BROWN = ITEMS.register("easter_cotton_candy_brown",
            () -> new CottonCandyBrownItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_BROWN)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_LIME = ITEMS.register("easter_cotton_candy_lime",
            () -> new CottonCandyLimeItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_LIME)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_LIGHT_BLUE = ITEMS.register("easter_cotton_candy_light_blue",
            () -> new CottonCandyLightBlueItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_LIGHT_BLUE)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_CYAN = ITEMS.register("easter_cotton_candy_cyan",
            () -> new CottonCandyCyanItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_CYAN)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_WHITE = ITEMS.register("easter_cotton_candy_white",
            () -> new CottonCandyWhiteItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_WHITE)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_PINK = ITEMS.register("easter_cotton_candy_pink",
            () -> new CottonCandyPinkItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_PINK)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_MAGENTA = ITEMS.register("easter_cotton_candy_magenta",
            () -> new CottonCandyMagentaItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_MAGENTA)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_LIGHT_GRAY = ITEMS.register("easter_cotton_candy_light_gray",
            () -> new CottonCandyLightGrayItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_LIGHT_GRAY)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_GRAY = ITEMS.register("easter_cotton_candy_gray",
            () -> new CottonCandyGrayItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_GRAY)));
    public static final RegistryObject<Item> EASTER_COTTON_CANDY_GOLDEN = ITEMS.register("easter_cotton_candy_golden",
            () -> new CottonCandyGoldenItem(new Item.Properties().food(ModFoods.EASTER_COTTON_CANDY_GOLDEN)));

    public static final RegistryObject<Item> EASTER_CARROT_SWORD = ITEMS.register("easter_carrot_sword",
            () -> new SwordItem(Tiers.DIAMOND, 6, -1.5f, new Item.Properties().durability(750)));


    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
