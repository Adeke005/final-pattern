package com.game.towerdefense.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.managers.PlayerBase;
import com.game.towerdefense.managers.WaveManager;
import com.game.towerdefense.observer.GameObserver;

public class HUD implements GameObserver {
    private BitmapFont font;
    private String eventText = "";

    public HUD() {
        font = new BitmapFont();
    }

    public void render(SpriteBatch batch, PlayerBase base, WaveManager waveManager, String selectedTower, GameMessage message, int levelNumber) {
        batch.begin();

        font.draw(batch, "HP: " + base.getHp(), 20, 460);
        font.draw(batch, "Gold: " + base.getGold(), 120, 460);
        font.draw(batch, "Wave: " + waveManager.getCurrentWave(), 240, 460);
        font.draw(batch, "Selected Tower: " + selectedTower, 360, 460);
        font.draw(batch, "Level: " + levelNumber, 520, 460);

        font.draw(batch, "1: Arrow | 2: Cannon | 3: Ice | U: Upgrade | M: Merge | RMB: Remove", 20, 30);

        if (message != null && message.isVisible()) {
            font.draw(batch, message.getText(), 300, 430);
        }

        if (!eventText.isEmpty()) {
            font.draw(batch, eventText, 300, 405);
        }

        batch.end();
    }

    @Override
    public void onEnemyKilled(Enemy enemy) {
        eventText = "Enemy killed! +" + enemy.getRewardGold() + " gold";
    }

    @Override
    public void onBaseDamaged(int damage) {
        eventText = "Base damaged! -" + damage + " HP";
    }

    @Override
    public void onWaveCompleted(int waveNumber) {
        eventText = "Wave " + waveNumber + " completed!";
    }

    public void dispose() {
        font.dispose();
    }
}