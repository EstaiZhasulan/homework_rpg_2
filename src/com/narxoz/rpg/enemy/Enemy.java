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
    Enemy clone();

    void multiplyStats(double multiplier);
    void setElement(String element);
    void addAbility(Ability ability);
}