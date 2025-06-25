package org.xitssunny.clientspoofer.config;

import cc.polyfrost.oneconfig.config.annotations.Switch;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import org.jetbrains.annotations.NotNull;
import org.xitssunny.clientspoofer.ClientSpoofer;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import org.xitssunny.clientspoofer.event.ClientBrandEvent;
import org.xitssunny.clientspoofer.event.SendPacketEvent;
import org.xitssunny.clientspoofer.eventbus.EventListener;

public class ClientSpooferConfig extends Config {
    @Dropdown(
            name = "Client",
            options = {"Vanilla", "Forge", "Lunar", "Badlion", "Null", "Cancel"}
    )
    public static int clientDropdown = 0;

    @Switch(
            name = "cancelForgePacket"
    )
    public static boolean cancelforgepacket = false;

    @EventListener
    public void onSendPacket(@NotNull SendPacketEvent event) {
        if (event.getPacket() instanceof FMLProxyPacket
                && cancelforgepacket == true) {
            event.cancel();
        }
        if (event.getPacket() instanceof C17PacketCustomPayload
                && clientDropdown == 5) {
            event.cancel();
        }
    }

    @EventListener
    public void onClientBrand(@NotNull ClientBrandEvent event) {
        String brand = event.getBrand();

        switch (clientDropdown) {
            case 0:
                brand = "vanilla";
                break;
            case 1:
                brand = "fml,forge";
                break;
            case 2:
                brand = "lunarclient:v2.18.3-2451";
                break;
            case 3:
                brand = "badlion";
                break;
            case 4:
                brand = "null";
                break;
        }

        event.setBrand(brand);
    }

    public ClientSpooferConfig() {
        super(new Mod(ClientSpoofer.NAME, ModType.UTIL_QOL), ClientSpoofer.MODID + ".json");
        initialize();
    }
}