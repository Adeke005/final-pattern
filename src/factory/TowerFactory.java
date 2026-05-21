package com.game.towerdefense.factory;

import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.towers.ArrowTower;
import com.game.towerdefense.towers.CannonTower;
import com.game.towerdefense.towers.IceTower;

public class TowerFactory {

    public static Tower createTower(String type, float x, float y) {
        switch (type) {
            case "ARROW":
                return new ArrowTower(x, y);
            case "CANNON":
                return new CannonTower(x, y);
            case "ICE":
                return new IceTower(x, y);
            default:
                return new ArrowTower(x, y);
        }
    }
}