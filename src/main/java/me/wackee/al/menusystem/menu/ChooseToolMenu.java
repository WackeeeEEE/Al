package me.wackee.al.menusystem.menu;

        import me.wackee.al.EBBuilder;
        import me.wackee.al.ItemBuilder;
        import me.wackee.al.menusystem.Menu;
        import me.wackee.al.menusystem.PlayerMenuUtility;
        import org.bukkit.ChatColor;
        import org.bukkit.Material;
        import org.bukkit.enchantments.Enchantment;
        import org.bukkit.event.inventory.InventoryClickEvent;
        import org.bukkit.inventory.ItemStack;

public class ChooseToolMenu extends Menu {

    public ChooseToolMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.BLACK + "Librarian - Choose Tool Enchant";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

        switch (e.getCurrentItem().getType()){
                //Invalid Items
            case GRAY_STAINED_GLASS_PANE: // FILLER_GLASS
                e.setCancelled(true);
                break;
            case ENCHANTED_BOOK:
                e.setCancelled(true);
                break;

                // Efficiency stacks
            case DIRT:
                ItemStack eff1 = new EBBuilder(Material.ENCHANTED_BOOK).makeEB(Enchantment.DIG_SPEED, 1).toItemStack();
                e.getClickedInventory().addItem(eff1);
                e.setCancelled(true);
                break;
            case OAK_WOOD:
                ItemStack eff2 = new EBBuilder(Material.ENCHANTED_BOOK).makeEB(Enchantment.DIG_SPEED, 2).toItemStack();
                e.getClickedInventory().addItem(eff2);
                e.setCancelled(true);
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
            case BARRIER:
                new ChooseTypeMenu(playerMenuUtility).open();
                break;
        }

    }

    @Override
    public void setMenuItems() {

        //Create Enchantment options

        //Generic Stacks for conveying enchant level
        ItemStack I = new ItemBuilder(Material.ENCHANTED_BOOK, 1).setName("Level I").hideStats().toItemStack();
        ItemStack II = new ItemBuilder(Material.ENCHANTED_BOOK, 2).setName("Level II").hideStats().toItemStack();
        ItemStack III = new ItemBuilder(Material.ENCHANTED_BOOK, 3).setName("Level III").hideStats().toItemStack();
        ItemStack IV = new ItemBuilder(Material.ENCHANTED_BOOK, 4).setName("Level IV").hideStats().toItemStack();
        ItemStack V = new ItemBuilder(Material.ENCHANTED_BOOK, 5).setName("Level V").hideStats().toItemStack();

        //Efficiency stacks
        ItemStack eff1 = new ItemBuilder(Material.DIRT).setName("Efficiency I").hideStats().toItemStack(); // Efficiency 1
        ItemStack eff2 = new ItemBuilder(Material.OAK_WOOD).setName("Efficiency II").hideStats().toItemStack();
        ItemStack eff3 = new ItemBuilder(Material.STONE).setName("Efficiency III").hideStats().toItemStack();
        ItemStack eff4 = new ItemBuilder(Material.IRON_ORE).setName("Efficiency IV").hideStats().toItemStack();
        ItemStack eff5 = new ItemBuilder(Material.GILDED_BLACKSTONE).setName("Efficiency V").hideStats().toItemStack();

        //Fortune stacks
        ItemStack fort1 = new ItemBuilder(Material.REDSTONE_BLOCK).setName("Fortune I").hideStats().toItemStack(); // Fortune 1
        ItemStack fort2 = new ItemBuilder(Material.EMERALD_BLOCK).setName("Fortune II").hideStats().toItemStack();
        ItemStack fort3 = new ItemBuilder(Material.DIAMOND_BLOCK).setName("Fortune III").hideStats().toItemStack();

        //Unbreaking stacks
        ItemStack ub1 = new ItemBuilder(Material.GRAY_CONCRETE).setName("Unbreaking I").hideStats().toItemStack(); // Unbreaking 1
        ItemStack ub2 = new ItemBuilder(Material.OBSIDIAN).setName("Unbreaking II").hideStats().toItemStack();
        ItemStack ub3 = new ItemBuilder(Material.BEDROCK).setName("Unbreaking III").hideStats().toItemStack();

        //Others
        ItemStack silk = new ItemBuilder(Material.DIAMOND_ORE).setName("Silk Touch").hideStats().toItemStack();
        ItemStack mend = new ItemBuilder(Material.ANVIL).setName("Mending").hideStats().toItemStack();
        ItemStack back = new ItemBuilder(Material.BARRIER).setName(ChatColor.BLUE + "Back to Enchantment Type").hideStats().toItemStack();


        //Row 1
        inventory.setItem(0, I);
        inventory.setItem(1, eff1);
        inventory.setItem(2, fort1);
        inventory.setItem(3, ub1);
        //Right side
        inventory.setItem(7, silk);
        inventory.setItem(8, mend);

        //Row 2
        inventory.setItem(9, II);
        inventory.setItem(10, eff2);
        inventory.setItem(11, fort2);
        inventory.setItem(12, ub2);

        //Row 3
        inventory.setItem(18, III);
        inventory.setItem(19, eff3);
        inventory.setItem(20, fort3);
        inventory.setItem(6, ub3);

        //Row 4
        inventory.setItem(27, IV);
        inventory.setItem(28, eff4);

        //Row 5
        inventory.setItem(36, V);
        inventory.setItem(37, eff5);

        //Row 6
        /*Unused
        inventory.setItem(45);
        inventory.setItem(46);
        inventory.setItem(47);
        inventory.setItem(48);
        inventory.setItem(49);
        inventory.setItem(50);
        inventory.setItem(51);
        inventory.setItem(52);
         */
        inventory.setItem(53, back);

        setFillerGlass();

    }
}
