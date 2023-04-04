package net.boybacks.superhardcore.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;

import static org.bukkit.potion.PotionEffectType.NIGHT_VISION;

public class onMove implements Listener {

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent e) {
    Player player = e.getPlayer();
    Location location = player.getLocation();
    int light = location.getBlock().getLightLevel();
    PotionEffect effect = player.getPotionEffect(NIGHT_VISION);
    if (light < 8) {
      if (player.getInventory().getItemInHand().getType().equals(Material.TORCH)) {
        return;
      }
      else if (player.getInventory().getItemInOffHand().getType() == Material.TORCH) {
        return;
      }
      else if (effect != null) {
        return;
      }
      player.damage(1);
    }
  }
}
