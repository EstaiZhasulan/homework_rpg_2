package com.narxoz.rpg.combat;

public class FireShield implements Ability {
    private final String name = "Fire Shield";
    private final int damage; // defensive buff may have zero damage
    private final String description;

    public FireShield() { this(0, "Defensive buff that reduces incoming damage"); }
    public FireShield(int damage, String description) {
        this.damage = damage;
        this.description = description;
    }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return AbilityType.BUFF; }
    @Override public Ability clone() { return new FireShield(damage, description); }
}
