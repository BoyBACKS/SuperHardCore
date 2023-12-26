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

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class SoulVial implements Listener {

  public static void onInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 45, fix("&3&lRecipe: &b&lSoul Vial"));
    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    ItemStack diamondNugget = new ItemBuilderManager(Material.IRON_NUGGET).setTitle("&b&lDiamond Nugget").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(11, diamondNugget);

    ItemStack wildSoul = new ItemBuilderManager(Material.FEATHER, 1).setTitle("&b&lWild Soul").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(10, wildSoul);
    inventory.setItem(12, wildSoul);
    inventory.setItem(19, wildSoul);
    inventory.setItem(21, wildSoul);
    inventory.setItem(28, wildSoul);
    inventory.setItem(29, wildSoul);
    inventory.setItem(30, wildSoul);

    ItemStack emptySoulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lEmpty Soul Vial").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(20, emptySoulVial);

    ItemStack soulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lSoul Vial").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(24, soulVial);

    ItemStack exit = new ItemBuilderManager(Material.RED_STAINED_GLASS_PANE).setTitle("&c&lBack").toItemStack();
    inventory.setItem(40, exit);

    player.openInventory(inventory);
  }

  @EventHandler
  public static void onClick(InventoryClickEvent event) {
    if (event.getClickedInventory() == null) {
      return;
    }
    if (event.getView().getTitle().equalsIgnoreCase(fix("&3&lRecipe: &b&lSoul Vial"))) {
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
