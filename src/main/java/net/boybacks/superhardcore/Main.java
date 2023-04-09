package net.boybacks.superhardcore;

import net.boybacks.releaseschecker.ReleaseChecker;
import net.boybacks.superhardcore.bossbar.*;
import net.boybacks.superhardcore.craftingrecipes.items.*;
import net.boybacks.superhardcore.craftingrecipes.*;
import net.boybacks.superhardcore.listeners.*;
import net.boybacks.superhardcore.managers.*;
import net.boybacks.superhardcore.update.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
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
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    Player player = (Player) sender;
    if (command.getName().equalsIgnoreCase("sethealth") && sender.isOp())
      if (args.length == 2) {
        String name = args[1];
        int value = 0;
        try {
          value = Integer.valueOf(args[0]);
        }
        catch (NumberFormatException e) {
          sender.sendMessage(fix("&cSet number as value. Use command /sethealth <value> <player>"));
          return false;
        }
        if (value > 30) {
          sender.sendMessage(fix("&cYou can't set more health than 30"));
          return false;
        }
        if (Bukkit.getPlayer(name) !=null) {
          Bukkit.getPlayer(name).setMaxHealth(value);
          Bukkit.getPlayer(name).setHealth(value);
        }
      }
      else if (args.length == 1) {
        int value = 0;
        try {
          value = Integer.valueOf(args[0]);
        }
        catch (NumberFormatException e) {
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
    if (command.getName().equalsIgnoreCase("debug") && player.isOp()) {

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

    /* Update Inventory Click Event */
    getServer().getPluginManager().registerEvents(new onUpdateClick(), this);

    /* Custom Crafting Inventories Click Events */
    getServer().getPluginManager().registerEvents(new onCraftingClick(), this);
    getServer().getPluginManager().registerEvents(new Crystal(), this);
    getServer().getPluginManager().registerEvents(new InfusedCrystal(), this);
    getServer().getPluginManager().registerEvents(new RippedHeart(), this);
    getServer().getPluginManager().registerEvents(new Saddle(), this);
    getServer().getPluginManager().registerEvents(new TotemOfUndying(), this);
  }

  public void latestVersionChecker() {
    ReleaseChecker.getVersion("v0.2.1");
    ReleaseChecker.getRepository("boybacks", "SuperHardCore");
    if (!ReleaseChecker.releaseCheck()) {
      System.out.println(ChatColor.RED + "There is a new version to download, go to github to get it!");
    }
  }


}
