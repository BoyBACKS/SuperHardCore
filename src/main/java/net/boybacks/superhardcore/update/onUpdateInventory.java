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

    .add(
        new ComponentBuilder(fix("  &c&lChange log v0.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .append(fix("\n&4&lAt the moment, this feature is not available!")).create()))
                .create())
            .create());

  https://github.com/BoyBACKS/SuperHardCoreSMP/wiki
   */

  public static void updateInv(Player player) {
    Inventory inventory = Bukkit.createInventory(player, 36, fix("&4&lChange Log"));
    ArrayList<BaseComponent[]> bookv01Page = new ArrayList<>();
    bookv01Page.add(
        new ComponentBuilder(fix("  &c&lChange log v0.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(fix("\n\n   &a&lMajor Changes:"))
            .append(fix("\n\n&a&l+&0 We setted everything up for play"))
            .append(fix("\n\n&a&l+&0 We added new command /updates, to open changelog menu"))
            .create());
    bookv01Page.add(new ComponentBuilder(fix("&c&l-&0 Debug commands removed /zdrowie, /daj, /sprawdz"))
        .append(fix("\n\n&b&l⟳&0 Debug command /debug is available only for operators players"))
        .append(fix("\n\n&b&l⟳&0 Command /sethealth is available only for operators players"))
        .create());
    bookv01Page.add(new ComponentBuilder(fix("&6&l?&0 We think about adding new recipes and features"))
        .append(fix("\n\n&6&l?&0 We think about add inventory with custom items recipes"))
        .create());
    bookv01Page.add(
        new ComponentBuilder(fix("  &c&lChange log v0.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v01"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .append(fix("\n&4&lAt the moment, this feature is not available!")).create()))
                .create())
            .create());

    ItemStack bookv01 = BookBuilderManager.BookBuilder("&c&lUpdate v0.1", "Super HardCore Updates", bookv01Page);
    inventory.setItem(11, bookv01);



    ArrayList<BaseComponent[]> bookv011Page = new ArrayList<>();
    bookv011Page.add(new ComponentBuilder(fix(" &c&lChange log v0.1.1"))
        .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
        .append(fix("\n\n   &a&lMajor Changes:"))
        .append(fix("\n\n&a&l+&0 We added new command /recipes and is available only for operators players - BETA"))
        .create());
    bookv011Page.add(new ComponentBuilder(fix("&b&l⟳&0 We changed damage by darkness - for now torch in off hand is working properly"))
            .append(fix("\n\n&b&l⟳&0 Reciving hearts by &c&lRipped Heart &0is currently off becouse of code errors"))
        .create());
    bookv011Page.add(new ComponentBuilder(fix("&b&l⟳&0 We have changed colors to Crystal and Infused Crystal to pink for future reasons*"))
        .append(fix("\n\n&b&l⟳&0 We are currently working on add inventories for custom crafting recipes"))
        .create());
    bookv011Page.add(new ComponentBuilder(fix("\n\n&6&l?&0 * We are thinking about add texture pack for better game style")).create());
    bookv011Page.add(
        new ComponentBuilder(fix(" &c&lChange log v0.1.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v011"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .create()))
                .create())
            .create());
    ItemStack bookv011 = BookBuilderManager.BookBuilder("&c&lUpdate v0.1.1", "Super HardCore Updates", bookv011Page);
    inventory.setItem(12, bookv011);


    ArrayList<BaseComponent[]> bookv02Page = new ArrayList<>();
    bookv02Page.add(new ComponentBuilder(fix("  &c&lChange log v0.2"))
        .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
        .append(fix("\n\n   &a&lMajor Changes:"))
        .append(fix("\n\n&a&l+&0 We added /recipes command, all custom recipes are available there - The command is available to all players and has no permissions"))
        .create());
    bookv02Page.add(new ComponentBuilder(fix("&a&l+&0 We added recipe for &nTotem of Undying"))
            .append(fix("\n\n&b&l⟳&0 We have changed the mechanics of receiving damage from darkness. From now on, at &nlight level 7 to 8 &0there is a warning, from &nlight level 6 &0the player will receive damage changed from &n1 damage &0to &n1.5 damage"))
        .create());
    bookv02Page.add(new ComponentBuilder(fix("&b&l⟳&0 We fixed the bug with interactions, from now on everything works"))
            .append(fix("\n\n&b&l⟳&0 We fixed the bug with crafting, from now on everything works"))
        .create());
    bookv02Page.add(
        new ComponentBuilder(fix("  &c&lChange log v0.2"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v02"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .create()))
                .create())
            .create());
    ItemStack bookv02 = BookBuilderManager.BookBuilder("&c&lUpdate v0.2", "Super HardCore Updates", bookv02Page);
    inventory.setItem(13, bookv02);



    ArrayList<BaseComponent[]> bookv021Page = new ArrayList<>();
    bookv021Page.add(new ComponentBuilder(fix(" &c&lChange log v0.2.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v021"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .create()))
                .create())
            .create());
    ItemStack bookv021 = BookBuilderManager.BookBuilder("&c&lUpdate v0.2.1", "Super HardCore Updates", bookv021Page);
    inventory.setItem(14, bookv021);



    ArrayList<BaseComponent[]> bookv022Page = new ArrayList<>();
    bookv022Page.add(new ComponentBuilder(fix(" &c&lChange log v0.2.2"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(fix("\n\n&a&l+&0 We added new recipes and items, you can read more on our wiki"))
            .append(fix("\n\n&a&l+&0 We added new drops from mobs, you can read more on our wiki"))
        .create());
    bookv022Page.add(
        new ComponentBuilder(fix(" &c&lChange log v0.2.2"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v022"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .create()))
                .create())
            .create());
    ItemStack bookv022 = BookBuilderManager.BookBuilder("&c&lUpdate v0.2.2", "Super HardCore Updates", bookv022Page);
    inventory.setItem(15, bookv022);

    ArrayList<BaseComponent[]> bookv023Page = new ArrayList<>();
    bookv023Page.add(new ComponentBuilder(fix(" &c&lChange log v0.2.3"))
        .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
        .append(fix("\n\n&a&l+&0 We added new enemy, it appears randomly every 3 minutes with a chance of 7.5%"))
        .append(fix("\n\n&b&l⟳&0 We fixed major problem with taking damage by darkness, now everything works"))
        .create());
    bookv023Page.add(new ComponentBuilder(fix("&b&l⟳&0 We changed a few mobs, by changing drops and health"))
            .append(fix("\n\n&b&l⟳&0 We changed crafting recipe of a Sacrifice Dagger"))
            .append(fix("\n\n&6&l?&0 We have idea to implement Diamond and Netherite items"))
        .create());
    bookv023Page.add(
        new ComponentBuilder(fix(" &c&lChange log v0.2.3"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v023"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .create()))
                .create())
            .create());
    ItemStack bookv023 = BookBuilderManager.BookBuilder("&c&lUpdate v0.2.3", "Super HardCore Updates", bookv023Page);
    inventory.setItem(20, bookv023);

    ArrayList<BaseComponent[]> bookv030Page = new ArrayList<>();
    bookv030Page.add(new ComponentBuilder(fix(" &c&lChange log v0.3.0"))
        .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
        .append(fix("\n\n&b&l⟳&0 We ported the package from version 1.19.x to 1.19.x-1.20.x and updated the plugins."))
        .create());
    bookv030Page.add(new ComponentBuilder(fix("&6&l?&0 We encountered a problem in the ViaVersions plugin and there was a limitation to the server entry version to 1.20.4."))
        .create());
    bookv030Page.add(new ComponentBuilder(fix(" &c&lChange log v0.3.0\n     &c&lExtra patch"))
        .append(fix("\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
        .append(fix("\n\n&6&l⟳&0 We managed to fix the problem occurring with the problem in the ViaVersions plugin, now everything works"))
        .create());
    bookv030Page.add(
        new ComponentBuilder(fix(" &c&lChange log v0.3.0"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v030"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .create()))
                .create())
            .create());
    ItemStack bookv030 = BookBuilderManager.BookBuilder("&c&lUpdate v0.3.0", "Super HardCore Updates", bookv030Page);
    inventory.setItem(21, bookv030);


    ArrayList<BaseComponent[]> bookv031Page = new ArrayList<>();
    bookv031Page.add(new ComponentBuilder(fix(" &c&lChange log v0.3.1"))
        .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
        .append(fix("\n\n&a&l+&0 We have added a new mechanic when trying to go to The End"))
        .append(fix("\n\n&6&l⟳&0 We have fixed a problem that occurred when repairing Sacrifice Dagger"))
        .create());
    bookv031Page.add(new ComponentBuilder(fix("&6&l⟳&0 We have fixed the problem related to crafting custom items, while there was a problem related to porting a package from an older to a newer version. All custom scrafted items on older versions are no longer playable."))
        .create());
    bookv031Page.add(
        new ComponentBuilder(fix(" &c&lChange log v0.3.1"))
            .append(fix("\n\n&0&m⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯"))
            .append(new ComponentBuilder(fix("\n\n    &3&n&lSide changes"))
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/BoyBACKS/SuperHardCoreSMP/wiki/Updates#update-v031"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(fix("&f>> &b&lClick here to see other changes"))
                    .create()))
                .create())
            .create());
    ItemStack bookv031 = BookBuilderManager.BookBuilder("&c&lUpdate v0.3.1", "Super HardCore Updates", bookv031Page);
    inventory.setItem(22, bookv031);

    for (int i = 0; i < inventory.getSize(); i++) {
      if(inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
        ItemStack glassPane = new ItemBuilderManager(Material.BLACK_STAINED_GLASS_PANE).setTitle("&a").toItemStack();
        inventory.setItem(i, glassPane);
      }
    }
    player.openInventory(inventory);
  }
}
