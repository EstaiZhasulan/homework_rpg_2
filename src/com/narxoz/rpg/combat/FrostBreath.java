package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    private final String name = "Frost Breath";
    private final int damage;
    private final String description;

    public FrostBreath() { this(40, "Cold AoE damage + slow"); }
    public FrostBreath(int damage, String description) { this.damage = damage; this.description = description; }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return AbilityType.DAMAGE; }
    @Override public Ability clone() { return new FrostBreath(damage, description); }
}
