package me.raydond123.pexchatutils;

import me.raydond123.pexchatutils.commands.Prefix;
import me.raydond123.pexchatutils.commands.Suffix;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PexChatUtils extends JavaPlugin {

    public Logger logger = Logger.getLogger("Minecraft");

    Prefix prefix;
    Suffix suffix;

    public void onEnable() {

        logger.info("[PexChatUtils] The plugin has been enabled!");

        setupChat();

        prefix = new Prefix(this);
        suffix = new Suffix(this);

        getCommand("prefix").setExecutor(prefix);
        getCommand("suffix").setExecutor(suffix);

    }

    public void onDisable() {

        logger.info("[PexChatUtils] The plugin has been disabled!");

    }

    public static Chat chat = null;

    private boolean setupChat() {

        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);

    }

}
