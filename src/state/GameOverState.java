package com.game.towerdefense.state;

import com.game.towerdefense.screens.GameScreen;

public class GameOverState implements GameState {

    @Override
    public void update(GameScreen screen, float delta) {
        screen.openGameOverScreen();
    }

    @Override
    public String getName() {
        return "GAME_OVER";
    }
}