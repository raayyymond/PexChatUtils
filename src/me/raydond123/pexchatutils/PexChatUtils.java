package me.raydond123.pexchatutils;

import me.raydond123.pexchatutils.commands.Prefix;
import me.raydond123.pexchatutils.commands.Suffix;
import me.raydond123.pexchatutils.utils.WordChecker;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class PexChatUtils extends JavaPlugin {

    public Logger logger = Logger.getLogger("Minecraft");

    Prefix prefix;
    Suffix suffix;
    public WordChecker wordChecker;

    File wordsFile;
    YamlConfiguration words;

    public void onEnable() {

        logger.info("[PexChatUtils] The plugin has been enabled!");

        setupChat();

        prefix = new Prefix(this);
        suffix = new Suffix(this);
        wordChecker = new WordChecker(this);

        getCommand("prefix").setExecutor(prefix);
        getCommand("suffix").setExecutor(suffix);

        wordsFile = new File("plugins/PexChatUtils/words.yml");
        words = YamlConfiguration.loadConfiguration(wordsFile);

        saveWords();

    }

    public void onDisable() {

        logger.info("[PexChatUtils] The plugin has been disabled!");

    }

    public YamlConfiguration getWords() {

        return words;

    }

    public void saveWords() {

        if(wordsFile.exists()) {

            try {
                words.save(wordsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            List<String> list = words.getStringList("banned-words");
            list.clear();
            list.add("fuck");

            words.set("banned-words", list);

            try {
                words.save(wordsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

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
