package r4mblerplugins.griefreportplugin.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import r4mblerplugins.griefreportplugin.classes.GriefList;
import r4mblerplugins.griefreportplugin.classes.ItemGrief;

public class grief_list extends AbstractCommand{

    public grief_list()
    {super("grieflist");}

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player= (Player) sender;
        if (!player.hasPermission("GriefReportPlugin.GriefListManage"))
        {
            player.sendMessage(org.bukkit.ChatColor.RED + "you don't have permission");
            return;
        }
        if (GriefList.List.size()==0)
        {
            player.sendMessage(ChatColor.RED+"grief list is empty");
            return;
        }
        if (args.length==0) {
            player.sendMessage("grief list:");
            for (ItemGrief item : GriefList.List) {
                String command = "/tp " + sender.getName() + " " + item.location.getX() + " " + item.location.getY() + " " + item.location.getZ() + " ";
                TextComponent component = new TextComponent("sender: ");
                TextComponent _name = new TextComponent(item.PlayerName);
                _name.setColor(ChatColor.GOLD);
                component.addExtra(_name);
                TextComponent component1 = new TextComponent("details: ");
                component.addExtra(component1);
                TextComponent reason= new TextComponent(item.Reason);
                reason.setColor(ChatColor.GOLD);
                component.addExtra(reason);
                TextComponent cordinates = new TextComponent(" [TELEPORT]");
                cordinates.setColor(ChatColor.GREEN);
                cordinates.setBold(true);
                cordinates.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
                cordinates.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("click to teleport").color(ChatColor.ITALIC).create()));
                component.addExtra(cordinates);
                player.spigot().sendMessage(component);
            }
        }
        else
        {
            if (args[0].equals("remove")) {
                try {
                    int i=Integer.parseInt(args[1])-1;
                    GriefList.List.remove(i);
                    player.sendMessage(ChatColor.GREEN + "grief delete from list");
                } catch (Throwable t) {
                    player.sendMessage(ChatColor.RED + "incorrect grief ID");
                }
                return;
            }
            if (args[0].equals("clear")) {
                    GriefList.List.clear();
                    player.sendMessage(ChatColor.GREEN + "grief list has been cleared");
                return;
            }
            player.sendMessage(ChatColor.RED + "incorrect command");
        }

    }
}
