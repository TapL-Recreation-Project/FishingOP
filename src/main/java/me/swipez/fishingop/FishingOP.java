package me.swipez.fishingop;

import org.bukkit.plugin.java.JavaPlugin;
import me.swipez.fishingop.Metrics;

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
        new Metrics(this, 10666);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
