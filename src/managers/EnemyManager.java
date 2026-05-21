package com.game.towerdefense.managers;

import com.game.towerdefense.entities.Enemy;
import com.game.towerdefense.observer.EventManager;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyManager {
    private List<Enemy> enemies = new ArrayList<>();
    private EventManager eventManager;

    public EnemyManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

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
                eventManager.notifyBaseDamaged(enemy.getDamageToBase());
                iterator.remove();
            }

            if (enemy.isDead()) {
                base.addGold(enemy.getRewardGold());
                eventManager.notifyEnemyKilled(enemy);
                iterator.remove();
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}