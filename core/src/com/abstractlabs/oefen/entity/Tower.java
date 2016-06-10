package com.abstractlabs.oefen.entity;

import com.badlogic.gdx.graphics.Texture;

public class Tower extends Entity {
	private int hp;

	public Tower(Texture texture, int size, int srcx, int srcy, int srcw, int srch, int posx, int posy, int scalew, int scaleh, int hp) {
		super(texture, size, srcx, srcy, srcw, srch, posx, posy, scalew, scaleh);
		this.hp = hp;
	}

	public Tower(Texture texture, int size, int srcx, int srcy, int srcw, int srch, int posx, int posy, int scalew, int scaleh, int hp, float r, float g, float b, float a) {
		super(texture, size, srcx, srcy, srcw, srch, posx, posy, scalew, scaleh, r, g ,b, a);
		this.hp = hp;
	}
	
	public int getHealth() {
		return this.hp;
	}
}