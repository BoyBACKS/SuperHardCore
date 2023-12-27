package net.boybacks.superhardcore.listeners;

import net.boybacks.superhardcore.Main;
import net.boybacks.superhardcore.managers.RandomizerManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vex;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import static net.boybacks.superhardcore.managers.ChatManager.fix;
import static net.boybacks.superhardcore.managers.RandomizerManager.randomizer;

public class onMinionSummon implements Listener {

  public void onSummon() {
    new BukkitRunnable() {
      @Override
      public void run() {
        for (Player player : Bukkit.getOnlinePlayers())
          if (player != null) {
            if (randomizer(75)) {
              Location loc = player.getLocation();
              Vex vex = (Vex) loc.getWorld().spawnEntity(loc, EntityType.VEX);
              vex.setMaxHealth(1);
              vex.setHealth(1);
              vex.setCustomName(fix("&c&lCharlie's Minion"));
              vex.setCustomNameVisible(true);
              vex.setTarget(player);
              vex.setLifeTicks(20*45);

              vex.setMetadata("MinionDamage", new FixedMetadataValue(Main.main, 1.0));
            }
          }
      }
    }.runTaskTimer(Main.main, 0, 20*60*3);
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    if (event.getDamager() instanceof Vex && event.getDamager().hasMetadata("MinionDamage")) {
      event.setDamage(event.getDamager().getMetadata("MinionDamage").get(0).asDouble());
    }
  }
}
