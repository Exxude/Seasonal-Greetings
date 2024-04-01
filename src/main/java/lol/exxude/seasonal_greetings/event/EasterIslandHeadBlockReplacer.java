package lol.exxude.seasonal_greetings.event;

import lol.exxude.seasonal_greetings.block.ModBlocks;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EasterIslandHeadBlockReplacer {
    @SubscribeEvent
    public void blockEvent(BlockEvent.EntityPlaceEvent event) {
        if(event.getPlacedBlock().getBlock() == ModBlocks.EASTER_ISLAND_HEAD.get()) {
            if(event.isCancelable()) {
                event.setCanceled(true);
                event.getLevel().setBlock(event.getPos(), ModBlocks.EASTER_ISLAND_HEAD_BOTTOM.get().defaultBlockState(), 1);
                event.getLevel().setBlock(event.getPos(), event.getState(), 1);
                event.getLevel().setBlock(event.getPos().above(1), ModBlocks.EASTER_ISLAND_HEAD_TOP.get().defaultBlockState(), 1);
                event.getLevel().setBlock(event.getPos().above(1), event.getState(), 1);
            }
        }
    }
}
