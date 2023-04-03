package net.boybacks.superhardcore.update;

import net.boybacks.superhardcore.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class onUpdateCommand implements CommandExecutor {

  public onUpdateCommand(Main p) {
    Main.main = p;
    p.getCommand("updates").setExecutor(this);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("updates")) {
      onUpdateInventory.updateInv((Player) sender);
    }
    return false;
  }
}
