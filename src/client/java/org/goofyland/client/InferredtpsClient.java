package org.goofyland.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InferredtpsClient implements ClientModInitializer {
	public static final String MOD_ID = "inferredtps";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TpsManager TPS_MANAGER = new TpsManager();

	@Override
	public void onInitializeClient() {
	}
}