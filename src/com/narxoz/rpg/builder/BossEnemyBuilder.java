package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class BossEnemyBuilder implements EnemyBuilder {
    String name;
    int health;
    int damage;
    int defense;
    int speed;
    String element;
    List<Ability> abilities = new ArrayList<>();
    LinkedHashMap<Integer,Integer> phases = new LinkedHashMap<>();
    LootTable lootTable;
    String aiBehavior;
    boolean canFly = false;
    boolean hasBreathAttack = false;
    int wingspan = 0;
    boolean isTemplate = true;

    @Override public BossEnemyBuilder setName(String name){ this.name = name; return this; }
    @Override public BossEnemyBuilder setHealth(int health){ this.health = health; return this; }
    @Override public BossEnemyBuilder setDamage(int damage){ this.damage = damage; return this; }
    @Override public BossEnemyBuilder setDefense(int defense){ this.defense = defense; return this; }
    @Override public BossEnemyBuilder setSpeed(int speed){ this.speed = speed; return this; }
    @Override public BossEnemyBuilder setElement(String element){ this.element = element; return this; }
    @Override public BossEnemyBuilder addAbility(Ability ability){ this.abilities.add(ability); return this; }
    @Override public BossEnemyBuilder setAbilities(List<Ability> abilities){
        this.abilities = new ArrayList<>(abilities); return this;
    }
    @Override public BossEnemyBuilder addPhase(int phaseNumber, int healthThreshold){ this.phases.put(phaseNumber, healthThreshold); return this; }
    @Override public BossEnemyBuilder setLootTable(LootTable loot){ this.lootTable = loot; return this; }
    @Override public BossEnemyBuilder setAI(String aiBehavior){ this.aiBehavior = aiBehavior; return this; }

    public BossEnemyBuilder setCanFly(boolean canFly){ this.canFly = canFly; return this; }
    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack){ this.hasBreathAttack = hasBreathAttack; return this; }
    public BossEnemyBuilder setWingspan(int wingspan){ this.wingspan = wingspan; return this; }

    @Override
    public Enemy build() {
        if (name == null || name.isEmpty()) throw new IllegalStateException("Name required");
        if (health <= 0) throw new IllegalStateException("Health must be positive");

        DragonBoss boss = new DragonBoss(this);
        boss.isTemplate = true;
        return boss;
    }
}