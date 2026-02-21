package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;
import java.util.*;

public class FireComponentFactory implements EnemyComponentFactory {
    @Override public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new FlameBreath());
        abilities.add(new FireShield());
        abilities.add(new MeteorStorm());
        return abilities;
    }
    @Override public LootTable createLootTable() { return new FireLootTable(); }
    @Override public String createAIBehavior() { return "AGGRESSIVE"; }
}