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

public class TotemOfUndying implements Listener {

  public static void onCrystalInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &e&lTotem of Undying"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }
    ItemStack emerald = new ItemStack(Material.EMERALD);
    inventory.setItem(10, emerald);
    inventory.setItem(12, emerald);

    ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
    inventory.setItem(28, goldIngot);
    inventory.setItem(30, goldIngot);

    ItemStack rippedHeart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE, 1).setTitle("&c&lRipped Heart").addGlow().toItemStack();
    inventory.setItem(20, rippedHeart);

    ItemStack infusedCrystal = new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lInfused Crystal").addGlow().toItemStack();
    inventory.setItem(11, infusedCrystal);
    inventory.setItem(19, infusedCrystal);
    inventory.setItem(21, infusedCrystal);
    inventory.setItem(29, infusedCrystal);

    ItemStack totemOfUndying = new ItemBuilderManager(Material.TOTEM_OF_UNDYING, 1).toItemStack();
    inventory.setItem(24, totemOfUndying);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onRippedHeartClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &e&lTotem of Undying"))) {
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
