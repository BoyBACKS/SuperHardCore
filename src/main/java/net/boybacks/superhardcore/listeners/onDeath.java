package net.boybacks.superhardcore.listeners;

import net.boybacks.tempbanapi.TempBan;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onDeath implements Listener {

  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent e) {
    Player player = e.getPlayer();
    double health = player.getMaxHealth();
    health -= 1;
    if (health == 0) {                                  // for now is 5 minutes
      TempBan.banPlayer(player, fix("&lYou have died!"), 1800);
      TempBan.sendBanScreen(player);
      return;
    }
    player.setMaxHealth(health);
  }
}
