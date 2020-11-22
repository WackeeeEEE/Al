package me.wackee.al.menusystem.menu;

import me.wackee.al.ItemBuilder;
import me.wackee.al.menusystem.Menu;
import me.wackee.al.menusystem.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ChooseTypeMenu extends Menu {

    public ChooseTypeMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.BLACK + "Librarian - Choose Type";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

        switch (e.getCurrentItem().getType()){
            case DIAMOND_PICKAXE:
                new ChooseToolMenu(playerMenuUtility).open();
                break;
            case DIAMOND_SWORD:
                break;
            case BOW:
                break;
            case DIAMOND_CHESTPLATE:
                break;
            case DIAMOND_HELMET:
                break;
            case DIAMOND_BOOTS:
                break;
            case FISHING_ROD:
                break;
            case TRIDENT:
                break;
            case ENCHANTED_BOOK:
                break;
            case BARRIER:
                e.getWhoClicked().closeInventory();
                break;
        }

    }

    @Override
    public void setMenuItems() {

        //Set ItemStacks HERE

        ItemStack tool = new ItemBuilder(Material.DIAMOND_PICKAXE).setName(ChatColor.BLUE + "Tool Enchantments").setLore(ChatColor.GOLD + "Show all available tool enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack sword = new ItemBuilder(Material.DIAMOND_SWORD).setName(ChatColor.BLUE + "Sword Enchantments").setLore(ChatColor.GOLD + "Show all available sword enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack bow = new ItemBuilder(Material.BOW).setName(ChatColor.BLUE + "Bow Enchantments").setLore(ChatColor.GOLD + "Show all available bow enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack armor = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName(ChatColor.BLUE + "Armor Enchantments").setLore(ChatColor.GOLD + "Show all available armor enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack helmet = new ItemBuilder(Material.DIAMOND_HELMET).setName(ChatColor.BLUE + "Helmet Enchantments").setLore(ChatColor.GOLD + "Show all available helmet enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack boots = new ItemBuilder(Material.DIAMOND_BOOTS).setName(ChatColor.BLUE + "Boots Enchantments").setLore(ChatColor.GOLD + "Show all available boots enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack frod = new ItemBuilder(Material.FISHING_ROD).setName(ChatColor.BLUE + "Rod Enchantments").setLore(ChatColor.GOLD + "Show all available rod enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack trident = new ItemBuilder(Material.TRIDENT).setName(ChatColor.BLUE + "Trident Enchantments").setLore(ChatColor.GOLD + "Show all available trident enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack misc = new ItemBuilder(Material.ENCHANTED_BOOK).setName(ChatColor.BLUE + "Miscellaneous Enchantments").setLore(ChatColor.GOLD + "Show all available miscellaneous enchantments").addEnchant(Enchantment.ARROW_DAMAGE, 1).hideStats().toItemStack();
        ItemStack back = new ItemBuilder(Material.BARRIER).setName(ChatColor.BLUE + "Close Menu").toItemStack();

        inventory.setItem(0, tool);
        inventory.setItem(1, sword);
        inventory.setItem(2, bow);
        inventory.setItem(3, armor);
        inventory.setItem(4, helmet);
        inventory.setItem(5, boots);
        inventory.setItem(6, frod);
        inventory.setItem(7, trident);
        inventory.setItem(8, misc);
        inventory.setItem(53, back);

        setFillerGlass();

    }
}
