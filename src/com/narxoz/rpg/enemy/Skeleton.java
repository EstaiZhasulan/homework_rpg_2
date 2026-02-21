package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import java.util.ArrayList;

public class Skeleton extends AbstractEnemy {

    public Skeleton(String name) {
        this.name = name;
        this.health = 80;
        this.damage = 20;
        this.defense = 8;
        this.speed = 25;
        this.abilities = new ArrayList<>();
    }

    @Override
    public Enemy clone() {
        Skeleton copy = new Skeleton(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.abilities = new java.util.ArrayList<>();
        for (Ability a : this.abilities) copy.abilities.add(a.clone());
        copy.lootTable = (this.lootTable == null) ? null : this.lootTable.clone();
        copy.isTemplate = false;
        return copy;
    }
}