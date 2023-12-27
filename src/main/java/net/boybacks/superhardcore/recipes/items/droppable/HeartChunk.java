package net.boybacks.superhardcore.recipes.items.droppable;

import lombok.Getter;
import net.boybacks.superhardcore.managers.ItemBuilderManager;
import net.boybacks.superhardcore.recipes.items.craftable.RippedHeart;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.RandomizerManager.randomizer;

public class HeartChunk implements Listener {

  @Getter static ItemStack heartChunk = new ItemBuilderManager(Material.SPIDER_EYE).setTitle("&c&lHeart Chunk").addLoreLine("&8Custom Item").toItemStack();

  @EventHandler
  public void onMobKill(EntityDeathEvent event) {
    EntityType entityType = event.getEntity().getType();
    if (!(entityType.equals(EntityType.WARDEN) && entityType.equals(EntityType.ENDER_CRYSTAL) && entityType.equals(EntityType.ENDER_DRAGON)))
      if (randomizer(10))
        event.getDrops().add(HeartChunk.getHeartChunk());
  }
}
