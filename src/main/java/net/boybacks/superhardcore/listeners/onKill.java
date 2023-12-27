package net.boybacks.superhardcore.listeners;

import net.boybacks.superhardcore.recipes.items.droppable.HeartChunk;
import net.boybacks.superhardcore.recipes.items.droppable.WildSoul;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;
import static net.boybacks.superhardcore.managers.RandomizerManager.randomizer;

public class onKill implements Listener {

  @EventHandler
  public void onMobKill(EntityDeathEvent event) {
    EntityType entityType = event.getEntity().getType();

    if (entityType.equals(EntityType.WITCH)) {
      event.getDrops().removeIf(item -> item.getType() == Material.SPIDER_EYE);
    }

    if (entityType.equals(EntityType.SPIDER) || entityType.equals(EntityType.CAVE_SPIDER)) {
      event.getDrops().remove(new ItemStack(Material.SPIDER_EYE));
      if (randomizer(50)) {
        event.getDrops().add(new ItemStack(Material.SPIDER_EYE));
      }
    }


    if (event.getEntity().getKiller() instanceof Player) {
      Player player = event.getEntity().getKiller();
      ItemStack heldItem = player.getInventory().getItemInMainHand();
      if (event.getEntity().getName().equals(fix("&c&lCharlie's Minion"))) {
        if (randomizer(400)) {
          event.getDrops().add(WildSoul.getWildSoul());
        }
      }

      if (heldItem.getItemMeta() == null) {
        return;
      }
      if (heldItem.getItemMeta().getDisplayName().equals(fix("&6&lSacrifice Dagger"))) {
        if (randomizer(20)) {
          event.getDrops().add(WildSoul.getWildSoul());
        }
      }
    }
  }
}
