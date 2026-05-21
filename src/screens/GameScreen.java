package com.game.towerdefense.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import com.game.towerdefense.GameApp;
import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.managers.EnemyManager;
import com.game.towerdefense.managers.PlayerBase;
import com.game.towerdefense.managers.TowerManager;
import com.game.towerdefense.managers.WaveManager;
import com.game.towerdefense.map.Level;
import com.game.towerdefense.map.MapRenderer;
import com.game.towerdefense.ui.HUD;

public class GameScreen implements Screen {
    private GameApp game;

    private Level level;
    private MapRenderer mapRenderer;

    private EnemyManager enemyManager;
    private TowerManager towerManager;
    private WaveManager waveManager;
    private PlayerBase base;

    private HUD hud;
    private SpriteBatch batch;

    private String selectedTowerType = "ARROW";

    public GameScreen(GameApp game) {
        this.game = game;
    }

    @Override
    public void show() {
        level = new Level();
        mapRenderer = new MapRenderer();

        enemyManager = new EnemyManager();
        towerManager = new TowerManager();
        waveManager = new WaveManager();

        base = new PlayerBase();

        hud = new HUD();
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        handleInput();

        waveManager.update(delta, enemyManager, level.getPath().getSpawnPoint());

        enemyManager.update(delta, level.getPath().getPoints(), base);
        towerManager.update(delta, enemyManager.getEnemies());

        mapRenderer.render(level);
        hud.render(batch, base, waveManager, selectedTowerType);

        if (base.isDestroyed()) {
            game.setScreen(new GameOverScreen(game));
        }

        if (waveManager.isGameCompleted()) {
            game.setScreen(new WinScreen(game));
        }

        if (waveManager.isWaveFinished() && !waveManager.isGameCompleted()) {
            waveManager.startNextWave();
        }
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new PauseScreen(game, this));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            selectedTowerType = "ARROW";
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            selectedTowerType = "CANNON";
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            selectedTowerType = "ICE";
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            towerManager.tryMergeSelectedTowers();
        }

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY();

            Tower clickedTower = towerManager.findTowerAt(x, y);

            if (clickedTower != null) {
                towerManager.selectTower(x, y);
                return;
            }

            Vector2 spot = level.getNearestTowerSpot(x, y);

            if (spot != null) {
                towerManager.placeTower(selectedTowerType, spot.x, spot.y, base);
            }
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        mapRenderer.dispose();
        hud.dispose();
        batch.dispose();
    }
}