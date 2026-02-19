package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {
    private final List<String> items;
    private final int gold;
    private final int exp;

    public IceLootTable() {
        items = new ArrayList<>();
        items.add("Ice Gem");
        items.add("Frost Scale");
        items.add("Ice Rune");
        gold = 450;
        exp = 1800;
    }

    private IceLootTable(List<String> items, int gold, int exp) {
        this.items = new ArrayList<>(items);
        this.gold = gold; this.exp = exp;
    }

    @Override public List<String> getItems() { return new ArrayList<>(items); }
    @Override public int getGoldDrop() { return gold; }
    @Override public int getExperienceDrop() { return exp; }
    @Override public String getLootInfo() { return "Items: " + items + " Gold: " + gold + " EXP: " + exp; }
    @Override public LootTable clone() { return new IceLootTable(this.items, this.gold, this.exp); }
}
