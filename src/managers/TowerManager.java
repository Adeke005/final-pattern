package com.game.towerdefense.managers;

import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.factory.TowerFactory;

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
        Tower tower = TowerFactory.createTower(type, x, y);

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