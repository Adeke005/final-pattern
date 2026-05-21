package com.game.towerdefense.state;

import com.game.towerdefense.screens.GameScreen;

public class PlayingState implements GameState {

    @Override
    public void update(GameScreen screen, float delta) {
        screen.updateGameplay(delta);
    }

    @Override
    public String getName() {
        return "PLAYING";
    }
}