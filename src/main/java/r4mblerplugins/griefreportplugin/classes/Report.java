package r4mblerplugins.griefreportplugin.classes;

import org.bukkit.Location;


public class Report {
    public double x;
    public double y;
    public double z;
    public String PlayerName;
    public String Reason;

    public Report(String name, Location locale, String reason) {
        this.PlayerName = name;
        this.x = locale.getX();
        this.y = locale.getY();
        this.z = locale.getZ();
        this.Reason = reason;
    }

}

