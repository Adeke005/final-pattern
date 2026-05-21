package com.game.towerdefense.map;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MapRenderer {
    private ShapeRenderer shapeRenderer;

    public MapRenderer() {
        shapeRenderer = new ShapeRenderer();
    }

    public void render(Level level) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // path
        shapeRenderer.setColor(0.5f, 0.35f, 0.2f, 1);
        for (Vector2 point : level.getPath().getPoints()) {
            shapeRenderer.circle(point.x, point.y, 18);
        }

        // tower spots
        shapeRenderer.setColor(0.2f, 0.7f, 0.2f, 1);
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            selectedTowerType = "ARROW";
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            selectedTowerType = "CANNON";
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            selectedTowerType = "ICE";
        }

        shapeRenderer.end();
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}