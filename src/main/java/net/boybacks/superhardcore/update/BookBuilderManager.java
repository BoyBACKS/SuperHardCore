package net.boybacks.superhardcore.update;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class BookBuilderManager {

  public static ItemStack BookBuilder(String title, String author, BaseComponent[] page) {
    ItemStack itemStack = new ItemStack(Material.WRITTEN_BOOK);
    BookMeta bookMeta = (BookMeta) itemStack.getItemMeta();
    bookMeta.spigot().addPage(page);
    bookMeta.setTitle(fix(title));
    bookMeta.setAuthor(fix(author));
    itemStack.setItemMeta(bookMeta);
    return itemStack;
  }

  public static ItemStack BookBuilder(String title, String author, ArrayList<BaseComponent[]> pages) {
    ItemStack itemStack = new ItemStack(Material.WRITTEN_BOOK);
    BookMeta bookMeta = (BookMeta) itemStack.getItemMeta();
    for (BaseComponent[] page : pages)
      bookMeta.spigot().addPage(page);
    bookMeta.setTitle(fix(title));
    bookMeta.setAuthor(fix(author));
    itemStack.setItemMeta(bookMeta);
    return itemStack;
  }
}
