package net.boybacks.superhardcore.listeners;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;
import static net.boybacks.superhardcore.managers.RandomizerManager.randomizer;

public class onKill implements Listener {

  @EventHandler
  public void onMobKill(EntityDeathEvent event) {
    EntityType entityType = event.getEntity().getType();

    if (entityType.equals(EntityType.WARDEN)) {
      if (randomizer(300)) { // 30.0%
        ItemStack rippedHeart = new ItemBuilderManager(Material.FERMENTED_SPIDER_EYE).setTitle("&c&lRipped Heart").addLoreLine("&8Custom Item").addGlow().toItemStack();
        event.getDrops().add(rippedHeart);
      }
    }

    if (entityType.equals(EntityType.WITCH)) {
      event.getDrops().removeIf(item -> item.getType() == Material.SPIDER_EYE);
//      if (randomizer(5)) {
//        event.getDrops().add(new ItemStack(Material.SPIDER_EYE));
//      }
    }

    if (entityType.equals(EntityType.SPIDER) || entityType.equals(EntityType.CAVE_SPIDER)) {
      event.getDrops().remove(new ItemStack(Material.SPIDER_EYE));
      if (randomizer(50)) {
        event.getDrops().add(new ItemStack(Material.SPIDER_EYE));
      }
    }

    if (!(entityType.equals(EntityType.WARDEN) && entityType.equals(EntityType.ENDER_CRYSTAL) && entityType.equals(EntityType.ENDER_DRAGON))) {
      ItemStack heartChunk = new ItemBuilderManager(Material.SPIDER_EYE).setTitle("&c&lHeart Chunk").addLoreLine("&8Custom Item").toItemStack();
      if (randomizer(10)) {
        event.getDrops().add(heartChunk);
      }
    }

    if (event.getEntity().getKiller() instanceof Player) {
      Player player = event.getEntity().getKiller();
      ItemStack heldItem = player.getInventory().getItemInMainHand();
      if (event.getEntity().getName().equals(fix("&c&lCharlie's Minion"))) {
        if (randomizer(400)) {
          event.getDrops().add(new ItemBuilderManager(Material.FEATHER).setTitle("&b&lWild Soul").addLoreLine("&8Custom Item").toItemStack());
        }
      }

      if (heldItem.getItemMeta() == null) {
        return;
      }
      if (heldItem.getItemMeta().getDisplayName().equals(fix("&6&lSacrifice Dagger"))) {
        if (randomizer(20)) {
          event.getDrops().add(new ItemBuilderManager(Material.FEATHER).setTitle("&b&lWild Soul").addLoreLine("&8Custom Item").toItemStack());
        }
      }
    }
  }
}
