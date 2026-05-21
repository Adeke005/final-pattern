package com.game.towerdefense.strategy;

import com.game.towerdefense.entities.Enemy;

public class CannonAttack implements AttackStrategy {

    @Override
    public void attack(Enemy enemy, int damage) {
        enemy.takeDamage(damage * 2);
    }
}