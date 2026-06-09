package turniplabs.examplemod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("examplemod", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("ExampleMod initialized.");
		CommonEvents.BEFORE_GAME_START.listen(ExampleMod::beforeGameStart);
	}

	private static void beforeGameStart() {
		LOGGER.info("This is an example event!");
	}
}
