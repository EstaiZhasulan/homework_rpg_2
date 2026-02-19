package com.narxoz.rpg.combat;

public class FireShield extends AbstractAbility {

    public FireShield() {
        super("Fire Shield", 0, "Creates a protective wall of fire.");
    }

    @Override
    public Ability clone() {
        return new FireShield();
    }
}
