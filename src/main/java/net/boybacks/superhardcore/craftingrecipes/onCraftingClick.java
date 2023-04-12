package net.boybacks.superhardcore.craftingrecipes;

import net.boybacks.superhardcore.craftingrecipes.items.*;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onCraftingClick implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lItems Recipes"))) {
      event.setCancelled(true);
      Player player = (Player) event.getWhoClicked();
      if (event.getCurrentItem() == null) {
        return;
      }
      if (event.getCurrentItem().getType() == Material.SADDLE) {
        Saddle.onSaddleInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&d&lCrystal"))) {
        Crystal.onCrystalInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&d&lInfused Crystal"))) {
        InfusedCrystal.onInfusedCrystalInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&c&lRipped Heart"))) {
        RippedHeart.onRippedHeartInventory(player);
      }
      if (event.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING) {
        TotemOfUndying.onCrystalInventory(player);
      }
      if (event.getCurrentItem().getType() == Material.KNOWLEDGE_BOOK) {
        TextComponent message = new TextComponent(fix("&3Click here to see more info about Texture Pack"));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki#texture-pack"));
        player.spigot().sendMessage(message);
      }
    }
  }
}
