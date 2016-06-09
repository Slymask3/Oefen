package com.abstractlabs.oefen.card;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Card {
	private Rectangle rect;
	private TextureRegion texture;
	
	public Card(Texture texture, int size, int srcx, int srcy, int srcw, int srch, int posx, int posy, int scalew, int scaleh) {
		this.rect = new Rectangle(posx, posy, scalew, scaleh);
		TextureRegion[][] tmp = (new TextureRegion(texture)).split(size, size);
		this.texture = tmp[srcx/size][srcy/size];
	}
	
	public Rectangle getRectangle() {
		return this.rect;
	}
	
	public TextureRegion getTexture() {
		return this.texture;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(getTexture(), getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height);
	}
}