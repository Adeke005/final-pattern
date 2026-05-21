package com.game.towerdefense.ui;

public class GameMessage {
    private String text = "";
    private float timer = 0f;

    public void show(String text) {
        this.text = text;
        this.timer = 2.5f;
    }

    public void update(float delta) {
        if (timer > 0) {
            timer -= delta;
        }
    }

    public boolean isVisible() {
        return timer > 0;
    }

    public String getText() {
        return text;
    }
}