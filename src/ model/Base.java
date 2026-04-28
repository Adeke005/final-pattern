package com.narxoz.towerdefense.model;

public class Base {
    private int hp;

    public Base(int hp) {
        this.hp = hp;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }

        System.out.println("Base took " + damage + " damage. Base HP: " + hp);
    }

    public boolean isDestroyed() {
        return hp <= 0;
    }

    public int getHp() {
        return hp;
    }
}