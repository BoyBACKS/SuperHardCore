package net.boybacks.superhardcore.craftingrecipes;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onCraftingInventory {

  public static void craftingInventory(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 36, fix("&3&lItems Recipes"));

    ItemStack saddle = new ItemBuilderManager(Material.SADDLE).toItemStack();
    inventory.setItem(10, saddle);

    ItemStack crystal = new ItemBuilderManager(Material.EMERALD).setTitle("&d&lCrystal").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(11, crystal);

    ItemStack infusedCrystal = new ItemBuilderManager(Material.EMERALD).setTitle("&d&lInfused Crystal").addLoreLine("&8Custom Item").addGlow().toItemStack();
    inventory.setItem(12, infusedCrystal);

    ItemStack rippedHeart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lRipped Heart").addLoreLine("&8Custom Item").addGlow().toItemStack();
    inventory.setItem(13, rippedHeart);

    ItemStack totemOfUndying = new ItemStack(Material.TOTEM_OF_UNDYING);
    inventory.setItem(14, totemOfUndying);

    ItemStack charlieHeart = new ItemBuilderManager(Material.FEATHER).setTitle("&8&k&lCharlie Heart").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(16, charlieHeart);

    ItemStack info = new ItemBuilderManager(Material.KNOWLEDGE_BOOK).setTitle("&3&lDon't see the textures?").addLoreLine("&fClick here to see tutorial").toItemStack();
    inventory.setItem(35, info);

    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.WHITE_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }

    player.openInventory(inventory);
  }
}
