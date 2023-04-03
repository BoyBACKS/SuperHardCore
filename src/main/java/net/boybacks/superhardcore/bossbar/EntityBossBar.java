package net.boybacks.superhardcore.bossbar;

import net.boybacks.superhardcore.managers.BossBarManager;
import org.bukkit.boss.*;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

import static net.boybacks.superhardcore.Main.main;
import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class EntityBossBar implements Listener {

  private static Map<String, BossBarManager> playersBars;
  private String titleHpOther = fix("&c&lEnemy Health");
  private static final int time = 2;

  public EntityBossBar() {
    playersBars = new HashMap<String, BossBarManager>();
  }

  @EventHandler
  public void onQuitPlayer(final PlayerQuitEvent event) {
    playersBars.remove(event.getPlayer().getName());
  }

  @EventHandler
  public void onEntityDamage(final EntityDamageByEntityEvent event) {
    if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
      final Player player = (Player)event.getDamager();
      final LivingEntity livingEntity = (LivingEntity)event.getEntity();
      titleHpOther = livingEntity.getName();
      if (event.getEntity() instanceof EnderDragon) {
        return;
      }
      if (event.getEntity() instanceof Wither) {
        return;
      }
      if (event.getEntity() instanceof Player) {
        final Player twoPlayer = (Player)event.getEntity();
        if (twoPlayer.getName().equalsIgnoreCase(player.getName())) {
          return;
        }
      }
      Bukkit.getScheduler().runTask(main, () ->
          updateBars(player, new BossBarManager(getHealthBar(livingEntity, BarColor.RED, "&c&l"+titleHpOther),
              System.currentTimeMillis()))
      );
    }
  }

  public static void removeEnemyBars() {
    new BukkitRunnable() {
      @Override
      public void run() {
        for (final String name : playersBars.keySet()) {
          removeEnemyBar(name);
        }
      }
    }.runTaskTimer(main, (time * 20), (time * 20));
  }

  private static void removeEnemyBar(final String name) {
    BossBarManager bossBars = playersBars.get(name);
    if (System.currentTimeMillis() - bossBars.getLastUpdate() > time * 1000) {
      deleteBar(bossBars.getEnemyHp());
    }
  }

  private void updateBars(Player player, BossBarManager bossBars) {
    BossBarManager currentBossBars = playersBars.get(player.getName());
    if (currentBossBars != null) {
      deleteBar(currentBossBars.getEnemyHp());
    }
    playersBars.put(player.getName(), bossBars);
    setBar(player, bossBars.getEnemyHp());
  }

  private void setBar(final Player player, final BossBar bossBar) {
    if (bossBar != null) {
      bossBar.addPlayer(player);
    }
  }

  private static void deleteBar(final BossBar bossBar) {
    if (bossBar != null) {
      bossBar.removeAll();
    }
  }

  private BossBar getHealthBar(LivingEntity entity, BarColor barColor, String title) {
    int heath = getHealth(entity);
    BossBar bossBar = Bukkit.createBossBar(String.format(fix(title), heath, Math.ceil(entity.getMaxHealth())), barColor, BarStyle.SOLID, new BarFlag[0]);
    bossBar.setProgress(heath / Math.ceil(entity.getMaxHealth()));
    return bossBar;
  }

  private int getHealth(final LivingEntity entity) {
    return (int)Math.ceil(entity.getHealth());
  }
}
