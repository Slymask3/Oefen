package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Range {
	public static void drawCircle(Batch batch, ShapeRenderer sr, float x, float y, float radius, float r, float g, float b) {
//		OrthographicCamera guiCam;
//		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
//		guiCam.position.set(Oefen.WIDTH/2, Oefen.HEIGHT/2, 0);

		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
//		ShapeRenderer sr = new ShapeRenderer();
		//sr.setProjectionMatrix(guiCam.combined);
		sr.setColor(r,g,b,0.2f);
		sr.begin(ShapeType.Filled);
		sr.circle(x, y, radius);
		sr.end();
		batch.enableBlending();
		batch.begin();
	}
	
	public static void drawRectangle(Batch batch, ShapeRenderer sr, float x, float y, float width, float height, float r, float g, float b) {
//		OrthographicCamera guiCam;
//		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
//		guiCam.position.set(Oefen.WIDTH/2, Oefen.HEIGHT/2, 0);
		
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
//		ShapeRenderer sr = new ShapeRenderer();
		//sr.setProjectionMatrix(guiCam.combined);
		sr.setColor(r,g,b,0.2f);
		sr.begin(ShapeType.Filled);
		sr.rect(x, y, width, height);
		sr.end();
		batch.enableBlending();
		batch.begin();
	}
}