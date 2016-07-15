package com.abstractlabs.oefen.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bridge {
	private TextureRegion horizontal;
	private TextureRegion vertical;
	private TextureRegion cornerBottomRight;
	private TextureRegion cornerTopLeft;
	
	public Bridge(TextureRegion horizontal, TextureRegion vertical, TextureRegion cornerBottomRight, TextureRegion cornerTopLeft) {
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.cornerBottomRight = cornerBottomRight;
		this.cornerTopLeft = cornerTopLeft;
		Skins.bridgeAll.add(this);
	}
	
	public TextureRegion getHorizontal() {
		return this.horizontal;
	}
	
	public TextureRegion getVertical() {
		return this.vertical;
	}
	
	public TextureRegion getCornerBottomRight() {
		return this.cornerBottomRight;
	}
	
	public TextureRegion getCornerTopLeft() {
		return this.cornerTopLeft;
	}
}