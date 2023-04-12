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

public class InfusedCrystal implements Listener {

  public static void onInfusedCrystalInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &d&lInfused Crystal"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    ItemStack redstone = new ItemStack(Material.REDSTONE);
    inventory.setItem(10, redstone);
    inventory.setItem(12, redstone);
    inventory.setItem(28, redstone);
    inventory.setItem(30, redstone);

    ItemStack gunpowder = new ItemStack(Material.GUNPOWDER);
    inventory.setItem(11, gunpowder);
    inventory.setItem(19, gunpowder);
    inventory.setItem(21, gunpowder);

    ItemStack blazePowder = new ItemStack(Material.BLAZE_POWDER);
    inventory.setItem(29, blazePowder);

    ItemStack crystal = new ItemBuilderManager(Material.EMERALD).setTitle("&d&lCrystal").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(20, crystal);

    ItemStack infusedCrystal = new ItemBuilderManager(Material.EMERALD).setTitle("&d&lInfused Crystal").addLoreLine("&8Custom Item").addGlow().toItemStack();
    inventory.setItem(24, infusedCrystal);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onInfusedCrystalClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &d&lInfused Crystal"))) {
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
