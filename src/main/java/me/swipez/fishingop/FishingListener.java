package me.swipez.fishingop;

import me.swipez.fishingop.scrolls.ScrollManager;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;

public class FishingListener implements Listener {

    FishingOP plugin;
    private final Random rng = new Random();
    private final RandomLootPicker randomLootPicker;

    public FishingListener(FishingOP plugin) {
        this.plugin = plugin;
        this.randomLootPicker = new RandomLootPicker(plugin);
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent e) {
        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            ItemStack fishingrod = e.getPlayer().getInventory().getItemInMainHand();
            ItemStack normalrod = new ItemStack(Material.FISHING_ROD);
            double chance = 0;
            if (fishingrod.getItemMeta().hasLore()){
                for (int luck = 10; luck <= 100; luck += 10) {
                    if (fishingrod.getItemMeta().getLore().contains(ChatColor.GRAY + "Luck " + luck + "%")) {
                        chance = luck / 100.0;
                    }
                }
            } else {
                final double lure5chance = 0.10;
                if (rng.nextDouble() < lure5chance){
                    Item item = (Item) e.getCaught();
                    item.setItemStack(ScrollManager.LURE_5_SCROLL);
                }
            }
            if (rng.nextDouble() < chance) {
                List<String> enchants = plugin.getConfig().getStringList("enchantslist");
                List<String> peffects = plugin.getConfig().getStringList("peffects");

                ItemStack ritem = randomLootPicker.randomItemStack();

                if (ritem.getType() == Material.ENCHANTED_BOOK) {
                    ItemMeta meta = ritem.getItemMeta();
                    EnchantmentStorageMeta emeta = (EnchantmentStorageMeta) meta;
                    int mine = 0;
                    int maxe = enchants.size() - 1;
                    double rench = Math.random() * (maxe - mine + 1) + mine;
                    emeta.addStoredEnchant(Enchantment.getByKey(NamespacedKey.minecraft(enchants.get((int) rench).toLowerCase())), 10, true);
                    ritem.setItemMeta(emeta);
                }
                if (ritem.getType() == Material.POTION) {
                    ItemMeta meta = ritem.getItemMeta();
                    PotionMeta pmeta = (PotionMeta) meta;
                    int mine = 0;
                    int maxe = peffects.size() - 1;
                    double rench = Math.random() * (maxe - mine + 1) + mine;
                    pmeta.addCustomEffect(new PotionEffect((PotionEffectType.getByName(peffects.get((int) rench).toUpperCase())), 1200, 2), true);
                    pmeta.setColor(Color.YELLOW);
                    pmeta.setDisplayName("OP Potion");
                    ritem.setItemMeta(pmeta);
                }
                Item item = (Item) e.getCaught();
                item.setItemStack(ritem);
            }
        }
    }
}
