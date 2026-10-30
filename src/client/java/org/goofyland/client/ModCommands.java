package org.goofyland.client;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class ModCommands {
    public int itps_get(CommandContext<FabricClientCommandSource> ctx) {
        var tps = InferredtpsClient.TPS_MANAGER.getTPS();
        ctx.getSource().sendFeedback(Component.literal(String.format("Inferred TPS: ~%f", tps)));

        return 0;
    }

    public int itps_tablist_show(CommandContext<FabricClientCommandSource> ctx) {
        InferredtpsClient.TABLIST_MANAGER.setEnabled(true);
        return 0;
    }

    public int itps_tablist_hide(CommandContext<FabricClientCommandSource> ctx) {
        InferredtpsClient.TABLIST_MANAGER.setEnabled(false);
        return 0;
    }
}
