package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Range {
	public static void drawCircle(Batch batch, float x, float y, float radius, float r, float g, float b) {
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		ShapeRenderer sr = new ShapeRenderer();
		sr.setColor(r,g,b,0.2f);
		sr.begin(ShapeType.Filled);
		sr.circle(x, y, radius);
		sr.end();
		batch.enableBlending();
		batch.begin();
	}
	
	public static void drawRectangle(Batch batch, float x, float y, float width, float height, float r, float g, float b) {
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		ShapeRenderer sr = new ShapeRenderer();
		sr.setColor(r,g,b,0.2f);
		sr.begin(ShapeType.Filled);
		sr.rect(x, y, width, height);
		sr.end();
		batch.enableBlending();
		batch.begin();
	}
}