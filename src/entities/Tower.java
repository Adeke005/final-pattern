package com.game.towerdefense.entities;

import com.badlogic.gdx.math.Vector2;
import com.game.towerdefense.strategy.AttackStrategy;
import com.game.towerdefense.managers.BulletManager;

import java.util.List;

public abstract class Tower {
    protected Vector2 position;
    protected int damage;
    protected float range;
    protected float cooldown;
    protected float timer = 0f;
    protected int cost;
    protected String type;
    protected int level = 1;
    protected int maxLevel = 3;
    protected int upgradeCost = 70;

    protected AttackStrategy attackStrategy;

    public Tower(String type, float x, float y, int damage, float range, float cooldown, int cost, AttackStrategy attackStrategy) {
        this.type = type;
        this.position = new Vector2(x, y);
        this.damage = damage;
        this.range = range;
        this.cooldown = cooldown;
        this.cost = cost;
        this.attackStrategy = attackStrategy;
    }

    public void update(float delta, List<Enemy> enemies, BulletManager bulletManager) {
        timer += delta;

        Enemy target = findTarget(enemies);

        if (target != null && timer >= cooldown) {
            attack(target, bulletManager);
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

    public boolean canUpgrade() {
        return level < maxLevel;
    }

    public void upgrade() {
        if (!canUpgrade()) return;

        level++;
        damage += 10;
        range += 20f;
        cooldown *= 0.85f;
        upgradeCost += 50;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getLevel() {
        return level;
    }

    protected void attack(Enemy enemy, BulletManager bulletManager) {
        bulletManager.addBullet(position.x, position.y, enemy, damage);
    }

    public boolean isNear(Tower other) {
        return position.dst(other.getPosition()) <= 80f;
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

    public String getType() {
        return type;
    }
}