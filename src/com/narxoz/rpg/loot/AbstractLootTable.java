package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLootTable implements LootTable {
    protected List<String> lootItems = new ArrayList<>();
    protected int goldDrop;
    protected int experienceDrop;

    @Override public List<String> getLootItems() { return new ArrayList<>(lootItems); }
    @Override public int getGoldDrop() { return goldDrop; }
    @Override public int getExperienceDrop() { return experienceDrop; }
}
