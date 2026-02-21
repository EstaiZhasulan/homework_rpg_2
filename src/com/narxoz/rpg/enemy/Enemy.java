package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface Enemy {
    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    List<Ability> getAbilities();
    LootTable getLootTable();
    void displayInfo();

    // Prototype pattern - must deep copy
    Enemy clone();

    // Helpers for variants (allowed on clones)
    void multiplyStats(double multiplier);
    void addAbility(com.narxoz.rpg.combat.Ability ability);
    void setElement(String element);
}