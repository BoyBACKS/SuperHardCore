package net.boybacks.superhardcore.recipes.items.craftable.vanilla;

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

public class Saddle implements Listener {

  @Getter static ItemStack saddle = new ItemStack(Material.SADDLE);

  public static void onInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &8Saddle"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }
    ItemStack air = new ItemStack(Material.AIR);
    inventory.setItem(20, air);
    inventory.setItem(29, air);

    ItemStack leather = new ItemStack(Material.LEATHER);
    inventory.setItem(10, leather);
    inventory.setItem(11, leather);
    inventory.setItem(12, leather);

    ItemStack copper = new ItemStack(Material.COPPER_INGOT);
    inventory.setItem(19, copper);
    inventory.setItem(21, copper);

    ItemStack tripwireHook = new ItemStack(Material.TRIPWIRE_HOOK);
    inventory.setItem(28, tripwireHook);
    inventory.setItem(30, tripwireHook);

    ItemStack saddle = new ItemStack(Material.SADDLE);
    inventory.setItem(24, saddle);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &8Saddle"))) {
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
