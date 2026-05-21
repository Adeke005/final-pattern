package com.game.towerdefense.towers;

import com.game.towerdefense.entities.AdvancedTower;
import com.game.towerdefense.strategy.CannonAttack;

public class MegaCannonTower extends AdvancedTower {
    public MegaCannonTower(float x, float y) {
        super("MEGA_CANNON", x, y, 80, 160f, 1.8f, 0, new CannonAttack());
    }
}