package org.goofyland.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InferredtpsClient implements ClientModInitializer {
    public static final String MOD_ID = "inferredtps";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final TpsManager TPS_MANAGER = new TpsManager();
    public static final TablistManager TABLIST_MANAGER = new TablistManager();
    private static final ModCommands MOD_COMMANDS = new ModCommands();

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(((dispatcher, buildContext) ->
                dispatcher.register(ClientCommands.literal("itps")
                        .then(ClientCommands.literal("get")
                                .executes(MOD_COMMANDS::itps_get)
                        ).then(ClientCommands.literal("tablist")
                                .then(ClientCommands.literal("show").executes(MOD_COMMANDS::itps_tablist_show))
                                .then(ClientCommands.literal("hide").executes(MOD_COMMANDS::itps_tablist_hide))
                        )
                )));
    }
}