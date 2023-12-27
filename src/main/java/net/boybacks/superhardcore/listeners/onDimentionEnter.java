package net.boybacks.superhardcore.listeners;

import net.boybacks.superhardcore.managers.RandomizerManager;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class onDimentionEnter implements Listener {

  @EventHandler
  public void onPlayerEnterEnd(PlayerPortalEvent event) {
    if (event.getCause() == PlayerPortalEvent.TeleportCause.END_PORTAL) {
      if (RandomizerManager.randomizer(50)) {
        return;
      }
      event.setCancelled(true);
      Location location = event.getPlayer().getLocation();
      int amount = 0;
      for (int x = -5; x <= 5; x++) {
        for (int y = -5; y <= 5; y++) {
          for (int z = -5; z <= 5; z++) {
            Block relativeBlock = location.clone().add(x, y, z).getBlock();
            BlockData blockData = relativeBlock.getBlockData();
            if (relativeBlock.getType() == Material.END_PORTAL) {
              location.getWorld().playSound(location, Sound.BLOCK_BEACON_DEACTIVATE, 1.0f, 0.4f);
              location.getWorld().playSound(location, Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
              location.getWorld().playEffect(location, Effect.STEP_SOUND, Material.END_PORTAL);
              relativeBlock.breakNaturally();
            }
            if (blockData instanceof EndPortalFrame) {
              if (!RandomizerManager.randomizer(250) || amount == 11) {
                EndPortalFrame endPortalFrame = (EndPortalFrame) blockData;
                endPortalFrame.setEye(false);
                relativeBlock.setBlockData(endPortalFrame);
              }
              amount += 1;
            }
          }
        }
      }
    }
  }
}
