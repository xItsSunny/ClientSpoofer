package org.xitssunny.clientspoofer;

import org.xitssunny.clientspoofer.command.ClientSpooferCommand;
import org.xitssunny.clientspoofer.config.ClientSpooferConfig;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ClientSpoofer.MODID, name = ClientSpoofer.NAME, version = ClientSpoofer.VERSION)
public class ClientSpoofer {

    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static ClientSpoofer INSTANCE;
    public static ClientSpooferConfig config;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new ClientSpooferConfig();
        CommandManager.INSTANCE.registerCommand(new ClientSpooferCommand());
    }
}
