package net.boybacks.superhardcore.managers;

import org.bukkit.ChatColor;

public class ChatManager {

  public static String fix(String msg) {
    return ChatColor.translateAlternateColorCodes('&', msg).replace("<<", "«").replace(">>", "»");
  }
}
