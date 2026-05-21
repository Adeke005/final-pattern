package com.game.towerdefense.state;

import com.game.towerdefense.screens.GameScreen;

public interface GameState {
    void update(GameScreen screen, float delta);
    String getName();
}