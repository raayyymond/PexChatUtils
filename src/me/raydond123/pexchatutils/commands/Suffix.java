package me.raydond123.pexchatutils.commands;

import me.raydond123.pexchatutils.PexChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Suffix implements CommandExecutor {

    PexChatUtils plugin;

    public Suffix(PexChatUtils plugin) {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(args.length == 1) {

                if(player.hasPermission("pexchatutils.suffix")) {

                    String suffix = args[0];

                    if(!plugin.wordChecker.wordIsBanned(suffix)) {

                        plugin.chat.setPlayerSuffix(player, suffix);
                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "Your suffix has been changed to " + ChatColor.translateAlternateColorCodes('&', suffix) + ChatColor.LIGHT_PURPLE + ".");

                    } else {

                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "A word in that suffix is banned!");

                    }

                } else {

                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "You do not have permission to run this command!");

                }

            } else if(args.length == 2) {

                if(player.hasPermission("pexchatutils.suffix.others")) {

                    String otherPlayer = args[0];
                    String suffix = args[1];

                    Player otherPlayer1 = Bukkit.getPlayer(otherPlayer);

                    if(otherPlayer1 != null) {

                        plugin.chat.setPlayerSuffix(otherPlayer1, suffix);
                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + otherPlayer + "'s suffix has been changed to " + ChatColor.translateAlternateColorCodes('&', suffix) + ChatColor.LIGHT_PURPLE + ".");

                    } else {

                        player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + otherPlayer + " is not online!");

                    }

                } else {

                    player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "You do not have permission to run this command!");

                }

            } else {

                player.sendMessage(ChatColor.BLUE + "[" + ChatColor.LIGHT_PURPLE + "PexChatUtils" + ChatColor.BLUE + "] " + ChatColor.LIGHT_PURPLE + "Correct Usage: /suffix [suffix] | /suffix [player] [suffix]");

            }

        } else {

            plugin.logger.info("This command can only be run by a player!");

        }

        return false;

    }

}
