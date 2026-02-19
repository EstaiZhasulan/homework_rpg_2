package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {
    private final List<String> items;
    private final int gold;
    private final int exp;

    public FireLootTable() {
        items = new ArrayList<>();
        items.add("Fire Gem");
        items.add("Dragon Scale");
        items.add("Flame Rune");
        gold = 500;
        exp = 2000;
    }

    private FireLootTable(List<String> items, int gold, int exp) {
        this.items = new ArrayList<>(items);
        this.gold = gold;
        this.exp = exp;
    }

    @Override public List<String> getItems() { return new ArrayList<>(items); }
    @Override public int getGoldDrop() { return gold; }
    @Override public int getExperienceDrop() { return exp; }
    @Override public String getLootInfo() { return "Items: " + items + " Gold: " + gold + " EXP: " + exp; }
    @Override public LootTable clone() { return new FireLootTable(this.items, this.gold, this.exp); }
}
