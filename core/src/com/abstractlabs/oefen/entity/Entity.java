package com.abstractlabs.oefen.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Entity {
	private Rectangle rect;
	private TextureRegion texture;
	private float r;
	private float g;
	private float b;
	private float a;
	
	public Entity(Texture texture, int size, int srcx, int srcy, int srcw, int srch, int posx, int posy, int scalew, int scaleh) {
		this.rect = new Rectangle(posx, posy, scalew, scaleh);
		TextureRegion[][] tmp = (new TextureRegion(texture)).split(size, size);
		this.texture = tmp[srcx/size][srcy/size];
		r = 1;
		g = 1;
		b = 1;
		a = 1;
	}
	
	public Entity(Texture texture, int size, int srcx, int srcy, int srcw, int srch, int posx, int posy, int scalew, int scaleh, float r, float g, float b, float a) {
		this.rect = new Rectangle(posx, posy, scalew, scaleh);
		TextureRegion[][] tmp = (new TextureRegion(texture)).split(size, size);
		this.texture = tmp[srcy/size][srcx/size];
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public Rectangle getRectangle() {
		return this.rect;
	}
	
	public TextureRegion getTexture() {
		return this.texture;
	}

	public void draw(SpriteBatch batch) {
	    batch.setColor(r, g, b, a);
		batch.draw(getTexture(), getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height);
	    batch.setColor(1, 1, 1, 1);
	}
}