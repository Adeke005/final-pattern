package com.game.towerdefense.managers;

import com.badlogic.gdx.math.Vector2;
import com.game.towerdefense.factory.EnemyFactory;

public class WaveManager {
    private int currentWave = 1;
    private int enemiesSpawned = 0;

    private float spawnTimer = 0f;
    private float spawnDelay = 1.5f;

    private boolean waveFinished = false;

    public void update(float delta, EnemyManager enemyManager, Vector2 spawnPoint) {
        if (waveFinished) return;

        spawnTimer += delta;

        if (spawnTimer >= spawnDelay && enemiesSpawned < getEnemiesPerWave()) {
            String enemyType = getEnemyTypeForWave();

            enemyManager.addEnemy(
                    EnemyFactory.createEnemy(enemyType, spawnPoint.x, spawnPoint.y)
            );

            enemiesSpawned++;
            spawnTimer = 0f;
        }

        if (enemiesSpawned >= getEnemiesPerWave() && enemyManager.getEnemies().isEmpty()) {
            waveFinished = true;
        }
    }

    private int getEnemiesPerWave() {
        if (currentWave == 1) return 5;
        if (currentWave == 2) return 8;
        if (currentWave == 3) return 10;
        if (currentWave == 4) return 1;
        return 0;
    }

    private String getEnemyTypeForWave() {
        if (currentWave == 1) {
            return "BASIC";
        }

        if (currentWave == 2) {
            return enemiesSpawned % 2 == 0 ? "BASIC" : "FAST";
        }

        if (currentWave == 3) {
            return enemiesSpawned % 3 == 0 ? "TANK" : "FAST";
        }

        if (currentWave == 4) {
            return "BOSS";
        }

        return "BASIC";
    }

    public void startNextWave() {
        currentWave++;
        enemiesSpawned = 0;
        spawnTimer = 0f;
        waveFinished = false;
    }

    public boolean isWaveFinished() {
        return waveFinished;
    }

    public boolean isGameCompleted() {
        return currentWave == 4 && waveFinished;
    }

    public int getCurrentWave() {
        return currentWave;
    }
}