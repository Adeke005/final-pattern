package com.game.towerdefense.observer;

import com.game.towerdefense.entities.Enemy;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyEnemyKilled(Enemy enemy) {
        for (GameObserver observer : observers) {
            observer.onEnemyKilled(enemy);
        }
    }

    public void notifyBaseDamaged(int damage) {
        for (GameObserver observer : observers) {
            observer.onBaseDamaged(damage);
        }
    }

    public void notifyWaveCompleted(int waveNumber) {
        for (GameObserver observer : observers) {
            observer.onWaveCompleted(waveNumber);
        }
    }
}