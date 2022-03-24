package r4mblerplugins.griefreportplugin.classes;

import org.bukkit.Location;


public class ItemGrief {
    public Location location;
    public String PlayerName;
    public String Reason;

    public ItemGrief(String name, Location locale, String reason) {
        this.PlayerName = name;
        this.location = locale;
        this.Reason = reason;
    }

}

