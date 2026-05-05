package com.game.towerdefense.managers;

import com.badlogic.gdx.math.Vector2;
import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.towers.ArrowTower;
import com.game.towerdefense.towers.CannonTower;
import com.game.towerdefense.towers.IceTower;

import java.util.ArrayList;
import java.util.List;

public class TowerManager {
    private List<Tower> towers = new ArrayList<>();

    public void update(float delta, List<Enemy> enemies) {
        for (Tower tower : towers) {
            tower.update(delta, enemies);
        }
    }

    public boolean placeTower(String type, float x, float y, PlayerBase base) {
        Tower tower;

        switch (type) {
            case "ARROW":
                tower = new ArrowTower(x, y);
                break;
            case "CANNON":
                tower = new CannonTower(x, y);
                break;
            case "ICE":
                tower = new IceTower(x, y);
                break;
            default:
                return false;
        }

        if (!base.spendGold(tower.getCost())) {
            return false;
        }

        towers.add(tower);
        return true;
    }

    public List<Tower> getTowers() {
        return towers;
    }
}