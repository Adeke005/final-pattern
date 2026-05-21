package com.game.towerdefense.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.game.towerdefense.GameApp;

public class PauseScreen implements Screen {
    private GameApp game;
    private GameScreen gameScreen;
    private SpriteBatch batch;
    private BitmapFont font;

    public PauseScreen(GameApp game, GameScreen gameScreen) {
        this.game = game;
        this.gameScreen = gameScreen;
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.08f, 0.08f, 0.12f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "PAUSED", 370, 280);
        font.draw(batch, "Press R to Resume", 330, 230);
        font.draw(batch, "Press M for Main Menu", 315, 200);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game.setScreen(gameScreen);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            game.setScreen(new MainMenuScreen(game));
        }
    }

    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}