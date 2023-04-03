package net.boybacks.superhardcore.listeners;

import net.boybacks.tempbanapi.TempBan;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;

import static net.boybacks.superhardcore.Main.main;

public class onJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
      Player player = event.getPlayer();

      BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
      scheduler.scheduleSyncDelayedTask(main, new Runnable() {
        @Override
        public void run() {
          if(TempBan.isBanned(player)) {
            if(TempBan.getBanTime(player) <= System.currentTimeMillis()) {
              TempBan.unbanPlayer(player);
              player.setMaxHealth(10);
            } else {
              TempBan.sendBanScreen(player);
            }
          }
        }
      }, 5);
    }
}
