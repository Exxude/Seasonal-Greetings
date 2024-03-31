package lol.exxude.seasonal_greetings.event;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.entity.ModBlockEntities;
import lol.exxude.seasonal_greetings.block.entity.renderer.EasterBunnyNestBlockRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SeasonalGreetings.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers events) {
        events.registerBlockEntityRenderer(ModBlockEntities.EASTER_BUNNY_NEST_BE.get(), EasterBunnyNestBlockRenderer::new);
    }
}
