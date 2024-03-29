package lol.exxude.seasonal_greetings;

import net.minecraftforge.common.ForgeConfigSpec;

public class SeasonalGreetingsConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ACTIVATE_EASTER;
    public static final ForgeConfigSpec.ConfigValue<Boolean> DISABLE_EASTER_WORLD_GENERATION;
    public static final ForgeConfigSpec.ConfigValue<Boolean> GENERATE_EASTER_ISLAND;
    public static final ForgeConfigSpec.ConfigValue<Boolean> DISABLE_ENDERMAN_CARRY_MODIFIER;

    static {
        BUILDER.push("Seasonal Greetings Common Configs");
        BUILDER.pop();
        BUILDER.push("EASTER");
        ACTIVATE_EASTER = BUILDER.comment("True/False :: This will activate/deactivate all Events for the Easter Holiday in every biome, everywhere. If this is 'false', the following options have no effect.")
                .define("Activate Easter", false);
        DISABLE_EASTER_WORLD_GENERATION = BUILDER.comment("True/False :: This will activate/deactivate all World Generation Events for the Easter Holiday in every biome, except the Easter Island.")
                .define("Disable Easter World Generation", false);
        GENERATE_EASTER_ISLAND = BUILDER.comment("True/False :: This will enable/disable the Easter Island Biome Generation Event.")
                .define("Generate Easter Island", true);
        DISABLE_ENDERMAN_CARRY_MODIFIER = BUILDER.comment("True/False :: This will enable/disable the custom event that will give all spawned Enderman a chance to be holding an Easter Egg.")
                .define("Disable Enderman Carry Modifier", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
