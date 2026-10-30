package org.goofyland.client;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class TablistManager {
    private boolean enabled = false;

    public void tick(Double tps) {
        if (!enabled) return;

        Minecraft.getInstance().gui.getTabList().setFooter(Component.literal(String.format("TPS: %f", tps)));
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
