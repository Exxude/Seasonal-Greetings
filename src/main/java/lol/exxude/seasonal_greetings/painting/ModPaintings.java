package lol.exxude.seasonal_greetings.painting;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTINGS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, SeasonalGreetings.MOD_ID);

    public static RegistryObject<PaintingVariant> EASTER_BUNNY_PAINTING = PAINTINGS.register("easter_bunny",
            () -> new PaintingVariant(32, 32));
    public static RegistryObject<PaintingVariant> CHICKEN_PAINTING = PAINTINGS.register("chicken",
            () -> new PaintingVariant(16, 16));

    public static void register(IEventBus eventBus) { PAINTINGS.register(eventBus); }
}
