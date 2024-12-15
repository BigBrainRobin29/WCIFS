package bigbrainrobin29.wcifs;

import net.fabricmc.api.ClientModInitializer;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WCIFS implements ClientModInitializer {
	public static final String MOD_ID = "wcifs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Component getTimeUntilNightComponent() {
		int firstSleepTick = Minecraft.getInstance().level.isRaining() ? 12010 : 12542;
		long currentDayTick = Minecraft.getInstance().level.getDayTime() % 24000L;

		long ticksUntilNight = firstSleepTick - currentDayTick;

		long totalSeconds = ticksUntilNight / 20;
		long minutes = totalSeconds / 60;
		long seconds = totalSeconds % 60;

		String string = (minutes == 0 ? "" : minutes + "m ") + seconds + "s";

		return Component.translatable("block.minecraft.bed.time_until_night", string);
	}

	@Override
	public void onInitializeClient() {
		LOGGER.info("Loaded WCIFS!");
	}
}