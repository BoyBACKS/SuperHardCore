package net.boybacks.superhardcore;

import net.boybacks.releaseschecker.ReleaseChecker;
import net.boybacks.superhardcore.bossbar.*;
import net.boybacks.superhardcore.craftingrecipes.handlers.onCraftingClick;
import net.boybacks.superhardcore.craftingrecipes.handlers.onCraftingCommand;
import net.boybacks.superhardcore.craftingrecipes.items.*;
import net.boybacks.superhardcore.listeners.*;
import net.boybacks.superhardcore.managers.*;
import net.boybacks.superhardcore.update.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.*;
import org.jetbrains.annotations.*;

import static net.boybacks.superhardcore.bossbar.EntityBossBar.*;
import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class Main extends JavaPlugin implements Listener {

  public static Main main;

  @Override
  public void onEnable() {
    main = this;
    System.out.println("Plugin is working");
    latestVersionChecker();
    registerListeners();
    RecipesManager.recipes();
    RecipesManager.removeBukkitRecipes();
    onCharlieRevenge.runnableCharlieRevenge();
    new onUpdateCommand(this);
    new onCraftingCommand(this);
    removeEnemyBars();
    onMinionSummon.onSummon();
    //Test();
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    Player player = (Player) sender;
    if (command.getName().equalsIgnoreCase("sethealth") && sender.isOp()) {
      if (args.length == 2) {
        String name = args[1];
        int value = 0;
        try {
          value = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
          sender.sendMessage(fix("&cSet number as value. Use command /sethealth <value> <player>"));
          return false;
        }
        if (value > 30) {
          sender.sendMessage(fix("&cYou can't set more health than 30"));
          return false;
        }
        if (Bukkit.getPlayer(name) != null) {
          Bukkit.getPlayer(name).setMaxHealth(value);
          Bukkit.getPlayer(name).setHealth(value);
        }
      }
      else if (args.length == 1) {
        int value = 0;
        try {
          value = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
          sender.sendMessage(fix("&cSet number as value. Use command /sethealth <value>"));
          return false;
        }
        if (value > 30) {
          sender.sendMessage(fix("&cYou can't set more health than 30"));
          return false;
        }
        player.setMaxHealth(value);
        player.setHealth(value);
      }
      else {
        return false;
      }
    }
    if (command.getName().equalsIgnoreCase("debug") && player.isOp()) {
      ItemStack heartChunk = new ItemBuilderManager(Material.SPIDER_EYE, 1).setTitle("&c&lHeart Chunk").addLoreLine("&8Custom Item").toItemStack();
      ItemStack wildSoul = new ItemBuilderManager(Material.FEATHER, 1).setTitle("&b&lWild Soul").addLoreLine("&8Custom Item").toItemStack();
      ItemStack soul = new ItemBuilderManager(Material.FEATHER, 1).setTitle("&b&lSoul").addLoreLine("&8Custom Item").addGlow().toItemStack();
      player.getInventory().addItem(heartChunk, soul, wildSoul);
    }
    return false;
  }

  public void registerListeners() {
    /* Old Listeners */
    //getServer().getPluginManager().registerEvents(new onCraft(), this);
    //getServer().getPluginManager().registerEvents(new onMove(), this);

    getServer().getPluginManager().registerEvents(this, this);
    getServer().getPluginManager().registerEvents(new onDeath(), this);
    getServer().getPluginManager().registerEvents(new onSpawn(), this);
    getServer().getPluginManager().registerEvents(new EntityBossBar(), this);
    getServer().getPluginManager().registerEvents(new onInteract(), this);
    getServer().getPluginManager().registerEvents(new onKill(), this);
    getServer().getPluginManager().registerEvents(new onRepair(), this);
    getServer().getPluginManager().registerEvents(new onJoin(), this);
    //getServer().getPluginManager().registerEvents(new onDamage(), this);
    getServer().getPluginManager().registerEvents(new onMinionSummon(), this);
    //getServer().getPluginManager().registerEvents(new Test(), this);

    /* Update Inventory Click Event */
    getServer().getPluginManager().registerEvents(new onUpdateClick(), this);

    /* Custom Crafting Inventories Click Events */
    getServer().getPluginManager().registerEvents(new onCraftingClick(), this);
    getServer().getPluginManager().registerEvents(new Crystal(), this);
    getServer().getPluginManager().registerEvents(new InfusedCrystal(), this);
    getServer().getPluginManager().registerEvents(new RippedHeart(), this);
    getServer().getPluginManager().registerEvents(new Saddle(), this);
    getServer().getPluginManager().registerEvents(new TotemOfUndying(), this);
    getServer().getPluginManager().registerEvents(new DiamondNugget(), this);
    getServer().getPluginManager().registerEvents(new EmptySoulVial(), this);
    getServer().getPluginManager().registerEvents(new SoulVial(), this);
    getServer().getPluginManager().registerEvents(new Heart(), this);
    getServer().getPluginManager().registerEvents(new SacrificeDagger(), this);
  }

  public void latestVersionChecker() {
    ReleaseChecker.getVersion("v0.2.3");
    ReleaseChecker.getRepository("boybacks", "SuperHardCore");
    if (!ReleaseChecker.releaseCheck()) {
      System.out.println(ChatColor.RED + "There is a new version to download, go to github to get it!");
    }
  }
}
