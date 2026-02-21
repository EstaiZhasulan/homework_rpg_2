package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {
    String name;
    int health = 100;
    int damage = 10;
    int defense = 5;
    int speed = 20;
    String element;
    List<Ability> abilities = new ArrayList<>();
    LootTable lootTable;

    @Override public BasicEnemyBuilder setName(String name){ this.name = name; return this; }
    @Override public BasicEnemyBuilder setHealth(int health){ this.health = health; return this; }
    @Override public BasicEnemyBuilder setDamage(int damage){ this.damage = damage; return this; }
    @Override public BasicEnemyBuilder setDefense(int defense){ this.defense = defense; return this; }
    @Override public BasicEnemyBuilder setSpeed(int speed){ this.speed = speed; return this; }
    @Override public BasicEnemyBuilder setElement(String element){ this.element = element; return this; }
    @Override public BasicEnemyBuilder addAbility(Ability ability){ this.abilities.add(ability); return this; }
    @Override public BasicEnemyBuilder setAbilities(List<Ability> abilities){
        this.abilities = new ArrayList<>(abilities); return this;
    }
    @Override public BasicEnemyBuilder addPhase(int phaseNumber, int healthThreshold){
        return this;
    }
    @Override public BasicEnemyBuilder setLootTable(LootTable loot){ this.lootTable = loot; return this; }
    @Override public BasicEnemyBuilder setAI(String aiBehavior){ /* not used for basic */ return this; }

    @Override
    public Enemy build() {
        if (name == null || name.isEmpty()) throw new IllegalStateException("Name required");

        LootTable clonedLoot = (this.lootTable == null) ? null : this.lootTable.clone();
        Goblin g = new Goblin(
                this.name,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                this.element,
                this.abilities,
                clonedLoot,
                true
        );
        return g;
    }
}