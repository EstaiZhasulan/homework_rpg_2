package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.builder.BossEnemyBuilder;

import java.util.*;

public class DragonBoss extends AbstractEnemy {
    private Map<Integer, Integer> phases = new LinkedHashMap<>();
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    DragonBoss(BossEnemyBuilder b) {
        // copy primitive fields
        this.name = b.name;
        this.health = b.health;
        this.damage = b.damage;
        this.defense = b.defense;
        this.speed = b.speed;
        this.element = b.element;
        this.abilities = new ArrayList<>();
        if (b.abilities != null) {
            for (Ability a : b.abilities) {
                this.abilities.add(a.clone());
            }
        }
        this.phases = new LinkedHashMap<>(b.phases);
        this.lootTable = (b.lootTable == null) ? null : b.lootTable.clone();
        this.aiBehavior = b.aiBehavior;
        this.canFly = b.canFly;
        this.hasBreathAttack = b.hasBreathAttack;
        this.wingspan = b.wingspan;
        // mark template / builder default isTemplate true
        this.isTemplate = b.isTemplate;
    }

    @Deprecated
    public DragonBoss(String name, int health, int damage, int defense,
                      int speed, String element, List<Ability> abilities,
                      int phase1Threshold, int phase2Threshold, int phase3Threshold,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {
        this.name = name; this.health = health; this.damage = damage; this.defense = defense; this.speed = speed;
        this.element = element;
        this.abilities = (abilities == null) ? new ArrayList<>() : new ArrayList<>(abilities);
        this.phases = new LinkedHashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);
        this.lootTable = (lootTable == null) ? null : lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly; this.hasBreathAttack = hasBreathAttack; this.wingspan = wingspan;
    }

    @Override
    public Enemy clone() {
        DragonBoss copy = new DragonBoss(this.name, this.health, this.damage, this.defense,
                this.speed, this.element, new ArrayList<>(),
                0,0,0, // these are placeholders — we'll copy phases below
                (this.lootTable == null) ? null : this.lootTable.clone(),
                this.aiBehavior, this.canFly, this.hasBreathAttack, this.wingspan);

        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) copy.abilities.add(a.clone());
        copy.phases = new LinkedHashMap<>();
        for (Map.Entry<Integer,Integer> e : this.phases.entrySet()) copy.phases.put(e.getKey(), e.getValue());
        copy.lootTable = (this.lootTable == null) ? null : this.lootTable.clone();
        copy.isTemplate = false; // clones are mutable
        return copy;
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
        for (com.narxoz.rpg.combat.Ability a : abilities) {
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