package r4mblerplugins.griefreportplugin;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import r4mblerplugins.griefreportplugin.classes.ItemGrief;
import r4mblerplugins.griefreportplugin.commands.grief;
import r4mblerplugins.griefreportplugin.commands.grief_list;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public final class GriefReportPlugin extends JavaPlugin {

    private static GriefReportPlugin instance;
    public static FileConfiguration config;
    public static List<ItemGrief> griefs;
    private File file;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Override
    public void onEnable() {
        instance = this;
        new grief();
        new grief_list();
        config = getConfig();
        saveDefaultConfig();
        file = new File(getDataFolder(), "list.json");
        try {
            if (!file.exists()) file.createNewFile();
            Type listType = new TypeToken<ArrayList<ItemGrief>>() {
            }.getType();
            griefs = gson.fromJson(new FileReader(file), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (griefs == null) griefs = new ArrayList<>();
    }


    @Override
    public void onDisable() {
        if (griefs != null) {
            file.delete();
            String json = gson.toJson(griefs);
            try {
                Files.write(file.toPath(), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static GriefReportPlugin GetInstance() {
        return instance;
    }
}
