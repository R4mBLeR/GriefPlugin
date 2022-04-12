package r4mblerplugins.griefreportplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import r4mblerplugins.griefreportplugin.GriefReportPlugin;
import r4mblerplugins.griefreportplugin.classes.ItemGrief;

public class grief extends AbstractCommand {

    public grief() {
        super("grief");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("GriefReportPlugin.SendGriefMessage")) {
            player.sendMessage(GriefReportPlugin.config.getString("messages.noperm-message"));
            return;
        }
        String name = player.getName();
        Location location = player.getLocation();
        if (args.length == 0) {
            sender.sendMessage(GriefReportPlugin.config.getString("messages.reason-message"));
            return;
        }

        String Reason = String.join(" ", args);
        ItemGrief Item = new ItemGrief(name, location, Reason);
        GriefReportPlugin.griefs.add(Item);
        sender.sendMessage(GriefReportPlugin.config.getString("messages.grief-send-message"));
    }
}
