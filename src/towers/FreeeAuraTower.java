package com.game.towerdefense.towers;

import com.game.towerdefense.entities.AdvancedTower;
import com.game.towerdefense.strategy.FreezeAttack;

public class FreezeAuraTower extends AdvancedTower {
    public FreezeAuraTower(float x, float y) {
        super("FREEZE_AURA", x, y, 20, 180f, 1.2f, 0, new FreezeAttack());
    }
}