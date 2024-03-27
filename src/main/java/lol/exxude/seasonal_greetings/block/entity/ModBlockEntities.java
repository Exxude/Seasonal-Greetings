package lol.exxude.seasonal_greetings.block.entity;

import lol.exxude.seasonal_greetings.SeasonalGreetings;
import lol.exxude.seasonal_greetings.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SeasonalGreetings.MOD_ID);

    public static final RegistryObject<BlockEntityType<TradingMachineBlockEntity>> TRADING_MACHINE_BE =
            BLOCK_ENTITIES.register("trading_machine_be", () ->
                    BlockEntityType.Builder.of(TradingMachineBlockEntity::new,
                            ModBlocks.TRADING_MACHINE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
