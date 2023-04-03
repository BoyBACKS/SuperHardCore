package net.boybacks.superhardcore.managers;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;

public class BossBarManager {
  private final BossBar enemyHp;
  private long lastUpdate;
  private LivingEntity targetEntity;

  public BossBarManager(final BossBar enemyHp) {
    this.enemyHp = enemyHp;
  }

  public BossBarManager(final BossBar enemyHp, final long lastUpdate) {
    this.enemyHp = enemyHp;
    this.lastUpdate = lastUpdate;
  }

  public long getLastUpdate() {
    return lastUpdate;
  }

  public BossBar getEnemyHp() {
    return enemyHp;
  }
}
