package net.boybacks.superhardcore.old;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onCraft implements Listener {

  public List<Material> materialList = new ArrayList<>();

  private void bannedMaterials() {
    materialList.add(Material.GOLDEN_APPLE);
  }

  //TODO Klasa do wyrzucenia
  @EventHandler
  public void onPlayerCraft(CraftItemEvent event) {
    bannedMaterials();
    Player player = (Player) event.getWhoClicked();
    for (Material blockedMaterial : materialList) {
      ItemStack craftedItem = event.getInventory().getItem(0);
      if (craftedItem.getItemMeta().getDisplayName().equals("")) {
        if (event.getCurrentItem().getType() == blockedMaterial) {
          event.setCancelled(true);
          player.sendMessage(fix("&cYou can't craft that item!"));
          player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 0.7f);
          return;
        }
      }
    }
  }
}
