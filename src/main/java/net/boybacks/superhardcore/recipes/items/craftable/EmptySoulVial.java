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

public class EmptySoulVial implements Listener {

  @Getter static ItemStack emptySoulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lEmpty Soul Vial").addLoreLine("&8Custom Item").toItemStack();

  public static void onInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &b&lEmpty Soul Vial"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    ItemStack glassBottle = new ItemStack(Material.GLASS_BOTTLE);
    inventory.setItem(20, glassBottle);

    ItemStack diamondNugget = new ItemBuilderManager(Material.IRON_NUGGET).setTitle("&b&lDiamond Nugget").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(10, diamondNugget);
    inventory.setItem(11, diamondNugget);
    inventory.setItem(12, diamondNugget);
    inventory.setItem(19, diamondNugget);
    inventory.setItem(21, diamondNugget);
    inventory.setItem(28, diamondNugget);
    inventory.setItem(29, diamondNugget);
    inventory.setItem(30, diamondNugget);

    ItemStack emptySoulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lEmpty Soul Vial").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(24, emptySoulVial);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &b&lEmpty Soul Vial"))) {
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
