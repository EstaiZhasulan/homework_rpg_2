package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
                .setName("Minion")
                .setHealth(50)
                .setDamage(8)
                .setDefense(2)
                .setSpeed(20)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
                .setName("Elite")
                .setHealth(200)
                .setDamage(40)
                .setDefense(15)
                .setSpeed(25)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Mini Boss")
                .setHealth(20000)
                .setDamage(400)
                .addPhase(1, 20000)
                .addPhase(2, 10000)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Raid Boss")
                .setHealth(100000)
                .setDamage(1000)
                .addPhase(1, 100000)
                .addPhase(2, 50000)
                .addPhase(3, 25000)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }
}