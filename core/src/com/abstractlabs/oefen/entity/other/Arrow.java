package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.entity.Entity;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Arrow extends Entity {
	float xd, yd;
	float width, height;
	float xc, yc;
	float tick;
	
	public Arrow(float width, float height, float x, float y, float xd, float yd, Map map) {
		super(null, x, y, 15, 3, map, null, 0, 0, 0);
		this.xd = xd;
		this.yd = yd;
		this.width = width;
		this.height = height;
//		this.setOrigin(width/2, height/2);
//		this.rotateBy((float) (Math.atan2(yd-y, xd-x) * 180 / Math.PI));

		float xdiff = Math.abs(xd-x);
		float ydiff = Math.abs(yd-y);

		this.xc = xdiff>=ydiff?xdiff/ydiff:xdiff/xdiff;
		this.yc = xdiff>=ydiff?ydiff/ydiff:ydiff/xdiff;
//		System.out.println("x="+x+" | y="+y);
//		System.out.println("xc="+xc+" | yc="+yc+" | xdiff="+xdiff+" | ydiff="+ydiff);
//		System.out.println("Math.abs(xd-x)="+Math.abs(xd-x)+" | Math.abs(yd-y)="+Math.abs(yd-y)+" | xd-x="+(xd-x)+" | yd-y="+(yd-y));
		
		this.tick = 0;
	}
	
	@Override
    public void draw(Batch batch, float alpha) {
        batch.draw(Assets.arrow, x, y, width/2, height/2, width, height, 1, 1, (float) (Math.atan2(yd-y, xd-x) * 180 / Math.PI));
    }
    
    @Override
    public void act(float delta) {
    	if(x > xd) {
    		x-=xc;
    		//System.out.println("x--");
    	} else if(x < xd) {
    		x+=xc;
    		//System.out.println("x++");
    	}
    	
    	if(y > yd) {
    		y-=yc;
    		//System.out.println("y--");
    	} else if(y < yd) {
    		y+=yc;
    		//System.out.println("y++");
    	}
    	
    	if(Math.round(x)==Math.round(xd) && Math.round(y)==Math.round(yd)) {
    		//System.out.println("arrow is dead");
    		this.remove();
    	}
    	
    	//System.out.println("x="+x+" | xd="+xd+" | y="+y+" | yd="+yd);
    	
    	tick++;
    	if(tick >= 200) { //cleanup
    		this.remove();
    	}
    }
}