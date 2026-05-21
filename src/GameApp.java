package com.game.towerdefense;

import com.badlogic.gdx.Game;
import com.game.towerdefense.screens.MainMenuScreen;

public class GameApp extends Game {

    @Override
    public void create() {
        setScreen(new MainMenuScreen(this));
    }
}