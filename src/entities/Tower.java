package com.game.towerdefense.entities;

import com.badlogic.gdx.math.Vector2;
import java.util.List;

public abstract class Tower {
    protected Vector2 position;
    protected int damage;
    protected float range;
    protected float cooldown;
    protected float timer = 0f;
    protected int cost;

    public Tower(float x, float y, int damage, float range, float cooldown, int cost) {
        this.position = new Vector2(x, y);
        this.damage = damage;
        this.range = range;
        this.cooldown = cooldown;
        this.cost = cost;
    }

    public void update(float delta, List<Enemy> enemies) {
        timer += delta;

        Enemy target = findTarget(enemies);

        if (target != null && timer >= cooldown) {
            attack(target);
            timer = 0f;
        }
    }

    protected Enemy findTarget(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (!enemy.isDead() && position.dst(enemy.getPosition()) <= range) {
                return enemy;
            }
        }
        return null;
    }

    protected void attack(Enemy enemy) {
        enemy.takeDamage(damage);
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getCost() {
        return cost;
    }

    public float getRange() {
        return range;
    }
}