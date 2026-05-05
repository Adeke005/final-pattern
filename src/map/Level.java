package com.game.towerdefense.map;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private Path path;
    private List<Vector2> towerSpots = new ArrayList<>();

    public Level() {
        path = new Path();

        towerSpots.add(new Vector2(160, 360));
        towerSpots.add(new Vector2(330, 360));
        towerSpots.add(new Vector2(180, 240));
        towerSpots.add(new Vector2(400, 240));
        towerSpots.add(new Vector2(560, 220));
        towerSpots.add(new Vector2(650, 100));
    }

    public Path getPath() {
        return path;
    }

    public List<Vector2> getTowerSpots() {
        return towerSpots;
    }

    public boolean isValidTowerSpot(float x, float y) {
        for (Vector2 spot : towerSpots) {
            if (spot.dst(x, y) < 30f) {
                return true;
            }
        }
        return false;
    }

    public Vector2 getNearestTowerSpot(float x, float y) {
        for (Vector2 spot : towerSpots) {
            if (spot.dst(x, y) < 30f) {
                return spot;
            }
        }
        return null;
    }
}