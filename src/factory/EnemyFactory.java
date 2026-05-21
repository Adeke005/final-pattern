package com.game.towerdefense.factory;

import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.enemies.BasicEnemy;
import com.game.towerdefense.enemies.FastEnemy;
import com.game.towerdefense.enemies.TankEnemy;
import com.game.towerdefense.enemies.BossEnemy;

public class EnemyFactory {

    public static Enemy createEnemy(String type, float x, float y) {
        switch (type) {
            case "BASIC":
                return new BasicEnemy(x, y);
            case "FAST":
                return new FastEnemy(x, y);
            case "TANK":
                return new TankEnemy(x, y);
            case "BOSS":
                return new BossEnemy(x, y);
            default:
                return new BasicEnemy(x, y);
        }
    }
}