package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.entity.Entity;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Projectile extends Entity {
	float xd, yd;
	float width, height;
	float xc, yc;
	float tick;
	
	public Projectile(ScreenGame screen, TextureRegion texture, float width, float height, float x, float y, float xd, float yd) {
		super(screen, texture, x, y, width, height);
		this.xd = xd;
		this.yd = yd;
		this.width = width;
		this.height = height;
		float xdiff = Math.abs(xd-x);
		float ydiff = Math.abs(yd-y);
		this.xc = xdiff>=ydiff?xdiff/ydiff:xdiff/xdiff;
		this.yc = xdiff>=ydiff?ydiff/ydiff:ydiff/xdiff;
		this.tick = 0;
	}
	
	@Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, x, y, width/2, height/2, width, height, 1, 1, (float) (Math.atan2(yd-y, xd-x) * 180 / Math.PI));
    }
    
    @Override
    public void act(float delta) {
    	if(x > xd) {
    		x-=xc;
    	} else if(x < xd) {
    		x+=xc;
    	}
    	
    	if(y > yd) {
    		y-=yc;
    	} else if(y < yd) {
    		y+=yc;
    	}

    	if(isWithin(x, y, xd, yd, 1)) {
    		this.remove();
    	}
    	
    	tick++;
    	if(tick >= 100) { //cleanup
    		this.remove();
    	}
    }

    private boolean isWithin(float x, float y, float xd, float yd, int pixels) {
    	return (x >= xd-pixels && x <= xd+pixels) && (y >= yd-pixels && y <= yd+pixels);
    }
    
	//no targets for projectile entity (target is set on the attacker/tower that creates this projectile)
	@Override
	public void findTarget() {}
}