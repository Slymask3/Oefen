package com.abstractlabs.oefen.entity.other;

import java.util.Random;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Oefen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Cloud extends Actor {
	private Random rand = new Random();
	private float x, y, width, height;
	
	public Cloud() {
		this.width = rand.nextInt(821)+100;
		this.height = width/2;
		this.x = 0-width;
		this.y = rand.nextInt(Oefen.HEIGHT);
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		batch.setColor(1, 1, 1, 0.2f);
		batch.draw(Assets.cloud, x, y, width, height);
		batch.setColor(1, 1, 1, 1);
	}
	
	@Override
	public void act(float delta) {
		x++;
		
		if(x>=Oefen.WIDTH) {
			this.remove();
		}
	}
}