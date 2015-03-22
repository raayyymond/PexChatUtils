package me.raydond123.pexchatutils.commands;

import me.raydond123.pexchatutils.PexChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuffixPrefixRemove implements CommandExecutor {

    PexChatUtils plugin;

    public SuffixPrefixRemove(PexChatUtils plugin) {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (cmd.getLabel().equalsIgnoreCase("removeprefix")) {

                if(player.hasPermission("pexchatutils.removeprefix")) {

                    if (args.length == 1) {

                        Player player1 = Bukkit.getPlayer(args[0]);

                        if (player1 != null) {

                            plugin.chat.setPlayerPrefix(player1, "");
                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + player1.getName() + "'s prefix has been removed!");

                        } else {

                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + args[0] + " is not online!");

                        }

                    } else if (args.length == 0) {

                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "Correct Usage: /removeprefix [player]");

                    }

                } else {

                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "You do not have permissions to run this command!");

                }

            } else if(cmd.getLabel().equalsIgnoreCase("removesuffix")) {

                if (player.hasPermission("pexchatutils.removesuffix")) {

                    if (args.length == 1) {

                        Player player1 = Bukkit.getPlayer(args[0]);

                        if (player1 != null) {

                            plugin.chat.setPlayerSuffix(player1, "");
                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + player1.getName() + "'s suffix has been removed!");

                        } else {

                            player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + args[0] + " is not online!");

                        }

                    } else if (args.length == 0) {

                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "Correct Usage: /removesuffix [player]");

                    }

                }

            }

        } else {

            plugin.logger.info("[PexChatUtils] That command can only be used by a player!");

        }

        return false;

    }

}
