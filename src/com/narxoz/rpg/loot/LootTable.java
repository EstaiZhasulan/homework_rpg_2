package com.narxoz.rpg.loot;

import java.util.List;

public interface LootTable {
    java.util.List<String> getItems();
    int getGoldDrop();
    int getExperienceDrop();
    String getLootInfo();
    LootTable clone();
}
