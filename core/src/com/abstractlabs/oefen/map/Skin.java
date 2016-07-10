package com.abstractlabs.oefen.map;

import com.abstractlabs.oefen.Assets;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Skin {
	private TextureRegion grass, flower, pathHorizontal, pathVertical, pathCorner;
	
	public Skin(TextureRegion grass, TextureRegion flower, TextureRegion pathHorizontal, TextureRegion pathVertical, TextureRegion pathCorner) {
		this.grass = grass;
		this.flower = flower;
		this.pathHorizontal = pathHorizontal;
		this.pathVertical = pathVertical;
		this.pathCorner = pathCorner;
	}

	public TextureRegion getGrass() {
		return grass;
	}

	public TextureRegion getFlower() {
		return flower;
	}

	public TextureRegion getPathHorizontal() {
		return pathHorizontal;
	}

	public TextureRegion getPathVertical() {
		return pathVertical;
	}

	public TextureRegion getPathCorner() {
		return pathCorner;
	}

	public void setGrass(TextureRegion grass) {
		this.grass = grass;
	}

	public void setFlower(TextureRegion flower) {
		this.flower = flower;
	}

	public void setPathHorizontal(TextureRegion pathHorizontal) {
		this.pathHorizontal = pathHorizontal;
	}

	public void setPathVertical(TextureRegion pathVertical) {
		this.pathVertical = pathVertical;
	}

	public void setPathCorner(TextureRegion pathCorner) {
		this.pathCorner = pathCorner;
	}
	
	///////////////////////////////////////////////////////// STATIC CLASS START //////////////////////////////////////////////////////////////////

	public static Skin classic = new Skin(Assets.grassTile, Assets.grassFlowerTile, Assets.dirtTile, Assets.dirt2Tile, Assets.dirtCornerTile);
	public static Skin desert = new Skin(Assets.sand2Tile, Assets.deadTree, Assets.pathHorizontal, Assets.pathVertical, Assets.pathCorner);
	public static Skin city = new Skin(Assets.grassTile, Assets.grassFlowerTile, Assets.roadHorizontal, Assets.roadVertical, Assets.roadCorner);
	public static Skin x16 = new Skin(Assets.grass16, Assets.flower16, Assets.path16Horizontal, Assets.path16Vertical, Assets.path16Corner);
}