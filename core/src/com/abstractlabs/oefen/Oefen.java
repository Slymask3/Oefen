package com.abstractlabs.oefen;

import com.abstractlabs.oefen.screen.ScreenMainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
		for(int i=0; i<Cards.all.size(); i++) {
			System.out.println(Cards.all.get(i));
		}
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void pause() {
		screen.pause();
	}
	
	@Override
	public void resume() {
		screen.resume();
	}
	
	@Override
	public void dispose() {
		screen.hide();
		batch.dispose();
		Assets.dispose();
		Gdx.app.exit();
	}
}