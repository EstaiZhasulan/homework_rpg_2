package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractEnemy implements Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String element;
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;

    protected boolean isTemplate = false;

    protected void checkMutable() {
        if (isTemplate) throw new IllegalStateException("Cannot modify template enemy. Clone it first.");
    }

    /**
     * Prototype contract: concrete subclasses must implement public clone()
     * performing a DEEP COPY (clone abilities, clone lootTable, copy maps/lists).
     */
    @Override
    public abstract Enemy clone();

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    @Override public com.narxoz.rpg.loot.LootTable getLootTable() { return lootTable; }

    @Override public void multiplyStats(double multiplier) {
        checkMutable();
        this.health = (int)(this.health * multiplier);
        this.damage = (int)(this.damage * multiplier);
        this.defense = (int)(this.defense * multiplier);
        this.speed = Math.max(1, (int)(this.speed * multiplier));
    }

    @Override public void addAbility(Ability ability) {
        Objects.requireNonNull(ability);
        checkMutable();
        this.abilities.add(ability);
    }

    @Override public void setElement(String element) {
        checkMutable();
        this.element = element;
    }

    @Override public void displayInfo() {
        System.out.println("=== " + name + " ===");
        System.out.println("HP: " + health + " | DMG: " + damage + " | DEF: " + defense + " | SPD: " + speed);
        System.out.println("Element: " + (element == null ? "None" : element));
        System.out.println("Abilities (" + abilities.size() + "):");
        for (com.narxoz.rpg.combat.Ability a : abilities) {
            System.out.println("  - " + a.getName() + " [" + a.getType() + "] : " + a.getDescription() + " (DMG: " + a.getDamage() + ")");
        }
        System.out.println("Loot: " + (lootTable == null ? "none" : lootTable.getLootInfo()));
    }
}