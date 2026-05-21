package com.game.towerdefense.map;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private int levelNumber;
    private Path path;
    private List<Vector2> towerSpots = new ArrayList<>();

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
        this.path = new Path(levelNumber);

        if (levelNumber == 1) {
            createLevelOneSpots();
        } else if (levelNumber == 2) {
            createLevelTwoSpots();
        } else {
            createLevelThreeSpots();
        }
    }

    private void createLevelOneSpots() {
        towerSpots.add(new Vector2(160, 360));
        towerSpots.add(new Vector2(330, 360));
        towerSpots.add(new Vector2(180, 240));
        towerSpots.add(new Vector2(400, 240));
        towerSpots.add(new Vector2(560, 220));
        towerSpots.add(new Vector2(650, 100));
    }

    private void createLevelTwoSpots() {
        towerSpots.add(new Vector2(120, 340));
        towerSpots.add(new Vector2(250, 300));
        towerSpots.add(new Vector2(350, 160));
        towerSpots.add(new Vector2(500, 300));
        towerSpots.add(new Vector2(590, 420));
        towerSpots.add(new Vector2(700, 250));
        towerSpots.add(new Vector2(700, 80));
    }

    private void createLevelThreeSpots() {
        towerSpots.add(new Vector2(180, 370));
        towerSpots.add(new Vector2(360, 370));
        towerSpots.add(new Vector2(560, 370));
        towerSpots.add(new Vector2(180, 260));
        towerSpots.add(new Vector2(380, 260));
        towerSpots.add(new Vector2(580, 260));
        towerSpots.add(new Vector2(250, 140));
        towerSpots.add(new Vector2(520, 140));
    }

    public Path getPath() {
        return path;
    }

    public List<Vector2> getTowerSpots() {
        return towerSpots;
    }

    public int getLevelNumber() {
        return levelNumber;
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