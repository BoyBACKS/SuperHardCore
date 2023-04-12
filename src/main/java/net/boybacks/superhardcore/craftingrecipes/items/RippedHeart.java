package net.boybacks.superhardcore.craftingrecipes.items;

import net.boybacks.superhardcore.craftingrecipes.onCraftingInventory;
import net.boybacks.superhardcore.managers.ItemBuilderManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class RippedHeart implements Listener {

  public static void onRippedHeartInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &c&lRipped Heart"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    ItemStack infusedCrystal = new ItemBuilderManager(Material.EMERALD).setTitle("&d&lInfused Crystal").addLoreLine("&8Custom Item").addGlow().toItemStack();
    inventory.setItem(10, infusedCrystal);
    inventory.setItem(12, infusedCrystal);
    inventory.setItem(28, infusedCrystal);
    inventory.setItem(30, infusedCrystal);

    ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
    inventory.setItem(11, goldIngot);
    inventory.setItem(19, goldIngot);
    inventory.setItem(21, goldIngot);
    inventory.setItem(29, goldIngot);

    ItemStack heart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lHeart").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(20, heart);

    ItemStack rippedHeart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lRipped Heart").addLoreLine("&8Custom Item").addGlow().toItemStack();
    inventory.setItem(24, rippedHeart);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onRippedHeartClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &c&lRipped Heart"))) {
      event.setCancelled(true);
      Player player = (Player) event.getWhoClicked();
      if (event.getCurrentItem() == null) {
        return;
      }
      if (event.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
        onCraftingInventory.craftingInventory(player);
      }
    }
  }
}
