package net.ramgaming.leapers;

import net.fabricmc.api.ModInitializer;
import net.ramgaming.leapers.block.ModBlocks;
import net.ramgaming.leapers.block.entity.ModBlockEntities;
import net.ramgaming.leapers.item.ModItems;
import net.ramgaming.leapers.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Leapers implements ModInitializer {
	public static final String MOD_ID = "leapers";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerBlocks();
		RegisterEvents.onInitialize();
		RegisterTags.onInitialize();
		ModBlockEntities.registerAllBlockEntities();
		ModMessages.registerC2SPackets();
	}
}
