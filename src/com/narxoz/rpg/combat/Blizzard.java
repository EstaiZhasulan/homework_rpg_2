package com.narxoz.rpg.combat;

public class Blizzard implements Ability {
    private final String name = "Blizzard";
    private final int damage;
    private final String description;

    public Blizzard() { this(110, "Ultimate: massive ice AoE with chill"); }
    public Blizzard(int damage, String description) { this.damage = damage; this.description = description; }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return AbilityType.ULTIMATE; }
    @Override public Ability clone() { return new Blizzard(damage, description); }
}
