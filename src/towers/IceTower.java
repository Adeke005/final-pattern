package com.game.towerdefense.towers;

import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.strategy.FreezeAttack;

public class IceTower extends Tower {
    public IceTower(float x, float y) {
        super(x, y, 8, 120f, 1.0f, 80, new FreezeAttack());
    }
}