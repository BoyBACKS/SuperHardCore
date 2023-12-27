package net.boybacks.superhardcore.recipes.items.craftable;

import lombok.Getter;
import net.boybacks.superhardcore.recipes.handlers.onCraftingInventory;
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

public class Heart implements Listener {

  @Getter static ItemStack heart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lHeart").addLoreLine("&8Custom Item").toItemStack();

  public static void onInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &c&lHeart"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    ItemStack heartChunk = new ItemBuilderManager(Material.SPIDER_EYE).setTitle("&c&lHeart Chunk").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(10, heartChunk);
    inventory.setItem(11, heartChunk);
    inventory.setItem(12, heartChunk);
    inventory.setItem(19, heartChunk);
    inventory.setItem(21, heartChunk);
    inventory.setItem(28, heartChunk);
    inventory.setItem(29, heartChunk);
    inventory.setItem(30, heartChunk);

    ItemStack soulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lSoul Vial").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(20, soulVial);

    ItemStack heart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lHeart").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(24, heart);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &c&lHeart"))) {
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
