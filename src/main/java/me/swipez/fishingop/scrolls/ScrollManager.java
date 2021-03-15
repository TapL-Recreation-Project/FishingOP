package me.swipez.fishingop.scrolls;

import me.swipez.fishingop.FishingOP;
import me.swipez.fishingop.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class ScrollManager {

    FishingOP plugin;

    public ScrollManager(FishingOP plugin) {
        this.plugin = plugin;
    }

    public static final ItemStack LUCK_10_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 10%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_20_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 20%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_30_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 30%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_40_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 40%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_50_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 50%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_60_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 60%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_70_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 70%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_80_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 80%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_90_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 90%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LUCK_100_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Luck 100%")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();
    public static final ItemStack LURE_5_SCROLL = ItemBuilder.of(Material.PAPER)
            .name(ChatColor.WHITE+"Scroll of"+ChatColor.LIGHT_PURPLE+" Lure V")
            .lore(ChatColor.GRAY+"Right click this item to apply the enchantment to all fishing rods in your inventory!")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static void initRecipes(FishingOP plugin) {
        registerScrollRecipe(plugin, "scroll_10_cod", LUCK_10_SCROLL, new ItemStack(Material.PAPER), new ItemStack(Material.COD));
        registerScrollRecipe(plugin, "scroll_10_pufferfish", LUCK_10_SCROLL, new ItemStack(Material.PAPER), new ItemStack(Material.PUFFERFISH));
        registerScrollRecipe(plugin, "scroll_10_tropical_fish", LUCK_10_SCROLL, new ItemStack(Material.PAPER), new ItemStack(Material.TROPICAL_FISH));

        registerScrollLevelRecipe(plugin, "scroll_20", LUCK_20_SCROLL, LUCK_10_SCROLL, new ItemStack(Material.DIRT));
        registerScrollLevelRecipe(plugin, "scroll_30", LUCK_30_SCROLL, LUCK_20_SCROLL, new ItemStack(Material.STONE));
        registerScrollLevelRecipe(plugin, "scroll_40", LUCK_40_SCROLL, LUCK_30_SCROLL, new ItemStack(Material.COAL_BLOCK));
        registerScrollLevelRecipe(plugin, "scroll_50", LUCK_50_SCROLL, LUCK_40_SCROLL, new ItemStack(Material.IRON_BLOCK));
        registerScrollLevelRecipe(plugin, "scroll_60", LUCK_60_SCROLL, LUCK_50_SCROLL, new ItemStack(Material.GOLD_BLOCK));
        registerScrollLevelRecipe(plugin, "scroll_70", LUCK_70_SCROLL, LUCK_60_SCROLL, new ItemStack(Material.DIAMOND_BLOCK));
        registerScrollLevelRecipe(plugin, "scroll_80", LUCK_80_SCROLL, LUCK_70_SCROLL, new ItemStack(Material.NETHERITE_SCRAP));
        registerScrollLevelRecipe(plugin, "scroll_90", LUCK_90_SCROLL, LUCK_80_SCROLL, new ItemStack(Material.NETHERITE_INGOT));
        registerScrollLevelRecipe(plugin, "scroll_100", LUCK_100_SCROLL, LUCK_90_SCROLL, new ItemStack(Material.NETHERITE_BLOCK));
    }

    @SuppressWarnings("deprecation")
    private static void registerScrollRecipe(FishingOP plugin, String id, ItemStack scrollResult, ItemStack scrollIngridient, ItemStack fish) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, id), scrollResult)
                .shape("CCC", "CFC", "CCC")
                .setIngredient('C', new RecipeChoice.ExactChoice(scrollIngridient))
                .setIngredient('F', new RecipeChoice.ExactChoice(fish));
        Bukkit.addRecipe(recipe);
    }

    @SuppressWarnings("deprecation")
    private static void registerScrollLevelRecipe(FishingOP plugin, String id, ItemStack scrollResult, ItemStack scrollIngridient, ItemStack centerItem) {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, id), scrollResult)
                .shape(" C ", "CFC", " C ")
                .setIngredient('C', new RecipeChoice.ExactChoice(scrollIngridient))
                .setIngredient('F', new RecipeChoice.ExactChoice(centerItem));
        Bukkit.addRecipe(recipe);
    }
}
