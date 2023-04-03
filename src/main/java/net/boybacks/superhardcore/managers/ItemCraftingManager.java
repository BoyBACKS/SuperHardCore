package net.boybacks.superhardcore.managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class ItemCraftingManager {

  //TODO Wyczyścić kod z gówna

  //Custom function for sacrifice dagger - Turned off
  public static ItemStack createItem(Material material, int amount, int data, String displayName, short durability, boolean attribute) {
    ItemStack itemStack = new ItemStack(material, amount, (short) data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(fix(displayName));
    itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", 0.1, AttributeModifier.Operation.ADD_NUMBER));
    itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    itemStack.setItemMeta(itemMeta);
    itemStack.setDurability(durability);
    return itemStack;
  }

  public static ItemStack createItem(Material material, int amount, int data, String displayName, ArrayList<String> lore,  ArrayList<Enchantment> enchantments, ArrayList<Integer> level) {
    ItemStack itemStack = new ItemStack(material, amount, (short) data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(fix(displayName));
    if (lore != null) {
      for (int i = 0; i < lore.size(); i++) {
        itemMeta.setLore(lore);
      }
    }
    itemStack.setItemMeta(itemMeta);
    for (int i = 0; i < enchantments.size(); i++) {
      itemStack.addUnsafeEnchantment(enchantments.get(i), level.get(i));
    }
    return itemStack;
  }

  public static ItemStack createItem(Material material, int amount, int data, String displayName, ArrayList<String> lore,  boolean glowing) {
    ItemStack itemStack = new ItemStack(material, amount, (short) data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(fix(displayName));
    if (lore != null) {
      for (int i = 0; i < lore.size(); i++) {
        itemMeta.setLore(lore);

      }
    }
    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    itemStack.setItemMeta(itemMeta);
    if (glowing) {
      itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
    }
    return itemStack;
  }

  public static ItemStack createItem(Material material, int amount, int data, String displayName, ArrayList<String> lore) {
    ItemStack itemStack = new ItemStack(material, amount, (short) data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(fix(displayName));
    if (lore != null) {
      for (int i = 0; i < lore.size(); i++) {
        itemMeta.setLore(lore);
      }
    }
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack createItem(Material material, int amount, int data, String displayName) {
    ItemStack itemStack = new ItemStack(material, amount, (short) data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(fix(displayName));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static ItemStack createItem(Material material, int amount, int data) {
    ItemStack itemStack = new ItemStack(material, amount, (short) data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }



  /* Potion Section */

  public static ItemStack createPotion(Material potionMaterial, PotionType potionType, boolean extended, boolean upgraded) {
    ItemStack itemStack = new ItemStack(potionMaterial);
    PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();
    potionMeta.setBasePotionData(new PotionData(potionType, extended, upgraded));
    itemStack.setItemMeta(potionMeta);
    return itemStack;
  }

  public static ItemStack createPotion(Material potionMaterial, PotionType potionType) {
    ItemStack itemStack = new ItemStack(Material.POTION);
    PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();
    potionMeta.setBasePotionData(new PotionData(potionType));
    itemStack.setItemMeta(potionMeta);
    return itemStack;
  }

  /* Recipe Block Section */

  public static void removeDefaultCraft(ItemStack item) {
    Iterator<Recipe> it = Bukkit.getServer().recipeIterator();
    while (it.hasNext()) {
      ItemStack result = it.next().getResult();
      if (result.isSimilar(item)) {
        it.remove();
        return;
      }
    }
  }
}
