package me.swipez.fishingop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Map;

public class AnvilClick implements Listener {

    @EventHandler
    public void onPlayerClickInInventory(InventoryClickEvent e){
        if (e.getInventory().getType().equals(InventoryType.ANVIL)){
            if (e.getInventory().getItem(0) != null && e.getInventory().getItem(1) != null && e.getInventory().getItem(2) != null){
                ItemStack item1 = e.getInventory().getItem(0);
                ItemStack bookstack = e.getInventory().getItem(1);
                EnchantmentStorageMeta book = (EnchantmentStorageMeta) bookstack.getItemMeta();
                ItemStack clickeditem = e.getCurrentItem();
                if (e.getInventory().getItem(2).equals(clickeditem)){
                    if (bookstack.getType() == Material.ENCHANTED_BOOK){
                        Map<Enchantment, Integer> bookEnchantments = book.getStoredEnchants();
                        ArrayList<Enchantment> bookenchantmentslist = new ArrayList<>(bookEnchantments.keySet());
                        Enchantment enchantment = bookenchantmentslist.get(0);
                        Integer value = bookEnchantments.get(enchantment);
                        ItemMeta meta = clickeditem.getItemMeta();
                        if (item1.containsEnchantment(enchantment)){
                            meta.addEnchant(enchantment, item1.getEnchantments().get(enchantment)+value, true);
                        }
                        else {
                            meta.addEnchant(enchantment, bookEnchantments.get(enchantment), true);
                        }
                        clickeditem.setItemMeta(meta);
                    }
                }
            }
        }
    }
}
