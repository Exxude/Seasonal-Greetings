package lol.exxude.seasonal_greetings.util;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> EASTER_EGGS = tag("easter_eggs");
        public static final TagKey<Block> EASTER_EGG_SPAWNABLES = tag("easter_egg_spawnables");
        public static final TagKey<Block> ENDERMAN_HOLDABLES = tag("enderman_holdables");
        public static final TagKey<Block> EASTER_ISLAND_GRASS = tag("easter_island_grass");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SeasonalGreetings.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> EASTER_EGGS = tag("easter_eggs");
        public static final TagKey<Item> SWEETS = tag("sweets");
        public static final TagKey<Item> EASTER_EGGS_SPECIAL = tag("easter_eggs_special");
        public static final TagKey<Item> TRADABLE_ITEMS = tag("tradable_items");
        public static final TagKey<Item> TRADABLE_CATALYSTS = tag("tradable_catalysts");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SeasonalGreetings.MOD_ID, name));
        }
    }
}
