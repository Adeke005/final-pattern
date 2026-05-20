package com.game.towerdefense.factory;

import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.enemies.BasicEnemy;
import com.game.towerdefense.enemies.FastEnemy;
import com.game.towerdefense.enemies.TankEnemy;

public class EnemyFactory {

    public static Enemy createEnemy(String type, float x, float y) {
        switch (type) {
            case "BASIC":
                return new BasicEnemy(x, y);
            case "FAST":
                return new FastEnemy(x, y);
            case "TANK":
                return new TankEnemy(x, y);
            default:
                return new BasicEnemy(x, y);
        }
    }
}