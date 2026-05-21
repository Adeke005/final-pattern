package com.game.towerdefense.entities;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private Vector2 position;
    private Enemy target;

    private int damage;
    private float speed = 300f;
    private boolean active = true;

    public Bullet(float x, float y, Enemy target, int damage) {
        this.position = new Vector2(x, y);
        this.target = target;
        this.damage = damage;
    }

    public void update(float delta) {
        if (target == null || target.isDead()) {
            active = false;
            return;
        }

        Vector2 direction = new Vector2(target.getPosition()).sub(position);

        if (direction.len() < 8f) {
            target.takeDamage(damage);
            active = false;
            return;
        }

        direction.nor();
        position.add(direction.scl(speed * delta));
    }

    public boolean isActive() {
        return active;
    }

    public Vector2 getPosition() {
        return position;
    }
}