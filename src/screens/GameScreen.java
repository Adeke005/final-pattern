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
import com.game.towerdefense.ui.GameMessage;
import com.game.towerdefense.observer.EventManager;

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
    private GameMessage gameMessage;
    private EventManager eventManager;

    private String selectedTowerType = "ARROW";

    public GameScreen(GameApp game) {
        this.game = game;
    }

    @Override
    @Override
    public void show() {
        level = new Level();
        mapRenderer = new MapRenderer();

        eventManager = new EventManager();

        hud = new HUD();
        eventManager.addObserver(hud);

        enemyManager = new EnemyManager(eventManager);
        towerManager = new TowerManager();
        waveManager = new WaveManager();

        base = new PlayerBase();

        batch = new SpriteBatch();
        gameMessage = new GameMessage();
    }

    @Override
    public void render(float delta) {
        handleInput();

        waveManager.update(delta, enemyManager, level.getPath().getSpawnPoint());

        enemyManager.update(delta, level.getPath().getPoints(), base);
        towerManager.update(delta, enemyManager.getEnemies());

        mapRenderer.render(
                level,
                enemyManager.getEnemies(),
                towerManager.getTowers(),
                towerManager.getFirstSelectedTower()
        );

        gameMessage.update(delta);

        hud.render(batch, base, waveManager, selectedTowerType, gameMessage);

        if (base.isDestroyed()) {
            game.setScreen(new GameOverScreen(game));
        }

        if (waveManager.isGameCompleted()) {
            game.setScreen(new WinScreen(game));
        }

        if (waveManager.isWaveFinished() && !waveManager.isGameCompleted()) {
            eventManager.notifyWaveCompleted(waveManager.getCurrentWave());
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
            boolean merged = towerManager.tryMergeSelectedTowers();

            if (merged) {
                gameMessage.show("Towers merged");
            } else {
                gameMessage.show("Cannot merge towers");
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.U)) {
            boolean upgraded = towerManager.upgradeSelectedTower(base);

            if (upgraded) {
                gameMessage.show("Tower upgraded");
            } else {
                gameMessage.show("Cannot upgrade tower");
            }
        }

        if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY();

            boolean removed = towerManager.removeTowerAt(x, y);

            if (removed) {
                gameMessage.show("Tower removed");
            }
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
                boolean placed = towerManager.placeTower(selectedTowerType, spot.x, spot.y, base);

                if (placed) {
                    gameMessage.show("Tower placed");
                } else {
                    gameMessage.show("Not enough gold");
                }
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