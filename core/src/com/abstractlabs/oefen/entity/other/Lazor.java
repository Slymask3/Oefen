package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Lazor extends Projectile {
	//private ShapeRenderer sr;
	private float r, g, b;
	
	public Lazor(ScreenGame screen, float x, float y, float xd, float yd, float r, float g, float b) {
		super(screen, null, 0, 0, x, y, xd, yd);
		//sr = screen.getOefen().sr;
//		System.out.println("lightning created");
		this.r = r;
		this.g = g;
		this.b = b;
		//System.out.println("lazor spawned");
	}
	
	@Override
    public void draw(Batch batch, float alpha) {
        batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		screen.getOefen().sr.setColor(r,g,b,1);
		screen.getOefen().sr.begin(ShapeType.Line);
		screen.getOefen().sr.line(x, y, xd, yd);
		screen.getOefen().sr.setColor(1,1,1,1);
		screen.getOefen().sr.end();
		batch.enableBlending();
		batch.begin();
    }
    
    @Override
    public void act(float delta) {
    	tick++;
    	if(tick >= 20) {
    		this.remove();
    	}
    }
}