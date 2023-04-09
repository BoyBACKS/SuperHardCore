package net.boybacks.superhardcore.craftingrecipes;

import net.boybacks.superhardcore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class onCraftingCommand implements CommandExecutor {

  public onCraftingCommand(Main p) {
    Main.main = p;
    p.getCommand("crafts").setExecutor(this);
  }

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
    if (command.getName().equalsIgnoreCase("crafts")) {
      Player player = (Player) commandSender;
      onCraftingInventory.craftingInventory(player);
    }
    return false;
  }
}
