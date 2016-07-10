package com.abstractlabs.oefen;

import com.abstractlabs.oefen.database.RestDBClient;
import com.abstractlabs.oefen.screen.ScreenMainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Oefen extends Game {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	public SpriteBatch batch;
	public ShapeRenderer sr;
	public RestDBClient db;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		db = new RestDBClient();
		Settings.load();
		Assets.load();
		setScreen(new ScreenMainMenu(this));
//		for(int i=0; i<Cards.all.size(); i++) {
//			System.out.println(Cards.all.get(i));
//		}
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
		//batch = null;
		db = null;
		screen.hide();
		batch.dispose();
		sr.dispose();
		Assets.dispose();
		Gdx.app.exit();
	}
}