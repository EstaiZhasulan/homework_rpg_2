package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    private final String name = "Flame Breath";
    private final int damage;
    private final String description;

    public FlameBreath() {
        this(50, "AoE fire damage + burn");
    }
    public FlameBreath(int damage, String description) {
        this.damage = damage;
        this.description = description;
    }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }
    @Override public AbilityType getType() { return AbilityType.DAMAGE; }
    @Override public Ability clone() { return new FlameBreath(damage, description); }
}
