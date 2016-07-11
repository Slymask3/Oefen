package com.abstractlabs.oefen.entity;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Book extends Group{
	Animation bookFrames;
	float x, y;
	float state = 0;
	int ticks = 0;
	boolean flipping = false;
	
	public Book(float x, float y) {
		this.x = x;
		this.y = y;
		this.bookFrames = Assets.bookStill;
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		state += Gdx.graphics.getDeltaTime();
		batch.draw(bookFrames.getKeyFrame(state, Animation.LOOPING), x, y);
	}
	
	public void changeAnimation() {
		//System.out.println("test");
		bookFrames = Assets.bookFrames;
		flipping = true;
		state = 0;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		if (flipping) {
			ticks++;
			if (ticks == 41) {
				bookFrames = Assets.bookStill;
				flipping = false;
				ticks = 0;
			}
		}
	}
}
