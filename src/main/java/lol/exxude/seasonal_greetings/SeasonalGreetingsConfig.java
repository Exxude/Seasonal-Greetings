package lol.exxude.seasonal_greetings;

import net.minecraftforge.common.ForgeConfigSpec;

public class SeasonalGreetingsConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ACTIVATE_EASTER;

    static {
        BUILDER.push("Seasonal Greetings Common Configs");
        ACTIVATE_EASTER = BUILDER.comment("True/False :: This will activate all world generations for Easter Holiday in every biome, everywhere.")
                .define("Activate Easter", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
