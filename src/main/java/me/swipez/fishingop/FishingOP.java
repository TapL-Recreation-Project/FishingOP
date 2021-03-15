package me.swipez.fishingop;

import org.bukkit.plugin.java.JavaPlugin;

public final class FishingOP extends JavaPlugin {

    boolean gamestarted = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fishop").setExecutor(new FishingCommand(this));
        getCommand("fishop").setTabCompleter(new CommandComplete());
        getServer().getPluginManager().registerEvents(new AnvilClick(), this);
        getServer().getPluginManager().registerEvents(new FishingListener(this), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
