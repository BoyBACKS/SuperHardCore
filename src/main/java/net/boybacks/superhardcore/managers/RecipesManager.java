package net.boybacks.superhardcore.managers;

import net.boybacks.superhardcore.recipes.items.craftable.*;
import net.boybacks.superhardcore.recipes.items.craftable.vanilla.Saddle;
import net.boybacks.superhardcore.recipes.items.craftable.vanilla.TotemOfUndying;
import net.boybacks.superhardcore.recipes.items.droppable.HeartChunk;
import net.boybacks.superhardcore.recipes.items.droppable.WildSoul;
import net.boybacks.superhardcore.recipes.items.smeltable.DiamondNugget;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.potion.PotionType;

import static net.boybacks.superhardcore.Main.main;

public class RecipesManager {

  public void recipes() {
    ShapedRecipe heartRippedRecipe = new ShapedRecipe(new NamespacedKey(main, "ripped-heart"), RippedHeart.getRippedHeart());
    heartRippedRecipe.shape("323", "212", "323");
    heartRippedRecipe.setIngredient('1', Heart.getHeart());
    heartRippedRecipe.setIngredient('2', Material.GOLD_INGOT);
    heartRippedRecipe.setIngredient('3', InfusedCrystal.getInfusedCrystal());
    main.getServer().addRecipe(heartRippedRecipe);

    ShapedRecipe saddleRecipe = new ShapedRecipe(new NamespacedKey(main, "saddle"), Saddle.getSaddle());
    saddleRecipe.shape("111", "2 2", "3 3");
    saddleRecipe.setIngredient('1', Material.LEATHER);
    saddleRecipe.setIngredient('2', Material.COPPER_INGOT);
    saddleRecipe.setIngredient('3', Material.TRIPWIRE_HOOK);
    main.getServer().addRecipe(saddleRecipe);

    ShapedRecipe crystalRecipe = new ShapedRecipe(new NamespacedKey(main, "crystal"), Crystal.getCrystal());
    crystalRecipe.shape("121", "131", "111");
    crystalRecipe.setIngredient('1', Material.REDSTONE);
    crystalRecipe.setIngredient('2', Material.EMERALD);
    crystalRecipe.setIngredient('3', Material.AMETHYST_SHARD);
    main.getServer().addRecipe(crystalRecipe);

    ShapedRecipe infusedCrystalRecipe = new ShapedRecipe(new NamespacedKey(main, "infused-crystal"), InfusedCrystal.getInfusedCrystal());
    infusedCrystalRecipe.shape("121", "232", "141");
    infusedCrystalRecipe.setIngredient('1', Material.REDSTONE);
    infusedCrystalRecipe.setIngredient('2', Material.GUNPOWDER);
    infusedCrystalRecipe.setIngredient('3', Crystal.getCrystal());
    infusedCrystalRecipe.setIngredient('4', Material.BLAZE_POWDER);
    main.getServer().addRecipe(infusedCrystalRecipe);

    /* Currently, turned off */
    ShapedRecipe daggerRecipe = new ShapedRecipe(new NamespacedKey(main, "sacrifice-dagger"), SacrificeDagger.getSacrificeDagger());
    daggerRecipe.shape(" 12", " 21", "4  ");
    daggerRecipe.setIngredient('1', new ItemBuilderManager(Material.POTION).setPotionType(PotionType.POISON, false, true).toItemStack());
    daggerRecipe.setIngredient('2', Material.GOLD_INGOT);
    daggerRecipe.setIngredient('4', Material.STICK);
    main.getServer().addRecipe(daggerRecipe);

    ShapedRecipe totemRecipe = new ShapedRecipe(new NamespacedKey(main, "totem-of-undying"), TotemOfUndying.getTotemOfUndying());
    totemRecipe.shape("121", "232", "424");
    totemRecipe.setIngredient('1', Material.EMERALD);
    totemRecipe.setIngredient('2', InfusedCrystal.getInfusedCrystal());
    totemRecipe.setIngredient('3', RippedHeart.getRippedHeart());
    totemRecipe.setIngredient('4', Material.GOLD_INGOT);
    main.getServer().addRecipe(totemRecipe);

    /* Shöw yöurself! */
//    ItemStack test = new ItemBuilderManager(Material.FEATHER).setTitle("&8&k&lCharlie Heart").addLoreLine("&8Custom Item").toItemStack();
//    ShapedRecipe testRecipe = new ShapedRecipe(new NamespacedKey(main, "test-item"), new ItemStack(test));
//    testRecipe.shape("   ", "111", "   ");
//    testRecipe.setIngredient('1', Material.FEATHER);
//    main.getServer().addRecipe(testRecipe);

    FurnaceRecipe diamondBurnRecipe = new FurnaceRecipe(DiamondNugget.getDiamondNugget(), Material.DIAMOND);
    main.getServer().addRecipe(diamondBurnRecipe);

    ShapedRecipe emptySoulVialRecipe = new ShapedRecipe(new NamespacedKey(main, "empty-soul-vial"), EmptySoulVial.getEmptySoulVial());
    emptySoulVialRecipe.shape("111", "121", "111");
    emptySoulVialRecipe.setIngredient('1', DiamondNugget.getDiamondNugget());
    emptySoulVialRecipe.setIngredient('2', Material.GLASS_BOTTLE);
    main.getServer().addRecipe(emptySoulVialRecipe);

    ShapedRecipe soulVialRecipe = new ShapedRecipe(new NamespacedKey(main, "soul-vial"), SoulVial.getSoulVial());
    soulVialRecipe.shape("131", "121", "111");
    soulVialRecipe.setIngredient('1', WildSoul.getWildSoul());
    soulVialRecipe.setIngredient('2', EmptySoulVial.getEmptySoulVial());
    soulVialRecipe.setIngredient('3', DiamondNugget.getDiamondNugget());
    main.getServer().addRecipe(soulVialRecipe);

    ShapedRecipe heartRecipe = new ShapedRecipe(new NamespacedKey(main, "heart"), Heart.getHeart());
    heartRecipe.shape("111", "121", "111");
    heartRecipe.setIngredient('1', HeartChunk.getHeartChunk());
    heartRecipe.setIngredient('2', SoulVial.getSoulVial());
    main.getServer().addRecipe(heartRecipe);
  }

  public void removeBukkitRecipes() {
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
