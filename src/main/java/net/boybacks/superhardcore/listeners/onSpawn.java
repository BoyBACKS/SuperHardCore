package net.boybacks.superhardcore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.List;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onSpawn implements Listener {

  @EventHandler
  public void onMobSpawn(CreatureSpawnEvent event) {
    Damageable dam = event.getEntity();
    if (dam.getType().equals(EntityType.WARDEN)) {
      dam.setMaxHealth(750);
      dam.setHealth(750);
    }
    if (dam.getType().equals(EntityType.BLAZE)) {
      dam.setMaxHealth(40);
      dam.setHealth(40);
    }
  }

  @EventHandler
  public void onWardenSpawn(CreatureSpawnEvent event) {
    List<Entity> entityList = event.getEntity().getNearbyEntities(75, 75 , 75);
    boolean isWarden = false;
    boolean isWither = false;
    for (int i = 0; i < entityList.size(); i++) {
      if (entityList.get(i).getType().equals(EntityType.WARDEN)) {
        event.setCancelled(true);
        isWarden = true;
      }
      if (entityList.get(i).getType().equals(EntityType.WITHER)) {
        event.setCancelled(true);
        isWither = true;
      }
    }
    if (isWarden && event.getEntity().getType().equals(EntityType.WARDEN)) {
      Bukkit.broadcastMessage(fix("&3&lTHERE IS WARDEN NERBY"));
    }
    if (isWither && event.getEntity().getType().equals(EntityType.WITHER)) {
      Bukkit.broadcastMessage(fix("&c&lTHERE IS WITHER NERBY"));
    }
  }
}
