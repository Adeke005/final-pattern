package com.game.towerdefense.managers;

import com.badlogic.gdx.math.Vector2;
import com.game.towerdefense.factory.EnemyFactory;

public class WaveManager {
    private int currentWave = 1;
    private int enemiesSpawned = 0;
    private int enemiesPerWave = 5;

    private float spawnTimer = 0f;
    private float spawnDelay = 1.5f;

    private boolean waveFinished = false;

    public void update(float delta, EnemyManager enemyManager, Vector2 spawnPoint) {
        if (waveFinished) return;

        spawnTimer += delta;

        if (spawnTimer >= spawnDelay && enemiesSpawned < enemiesPerWave) {
            String enemyType = getEnemyTypeForWave();

            enemyManager.addEnemy(
                    EnemyFactory.createEnemy(enemyType, spawnPoint.x, spawnPoint.y)
            );

            enemiesSpawned++;
            spawnTimer = 0f;
        }

        if (enemiesSpawned >= enemiesPerWave && enemyManager.getEnemies().isEmpty()) {
            waveFinished = true;
        }
    }

    private String getEnemyTypeForWave() {
        if (currentWave == 1) return "BASIC";
        if (currentWave == 2) return enemiesSpawned % 2 == 0 ? "BASIC" : "FAST";
        return enemiesSpawned % 3 == 0 ? "TANK" : "FAST";
    }

    public void startNextWave() {
        currentWave++;
        enemiesSpawned = 0;
        enemiesPerWave += 3;
        waveFinished = false;
    }

    public boolean isWaveFinished() {
        return waveFinished;
    }

    public boolean isGameCompleted() {
        return currentWave >= 3 && waveFinished;
    }

    public int getCurrentWave() {
        return currentWave;
    }
}