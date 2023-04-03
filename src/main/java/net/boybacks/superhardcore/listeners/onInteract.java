package net.boybacks.superhardcore.listeners;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onInteract implements Listener {

  @EventHandler
  public void onItemInteract(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    PlayerInventory playerInventory = player.getInventory();
    if (event.getAction() != Action.RIGHT_CLICK_AIR) {
      return;
    }
    if (playerInventory.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&c&lRipped Heart"))) {
      double health = player.getMaxHealth();
      if (health == 30) {
        player.sendMessage("&cYour health has reached its maximum level!");
        return;
      }
      if (health == 29) {
        health++;
      }
      else {
        health += 2;
      }
      player.setMaxHealth(health);
      Bukkit.broadcastMessage(fix("Player " + player.getDisplayName() + " used &c&lRipped Heart"));
      ItemStack itemStack = playerInventory.getItemInHand();
      removeOne(playerInventory, itemStack);
      for (Player allPlayers : Bukkit.getOnlinePlayers())
      {
        allPlayers.playSound(allPlayers.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 3.0f, 0.6f);
      }
    }
  }

  public static void removeOne(Inventory inventory, ItemStack item) {
    int size = inventory.getSize();
    for (int i = 0; i < size; i ++) {
      ItemStack other = inventory.getItem(i);
      if (item.isSimilar(other)) {
        int amount = other.getAmount();
        if (amount > 1) {
          other.setAmount(amount - 1);
        } else {
          other = null;
        }
        inventory.setItem(i, other);
        break;
      }
    }
  }
}
