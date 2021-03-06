package me.wackee.al;

import me.wackee.al.commands.AlChooseTool;
import me.wackee.al.commands.AlChooseType;
import me.wackee.al.commands.KillCommand;
import me.wackee.al.commands.SuicideCommand;
import me.wackee.al.listeners.MenuListener;
import me.wackee.al.menusystem.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Al extends JavaPlugin {

    private static Al plugin;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        getCommand("suicide").setExecutor(new SuicideCommand());
        getCommand("killplayer").setExecutor(new KillCommand());
        getCommand("alType").setExecutor(new AlChooseType());
        getCommand("alTool").setExecutor(new AlChooseTool());

        //Menu listener system
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    //Provide a player and return a menu system for that player
    //create one if they don't already have one
    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) { //See if the player has a playermenuutility "saved" for them

            //This player doesn't. Make one for them add add it to the hashmap
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p); //Return the object by using the provided player
        }
    }

    public static Al getPlugin() {
        return plugin;
    }
}

