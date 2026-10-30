package org.goofyland.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InferredtpsClient implements ClientModInitializer {
    public static final String MOD_ID = "inferredtps";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final TpsManager TPS_MANAGER = new TpsManager();
    private static final ModCommands MOD_COMMANDS = new ModCommands();

    @Override
    public void onInitializeClient() {
        CommandRegistrationCallback.EVENT.register((((dispatcher, buildContext, selection) ->
                dispatcher.register(Commands.literal("itps")
                        .then(Commands.literal("get")
                                .executes(MOD_COMMANDS::itps_get)
                        ).then(Commands.literal("tablist")
                                .then(Commands.literal("show")).executes(MOD_COMMANDS::itps_tablist_show)
                                .then(Commands.literal("hide")).executes(MOD_COMMANDS::itps_tablist_hide)
                        )
                )
        )));
    }
}