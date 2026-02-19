package com.narxoz.rpg.combat;

public class FrostBreath extends AbstractAbility {

    public FrostBreath() {
        super("Frost Breath", 100, "Freezes enemies and slows them.");
    }

    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}
