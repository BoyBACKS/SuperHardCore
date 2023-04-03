package net.boybacks.superhardcore.update;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onUpdateClick implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&4&lChange Log"))) {
      //Player player = (Player) event.getWhoClicked();
      if (event.getCurrentItem() == null) {
        return;
      }
      if (event.getCurrentItem().getType() != Material.WRITTEN_BOOK) {
        event.setCancelled(true);
      }
    }
  }
}
