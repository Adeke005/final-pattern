package com.game.towerdefense.map;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Vector2> points = new ArrayList<>();

    public Path() {
        points.add(new Vector2(50, 420));
        points.add(new Vector2(250, 420));
        points.add(new Vector2(250, 300));
        points.add(new Vector2(500, 300));
        points.add(new Vector2(500, 150));
        points.add(new Vector2(750, 150));
    }

    public List<Vector2> getPoints() {
        return points;
    }

    public Vector2 getSpawnPoint() {
        return points.get(0);
    }

    public Vector2 getBasePoint() {
        return points.get(points.size() - 1);
    }
}