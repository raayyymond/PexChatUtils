package me.raydond123.pexchatutils.utils;

import me.raydond123.pexchatutils.PexChatUtils;

public class WordChecker {

    PexChatUtils plugin;

    public WordChecker(PexChatUtils plugin) {

        this.plugin = plugin;

    }

    public boolean wordIsBanned(String word) {

        for(String bannedWord : plugin.getWords().getStringList("banned-words")) {

            if(word.contains(bannedWord)) return true;

        }

        return false;

    }

}
