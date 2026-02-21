package com.narxoz.rpg.enemy;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Complex boss enemy. Constructor that accepts BossEnemyBuilder is public
 * so the builder (in another package) can instantiate DragonBoss.
 */
public class DragonBoss extends AbstractEnemy {
    private Map<Integer, Integer> phases = new LinkedHashMap<>();
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    /**
     * Public constructor used by BossEnemyBuilder.
     * Performs defensive/deep copies of collections and components.
     */
    public DragonBoss(BossEnemyBuilder b) {
        this.name = b.getName();
        this.health = b.getHealth();
        this.damage = b.getDamage();
        this.defense = b.getDefense();
        this.speed = b.getSpeed();
        this.element = b.getElement();

        this.abilities = new ArrayList<>();
        List<Ability> bAbilities = b.getAbilities();
        if (bAbilities != null) {
            for (Ability a : bAbilities) {
                this.abilities.add(a.clone());
            }
        }

        this.phases = new LinkedHashMap<>(b.getPhases());

        LootTable lt = b.getLootTable();
        this.lootTable = (lt == null) ? null : lt.clone();

        this.aiBehavior = b.getAiBehavior();
        this.canFly = b.isCanFly();
        this.hasBreathAttack = b.isHasBreathAttack();
        this.wingspan = b.getWingspan();

        this.isTemplate = b.isTemplate();
    }

    /**
     * Copy-constructor used by clone().
     */
    public DragonBoss(DragonBoss other) {
        this.name = other.name;
        this.health = other.health;
        this.damage = other.damage;
        this.defense = other.defense;
        this.speed = other.speed;
        this.element = other.element;

        this.abilities = new ArrayList<>();
        for (Ability a : other.abilities) this.abilities.add(a.clone());

        this.phases = new LinkedHashMap<>(other.phases);

        this.lootTable = (other.lootTable == null) ? null : other.lootTable.clone();

        this.aiBehavior = other.aiBehavior;
        this.canFly = other.canFly;
        this.hasBreathAttack = other.hasBreathAttack;
        this.wingspan = other.wingspan;

        this.isTemplate = false;
    }

    @Deprecated
    public DragonBoss(String name, int health, int damage, int defense,
                      int speed, String element,
                      List<Ability> abilities,
                      int phase1Threshold, int phase2Threshold, int phase3Threshold,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = (abilities == null) ? new ArrayList<>() : new ArrayList<>(abilities);
        this.phases = new LinkedHashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);
        this.lootTable = (lootTable == null) ? null : lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
        this.isTemplate = true;
    }

    @Override
    public Enemy clone() {
        return new DragonBoss(this);
    }

    public Map<Integer, Integer> getPhases() { return new LinkedHashMap<>(phases); }
    public String getAiBehavior() { return aiBehavior; }
    public boolean isCanFly() { return canFly; }
    public boolean isHasBreathAttack() { return hasBreathAttack; }
    public int getWingspan() { return wingspan; }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + (element == null ? "None" : element));
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " [" + a.getType() + "] : " + a.getDescription() + " (DMG: " + a.getDamage() + ")");
        }
        System.out.println("Boss Phases:");
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey() + " triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly + " | Breath Attack: " + hasBreathAttack + " | Wingspan: " + wingspan);
        System.out.println("Loot: " + ((lootTable == null) ? "none" : lootTable.getLootInfo()));
    }
}