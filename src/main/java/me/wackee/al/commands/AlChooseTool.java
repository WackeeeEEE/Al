package me.wackee.al.commands;

import me.wackee.al.Al;
import me.wackee.al.menusystem.menu.ChooseToolMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlChooseTool implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            //create the menu and then open it for the player
            new ChooseToolMenu(Al.getPlayerMenuUtility(p)).open();

        }
        return true;
    }
}
