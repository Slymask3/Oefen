package com.abstractlabs.oefen.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Road {
	private TextureRegion horizontal;
	private TextureRegion vertical;
	private TextureRegion corner;
	
	public Road(TextureRegion horizontal, TextureRegion vertical, TextureRegion corner) {
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.corner = corner;
		Skins.roadAll.add(this);
	}
	
	public TextureRegion getHorizontal() {
		return this.horizontal;
	}
	
	public TextureRegion getVertical() {
		return this.vertical;
	}
	
	public TextureRegion getCorner() {
		return this.corner;
	}
}