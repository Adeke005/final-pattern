package com.narxoz.towerdefense.model;

public class Player {
    private int gold;

    public Player(int gold) {
        this.gold = gold;
    }

    public void addGold(int amount) {
        gold += amount;
        System.out.println("Player earned " + amount + " gold. Total gold: " + gold);
    }

    public boolean spendGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            System.out.println("Player spent " + amount + " gold. Gold left: " + gold);
            return true;
        }

        System.out.println("Not enough gold!");
        return false;
    }

    public int getGold() {
        return gold;
    }
}