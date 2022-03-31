package r4mblerplugins.griefreportplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import r4mblerplugins.griefreportplugin.commands.grief;
import r4mblerplugins.griefreportplugin.commands.grief_list;


public final class GriefReportPlugin extends JavaPlugin {

    private static GriefReportPlugin instance;
    public static FileConfiguration config;


    @Override
    public void onEnable() {
        instance = this;
        new grief();
        new grief_list();
        config = getConfig();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }

    public static GriefReportPlugin GetInstance() {
        return instance;
    }
}
