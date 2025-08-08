package dev.bigbrainrobin29.wcifs.mixin;

import dev.bigbrainrobin29.wcifs.WCIFS;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;
//? >= 1.19 {
import net.minecraft.text.TranslatableTextContent;
//?} else {
/*import net.minecraft.text.TranslatableText;
*///?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(at = @At("HEAD"), method = "setOverlayMessage", cancellable = true)
	private void init(Text text, boolean bl, CallbackInfo info) {
		//? >= 1.19 {
		boolean shouldInject = text.getContent() instanceof TranslatableTextContent translatableTextContent && translatableTextContent.getKey().equals("block.minecraft.bed.no_sleep");
		//?} else {
		/*boolean shouldInject = text instanceof TranslatableText translatableText && translatableText.getKey().equals("block.minecraft.bed.no_sleep");
		*///?}

		if (shouldInject) {
			text = text.copy().append(WCIFS.getTimeUntilNightComponent());
			//? >= 1.19.1 {
			((InGameHud)(Object)this).setCanShowChatDisabledScreen(false);
			//?} else if = 1.19 {
			/*((InGameHud)(Object)this).method_44354(false);
			*///?}

			((InGameHud)(Object)this).overlayMessage = text;
			((InGameHud)(Object)this).overlayRemaining = 60;
			((InGameHud)(Object)this).overlayTinted = bl;

			info.cancel();
		}
	}
}