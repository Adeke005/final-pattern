package com.game.towerdefense.map;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Vector2> points = new ArrayList<>();

    public Path(int levelNumber) {
        if (levelNumber == 1) {
            createLevelOnePath();
        } else if (levelNumber == 2) {
            createLevelTwoPath();
        } else {
            createLevelThreePath();
        }
    }

    private void createLevelOnePath() {
        points.add(new Vector2(50, 420));
        points.add(new Vector2(250, 420));
        points.add(new Vector2(250, 300));
        points.add(new Vector2(500, 300));
        points.add(new Vector2(500, 150));
        points.add(new Vector2(750, 150));
    }

    private void createLevelTwoPath() {
        points.add(new Vector2(50, 400));
        points.add(new Vector2(180, 400));
        points.add(new Vector2(180, 220));
        points.add(new Vector2(420, 220));
        points.add(new Vector2(420, 380));
        points.add(new Vector2(650, 380));
        points.add(new Vector2(650, 120));
        points.add(new Vector2(760, 120));
    }

    private void createLevelThreePath() {
        points.add(new Vector2(40, 430));
        points.add(new Vector2(760, 430));
        points.add(new Vector2(760, 320));
        points.add(new Vector2(80, 320));
        points.add(new Vector2(80, 210));
        points.add(new Vector2(720, 210));
        points.add(new Vector2(720, 90));
        points.add(new Vector2(760, 90));
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