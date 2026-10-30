package org.goofyland.client;

import net.minecraft.network.protocol.game.ClientboundSetTimePacket;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

// i have no better names :/
public class TpsManager {
    private Instant lastPacketTime = Instant.now();
    private long lastGameTime = 0;

    private double tps = 0;

    public void handlePacket(ClientboundSetTimePacket packet) {
        var currentTime = Instant.now();
        var currentGameTime = packet.gameTime();

        var deltaTime = ChronoUnit.MILLIS.between(lastPacketTime, currentTime);
        var deltaGameTick = currentGameTime - lastGameTime;

        tps = (deltaGameTick * 1000.0) / deltaTime;
//        InferredtpsClient.LOGGER.info("TPS: {}", tps);

        lastPacketTime = currentTime;
        lastGameTime = currentGameTime;
    }

    public double getTPS() {
        return tps;
    }
}
