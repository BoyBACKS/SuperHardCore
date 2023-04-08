package net.boybacks.superhardcore.managers;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static net.boybacks.superhardcore.Main.main;

public class RecipesManager {

  public static void recipes() {
                                                                                                                //Wyjebane serce ~ Ebi <3
    ItemStack heart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE, 1).setTitle("&c&lRipped Heart").addGlow().toItemStack();
    ShapedRecipe heartRecipe = new ShapedRecipe(new NamespacedKey(main, "ripped-heart"), new ItemStack(heart));
    heartRecipe.shape("323", "212", "323");
    heartRecipe.setIngredient('1', Material.FERMENTED_SPIDER_EYE);
    heartRecipe.setIngredient('2', Material.GOLD_INGOT);
    heartRecipe.setIngredient('3', new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lInfused Crystal").addGlow().toItemStack());
    main.getServer().addRecipe(heartRecipe);

    ItemStack saddle = new ItemBuilderManager(Material.SADDLE, 1).toItemStack();
    ShapedRecipe saddleRecipe = new ShapedRecipe(new NamespacedKey(main, "saddle"), new ItemStack(saddle));
    saddleRecipe.shape("111", "2 2", "3 3");
    saddleRecipe.setIngredient('1', Material.LEATHER);
    saddleRecipe.setIngredient('2', Material.COPPER_INGOT);
    saddleRecipe.setIngredient('3', Material.TRIPWIRE_HOOK);
    main.getServer().addRecipe(saddleRecipe);

    ItemStack crystal = new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lCrystal").toItemStack();
    ShapedRecipe crystalRecipe = new ShapedRecipe(new NamespacedKey(main, "crystal"), new ItemStack(crystal));
    crystalRecipe.shape("121", "131", "111");
    crystalRecipe.setIngredient('1', Material.REDSTONE);
    crystalRecipe.setIngredient('2', Material.EMERALD);
    crystalRecipe.setIngredient('3', Material.AMETHYST_SHARD);
    main.getServer().addRecipe(crystalRecipe);

    ItemStack infusedCrystal = new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lInfused Crystal").addGlow().toItemStack();
    ShapedRecipe infusedCrystalRecipe = new ShapedRecipe(new NamespacedKey(main, "infused-crystal"), new ItemStack(infusedCrystal));
    infusedCrystalRecipe.shape("121", "232", "141");
    infusedCrystalRecipe.setIngredient('1', Material.REDSTONE);
    infusedCrystalRecipe.setIngredient('2', Material.GUNPOWDER);
    infusedCrystalRecipe.setIngredient('3', new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lCrystal").toItemStack());
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

    ItemStack totem = new ItemBuilderManager(Material.TOTEM_OF_UNDYING).toItemStack();
    ShapedRecipe totemRecipe = new ShapedRecipe(new NamespacedKey(main, "totem-of-undying"), new ItemStack(totem));
    totemRecipe.shape("121", "232", "424");
    totemRecipe.setIngredient('1', Material.EMERALD);
    totemRecipe.setIngredient('2', new ItemBuilderManager(Material.EMERALD, 1).setTitle("&d&lInfused Crystal").addGlow().toItemStack());
    totemRecipe.setIngredient('3', new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE, 1).setTitle("&c&lRipped Heart").addGlow().toItemStack());
    totemRecipe.setIngredient('4', Material.GOLD_INGOT);
    main.getServer().addRecipe(totemRecipe);
  }

  public static void removeBukkitRecipes() {
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.GOLDEN_APPLE));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_HELMET));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_CHESTPLATE));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_LEGGINGS));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.DIAMOND_BOOTS));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_HELMET));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_CHESTPLATE));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_LEGGINGS));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_BOOTS));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_AXE));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_SWORD));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_PICKAXE));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_SHOVEL));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_HOE));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_INGOT));
    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.NETHERITE_SCRAP));
//    ItemBuilderManager.removeDefaultCraft(new ItemStack(Material.));
  }
}
