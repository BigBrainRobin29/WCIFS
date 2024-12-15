package bigbrainrobin29.wcifs.mixin;

import bigbrainrobin29.wcifs.WCIFS;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.block.BedBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {
	@Inject(at = @At("HEAD"), method = "setOverlayMessage", cancellable = true)
	private void init(Component component, boolean bl, CallbackInfo info) {
		if (component.getContents() instanceof TranslatableContents translatableContents && translatableContents.getKey().equals("block.minecraft.bed.no_sleep")) {
			component = component.copy().append(WCIFS.getTimeUntilNightComponent());

			((Gui)(Object)this).setChatDisabledByPlayerShown(false);
			((Gui)(Object)this).overlayMessageString = component;
			((Gui)(Object)this).overlayMessageTime = 60;
			((Gui)(Object)this).animateOverlayMessageColor = bl;
			info.cancel();
		}
	}
}