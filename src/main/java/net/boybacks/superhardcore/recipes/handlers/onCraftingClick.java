package net.boybacks.superhardcore.recipes.handlers;

import net.boybacks.superhardcore.recipes.items.craftable.*;
import net.boybacks.superhardcore.recipes.items.craftable.vanilla.Saddle;
import net.boybacks.superhardcore.recipes.items.craftable.vanilla.TotemOfUndying;
import net.boybacks.superhardcore.recipes.items.smeltable.DiamondNugget;
import net.md_5.bungee.api.chat.ClickEvent;
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
        Saddle.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&d&lCrystal"))) {
        Crystal.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&d&lInfused Crystal"))) {
        InfusedCrystal.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&c&lRipped Heart"))) {
        RippedHeart.onInventory(player);
      }
      if (event.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING) {
        TotemOfUndying.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&b&lDiamond Nugget"))) {
        DiamondNugget.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&b&lEmpty Soul Vial"))) {
        EmptySoulVial.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&b&lSoul Vial"))) {
        SoulVial.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&c&lHeart"))) {
        Heart.onInventory(player);
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(fix("&6&lSacrifice Dagger"))) {
        SacrificeDagger.onInventory(player);
      }
      if (event.getCurrentItem().getType() == Material.KNOWLEDGE_BOOK) {
        TextComponent message = new TextComponent(fix("&3Click here to see more info about Texture Pack"));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki#texture-pack"));
        player.spigot().sendMessage(message);
      }
    }
  }
}
