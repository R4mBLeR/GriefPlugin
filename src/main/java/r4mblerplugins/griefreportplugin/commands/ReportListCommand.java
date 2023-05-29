package r4mblerplugins.griefreportplugin.commands;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import r4mblerplugins.griefreportplugin.GriefReportPlugin;
import r4mblerplugins.griefreportplugin.classes.Report;

import java.util.List;

public class ReportListCommand extends AbstractCommand {

    public ReportListCommand() {
        super("reportlist");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("GriefReportPlugin.ReportsManage")) {
            player.sendMessage(GriefReportPlugin.config.getString("messages.noperm-message"));
            return;
        }
        if (GriefReportPlugin.griefs.size() == 0) {
            player.sendMessage(GriefReportPlugin.config.getString("messages.empty-list-message"));
            return;
        }
        if (args.length == 0) {
            player.sendMessage(GriefReportPlugin.config.getString("messages.list-message") + ":");
            for (Report item : GriefReportPlugin.griefs) {
                String command = "/tp " + sender.getName() + " " + item.x + " " + item.y + " " + item.z + " ";
                TextComponent component = new TextComponent(GriefReportPlugin.config.getString("list-info.sender") + ": ");
                TextComponent _name = new TextComponent(item.PlayerName);
                _name.setColor(ChatColor.GOLD);
                component.addExtra(_name);
                TextComponent component1 = new TextComponent(GriefReportPlugin.config.getString("list-info.details") + ": ");
                component.addExtra(component1);
                TextComponent reason = new TextComponent(item.Reason);
                reason.setColor(ChatColor.GOLD);
                component.addExtra(reason);
                TextComponent cordinates = new TextComponent(" " + GriefReportPlugin.config.getString("list-info.teleport"));
                cordinates.setColor(ChatColor.GREEN);
                cordinates.setBold(true);
                cordinates.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
                cordinates.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(GriefReportPlugin.config.getString("list-info.click-message")).color(ChatColor.ITALIC).create()));
                component.addExtra(cordinates);
                player.spigot().sendMessage(component);
            }
        } else {
            if (args[0].equals("remove")) {
                try {
                    int i = Integer.parseInt(args[1]) - 1;
                    GriefReportPlugin.griefs.remove(i);
                    player.sendMessage(GriefReportPlugin.config.getString("messages.report-delete-message"));
                } catch (Throwable t) {
                    player.sendMessage(GriefReportPlugin.config.getString("messages.incorrect-id-message"));
                }
                return;
            }
            if (args[0].equals("clear")) {
                Gson gson = new Gson();
                String json = gson.toJson(GriefReportPlugin.griefs);
                player.sendMessage(json);
                GriefReportPlugin.griefs.clear();
                player.sendMessage(GriefReportPlugin.config.getString("messages.clear-list-message"));
                return;
            }
            player.sendMessage(GriefReportPlugin.config.getString("messages.incorrect-command-message"));
        }

    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if (args.length == 1) return Lists.newArrayList("remove", "clear");
        return Lists.newArrayList();
    }
}
