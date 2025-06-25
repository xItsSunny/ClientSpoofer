package org.xitssunny.clientspoofer.command;

import org.xitssunny.clientspoofer.ClientSpoofer;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

@Command(value = ClientSpoofer.MODID, description = "Access the " + ClientSpoofer.NAME + " GUI.")
public class ClientSpooferCommand {
    @Main
    private void handle() {
        ClientSpoofer.INSTANCE.config.openGui();
    }
}