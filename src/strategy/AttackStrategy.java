package com.game.towerdefense.strategy;

import com.game.towerdefense.entities.Enemy;

public interface AttackStrategy {
    void attack(Enemy enemy, int damage);
}