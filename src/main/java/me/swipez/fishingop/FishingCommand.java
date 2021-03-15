package me.swipez.fishingop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FishingCommand implements CommandExecutor {

    FishingOP plugin;

    public FishingCommand(FishingOP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (sender.hasPermission("opfishing.trigger")){
                if (args.length == 1){
                    if (args[0].equals("start")){
                        plugin.gamestarted = true;
                        Bukkit.broadcastMessage(ChatColor.GREEN+"OP Fishing challenge has started!");
                    }
                    else if (args[0].equals("stop")){
                        plugin.gamestarted = false;
                        Bukkit.broadcastMessage(ChatColor.GREEN+"OP Fishing challenge has ended!");
                    }
                    else if (args[0].equals("reload")){
                        plugin.reloadConfig();
                        p.sendMessage(ChatColor.GREEN+"Config Reloaded!");
                    }
                    else if (!args[0].equals("start") && !args[0].equals("stop")){
                        p.sendMessage(ChatColor.RED+"/fishingop <start/stop/reload>");
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED+"/fishingop <start/stop/reload>");
                }
            }
            else {
                p.sendMessage(ChatColor.RED+"You do not have the permission to run this command!");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED+"This command is for players only!");
        }
        return true;
    }
}
