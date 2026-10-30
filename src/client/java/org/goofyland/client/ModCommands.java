package org.goofyland.client;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class ModCommands {
    public int itps_get(CommandContext<CommandSourceStack> ctx) {
        var tps = InferredtpsClient.TPS_MANAGER.getTPS();
        ctx.getSource().sendSuccess(() -> Component.literal(String.format("Inferred TPS: ~%f", tps)), false);

        return 0;
    }

    public int itps_tablist_show(CommandContext<CommandSourceStack> ctx) {
        return 0;
    }

    public int itps_tablist_hide(CommandContext<CommandSourceStack> ctx) {

        return 0;
    }
}
