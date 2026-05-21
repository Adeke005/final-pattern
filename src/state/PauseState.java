package com.game.towerdefense.state;

import com.game.towerdefense.screens.GameScreen;

public class PauseState implements GameState {

    @Override
    public void update(GameScreen screen, float delta) {
        // game is paused
    }

    @Override
    public String getName() {
        return "PAUSED";
    }
}