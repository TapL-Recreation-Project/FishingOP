package me.swipez.fishingop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class RandomLootPicker {
    private static final Random rng = new Random();
    private final FishingOP plugin;
    private final List<Integer> cumulativeWeights = new ArrayList<>();
    private final List<Material> allMaterials = new ArrayList<Material>();
    private Configuration itemsConfig;

    public RandomLootPicker(FishingOP plugin) {
        this.itemsConfig = plugin.getConfig();
        this.plugin = plugin;
        buildMaterialAndWeightList();
    }

    public void reloadConfig() {
        this.itemsConfig = plugin.getConfig();
        buildMaterialAndWeightList();
    }

    private void buildMaterialAndWeightList() {
        int weightSum = 0;
        cumulativeWeights.add(0);
        Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] Starting to build material + weight list");
        for (String itemKey : this.itemsConfig.getConfigurationSection("drop_items").getKeys(false)) {
            Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] " + itemKey);
            Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] getting " + "drop_items." + itemKey + ".relative_chance, found value: " +
                    this.itemsConfig.getInt("drop_items." + itemKey + ".relative_chance"));
            weightSum += this.itemsConfig.getInt("drop_items." + itemKey + ".relative_chance");
            allMaterials.add(Material.matchMaterial(itemKey));
            cumulativeWeights.add(weightSum);
        }
        Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] These are all the materials and indexes: ");
        int index = 0;
        for (Material material : allMaterials) {
            Bukkit.getLogger().log(Level.INFO, index + ": " + allMaterials.get(index));
            index++;
        }
    }

    public ItemStack randomItemStack() {
        int maxWeight = cumulativeWeights.get(cumulativeWeights.size() - 1);
        Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] The maximum weight is " + maxWeight);
        double randomWeight = rng.nextDouble() * maxWeight;
        Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] Picked a random weight of " + randomWeight);
        Bukkit.getLogger().log(Level.INFO, "Starting to iterate through all cumulative weights, starting from the last");
        int numberOfWeights = cumulativeWeights.size();
        int bracket;
        for (bracket = numberOfWeights - 1; bracket >= 0; bracket--) {
            int weight = cumulativeWeights.get(bracket);
            Bukkit.getLogger().log(Level.INFO, "Found " + weight + ", comparing to " + randomWeight);
            if (randomWeight >= weight) {
                break;
            }
            Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] Now in bracket " + bracket + " (threshold: weight " + weight + ")");
        }
        Material randomMaterial = allMaterials.get(bracket);
        Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] Returning this material: " + randomMaterial);
        int amount = itemsConfig.getInt("drop_items." + randomMaterial.toString().toLowerCase() + ".amount");
        Bukkit.getLogger().log(Level.INFO, "[FISHING_OP_TEST] Amount: " + amount);
        return new ItemStack(randomMaterial, amount);
    }
}
