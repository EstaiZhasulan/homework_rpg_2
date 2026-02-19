package com.narxoz.rpg.loot;

import java.util.ArrayList;

public class FireLootTable extends AbstractLootTable {
    public FireLootTable() {
        lootItems.add("Flaming Sword");
        lootItems.add("Fire Amulet");
        lootItems.add("Burning Armor");
        goldDrop = 50;
        experienceDrop = 100;
    }
    @Override public LootTable clone() {
        FireLootTable copy = new FireLootTable();
        copy.lootItems = new ArrayList<>(lootItems);
        copy.goldDrop = goldDrop;
        copy.experienceDrop = experienceDrop;
        return copy;
    }
}
