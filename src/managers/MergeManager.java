package com.game.towerdefense.managers;

import com.game.towerdefense.entities.Tower;
import com.game.towerdefense.factory.MergedTowerFactory;

import java.util.List;

public class MergeManager {

    public boolean canMerge(Tower first, Tower second) {
        if (first == null || second == null) return false;
        if (first == second) return false;

        boolean sameType = first.getType().equals(second.getType());
        boolean near = first.isNear(second);

        return sameType && near;
    }

    public Tower merge(Tower first, Tower second) {
        if (!canMerge(first, second)) {
            return null;
        }

        float newX = (first.getPosition().x + second.getPosition().x) / 2f;
        float newY = (first.getPosition().y + second.getPosition().y) / 2f;

        return MergedTowerFactory.createMergedTower(first.getType(), newX, newY);
    }

    public void mergeAndReplace(List<Tower> towers, Tower first, Tower second) {
        Tower mergedTower = merge(first, second);

        if (mergedTower == null) {
            return;
        }

        towers.remove(first);
        towers.remove(second);
        towers.add(mergedTower);
    }
}