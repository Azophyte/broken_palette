package azo.broken_palette;

import azo.broken_palette.block.ModBlocks;
import azo.broken_palette.item.ModItemGroup;
import azo.broken_palette.item.ModItems;
import azo.broken_palette.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokenPalette implements ModInitializer {
	public static final String MOD_ID = "broken_palette";
	public static final Logger LOGGER = LoggerFactory.getLogger("broken_palette");

	@Override
	public void onInitialize() {
		LOGGER.info("Initialising Broken_Palette, Azo says hi!");
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
	}
}