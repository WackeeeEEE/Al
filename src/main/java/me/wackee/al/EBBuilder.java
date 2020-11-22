package me.wackee.al;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

/*
 * Easily create itemstacks, without messing your hands.
 * <i>Note that if you do use this in one of your projects, leave this notice.</i>
 * <i>Please do credit me if you do use this in one of your projects.</i>
 * @author NonameSL
 */
public class EBBuilder {
    private ItemStack is;
    /*
     * Create a new ItemBuilder from scratch.
     * @param m The material to create the ItemBuilder with.
     */
    public EBBuilder(Material m){
        this(m, 1);
    }
    /*
     * Create a new ItemBuilder over an existing itemstack.
     * @param is The itemstack to create the ItemBuilder over.
     */
    public EBBuilder(ItemStack is){
        this.is=is;
    }
    /*
     * Create a new ItemBuilder from scratch.
     * @param m The material of the item.
     * @param amount The amount of the item.
     */
    public EBBuilder(Material m, int amount){
        is= new ItemStack(m, amount);
    }
    /*
     * Create a new ItemBuilder from scratch.
     * @param m The material of the item.
     * @param amount The amount of the item.
     * @param durability The durability of the item.
     */
    //public ItemBuilder(Material m, int amount, byte durability){
    //    is = new ItemStack(m, amount, durability);
    // }
    /*
     * Clone the ItemBuilder into a new one.
     * @return The cloned instance.
     */

    public EBBuilder makeEB(Enchantment ench, int level) {
        ItemStack is = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta em = (EnchantmentStorageMeta) is.getItemMeta();
        em.addStoredEnchant(ench, level, false);
        is.setItemMeta(em);
        return this;
    }

    public ItemStack toItemStack(){
        return is;
    }
}