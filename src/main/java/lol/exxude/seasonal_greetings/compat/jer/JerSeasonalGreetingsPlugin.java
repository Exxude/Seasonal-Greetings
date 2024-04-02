package lol.exxude.seasonal_greetings.compat.jer;

import jeresources.api.IJERAPI;
import jeresources.compatibility.api.JERAPI;
import lol.exxude.seasonal_greetings.SeasonalGreetings;

public class JerSeasonalGreetingsPlugin {
    public static void init() {
        IJERAPI api = JERAPI.getInstance();
        if(SeasonalGreetings.ModCompats.JER){
            try {
                SeasonalGreetings.LOGGER.info("Applying JER patch.");
                new SeasonalGreetingsDungeonRegistry().register(api);
            } catch (Exception e) {
                SeasonalGreetings.LOGGER.error("Failed to apply JER patch.");
            }
        }
    }
}
