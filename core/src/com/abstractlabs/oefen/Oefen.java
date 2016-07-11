package com.abstractlabs.oefen;

import com.abstractlabs.oefen.screen.ScreenMainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Oefen extends Game {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public SpriteBatch batch;
	
	@Override
	public void create () {	
		batch = new SpriteBatch();
		Settings.load();
		Assets.load();
		setScreen(new ScreenMainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
}