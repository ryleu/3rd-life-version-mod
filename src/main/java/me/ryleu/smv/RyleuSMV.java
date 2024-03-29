package me.ryleu.smv;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.lang.JLang;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.util.Optional;

public class RyleuSMV implements ModInitializer {
	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("ryleu-smv:lang");
	@Override
	public void onInitialize() {
		final String modID = "ryleu-smv";
		final Optional<ModContainer> container =
				FabricLoader.getInstance().getModContainer(modID);
		String version = container.map(
				modContainer -> modContainer.getMetadata().getVersion().getFriendlyString()
		).orElse("???");

		JLang translation = JLang.lang();
		translation.entry("ryleu-smv.version",version);
		translation.entry("ryleu-smv.title","ryleu's 3rd Life v"+version);
		RESOURCE_PACK.addLang(RuntimeResourcePack.id("en_us"), translation);
		RRPCallback.BEFORE_VANILLA.register(a -> a.add(RESOURCE_PACK));
	}
}
