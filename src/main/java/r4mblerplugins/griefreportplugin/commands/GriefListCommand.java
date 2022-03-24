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


public class GriefListCommand extends AbstractCommand {

    public GriefListCommand() {
        super("grief-list");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {

        System.out.print(args[0]);
       // Player player = (Player) sender;

     /*   if (args[0]==null) {
               player.sendMessage("Список грифов:");
            for (ItemGrief item : GriefList.List) {
                String command = "/tp " + sender.getName() + " " + item.location.getX() + " " + item.location.getY() + " " + item.location.getZ() + " ";
                TextComponent component = new TextComponent("Игрок: ");
                TextComponent _name = new TextComponent(item.PlayerName);
                _name.setColor(ChatColor.GOLD);
                component.addExtra(_name);
                TextComponent component1 = new TextComponent(" Подробности грифа: ");
                component.addExtra(component1);
                TextComponent reason= new TextComponent(item.Reason);
                reason.setColor(ChatColor.GOLD);
                component.addExtra(reason);
                TextComponent cordinates = new TextComponent(" [ТЕЛЕПОРТ]");
                cordinates.setColor(ChatColor.GREEN);
                cordinates.setBold(true);
                cordinates.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
                cordinates.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Кликните для телепорта").color(ChatColor.ITALIC).create()));
                component.addExtra(cordinates);
                player.spigot().sendMessage(component);
            }
            return;
        }

        if (GriefList.List.size()==0)
        {
            player.sendMessage(ChatColor.RED+"Список грифов пуст");
            return;
        }
        else if (args[0].equals("remove"))
        {
            try {
                GriefList.List.remove(Integer.parseInt(args[1])-1);
                player.sendMessage(ChatColor.GREEN+"Гриф удалён из списка");
            } catch (Throwable t)
            {
                player.sendMessage(ChatColor.RED+"Неверно указан ID грифа");
            }
        }*/
    }
}
