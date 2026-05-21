package com.game.towerdefense.towers;

import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.strategy.CannonAttack;

public class CannonTower extends Tower {
    public CannonTower(float x, float y) {
        super("CANNON", x, y, 40, 110f, 1.5f, 100, new CannonAttack());
    }
}