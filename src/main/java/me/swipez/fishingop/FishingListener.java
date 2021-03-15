package me.swipez.fishingop;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
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
import org.bukkit.util.Vector;

import java.util.List;

public class FishingListener implements Listener {

    FishingOP plugin;

    public FishingListener(FishingOP plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerFish(PlayerFishEvent e){
        if (plugin.gamestarted) {
            if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH){
                List<String> mats = plugin.getConfig().getStringList("fallitems");
                List<String> counts = plugin.getConfig().getStringList("fallitemscount");
                List<String> enchants = plugin.getConfig().getStringList("enchantslist");
                List<String> peffects = plugin.getConfig().getStringList("peffects");
                int min = 0;
                int max = mats.size() - 1;
                double random = Math.random() * (max - min + 1) + min;
                int stackcount = Integer.parseInt(counts.get((int) random));
                ItemStack ritem = new ItemStack(Material.valueOf(mats.get((int) random).toUpperCase()), stackcount);
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
