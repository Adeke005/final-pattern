package com.game.towerdefense.managers;

public class PlayerBase {
    private int hp = 100;
    private int gold = 200;

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public boolean isDestroyed() {
        return hp <= 0;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (gold < amount) return false;
        gold -= amount;
        return true;
    }

    public int getHp() {
        return hp;
    }

    public int getGold() {
        return gold;
    }
}