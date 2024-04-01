package lol.exxude.seasonal_greetings;

import com.mojang.logging.LogUtils;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import lol.exxude.seasonal_greetings.block.entity.ModBlockEntities;
import lol.exxude.seasonal_greetings.entity.EndermanListener;
import lol.exxude.seasonal_greetings.item.ModCreativeModeTabs;
import lol.exxude.seasonal_greetings.item.ModItems;
import lol.exxude.seasonal_greetings.painting.ModPaintings;
import lol.exxude.seasonal_greetings.recipe.ModRecipe;
import lol.exxude.seasonal_greetings.screen.ModMenuTypes;
import lol.exxude.seasonal_greetings.screen.TradingMachineScreen;
import lol.exxude.seasonal_greetings.worldgen.ModFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(SeasonalGreetings.MOD_ID)
public class SeasonalGreetings
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "seasonal_greetings";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public SeasonalGreetings() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipe.register(modEventBus);

        ModFeatures.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(EndermanListener.class);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SeasonalGreetingsConfig.SPEC, "seasonal_greetings-common_config.toml");
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Vanilla Tabs
        //if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            //event.accept(ModItems.ITEMNAME);
        //}
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.TRADING_MACHINE_MENU.get(), TradingMachineScreen::new);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.EASTER_ISLAND_GRASS.get(), RenderType.cutout());
        }
    }
}
