package com.game.towerdefense.state;

import com.game.towerdefense.screens.GameScreen;

public class WinState implements GameState {

    @Override
    public void update(GameScreen screen, float delta) {
        screen.openWinScreen();
    }

    @Override
    public String getName() {
        return "WIN";
    }
}