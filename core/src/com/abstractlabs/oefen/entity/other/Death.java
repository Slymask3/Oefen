package com.abstractlabs.oefen.entity.other;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.entity.Entity;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Death extends Entity {
	private float r, g, b;
    private int tick;
    private float state;
    private Animation animation;
	
	public Death(ScreenGame screen, Animation animation, float x, float y, float r, float g, float b) {
		super(screen, x, y);
		this.r = r;
		this.g = g;
		this.b = b;
		this.tick = 50;
		this.state = 0;
		this.animation = animation;
	}
	
	public Death(ScreenGame screen, float x, float y, float r, float g, float b) {
		this(screen, Assets.blood, x, y, r, g, b);
	}
	
	@Override
    public void draw(Batch batch, float alpha){
    	state += Gdx.graphics.getDeltaTime();
        batch.setColor(r, g, b, 1);
        batch.draw(animation.getKeyFrame(state, 1), x, y, 32, 32);
        batch.setColor(1, 1, 1, 1);
        //System.out.println("state == "+state);
    }
    
    @Override
    public void act(float delta){
    	tick--;
    	
    	if(tick <= 0) {
    		this.getParent().removeActor(this);
    	}
    }
}