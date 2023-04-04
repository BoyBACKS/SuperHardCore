package net.boybacks.superhardcore.managers;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static net.boybacks.superhardcore.Main.main;

public class RecipesManager {

  public static void recipes() {
                                                                                                                //Wyjebane serce ~ Ebi <3
    ItemStack heart = ItemCraftingManager.createItem(Material.FERMENTED_SPIDER_EYE, 1, 0, "&c&lRipped Heart", null, true);
    ShapedRecipe heartRecipe = new ShapedRecipe(new NamespacedKey(main, "ripped-heart"), new ItemStack(heart));
    heartRecipe.shape("323", "212", "323");
    heartRecipe.setIngredient('1', Material.FERMENTED_SPIDER_EYE);
    heartRecipe.setIngredient('2', Material.GOLD_INGOT);
    heartRecipe.setIngredient('3', ItemCraftingManager.createItem(Material.EMERALD, 1, 0, "&d&lInfused Crystal", null, true));
    main.getServer().addRecipe(heartRecipe);

    ItemStack saddle = ItemCraftingManager.createItem(Material.SADDLE, 1, 0, "");
    ShapedRecipe saddleRecipe = new ShapedRecipe(new NamespacedKey(main, "saddle"), new ItemStack(saddle));
    saddleRecipe.shape("111", "2 2", "3 3");
    saddleRecipe.setIngredient('1', Material.LEATHER);
    saddleRecipe.setIngredient('2', Material.COPPER_INGOT);
    saddleRecipe.setIngredient('3', Material.TRIPWIRE_HOOK);
    main.getServer().addRecipe(saddleRecipe);

    ItemStack crystal = ItemCraftingManager.createItem(Material.EMERALD, 1, 0, "&d&lCrystal");
    ShapedRecipe crystalRecipe = new ShapedRecipe(new NamespacedKey(main, "crystal"), new ItemStack(crystal));
    crystalRecipe.shape("121", "131", "111");
    crystalRecipe.setIngredient('1', Material.REDSTONE);
    crystalRecipe.setIngredient('2', Material.EMERALD);
    crystalRecipe.setIngredient('3', Material.AMETHYST_SHARD);
    main.getServer().addRecipe(crystalRecipe);

    ItemStack infusedCrystal = ItemCraftingManager.createItem(Material.EMERALD, 1, 0, "&d&lInfused Crystal", null, true);
    ShapedRecipe infusedCrystalRecipe = new ShapedRecipe(new NamespacedKey(main, "infused-crystal"), new ItemStack(infusedCrystal));
    infusedCrystalRecipe.shape("121", "232", "141");
    infusedCrystalRecipe.setIngredient('1', Material.REDSTONE);
    infusedCrystalRecipe.setIngredient('2', Material.GUNPOWDER);
    infusedCrystalRecipe.setIngredient('3', ItemCraftingManager.createItem(Material.EMERALD, 1, 0, "&d&lCrystal"));
    infusedCrystalRecipe.setIngredient('4', Material.BLAZE_POWDER);
    main.getServer().addRecipe(infusedCrystalRecipe);

    // Currently, turned off
//    ItemStack dagger = ItemCraftingManager.createItem(Material.IRON_SWORD, 1, 0, "&c&lSacrifice Dagger", (short) 250.0, true);
//    ShapedRecipe daggerRecipe = new ShapedRecipe(new NamespacedKey(main, "sacrifice-dagger"), new ItemStack(dagger));
//    daggerRecipe.shape(" 12", " 21", "4  ");
//    daggerRecipe.setIngredient('1', ItemCraftingManager.createPotion(Material.POTION, PotionType.INSTANT_DAMAGE, false, true));
//    daggerRecipe.setIngredient('2', Material.IRON_INGOT);
//    daggerRecipe.setIngredient('4', Material.STICK);
//    main.getServer().addRecipe(daggerRecipe);
  }

  public static void removeBukkitRecipes() {
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.GOLDEN_APPLE));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_HELMET));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_CHESTPLATE));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_LEGGINGS));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_BOOTS));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_HELMET));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_CHESTPLATE));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_LEGGINGS));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_BOOTS));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_AXE));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_SWORD));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_PICKAXE));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_SHOVEL));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_HOE));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_INGOT));
    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_SCRAP));
//    ItemCraftingManager.removeDefaultCraft(new ItemStack(Material.));
  }
}
