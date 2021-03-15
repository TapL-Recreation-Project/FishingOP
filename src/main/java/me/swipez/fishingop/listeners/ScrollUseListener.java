package me.swipez.fishingop.listeners;

import me.swipez.fishingop.scrolls.ScrollManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class ScrollUseListener implements Listener {
    @EventHandler
    public void onPlayerUseScroll(PlayerInteractEvent event){
        ItemStack clickeditem = event.getPlayer().getInventory().getItemInMainHand();
        if (clickeditem.getItemMeta() != null){
            clickeditem.getItemMeta().getDisplayName();
            Player player = event.getPlayer();
            if (clickeditem.getItemMeta().getDisplayName().toLowerCase().contains("scroll")){
                Inventory inventory = event.getPlayer().getInventory();
                if (clickeditem.isSimilar(ScrollManager.LUCK_10_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 10%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_20_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 20%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_30_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 30%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_40_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 40%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_50_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 50%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_60_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 60%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_70_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 70%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_80_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 80%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_90_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 90%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LUCK_100_SCROLL)){
                    addLuckEnchantment(inventory, "Luck 100%", player);
                }
                else if (clickeditem.isSimilar(ScrollManager.LURE_5_SCROLL)){
                    addLureEnchantment(inventory, player);
                }
                clickeditem.setAmount(clickeditem.getAmount()-1);
                event.setCancelled(true);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
            }
        }
    }
    public void addLuckEnchantment(Inventory inventory, String lore, Player player){
        for (int i = 0; i < inventory.getSize(); i++){
            if (inventory.getItem(i) != null){
                if (inventory.getItem(i).getType().equals(Material.FISHING_ROD)){
                    ItemStack fishingrod = inventory.getItem(i);
                    ItemMeta meta = fishingrod.getItemMeta();
                    List<String> lorelist = new ArrayList<>();
                    lorelist.add(ChatColor.GRAY+lore);
                    meta.setLore(lorelist);
                    int value;
                    if (meta.hasEnchant(Enchantment.LURE)){
                        value = meta.getEnchantLevel(Enchantment.LURE)+1;
                    }
                    else {
                        value = 1;
                    }
                    if (value > 5){
                        value = 5;
                    }
                    meta.addEnchant(Enchantment.LURE, value, false);
                    fishingrod.setItemMeta(meta);
                }
            }
        }
        player.sendMessage(ChatColor.GRAY+"[!] All your fishing rods have been enchanted with "+ChatColor.LIGHT_PURPLE+lore+ChatColor.GRAY+"!");
    }

    public void addLureEnchantment(Inventory inventory, Player player){
        for (int i = 0; i < inventory.getSize(); i++){
            if (inventory.getItem(i) != null){
                if (inventory.getItem(i).getType().equals(Material.FISHING_ROD)){
                    ItemStack fishingrod = inventory.getItem(i);
                    ItemMeta meta = fishingrod.getItemMeta();
                    meta.addEnchant(Enchantment.LURE, 5, true);
                    fishingrod.setItemMeta(meta);
                }
            }
        }
        player.sendMessage(ChatColor.GRAY+"[!] All your fishing rods have been enchanted with "+ChatColor.LIGHT_PURPLE+"Lure V"+ChatColor.GRAY+"!");
    }
}
