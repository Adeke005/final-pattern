package com.game.towerdefense.managers;

import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.factory.TowerFactory;

import java.util.ArrayList;
import java.util.List;

public class TowerManager {
    private List<Tower> towers = new ArrayList<>();
    private Tower firstSelectedTower;
    private Tower secondSelectedTower;

    private MergeManager mergeManager = new MergeManager();

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

    public Tower findTowerAt(float x, float y) {
        for (Tower tower : towers) {
            if (tower.getPosition().dst(x, y) <= 30f) {
                return tower;
            }
        }
        return null;
    }

    public void selectTower(float x, float y) {
        Tower tower = findTowerAt(x, y);

        if (tower == null) {
            return;
        }

        if (firstSelectedTower == null) {
            firstSelectedTower = tower;
            System.out.println("First tower selected: " + tower.getType());
        } else if (secondSelectedTower == null && tower != firstSelectedTower) {
            secondSelectedTower = tower;
            System.out.println("Second tower selected: " + tower.getType());
        } else {
            firstSelectedTower = tower;
            secondSelectedTower = null;
            System.out.println("Selection reset. First tower selected: " + tower.getType());
        }
    }

    public void tryMergeSelectedTowers() {
        if (firstSelectedTower == null || secondSelectedTower == null) {
            System.out.println("Select two towers first");
            return;
        }

        if (mergeManager.canMerge(firstSelectedTower, secondSelectedTower)) {
            mergeManager.mergeAndReplace(towers, firstSelectedTower, secondSelectedTower);
            System.out.println("Towers merged");
        } else {
            System.out.println("Cannot merge these towers");
        }

        firstSelectedTower = null;
        secondSelectedTower = null;
    }

    public boolean removeTowerAt(float x, float y) {
        Tower tower = findTowerAt(x, y);

        if (tower == null) {
            return false;
        }

        towers.remove(tower);

        if (tower == firstSelectedTower) {
            firstSelectedTower = null;
        }

        if (tower == secondSelectedTower) {
            secondSelectedTower = null;
        }

        return true;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public Tower getFirstSelectedTower() {
        return firstSelectedTower;
    }
}