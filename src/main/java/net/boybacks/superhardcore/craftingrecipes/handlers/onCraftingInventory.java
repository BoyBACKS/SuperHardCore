package net.boybacks.superhardcore.craftingrecipes.handlers;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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

    ItemStack diamondNugget = new ItemBuilderManager(Material.IRON_NUGGET).setTitle("&b&lDiamond Nugget").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(15, diamondNugget);

    ItemStack emptySoulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lEmpty Soul Vial").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(16, emptySoulVial);

    ItemStack soulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lSoul Vial").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(19, soulVial);

    ItemStack heart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lHeart").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(20, heart);

    ItemStack dagger = new ItemBuilderManager(Material.GOLDEN_SWORD).setTitle("&6&lSacrifice Dagger").addLoreLine("&8Custom Item").setDurability((short) 22).toItemStack();
    inventory.setItem(21, dagger);

    ItemStack charlieHeart = new ItemBuilderManager(Material.FEATHER).setTitle("&8&k&lCharlie Heart").addLoreLine("&8Custom Item").toItemStack();
    inventory.setItem(25, charlieHeart);

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
