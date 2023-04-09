package net.boybacks.superhardcore.listeners;

import net.boybacks.superhardcore.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onCharlieRevenge {

  public static void runnableCharlieRevenge() {
    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    scheduler.scheduleSyncRepeatingTask(Main.main, new Runnable() {
      @Override
      public void run() {
        lightCheck();
      }
    }, 0L, 20L);
  }

  public static void lightCheck() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      Location location = player.getLocation();
      PotionEffect effect = player.getPotionEffect(PotionEffectType.NIGHT_VISION);
      if (player.getGameMode() != GameMode.SURVIVAL) {
        return;
      }
      if (player.getInventory().getItemInHand().getType().equals(Material.TORCH) || player.getInventory().getItemInOffHand().getType() == Material.TORCH || effect != null) {
        player.removePotionEffect(PotionEffectType.DARKNESS);
        return;
      }

      if (location.getBlock().getLightLevel() <= 6) {
        if (player.getPotionEffect(PotionEffectType.DARKNESS) == null) {
          player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20*13, 0, true, false));
          player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(fix("&4&lYOUR SOUL WILL BE MINE")));
        }
        player.damage(1.5);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, 20.0f, 0.1f);
      }
      else if (location.getBlock().getLightLevel() <= 8) {
        if (player.getPotionEffect(PotionEffectType.DARKNESS) == null) {
          player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20*13, 0, true, false));
          player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(fix("&4&lYOUR SOUL WILL BE MINE")));
        }
        player.playSound(player.getLocation(), Sound.ENTITY_HUSK_AMBIENT, 5.0f, 0.5f);
      }
      //TODO Zmienić
//      else {
//        player.removePotionEffect(PotionEffectType.DARKNESS);
//      }
    }
  }
}
