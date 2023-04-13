package net.boybacks.superhardcore.managers;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.potion.PotionType;

import static net.boybacks.superhardcore.Main.main;

public class RecipesManager {

  public static void recipes() {
                                                                                                                //Wyjebane serce ~ Ebi <3
    ItemStack heartRipped = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lRipped Heart").addLoreLine("&8Custom Item").addGlow().toItemStack();
    ShapedRecipe heartRippedRecipe = new ShapedRecipe(new NamespacedKey(main, "ripped-heart"), new ItemStack(heartRipped));
    heartRippedRecipe.shape("323", "212", "323");
    heartRippedRecipe.setIngredient('1', new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lHeart").addLoreLine("&8Custom Item").toItemStack());
    heartRippedRecipe.setIngredient('2', Material.GOLD_INGOT);
    heartRippedRecipe.setIngredient('3', new ItemBuilderManager(Material.EMERALD).setTitle("&d&lInfused Crystal").addLoreLine("&8Custom Item").addGlow().toItemStack());
    main.getServer().addRecipe(heartRippedRecipe);

    ItemStack saddle = new ItemBuilderManager(Material.SADDLE).toItemStack();
    ShapedRecipe saddleRecipe = new ShapedRecipe(new NamespacedKey(main, "saddle"), new ItemStack(saddle));
    saddleRecipe.shape("111", "2 2", "3 3");
    saddleRecipe.setIngredient('1', Material.LEATHER);
    saddleRecipe.setIngredient('2', Material.COPPER_INGOT);
    saddleRecipe.setIngredient('3', Material.TRIPWIRE_HOOK);
    main.getServer().addRecipe(saddleRecipe);

    ItemStack crystal = new ItemBuilderManager(Material.EMERALD).setTitle("&d&lCrystal").addLoreLine("&8Custom Item").toItemStack();
    ShapedRecipe crystalRecipe = new ShapedRecipe(new NamespacedKey(main, "crystal"), new ItemStack(crystal));
    crystalRecipe.shape("121", "131", "111");
    crystalRecipe.setIngredient('1', Material.REDSTONE);
    crystalRecipe.setIngredient('2', Material.EMERALD);
    crystalRecipe.setIngredient('3', Material.AMETHYST_SHARD);
    main.getServer().addRecipe(crystalRecipe);

    ItemStack infusedCrystal = new ItemBuilderManager(Material.EMERALD).setTitle("&d&lInfused Crystal").addLoreLine("&8Custom Item").addGlow().toItemStack();
    ShapedRecipe infusedCrystalRecipe = new ShapedRecipe(new NamespacedKey(main, "infused-crystal"), new ItemStack(infusedCrystal));
    infusedCrystalRecipe.shape("121", "232", "141");
    infusedCrystalRecipe.setIngredient('1', Material.REDSTONE);
    infusedCrystalRecipe.setIngredient('2', Material.GUNPOWDER);
    infusedCrystalRecipe.setIngredient('3', new ItemBuilderManager(Material.EMERALD).setTitle("&d&lCrystal").addLoreLine("&8Custom Item").toItemStack());
    infusedCrystalRecipe.setIngredient('4', Material.BLAZE_POWDER);
    main.getServer().addRecipe(infusedCrystalRecipe);

    /* Currently, turned off */
    ItemStack dagger = new ItemBuilderManager(Material.GOLDEN_SWORD).setTitle("&6&lSacrifice Dagger").addLoreLine("&8Custom Item").setDurability((short) 22).toItemStack();
    ShapedRecipe daggerRecipe = new ShapedRecipe(new NamespacedKey(main, "sacrifice-dagger"), new ItemStack(dagger));
    daggerRecipe.shape(" 12", " 21", "4  ");
    daggerRecipe.setIngredient('1', new ItemBuilderManager(Material.POTION).setPotionType(PotionType.INSTANT_DAMAGE, false, true).toItemStack());
    daggerRecipe.setIngredient('2', Material.GOLD_INGOT);
    daggerRecipe.setIngredient('4', Material.STICK);
    main.getServer().addRecipe(daggerRecipe);

    ItemStack totem = new ItemBuilderManager(Material.TOTEM_OF_UNDYING).toItemStack();
    ShapedRecipe totemRecipe = new ShapedRecipe(new NamespacedKey(main, "totem-of-undying"), new ItemStack(totem));
    totemRecipe.shape("121", "232", "424");
    totemRecipe.setIngredient('1', Material.EMERALD);
    totemRecipe.setIngredient('2', new ItemBuilderManager(Material.EMERALD).setTitle("&d&lInfused Crystal").addLoreLine("&8Custom Item").addGlow().toItemStack());
    totemRecipe.setIngredient('3', new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lRipped Heart").addLoreLine("&8Custom Item").addGlow().toItemStack());
    totemRecipe.setIngredient('4', Material.GOLD_INGOT);
    main.getServer().addRecipe(totemRecipe);

    /* Shöw yöurself! */
//    ItemStack test = new ItemBuilderManager(Material.FEATHER).setTitle("&8&k&lCharlie Heart").addLoreLine("&8Custom Item").toItemStack();
//    ShapedRecipe testRecipe = new ShapedRecipe(new NamespacedKey(main, "test-item"), new ItemStack(test));
//    testRecipe.shape("   ", "111", "   ");
//    testRecipe.setIngredient('1', Material.FEATHER);
//    main.getServer().addRecipe(testRecipe);

    /* TODO - Dodać możliwość craftowania desek z półpłytek*/
//    ItemStack wood = new ItemStack(Material.OAK_PLANKS);
//    ShapelessRecipe woodRecipe = new ShapelessRecipe(new NamespacedKey(main, "oak-planks"), new ItemStack(wood));
//    woodRecipe.addIngredient(Material.OAK_SLAB);
//    woodRecipe.addIngredient(Material.OAK_SLAB);
//    main.getServer().addRecipe(woodRecipe);

    ItemStack diamondNugget = new ItemBuilderManager(Material.IRON_NUGGET).setTitle("&b&lDiamond Nugget").addLoreLine("&8Custom Item").toItemStack();
    FurnaceRecipe diamondBurnRecipe = new FurnaceRecipe(diamondNugget, Material.DIAMOND);
    main.getServer().addRecipe(diamondBurnRecipe);

    ItemStack emptySoulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lEmpty Soul Vial").addLoreLine("&8Custom Item").toItemStack();
    ShapedRecipe emptySoulVialRecipe = new ShapedRecipe(new NamespacedKey(main, "empty-soul-vial"), new ItemStack(emptySoulVial));
    emptySoulVialRecipe.shape("111", "121", "111");
    emptySoulVialRecipe.setIngredient('1', new ItemBuilderManager(Material.IRON_NUGGET).setTitle("&b&lDiamond Nugget").addLoreLine("&8Custom Item").toItemStack());
    emptySoulVialRecipe.setIngredient('2', Material.GLASS_BOTTLE);
    main.getServer().addRecipe(emptySoulVialRecipe);

    ItemStack soulVial = new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lSoul Vial").addLoreLine("&8Custom Item").toItemStack();
    ShapedRecipe soulVialRecipe = new ShapedRecipe(new NamespacedKey(main, "soul-vial"), new ItemStack(soulVial));
    soulVialRecipe.shape("131", "121", "111");
    soulVialRecipe.setIngredient('1', new ItemBuilderManager(Material.FEATHER).setTitle("&b&lWild Soul").addLoreLine("&8Custom Item").toItemStack());
    soulVialRecipe.setIngredient('2', new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lEmpty Soul Vial").addLoreLine("&8Custom Item").toItemStack());
    soulVialRecipe.setIngredient('3', new ItemBuilderManager(Material.IRON_NUGGET).setTitle("&b&lDiamond Nugget").addLoreLine("&8Custom Item").toItemStack());
    main.getServer().addRecipe(soulVialRecipe);

    ItemStack heart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lHeart").addLoreLine("&8Custom Item").toItemStack();
    ShapedRecipe heartRecipe = new ShapedRecipe(new NamespacedKey(main, "heart"), new ItemStack(heart));
    heartRecipe.shape("111", "121", "111");
    heartRecipe.setIngredient('1', new ItemBuilderManager(Material.SPIDER_EYE).setTitle("&c&lHeart Chunk").addLoreLine("&8Custom Item").toItemStack());
    heartRecipe.setIngredient('2', new ItemBuilderManager(Material.GLASS_BOTTLE).setTitle("&b&lSoul Vial").addLoreLine("&8Custom Item").toItemStack());
    main.getServer().addRecipe(heartRecipe);
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
