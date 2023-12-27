package net.boybacks.superhardcore;

import net.boybacks.releaseschecker.ReleaseChecker;
import net.boybacks.superhardcore.bossbar.*;
import net.boybacks.superhardcore.recipes.handlers.onCraftingClick;
import net.boybacks.superhardcore.recipes.handlers.onCraftingCommand;
import net.boybacks.superhardcore.listeners.*;
import net.boybacks.superhardcore.managers.*;
import net.boybacks.superhardcore.recipes.items.craftable.*;
import net.boybacks.superhardcore.recipes.items.craftable.vanilla.Saddle;
import net.boybacks.superhardcore.recipes.items.craftable.vanilla.TotemOfUndying;
import net.boybacks.superhardcore.recipes.items.droppable.HeartChunk;
import net.boybacks.superhardcore.recipes.items.droppable.WildSoul;
import net.boybacks.superhardcore.recipes.items.smeltable.DiamondNugget;
import net.boybacks.superhardcore.update.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.*;
import org.jetbrains.annotations.*;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class Main extends JavaPlugin implements Listener {

  public static Main main;

  @Override
  public void onEnable() {
    main = this;
    System.out.println("Plugin is working");
    this.latestVersionChecker();

    new RecipesManager().recipes();
    new RecipesManager().removeBukkitRecipes();
    new onCharlieRevenge().runnableCharlieRevenge();
    new EntityBossBar().removeEnemyBars();
    new onMinionSummon().onSummon();

    new onUpdateCommand(this);
    new onCraftingCommand(this);


    registerEvents(
        this, new onDeath(), new onSpawn(), new EntityBossBar(), new onInteract(), new onKill(),
        new onRepair(), new onJoin(), new onMinionSummon(),
//        new onDamage(),
        new onDimentionEnter(), new onUpdateClick()
    );

    registerEvents(
        /* Craftings */
        new onCraftingClick(),
        new Crystal(), new InfusedCrystal(), new RippedHeart(), new Saddle(), new TotemOfUndying(), new DiamondNugget(),
        new EmptySoulVial(), new SoulVial(), new Heart(), new SacrificeDagger(),
        /* Drops */
        new HeartChunk(), new WildSoul()
    );
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

  public void latestVersionChecker() {
    ReleaseChecker.getVersion("v0.3.1");
    ReleaseChecker.getRepository("boybacks", "SuperHardCore");
    if (!ReleaseChecker.releaseCheck()) {
      System.err.println("There is a new version to download, go to github to get it!");
    }
  }

  private void registerEvents(Listener... listeners) {
    for (Listener listener : listeners)
      Bukkit.getPluginManager().registerEvents(listener, this);
  }
}
