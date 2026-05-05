package com.game.towerdefense.managers;

import com.game.towerdefense.entities.Enemy;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyManager {
    private List<Enemy> enemies = new ArrayList<>();

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void update(float delta, List<Vector2> pathPoints, PlayerBase base) {
        Iterator<Enemy> iterator = enemies.iterator();

        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            enemy.update(delta, pathPoints);

            if (enemy.hasReachedBase()) {
                base.takeDamage(enemy.getDamageToBase());
                iterator.remove();
            }

            if (enemy.isDead()) {
                base.addGold(enemy.getRewardGold());
                iterator.remove();
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}