package com.narxoz.rpg.combat;

public class ShadowStrike extends AbstractAbility {

    public ShadowStrike() {
        super("Shadow Strike", 150, "High damage stealth attack.");
    }

    @Override
    public Ability clone() {
        return new ShadowStrike();
    }
}
