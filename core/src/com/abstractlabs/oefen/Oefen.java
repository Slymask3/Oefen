package com.abstractlabs.oefen;

import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Oefen extends Game {
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Settings.load();
		Assets.load();
		setScreen(new ScreenGame(this));
	}

	@Override
	public void render () {
		super.render();
	}
}