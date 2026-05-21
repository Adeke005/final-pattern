package com.game.towerdefense.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.game.towerdefense.GameApp;

public class GameOverScreen implements Screen {
    private GameApp game;
    private SpriteBatch batch;
    private BitmapFont font;

    public GameOverScreen(GameApp game) {
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "GAME OVER", 360, 280);
        font.draw(batch, "Press R to Restart", 330, 230);
        font.draw(batch, "Press M for Main Menu", 315, 200);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game.setScreen(new GameScreen(game));
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