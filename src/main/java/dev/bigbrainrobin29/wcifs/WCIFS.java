package dev.bigbrainrobin29.wcifs;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
//? <= 1.18.2
/*import net.minecraft.text.TranslatableText;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WCIFS implements ClientModInitializer {
	public static final String MOD_ID = "wcifs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Text getTimeUntilNightComponent() {
		int firstSleepTick = MinecraftClient.getInstance().world.isRaining() ? 12010 : 12542;
		long currentDayTick = MinecraftClient.getInstance().world.getTimeOfDay() % 24000L;

		long ticksUntilNight = firstSleepTick - currentDayTick;

		long totalSeconds = ticksUntilNight / 20;
		long minutes = totalSeconds / 60;
		long seconds = totalSeconds % 60;

		String string = (minutes == 0 ? "" : minutes + "m ") + seconds + "s";

		//? if >= 1.19 {
		return Text.translatable("block.minecraft.bed.time_until_night", string);
		//?} else {
		/*return new TranslatableText("block.minecraft.bed.time_until_night", string);
		*///?}
	}

	@Override
	public void onInitializeClient() {
		LOGGER.info("Loaded WCIFS!");
	}
}