package lol.exxude.seasonal_greetings.datagen.loot;

import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    private static final List<Block> EASTER_EGG_BLOCKS = List.of(ModBlocks.EASTER_EGG_RED_BLOCK.get(), ModBlocks.EASTER_EGG_BLUE_BLOCK.get(),
            ModBlocks.EASTER_EGG_GREEN_BLOCK.get(), ModBlocks.EASTER_EGG_YELLOW_BLOCK.get(), ModBlocks.EASTER_EGG_ORANGE_BLOCK.get(), ModBlocks.EASTER_EGG_BLACK_BLOCK.get(),
            ModBlocks.EASTER_EGG_PURPLE_BLOCK.get(), ModBlocks.EASTER_EGG_BROWN_BLOCK.get(), ModBlocks.EASTER_EGG_LIME_BLOCK.get(), ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK.get(),
            ModBlocks.EASTER_EGG_CYAN_BLOCK.get(), ModBlocks.EASTER_EGG_WHITE_BLOCK.get(), ModBlocks.EASTER_EGG_PINK_BLOCK.get(), ModBlocks.EASTER_EGG_MAGENTA_BLOCK.get(),
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK.get(), ModBlocks.EASTER_EGG_GRAY_BLOCK.get(), ModBlocks.EASTER_EGG_WILD_BLOCK.get(), ModBlocks.EASTER_EGG_GOLDEN_BLOCK.get());

    private static final List<Block> EASTER_EGG_BLOCKS_DUAL = List.of(ModBlocks.EASTER_EGG_RED_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_BLUE_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_GREEN_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_YELLOW_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_ORANGE_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_BROWN_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_LIME_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_CYAN_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_WHITE_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_PINK_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_MAGENTA_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_GRAY_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_WILD_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_GOLDEN_BLOCK_DUAL.get());

    private static final List<Block> EASTER_EGG_BLOCKS_THRICE = List.of(ModBlocks.EASTER_EGG_RED_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_BLUE_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_GREEN_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_YELLOW_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_ORANGE_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_BROWN_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_LIME_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_CYAN_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_WHITE_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_PINK_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_MAGENTA_BLOCK_THRICE.get(),
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_GRAY_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_WILD_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_GOLDEN_BLOCK_THRICE.get());

    private static final List<Item> EASTER_EGGS = List.of(ModItems.EASTER_EGG_RED.get(), ModItems.EASTER_EGG_BLUE.get(),
            ModItems.EASTER_EGG_GREEN.get(), ModItems.EASTER_EGG_YELLOW.get(), ModItems.EASTER_EGG_ORANGE.get(), ModItems.EASTER_EGG_BLACK.get(),
            ModItems.EASTER_EGG_PURPLE.get(), ModItems.EASTER_EGG_BROWN.get(), ModItems.EASTER_EGG_LIME.get(), ModItems.EASTER_EGG_LIGHT_BLUE.get(),
            ModItems.EASTER_EGG_CYAN.get(), ModItems.EASTER_EGG_WHITE.get(), ModItems.EASTER_EGG_PINK.get(), ModItems.EASTER_EGG_MAGENTA.get(),
            ModItems.EASTER_EGG_LIGHT_GRAY.get(), ModItems.EASTER_EGG_GRAY.get(), ModItems.EASTER_EGG_WILD.get(), ModItems.EASTER_EGG_GOLDEN.get());

    private static final List<Block> EASTER_EGG_BLOCKS_HELD = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK_HELD.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_HELD.get(),
            ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL_HELD.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL_HELD.get(),
            ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE_HELD.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE_HELD.get());
    private static final List<Block> EASTER_EGG_BLOCKS_DROP = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK.get(),
            ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL.get(),
            ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE.get());

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TRADING_MACHINE.get());
        this.dropSelf(ModBlocks.EASTER_BASKET.get());
        this.dropSelf(ModBlocks.EASTER_BASKET_MEDIUM.get());
        this.dropSelf(ModBlocks.EASTER_BASKET_LARGE.get());
        this.dropSelf(ModBlocks.EASTER_STRAW.get());
        this.dropSelf(ModBlocks.EASTER_BUNNY_NEST.get());
        this.dropSelf(ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY.get());

        this.createSelfSilked(ModBlocks.EASTER_BUNNY_NEST_WG.get());
        this.createSelfSilked(ModBlocks.EASTER_ISLAND_HEAD.get());

        this.add(ModBlocks.EASTER_ISLAND_HEAD_TOP.get(),
                block -> createSilkedDrop(ModBlocks.EASTER_ISLAND_HEAD.get().asItem(), Items.STONE, 8.0f));
        this.add(ModBlocks.EASTER_ISLAND_HEAD_BOTTOM.get(),
                block -> createSilkedDrop(ModBlocks.EASTER_ISLAND_HEAD.get().asItem(), Items.STONE, 8.0f));

        this.add(ModBlocks.EASTER_ISLAND_GRASS_BLOCK.get(),
                block -> createSilkedDrop(ModBlocks.EASTER_ISLAND_GRASS_BLOCK.get().asItem(), Items.DIRT, 1.0f));
        this.add(ModBlocks.EASTER_ISLAND_GRASS_BLOCK_FULL.get(),
                block -> createSilkedDrop(ModBlocks.EASTER_ISLAND_GRASS_BLOCK_FULL.get().asItem(), Items.DIRT, 1.0f));


        for(int i = 0; i < EASTER_EGG_BLOCKS.size(); i++) {
            int index = i;
            this.add(EASTER_EGG_BLOCKS.get(index),
                    block -> createEggDrop(EASTER_EGG_BLOCKS.get(index), EASTER_EGGS.get(index), 1.0f, 1.0f));
        }

        for(int i = 0; i < EASTER_EGG_BLOCKS_DUAL.size(); i++) {
            int index = i;
            this.add(EASTER_EGG_BLOCKS_DUAL.get(index),
                    block -> createEggDrop(EASTER_EGG_BLOCKS_DUAL.get(index), EASTER_EGGS.get(index), 2.0f, 2.0f));
        }

        for(int i = 0; i < EASTER_EGG_BLOCKS_THRICE.size(); i++) {
            int index = i;
            this.add(EASTER_EGG_BLOCKS_THRICE.get(index),
                    block -> createEggDrop(EASTER_EGG_BLOCKS_THRICE.get(index), EASTER_EGGS.get(index), 3.0f, 3.0f));
        }

        for(int i = 0; i < EASTER_EGG_BLOCKS_HELD.size(); i++) {
            int index = i;
            this.add(EASTER_EGG_BLOCKS_HELD.get(index),
                    block -> createEggBlockDropNoSilk(EASTER_EGG_BLOCKS_DROP.get(index).asItem()));
        }

        this.add(ModBlocks.EASTER_BASKET_WG.get(), block -> LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.EASTER_BASKET.get()))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_EGG.get()).setWeight(25)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_BUNNY.get()).setWeight(25)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f))))
                        .add(LootItem.lootTableItem(ModItems.TRADING_MACHINE_TEMPLATE.get()).setWeight(1))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_EGG.get()).setWeight(75)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0f, 8.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_BUNNY.get()).setWeight(75)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0f, 8.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_EGG_GOLDEN.get()).setWeight(1))
                )
        );

        this.add(ModBlocks.EASTER_BASKET_MEDIUM_WG.get(), block -> LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.EASTER_BASKET_MEDIUM.get()))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_EGG.get()).setWeight(20)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0f, 8.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_BUNNY.get()).setWeight(20)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0f, 8.0f))))
                        .add(LootItem.lootTableItem(ModItems.TRADING_MACHINE_TEMPLATE.get()).setWeight(1))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_EGG.get()).setWeight(60)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0f, 12.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_BUNNY.get()).setWeight(60)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0f, 12.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_EGG_GOLDEN.get()).setWeight(1))
                )
        );

        this.add(ModBlocks.EASTER_BASKET_LARGE_WG.get(), block -> LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModBlocks.EASTER_BASKET_LARGE.get()))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_EGG.get()).setWeight(15)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0f, 10.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_BUNNY.get()).setWeight(15)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0f, 10.0f))))
                        .add(LootItem.lootTableItem(ModItems.TRADING_MACHINE_TEMPLATE.get()).setWeight(1))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_RED.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_BLUE.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_GREEN.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_YELLOW.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_ORANGE.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_BLACK.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_PURPLE.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_BROWN.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_LIME.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_LIGHT_BLUE.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_CYAN.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_WHITE.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_PINK.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_MAGENTA.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_LIGHT_GRAY.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_GRAY.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_COTTON_CANDY_GOLDEN.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.EASTER_CARROT_SWORD.get()).setWeight(1))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_EGG.get()).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(12.0f, 16.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_CHOCOLATE_BUNNY.get()).setWeight(40)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(12.0f, 16.0f))))
                        .add(LootItem.lootTableItem(ModItems.EASTER_EGG_GOLDEN.get()).setWeight(1))
                )
        );
    }

    protected LootTable.Builder createEggDrop(Block pBlock, Item item, Float minSize, Float maxSize) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minSize, maxSize)))));
    }

    protected LootTable.Builder createEggBlockDropNoSilk(Item drop) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(drop)));
    }

    protected LootTable.Builder createSilkedDrop(Item silkedDrop, Item drop, Float amount) {
        return LootTable.lootTable().withPool(LootPool.lootPool().when(HAS_SILK_TOUCH).add(LootItem.lootTableItem(silkedDrop)))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, amount))));
    }

    protected LootTable.Builder createSelfSilked(Block silkedDrop) {
        return LootTable.lootTable().withPool(LootPool.lootPool().when(HAS_SILK_TOUCH).add(LootItem.lootTableItem(silkedDrop)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
