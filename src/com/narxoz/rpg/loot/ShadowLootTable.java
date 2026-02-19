package com.narxoz.rpg.loot;

import java.util.ArrayList;

public class ShadowLootTable extends AbstractLootTable {
    public ShadowLootTable() {
        lootItems.add("Shadow Dagger");
        lootItems.add("Dark Cloak");
        lootItems.add("Soul Ring");
        goldDrop = 60;
        experienceDrop = 120;
    }
    @Override public LootTable clone() {
        ShadowLootTable copy = new ShadowLootTable();
        copy.lootItems = new ArrayList<>(lootItems);
        copy.goldDrop = goldDrop;
        copy.experienceDrop = experienceDrop;
        return copy;
    }
}
