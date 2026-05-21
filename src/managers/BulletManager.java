package com.game.towerdefense.managers;

import com.game.towerdefense.entities.Bullet;
import com.game.towerdefense.entities.Enemy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BulletManager {
    private List<Bullet> bullets = new ArrayList<>();

    public void addBullet(float x, float y, Enemy target, int damage) {
        bullets.add(new Bullet(x, y, target, damage));
    }

    public void update(float delta) {
        Iterator<Bullet> iterator = bullets.iterator();

        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            bullet.update(delta);

            if (!bullet.isActive()) {
                iterator.remove();
            }
        }
    }

    public List<Bullet> getBullets() {
        return bullets;
    }
}