package net.boybacks.superhardcore.listeners;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.RandomizerManager.randomizer;

public class onKill implements Listener {

  @EventHandler
  public void onMobKill(EntityDeathEvent event) {
    EntityType entityType = event.getEntity().getType();

    if (entityType.equals(EntityType.WARDEN)) {
      if (randomizer(300)) { // 30.0%
        ItemStack heart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE, 1).setTitle("&c&lRipped Heart").addGlow().toItemStack();
        event.getDrops().add(heart);
      }
    }
  }
}
