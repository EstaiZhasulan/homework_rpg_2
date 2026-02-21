package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;
import java.util.*;

public class IceComponentFactory implements EnemyComponentFactory {
    @Override public List<Ability> createAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new FrostBreath());
        abilities.add(new IceShield());
        abilities.add(new Blizzard());
        return abilities;
    }
    @Override public LootTable createLootTable() { return new IceLootTable(); }
    @Override public String createAIBehavior() { return "DEFENSIVE"; }
}