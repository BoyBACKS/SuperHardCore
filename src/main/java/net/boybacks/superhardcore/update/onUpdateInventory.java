package net.boybacks.superhardcore.update;

import net.boybacks.superhardcore.managers.ItemBuilderManager;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class onUpdateInventory {

  /* Dzienniczek kopiowania
  ───────────────────
  ▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪▪
  .append(fix("\n\n&a&l+&0 "))

  .append(fix("\n\n&c&l-&0 "))

  .append(fix("\n\n&6&l?&0 "))

  .append(fix("\n\n&b&l⟳&0 "))


  First Page

  fix("  &c&lChange log v0.1"))
  .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
  .append(fix("\n\n   &a&lMajor Changes:"))


  Last Page

    pageList.add(
        new ComponentBuilder(fix("  &c&lChange log v0.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .append(fix("\n&4&lAt the moment, this feature is not available!")).create()))
                .create())
            .create());

  https://github.com/BoyBACKS/SuperHardCoreSMP/wiki
   */

  public static void updateInv(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 27, fix("&4&lChange Log"));
    ArrayList<BaseComponent[]> pageList = new ArrayList<>();
    pageList.add(
        new ComponentBuilder(fix("  &c&lChange log v0.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(fix("\n\n   &a&lMajor Changes:"))
            .append(fix("\n\n&a&l+&0 We setted everything up for play"))
            .append(fix("\n\n&a&l+&0 We added new command /updates, to open changelog menu"))
            .create());
    pageList.add(new ComponentBuilder(fix("&c&l-&0 Debug commands removed /zdrowie, /daj, /sprawdz"))
        .append(fix("\n\n&b&l⟳&0 Debug command /debug is available only for operators players"))
        .append(fix("\n\n&b&l⟳&0 Command /sethealth is available only for operators players"))
        .create());
    pageList.add(new ComponentBuilder(fix("&6&l?&0 We think about adding new recipes and features"))
        .append(fix("\n\n&6&l?&0 We think about add inventory with custom items recipes"))
        .create());
    pageList.add(
        new ComponentBuilder(fix("  &c&lChange log v0.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .append(fix("\n&4&lAt the moment, this feature is not available!")).create()))
                .create())
            .create());

    ItemStack bookv011 = BookBuilderManager.BookBuilder("&c&lUpdate v0.1", "Super HardCore Updates", pageList);
    inventory.setItem(11, bookv011);

    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.BLACK_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }
    player.openInventory(inventory);
  }
}
