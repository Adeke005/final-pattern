mappackage com.game.towerdefense.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.game.towerdefense.enemies.BasicEnemy;
import com.game.towerdefense.managers.EnemyManager;
import com.game.towerdefense.managers.PlayerBase;
import com.game.towerdefense.managers.TowerManager;
import com.game.towerdefense.map.Level;
import com.game.towerdefense.map.MapRenderer;

public class GameScreen implements Screen {
    private Level level;
    private MapRenderer mapRenderer;

    private EnemyManager enemyManager;
    private TowerManager towerManager;
    private PlayerBase base;

    private float spawnTimer = 0f;

    @Override
    public void show() {
        level = new Level();
        mapRenderer = new MapRenderer();

        enemyManager = new EnemyManager();
        towerManager = new TowerManager();
        base = new PlayerBase();
    }

    @Override
    public void render(float delta) {
        spawnTimer += delta;

        if (spawnTimer > 2f) {
            Vector2 spawn = level.getPath().getSpawnPoint();
            enemyManager.addEnemy(new BasicEnemy(spawn.x, spawn.y));
            spawnTimer = 0f;
        }

        enemyManager.update(delta, level.getPath().getPoints(), base);
        towerManager.update(delta, enemyManager.getEnemies());

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY();

            Vector2 spot = level.getNearestTowerSpot(x, y);

            if (spot != null) {
                towerManager.placeTower("ARROW", spot.x, spot.y, base);
            }
        }

        mapRenderer.render(level);

        if (base.isDestroyed()) {
            System.out.println("GAME OVER");
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        mapRenderer.dispose();
    }
}