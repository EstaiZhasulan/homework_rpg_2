package com.narxoz.rpg.loot;

import java.util.ArrayList;

public class IceLootTable extends AbstractLootTable {
    public IceLootTable() {
        lootItems.add("Ice Blade");
        lootItems.add("Frozen Crown");
        lootItems.add("Crystal Shield");
        goldDrop = 45;
        experienceDrop = 90;
    }
    @Override public LootTable clone() {
        IceLootTable copy = new IceLootTable();
        copy.lootItems = new ArrayList<>(lootItems);
        copy.goldDrop = goldDrop;
        copy.experienceDrop = experienceDrop;
        return copy;
    }
}
