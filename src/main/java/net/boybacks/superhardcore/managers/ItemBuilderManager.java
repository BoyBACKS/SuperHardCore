package net.boybacks.superhardcore.managers;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.*;

import static net.boybacks.superhardcore.managers.ChatManager.fix;

public class ItemBuilderManager {

  private final ItemStack is;

  public ItemBuilderManager(final Material m) {
    this(m, 1);
  }

  public ItemBuilderManager(final ItemStack is) {
    this.is = is;
  }

  public ItemBuilderManager(final Material m, final int amount) {
    this.is = new ItemStack(m, amount);
  }

  public ItemBuilderManager(final Material m, final short durability) {
    this.is = new ItemStack(m, 1, durability);
  }

  public ItemBuilderManager(final Material m, final int amount, final short durability) {
    this.is = new ItemStack(m, amount, durability);
  }

  public ItemBuilderManager clone() {
    return new ItemBuilderManager(this.is);
  }

  public ItemBuilderManager setDurability(final short dur) {
    this.is.setDurability(dur);
    return this;
  }

  public ItemBuilderManager setTitle(final String name) {
    final ItemMeta im = this.is.getItemMeta();
    im.setDisplayName(fix(name));
    this.is.setItemMeta(im);
    return this;
  }

  public ItemBuilderManager addUnsafeEnchantment(final Enchantment ench, final int level) {
    this.is.addUnsafeEnchantment(ench, level);
    return this;
  }

  public ItemBuilderManager removeEnchantment(final Enchantment ench) {
    this.is.removeEnchantment(ench);
    return this;
  }

  public ItemBuilderManager setSkullOwner(final String owner) {
    try {
      final SkullMeta im = (SkullMeta)this.is.getItemMeta();
      im.setOwner(owner);
      this.is.setItemMeta((ItemMeta)im);
    }
    catch (ClassCastException ex) {}
    return this;
  }

  public ItemBuilderManager addGlow() {
    final ItemMeta im = this.is.getItemMeta();
    im.addEnchant(Enchantment.DURABILITY, 10, true);
    im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE });
    return this;
  }

  public ItemBuilderManager addEnchant(final Enchantment ench, final int level) {
    final ItemMeta im = this.is.getItemMeta();
    im.addEnchant(ench, level, true);
    this.is.setItemMeta(im);
    return this;
  }

  public ItemBuilderManager addEnchantments(final Map<Enchantment, Integer> enchantments) {
    this.is.addEnchantments((Map)enchantments);
    return this;
  }

  public ItemBuilderManager setInfinityDurability() {
    final ItemMeta meta = this.is.getItemMeta();
    meta.setUnbreakable(true);
    this.is.setItemMeta(meta);
    return this;
  }

  public ItemBuilderManager setLore(final List<String> lore) {
    final ItemMeta im = this.is.getItemMeta();
    im.setLore((List)lore);
    this.is.setItemMeta(im);
    return this;
  }

  public ItemBuilderManager removeLoreLine(final String line) {
    final ItemMeta im = this.is.getItemMeta();
    final List<String> lore = new ArrayList<String>(im.getLore());
    if (!lore.contains(line)) {
      return this;
    }
    lore.remove(line);
    im.setLore((List)lore);
    this.is.setItemMeta(im);
    return this;
  }

  public ItemBuilderManager removeLoreLine(final int index) {
    final ItemMeta im = this.is.getItemMeta();
    final List<String> lore = new ArrayList<String>(im.getLore());
    if (index < 0 || index > lore.size()) {
      return this;
    }
    lore.remove(index);
    im.setLore((List)lore);
    this.is.setItemMeta(im);
    return this;
  }

  public ItemBuilderManager addLoreLine(final String line) {
    final ItemMeta im = this.is.getItemMeta();
    List<String> lore = new ArrayList<String>();
    if (im.hasLore()) {
      lore = new ArrayList<String>(im.getLore());
    }
    lore.add(line);
    im.setLore((List)lore);
    this.is.setItemMeta(im);
    return this;
  }

  public ItemBuilderManager addLoreLine(final String line, final int pos) {
    final ItemMeta im = this.is.getItemMeta();
    final List<String> lore = new ArrayList<String>(im.getLore());
    lore.set(pos, line);
    im.setLore((List)lore);
    this.is.setItemMeta(im);
    return this;
  }

  public ItemBuilderManager addBookPage(final String[] page) {
    final BookMeta bookMeta = (BookMeta) this.is.getItemMeta();
    bookMeta.addPage(page);
    this.is.setItemMeta((ItemMeta)bookMeta);
    return this;
  }
  public ItemBuilderManager addBookPage(final BaseComponent[] page) {
    final BookMeta bookMeta = (BookMeta) this.is.getItemMeta();
    bookMeta.spigot().addPage(page);
    this.is.setItemMeta((ItemMeta)bookMeta);
    return this;
  }

  public ItemBuilderManager setBookPage(final int page, final String data) {
    final BookMeta bookMeta = (BookMeta)this.is.getItemMeta();
    bookMeta.setPage(page, data);
    this.is.setItemMeta((ItemMeta)bookMeta);
    return this;
  }

  public ItemBuilderManager setBookOwner(final String authorName) {
    final BookMeta bookMeta = (BookMeta)this.is.getItemMeta();
    bookMeta.setAuthor(authorName);
    this.is.setItemMeta((ItemMeta)bookMeta);
    return this;
  }

  public ItemBuilderManager setBookOwner(final Player player) {
    final BookMeta bookMeta = (BookMeta)this.is.getItemMeta();
    bookMeta.setAuthor(player.getName());
    this.is.setItemMeta((ItemMeta)bookMeta);
    return this;
  }

  public ItemBuilderManager setBookOwner(final UUID uuid) {
    final BookMeta bookMeta = (BookMeta)this.is.getItemMeta();
    bookMeta.setAuthor(Bukkit.getPlayer(uuid).toString());
    this.is.setItemMeta((ItemMeta)bookMeta);
    return this;
  }

  public ItemStack toItemStack() {
    return this.is;
  }
}
