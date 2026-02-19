package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    private final String name = "Vanish";
    private final int damage;
    private final String description;

    public Vanish() { this(0, "Stealth / evasion ability"); }
    public Vanish(int damage, String description) { this.damage = damage; this.description = description; }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return AbilityType.BUFF; }
    @Override public Ability clone() { return new Vanish(damage, description); }
}
