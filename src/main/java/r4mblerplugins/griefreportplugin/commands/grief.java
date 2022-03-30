package r4mblerplugins.griefreportplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import r4mblerplugins.griefreportplugin.classes.GriefList;
import r4mblerplugins.griefreportplugin.classes.ItemGrief;

public class grief extends AbstractCommand {

    public grief() {
        super("grief");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("GriefReportPlugin.SendGriefMessage"))
        {
            player.sendMessage(ChatColor.RED + "you don't have permission");
            return;
        }
        String name= player.getName();
        Location location = player.getLocation();
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "write a reason");
            return;
        }

        String Reason = String.join(" ", args);
        ItemGrief Item = new ItemGrief(name, location, Reason);
        GriefList.List.add(Item);
        sender.sendMessage(ChatColor.GOLD+"grief message send");
    }
}
