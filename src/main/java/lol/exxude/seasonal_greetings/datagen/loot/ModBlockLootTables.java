package lol.exxude.seasonal_greetings.datagen.loot;

import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
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

    private static final List<Item> EASTER_EGGS = List.of(ModItems.EASTER_EGG_RED.get(), ModItems.EASTER_EGG_BLUE.get(),
            ModItems.EASTER_EGG_GREEN.get(), ModItems.EASTER_EGG_YELLOW.get(), ModItems.EASTER_EGG_ORANGE.get(), ModItems.EASTER_EGG_BLACK.get(),
            ModItems.EASTER_EGG_PURPLE.get(), ModItems.EASTER_EGG_BROWN.get(), ModItems.EASTER_EGG_LIME.get(), ModItems.EASTER_EGG_LIGHT_BLUE.get(),
            ModItems.EASTER_EGG_CYAN.get(), ModItems.EASTER_EGG_WHITE.get(), ModItems.EASTER_EGG_PINK.get(), ModItems.EASTER_EGG_MAGENTA.get(),
            ModItems.EASTER_EGG_LIGHT_GRAY.get(), ModItems.EASTER_EGG_GRAY.get(), ModItems.EASTER_EGG_WILD.get(), ModItems.EASTER_EGG_GOLDEN.get());

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TRADING_MACHINE.get());
        this.dropSelf(ModBlocks.EASTER_BASKET.get());
        this.dropSelf(ModBlocks.EASTER_STUFFED_ANIMAL_BUNNY.get());

        for(int i = 0; i < EASTER_EGG_BLOCKS.size(); i++) {
            int index = i;
            this.add(EASTER_EGG_BLOCKS.get(index),
                    block -> createEggDrop(EASTER_EGG_BLOCKS.get(index), EASTER_EGGS.get(index), 1.0f));
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
    }

    protected LootTable.Builder createEggDrop(Block pBlock, Item item, Float size) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, size)))));
    }

    protected LootTable.Builder createSilkedDrop(Item silkedDrop, Item drop, Float amount) {
        return LootTable.lootTable().withPool(LootPool.lootPool().when(HAS_SILK_TOUCH).add(LootItem.lootTableItem(silkedDrop)))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, amount))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}