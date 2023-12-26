package net.boybacks.superhardcore.craftingrecipes.items;

import net.boybacks.superhardcore.craftingrecipes.handlers.onCraftingInventory;
import net.boybacks.superhardcore.managers.ItemBuilderManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;

import static net.boybacks.superhardcore.managers.ChatManager.fix;


public class SacrificeDagger implements Listener {

  public static void onInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &6&lSacrifice Dagger"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }
    ItemStack air = new ItemStack(Material.AIR);
    inventory.setItem(10, air);
    inventory.setItem(19, air);
    inventory.setItem(29, air);
    inventory.setItem(30, air);

    ItemStack gold = new ItemStack(Material.GOLD_INGOT);
    inventory.setItem(12, gold);
    inventory.setItem(20, gold);

    ItemStack stick = new ItemStack(Material.STICK);
    inventory.setItem(28, stick);

    ItemStack potion = new ItemBuilderManager(Material.POTION).setPotionType(PotionType.POISON, false, true).toItemStack();
    inventory.setItem(11, potion);
    inventory.setItem(21, potion);

    ItemStack dagger = new ItemBuilderManager(Material.GOLDEN_SWORD).setTitle("&6&lSacrifice Dagger").addLoreLine("&8Custom Item").setDurability((short) 22).toItemStack();
    inventory.setItem(24, dagger);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &6&lSacrifice Dagger"))) {
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
