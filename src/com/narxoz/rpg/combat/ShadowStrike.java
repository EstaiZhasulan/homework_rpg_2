package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    private final String name = "Shadow Strike";
    private final int damage;
    private final String description;

    public ShadowStrike() { this(70, "High single-target damage + blind"); }
    public ShadowStrike(int damage, String description) { this.damage = damage; this.description = description; }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return AbilityType.DAMAGE; }
    @Override public Ability clone() { return new ShadowStrike(damage, description); }
}
