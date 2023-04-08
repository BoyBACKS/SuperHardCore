package net.boybacks.superhardcore.craftingrecipes;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onCraftingInventory {

  public static void craftingInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 27, fix("&3&lItems Recipes"));

    ItemStack saddle = new ItemBuilderManager(Material.SADDLE, 1).toItemStack();
    inventory.setItem(10, saddle);

    ItemStack crystal = new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lCrystal").toItemStack();
    inventory.setItem(11, crystal);

    ItemStack infusedCrystal = new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lInfused Crystal").addGlow().toItemStack();
    inventory.setItem(12, infusedCrystal);

    ItemStack rippedHeart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE, 1).setTitle("&c&lRipped Heart").addGlow().toItemStack();
    inventory.setItem(13, rippedHeart);

    ItemStack totemOfUndying = new ItemStack(Material.TOTEM_OF_UNDYING);
    inventory.setItem(14, totemOfUndying);

    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    player.openInventory(inventory);
  }
}
