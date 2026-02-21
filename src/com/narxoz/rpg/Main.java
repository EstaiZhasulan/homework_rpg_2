package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;
import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("Fire components:");
        List<Ability> fireAbilities = fireFactory.createAbilities();
        System.out.println("  Abilities:");
        fireAbilities.forEach(a -> System.out.println("   - " + a.getName() + " : " + a.getDescription()));
        System.out.println("  Loot: " + fireFactory.createLootTable().getLootInfo());
        System.out.println("  AI: " + fireFactory.createAIBehavior());
        System.out.println();

        System.out.println("Ice components:");
        iceFactory.createAbilities().forEach(a -> System.out.println("   - " + a.getName() + " : " + a.getDescription()));
        System.out.println("  Loot: " + iceFactory.createLootTable().getLootInfo());
        System.out.println("  AI: " + iceFactory.createAIBehavior());
        System.out.println();

        System.out.println("Shadow components:");
        shadowFactory.createAbilities().forEach(a -> System.out.println("   - " + a.getName() + " : " + a.getDescription()));
        System.out.println("  Loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println("  AI: " + shadowFactory.createAIBehavior());
        System.out.println("\n--------------------------------\n");

        System.out.println("PART 2: BUILDER - Complex Enemy Construction\n");
        BossEnemyBuilder bossBuilder = new BossEnemyBuilder();
        Enemy dragon = bossBuilder
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(20)
                .build();

        System.out.println("Built dragon (template):");
        dragon.displayInfo();
        System.out.println("\n--------------------------------\n");

        System.out.println("Director presets:");
        EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        Enemy raidBoss = director.createRaidBoss(iceFactory);
        raidBoss.displayInfo();
        System.out.println("\n--------------------------------\n");

        System.out.println("PART 3: PROTOTYPE - Cloning & Variants\n");
        EnemyRegistry registry = new EnemyRegistry();

        BasicEnemyBuilder basicBuilder = new BasicEnemyBuilder();
        Enemy baseGoblin = basicBuilder.setName("Forest Goblin")
                .setHealth(100).setDamage(15).setDefense(5).setSpeed(35)
                .addAbility(new FlameBreath())
                .build();

        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("dragon", dragon);

        System.out.println("Templates registered: " + registry.listTemplates());
        System.out.println();

        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.addAbility(new ShadowStrike()); // modifying clone
        System.out.println("Elite Goblin (clone):");
        eliteGoblin.displayInfo();

        System.out.println("\nOriginal Goblin Template (should be unchanged):");
        baseGoblin.displayInfo();
        System.out.println("\nDeep copy verified if original unchanged.\n--------------------------------\n");

        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER\n");
        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80000)
                .setDamage(900)
                .setDefense(300)
                .setSpeed(40)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .addPhase(1, 80000)
                .addPhase(2, 40000)
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .setCanFly(false)
                .setHasBreathAttack(false)
                .setWingspan(0)
                .build();

        System.out.println("Demon Lord template:");
        demonLord.displayInfo();

        registry.registerTemplate("demon-lord", demonLord);
        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        greaterDemon.multiplyStats(2.0);
        System.out.println("\nGreater Demon (clone x2):");
        greaterDemon.displayInfo();

        System.out.println("\n============================================");
        System.out.println("PATTERN SUMMARY:");
        System.out.println("Abstract Factory: Fire/Ice/Shadow factories create matching abilities+loot+AI.");
        System.out.println("Builder: BossEnemyBuilder & BasicEnemyBuilder implement fluent API; build() validates and is FACTORY METHOD.");
        System.out.println("Factory Method: build() is the factory method. Director delegates to builder polymorphically.");
        System.out.println("Prototype: EnemyRegistry returns clones; clone() implementations perform deep copy.");
        System.out.println("============================================");
        System.out.println("\n=== Demo Complete ===");
    }
}