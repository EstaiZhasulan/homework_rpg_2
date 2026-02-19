package com.narxoz.rpg.combat;

public class DarkNova extends AbstractAbility {

    public DarkNova() {
        super("Dark Nova", 180, "Massive shadow explosion.");
    }

    @Override
    public Ability clone() {
        return new DarkNova();
    }
}
