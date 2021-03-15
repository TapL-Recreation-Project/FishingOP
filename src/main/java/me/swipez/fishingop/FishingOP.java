package me.swipez.fishingop;

import me.swipez.fishingop.listeners.ScrollUseListener;
import me.swipez.fishingop.scrolls.ScrollManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.swipez.fishingop.Metrics;

public final class FishingOP extends JavaPlugin {

    boolean gamestarted = false;

    @Override
    public void onEnable() {

        // Listeners
        getServer().getPluginManager().registerEvents(new AnvilClick(), this);
        getServer().getPluginManager().registerEvents(new FishingListener(this), this);
        getServer().getPluginManager().registerEvents(new ScrollUseListener(), this);

        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Metrics
        new Metrics(this, 10666);

        //Recipes
        ScrollManager.initRecipes(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
