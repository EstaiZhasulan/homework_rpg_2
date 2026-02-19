package com.narxoz.rpg.combat;

public abstract class AbstractAbility implements Ability {

    protected String name;
    protected int damage;
    protected String description;

    public AbstractAbility(String name, int damage, String description) {
        this.name = name;
        this.damage = damage;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
