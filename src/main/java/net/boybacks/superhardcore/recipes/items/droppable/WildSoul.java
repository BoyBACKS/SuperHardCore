package net.boybacks.superhardcore.recipes.items.droppable;

import lombok.Getter;
import net.boybacks.superhardcore.managers.ItemBuilderManager;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import static net.boybacks.superhardcore.managers.ChatManager.fix;
import static net.boybacks.superhardcore.managers.RandomizerManager.randomizer;

public class WildSoul implements Listener {

  @Getter static ItemStack wildSoul = new ItemBuilderManager(Material.FEATHER).setTitle("&b&lWild Soul").addLoreLine("&8Custom Item").toItemStack();

  @EventHandler
  public void onMobKill(EntityDeathEvent event) {
    if (event.getEntity().getKiller() instanceof Player) {
      Player player = event.getEntity().getKiller();
      ItemStack heldItem = player.getInventory().getItemInMainHand();
      if (event.getEntity().getName().equals(fix("&c&lCharlie's Minion")))
        if (randomizer(400))
          event.getDrops().add(WildSoul.getWildSoul());

      if (heldItem.getItemMeta() == null) return;

      if (heldItem.getItemMeta().getDisplayName().equals(fix("&6&lSacrifice Dagger")))
        if (randomizer(20))
          event.getDrops().add(WildSoul.getWildSoul());
    }
  }
}
