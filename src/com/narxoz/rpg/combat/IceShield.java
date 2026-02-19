package com.narxoz.rpg.combat;

public class IceShield extends AbstractAbility {

    public IceShield() {
        super("Ice Shield", 0, "defense with icy armor.");
    }

    @Override
    public Ability clone() {
        return new IceShield();
    }
}
