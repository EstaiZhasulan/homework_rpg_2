package com.narxoz.rpg.combat;

public class FlameBreath extends AbstractAbility {

    public FlameBreath() {
        super("Flame Breath", 120, "Burns with fire.");
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}
