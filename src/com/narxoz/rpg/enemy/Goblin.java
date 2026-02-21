package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends AbstractEnemy {

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.abilities = new ArrayList<>();
        this.lootTable = null;
        this.isTemplate = false;
    }

    /**
     * Новый конструктор — используется билдерами.
     * Конструктор выполняет deep copy списка abilities и клонирование lootTable.
     *
     * @param name       имя
     * @param health     здоровье
     * @param damage     урон
     * @param defense    защита
     * @param speed      скорость
     * @param element    элемент (может быть null)
     * @param abilities  список способностей (может быть null)
     * @param lootTable  таблица лута (может быть null)
     * @param isTemplate пометка шаблона (immutable)
     */
    public Goblin(String name, int health, int damage, int defense, int speed,
                  String element, List<Ability> abilities, LootTable lootTable, boolean isTemplate) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;

        // deep copy abilities
        this.abilities = new ArrayList<>();
        if (abilities != null) {
            for (Ability a : abilities) {
                this.abilities.add(a.clone());
            }
        }

        this.lootTable = (lootTable == null) ? null : lootTable.clone();

        this.isTemplate = isTemplate;
    }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(
                this.name,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                this.element,
                this.abilities,
                this.lootTable,
                false
        );
        return copy;
    }
}