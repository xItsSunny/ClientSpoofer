package org.xitssunny.clientspoofer.event;

import lombok.*;
import net.minecraft.network.Packet;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class SendPacketEvent extends CancellableEvent {
    private Packet<?> packet;
}