package com.game.towerdefense.factory;

import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.towers.SniperTower;
import com.game.towerdefense.towers.MegaCannonTower;
import com.game.towerdefense.towers.FreezeAuraTower;

public class MergedTowerFactory {

    public static Tower createMergedTower(String baseType, float x, float y) {
        switch (baseType) {
            case "ARROW":
                return new SniperTower(x, y);
            case "CANNON":
                return new MegaCannonTower(x, y);
            case "ICE":
                return new FreezeAuraTower(x, y);
            default:
                return null;
        }
    }
}