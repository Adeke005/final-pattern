package com.game.towerdefense.entities;

import com.game.towerdefense.strategy.AttackStrategy;

public abstract class AdvancedTower extends Tower {

    public AdvancedTower(String type, float x, float y, int damage, float range, float cooldown, int cost, AttackStrategy attackStrategy) {
        super(type, x, y, damage, range, cooldown, cost, attackStrategy);
    }
}