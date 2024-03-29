package lol.exxude.seasonal_greetings.entity;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.SeasonalGreetingsConfig;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import org.slf4j.Logger;

import java.util.List;
import java.util.Random;

public class EndermanListener {
    @SubscribeEvent
    public static void EntityJoinLevelEvent(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof EnderMan) {
            if(((EnderMan) entity).getCarriedBlock() == null) {
                Double number = Math.random();
                if (number.floatValue() <= 0.10f) {
                    Block chosen = getRandom();
                    if (chosen != null) {
                        ((EnderMan) entity).setCarriedBlock(chosen.defaultBlockState());
                    }
                }
            }
        }
    }

    public static void LivingDropsEvent(LivingDropsEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof EnderMan) {
            if (SeasonalGreetingsConfig.ACTIVATE_EASTER.get()) {
                if (!SeasonalGreetingsConfig.DISABLE_ENDERMAN_CARRY_MODIFIER.get()) {
                    if (((EnderMan) entity).getCarriedBlock() != null) {
                        List<ItemEntity> drops = new java.util.ArrayList<>(event.getDrops().stream().toList());
                        List<Item> detect = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK_HELD.get().asItem(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_HELD.get().asItem(),
                                ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL_HELD.get().asItem(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL_HELD.get().asItem(),
                                ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE_HELD.get().asItem(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE_HELD.get().asItem());
                        List<Item> redrop = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK.get().asItem(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_HELD.get().asItem(),
                                ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL.get().asItem(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL.get().asItem(),
                                ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE.get().asItem(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE.get().asItem());
                        event.setCanceled(true);

                        Logger logger = SeasonalGreetings.LOGGER;
                        logger.atInfo().log("Canceled Enderman Drops");
                        for (int i = 0; i < detect.size(); i++) {
                            for (int d = 0; d < drops.size(); d++) {
                                logger.atInfo().log("Testing: " + drops.get(d).getItem() + "Against: " + detect.get(i));
                                if (drops.get(d).getItem().toString().equals(detect.get(i).getDefaultInstance().toString())) {
                                    drops.remove(d);
                                    logger.atInfo().log("Dropping: " + redrop.get(i));
                                    entity.spawnAtLocation(redrop.get(i));
                                }
                            }
                        }
                        for (int d = 0; d < drops.size(); d++) {
                            logger.atInfo().log("Re-Dropping: " + drops.get(d).getItem());
                            entity.spawnAtLocation(drops.get(d).getItem());
                        }
                    }
                }
            }
        }
    }

    private static Block getRandom() {
        List<Block> single_carryables = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK_HELD.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_HELD.get());
        List<Block> dual_carryables = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK_DUAL_HELD.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_DUAL_HELD.get());
        List<Block> thrice_carryables = List.of(ModBlocks.EASTER_EGG_BLACK_BLOCK_THRICE_HELD.get(), ModBlocks.EASTER_EGG_PURPLE_BLOCK_THRICE_HELD.get());
        List<List<Block>> carryables = List.of(single_carryables, single_carryables, single_carryables, single_carryables, single_carryables,
                single_carryables, dual_carryables, dual_carryables, dual_carryables, thrice_carryables);

        Integer index_carryables = new Random().nextInt(carryables.size());

        Integer index_chosen_carryables = new Random().nextInt(carryables.get(index_carryables).size());

        return carryables.get(index_carryables).get(index_chosen_carryables);
    }
}
