package net.boybacks.superhardcore.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onRepair implements Listener {

  @EventHandler
  public void onAnvilRepair(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    if (event.getInventory().getType() == InventoryType.ANVIL) {
      if (!event.getCurrentItem().hasItemMeta()) {
        return;
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equals(fix("&6&lSacrifice Dagger"))) {
        event.setCancelled(true);
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 5.0f, 1.0f);
        player.sendMessage(fix("&cYou can't repair this item!"));
        event.getInventory().close();
      }
    }
  }
}
