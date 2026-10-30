package org.goofyland.client.mixin;

import net.minecraft.network.Connection;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;
import org.goofyland.client.InferredtpsClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class ConnectionMixin {

	@Inject(method = "genericsFtw", at = @At("HEAD"), cancellable = false)
	private static <T extends PacketListener>  void genericsFtwMixin(Packet<T> packet, PacketListener listener, CallbackInfo ci) {
		if (!(packet instanceof ClientboundSetTimePacket)) return;

		InferredtpsClient.TPS_MANAGER.handlePacket((ClientboundSetTimePacket) packet);
	}
}