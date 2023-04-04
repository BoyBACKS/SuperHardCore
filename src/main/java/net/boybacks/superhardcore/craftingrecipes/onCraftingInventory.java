package net.boybacks.superhardcore.craftingrecipes;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import net.boybacks.superhardcore.managers.ItemCraftingManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onCraftingInventory {

  public static void craftingInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 27, fix("&3&lItems Recipes"));

    ItemStack crystal = ItemCraftingManager.createItem(Material.EMERALD, 1, 0, "&d&lCrystal");
    inventory.setItem(10, crystal);

    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.BLACK_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    player.openInventory(inventory);
  }
}
