package com.game.towerdefense.map;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.entities.Bullet;

import java.util.List;

public class MapRenderer {
    private ShapeRenderer shapeRenderer;

    public MapRenderer() {
        shapeRenderer = new ShapeRenderer();
    }

    public void render(Level level, List<Enemy> enemies, List<Tower> towers, List<Bullet> bullets, Tower selectedTower){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // background
        shapeRenderer.setColor(0.12f, 0.45f, 0.18f, 1);
        shapeRenderer.rect(0, 0, 800, 480);

        // path
        shapeRenderer.setColor(0.55f, 0.38f, 0.2f, 1);
        List<Vector2> points = level.getPath().getPoints();

        for (int i = 0; i < points.size() - 1; i++) {
            Vector2 start = points.get(i);
            Vector2 end = points.get(i + 1);
            drawThickLine(start, end, 36);
        }

        // tower spots
        shapeRenderer.setColor(0.2f, 0.75f, 0.2f, 1);
        for (Vector2 spot : level.getTowerSpots()) {
            shapeRenderer.circle(spot.x, spot.y, 22);
        }

        // spawn
        Vector2 spawn = level.getPath().getSpawnPoint();
        shapeRenderer.setColor(0f, 0f, 1f, 1);
        shapeRenderer.circle(spawn.x, spawn.y, 25);

        // base
        Vector2 base = level.getPath().getBasePoint();
        shapeRenderer.setColor(1f, 0f, 0f, 1);
        shapeRenderer.rect(base.x - 25, base.y - 25, 50, 50);

        // enemies
        for (Enemy enemy : enemies) {
            shapeRenderer.setColor(0.8f, 0.1f, 0.1f, 1);
            shapeRenderer.circle(enemy.getPosition().x, enemy.getPosition().y, 14);
        }

        // towers
        for (Tower tower : towers) {
            drawTower(tower);
        }

        // bullets
        for (Bullet bullet : bullets) {
            shapeRenderer.setColor(1f, 1f, 0f, 1);
            shapeRenderer.circle(
                    bullet.getPosition().x,
                    bullet.getPosition().y,
                    5
            );
        }

        if (selectedTower != null) {
            shapeRenderer.setColor(1f, 1f, 1f, 0.25f);
            shapeRenderer.circle(
                    selectedTower.getPosition().x,
                    selectedTower.getPosition().y,
                    selectedTower.getRange()
            );
        }

        shapeRenderer.end();
    }

    private void drawTower(Tower tower) {
        String type = tower.getType();

        if (type.equals("ARROW")) {
            shapeRenderer.setColor(0.1f, 0.1f, 0.9f, 1);
        } else if (type.equals("CANNON")) {
            shapeRenderer.setColor(0.2f, 0.2f, 0.2f, 1);
        } else if (type.equals("ICE")) {
            shapeRenderer.setColor(0.1f, 0.8f, 1f, 1);
        } else if (type.equals("SNIPER")) {
            shapeRenderer.setColor(0.6f, 0.1f, 0.9f, 1);
        } else if (type.equals("MEGA_CANNON")) {
            shapeRenderer.setColor(0f, 0f, 0f, 1);
        } else if (type.equals("FREEZE_AURA")) {
            shapeRenderer.setColor(0.7f, 0.95f, 1f, 1);
        } else {
            shapeRenderer.setColor(1f, 1f, 1f, 1);
        }

        shapeRenderer.rect(
                tower.getPosition().x - 15,
                tower.getPosition().y - 15,
                30,
                30
        );
    }

    private void drawThickLine(Vector2 start, Vector2 end, float thickness) {
        if (start.x == end.x) {
            float y = Math.min(start.y, end.y);
            float height = Math.abs(start.y - end.y);
            shapeRenderer.rect(start.x - thickness / 2f, y, thickness, height);
        } else if (start.y == end.y) {
            float x = Math.min(start.x, end.x);
            float width = Math.abs(start.x - end.x);
            shapeRenderer.rect(x, start.y - thickness / 2f, width, thickness);
        }
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}