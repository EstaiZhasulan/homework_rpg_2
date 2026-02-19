package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability {
    private final String name = "Meteor Storm";
    private final int damage;
    private final String description;

    public MeteorStorm() { this(120, "Ultimate: massive AoE meteor strike"); }
    public MeteorStorm(int damage, String description) { this.damage = damage; this.description = description; }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return AbilityType.ULTIMATE; }
    @Override public Ability clone() { return new MeteorStorm(damage, description); }
}
