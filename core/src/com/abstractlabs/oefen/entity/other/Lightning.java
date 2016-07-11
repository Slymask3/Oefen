package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Lightning extends Projectile {
	private ShapeRenderer sr;
	
	public Lightning(ScreenGame screen, float x, float y, float xd, float yd) {
		super(screen, null, 0, 0, x, y, xd, yd);
		sr = new ShapeRenderer();
//		System.out.println("lightning created");
	}
	
	@Override
    public void draw(Batch batch, float alpha) {
        batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		sr.setColor(0,1,1,1);
		sr.begin(ShapeType.Line);
		//TODO simulate lightning
		sr.line(x, y, xd, yd);
//		Random rand = new Random();
//		int times = rand.nextInt(5);
//		
//		for(int i=0; i<times; i++) {
//			sr.line(xd, yd, xd+10, yd+10);
//			xd = xd+10;
//			yd = yd+10;
//		}
//		sr.line(xd, yd, x, y);
		
		sr.end();
		batch.enableBlending();
		batch.begin();
    }
    
    @Override
    public void act(float delta) {
    	tick++;
    	if(tick >= 50) {
    		this.remove();
    	}
    }
}