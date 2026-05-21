package com.game.towerdefense.towers;

import com.game.towerdefense.entities.AdvancedTower;
import com.game.towerdefense.strategy.FastAttack;

public class SniperTower extends AdvancedTower {
    public SniperTower(float x, float y) {
        super("SNIPER", x, y, 45, 220f, 1.0f, 0, new FastAttack());
    }
}