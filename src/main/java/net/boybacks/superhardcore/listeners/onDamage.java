package net.boybacks.superhardcore.listeners;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import net.boybacks.superhardcore.managers.RandomizerManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onDamage implements Listener {

  @EventHandler
  public void onEnemyTakeDamage(EntityDamageByEntityEvent event) {
    Entity entity = event.getEntity();
    Player player = (Player) event.getDamager();
    if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&c&lSacrifice Dagger"))) {

      ItemStack rippedHeart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE, 1).setTitle("&c&lRipped Heart").addGlow().toItemStack();

      //TODO Naprwaić problem błędów
      if (entity instanceof Player) {
        if (RandomizerManager.randomizer(100)) { // 10.0%
          player.getInventory().addItem(rippedHeart);
        }
      }
      else {
        if (RandomizerManager.randomizer(25)) { // 2.5%
          player.getInventory().addItem(rippedHeart);
        }
      }
    }
  }
}
