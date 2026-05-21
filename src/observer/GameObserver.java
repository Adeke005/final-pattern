package com.game.towerdefense.observer;

import com.game.towerdefense.entities.Enemy;

public interface GameObserver {
    void onEnemyKilled(Enemy enemy);
    void onBaseDamaged(int damage);
    void onWaveCompleted(int waveNumber);
}