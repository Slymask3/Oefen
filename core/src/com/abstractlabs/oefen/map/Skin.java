package com.abstractlabs.oefen.map;

import java.util.Random;

import com.abstractlabs.oefen.Assets;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Skin {
	private TextureRegion grass, flower, pathHorizontal, pathVertical, pathCorner;
	private TextureRegion bridgeHorizontal, bridgeVertical, bridgeCornerBottomRight, bridgeCornerTopLeft;
	
	public Skin(TextureRegion grass, TextureRegion flower, TextureRegion pathHorizontal, TextureRegion pathVertical, TextureRegion pathCorner,
		    TextureRegion bridgeHorizontal, TextureRegion bridgeVertical, TextureRegion bridgeCornerBottomRight, TextureRegion bridgeCornerTopLeft) {
		this.grass = grass;
		this.flower = flower;
		this.pathHorizontal = pathHorizontal;
		this.pathVertical = pathVertical;
		this.pathCorner = pathCorner;
		this.bridgeHorizontal = bridgeHorizontal;
		this.bridgeVertical = bridgeVertical;
		this.bridgeCornerBottomRight = bridgeCornerBottomRight;
		this.bridgeCornerTopLeft = bridgeCornerTopLeft;
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

	public TextureRegion getBridgeHorizontal() {
		return bridgeHorizontal;
	}

	public TextureRegion getBridgeVertical() {
		return bridgeVertical;
	}

	public TextureRegion getBridgeCornerBottomRight() {
		return bridgeCornerBottomRight;
	}

	public TextureRegion getBridgeCornerTopLeft() {
		return bridgeCornerTopLeft;
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

	public void setBridgeHorizontal(TextureRegion bridgeHorizontal) {
		this.bridgeHorizontal = bridgeHorizontal;
	}

	public void setBridgeVertical(TextureRegion bridgeVertical) {
		this.bridgeVertical = bridgeVertical;
	}

	public void setBridgeCornerBottomRight(TextureRegion bridgeCornerBottomRight) {
		this.bridgeCornerBottomRight = bridgeCornerBottomRight;
	}

	public void setBridgeCornerTopLeft(TextureRegion bridgeCornerTopLeft) {
		this.bridgeCornerTopLeft = bridgeCornerTopLeft;
	}
	
	///////////////////////////////////////////////////////// STATIC CLASS START //////////////////////////////////////////////////////////////////

	public static Skin classic = new Skin(Assets.grass, Assets.flower, Assets.dirtHorizontal, Assets.dirtVertical, Assets.dirtCorner, Assets.bridgeStoneHorizontal, Assets.bridgeStoneVertical, Assets.bridgeStoneCornerBottomRight, Assets.bridgeStoneCornerTopLeft);
	public static Skin desert = new Skin(Assets.sand, Assets.deadTree, Assets.pathHorizontal, Assets.pathVertical, Assets.pathCorner, Assets.bridgeStoneHorizontal, Assets.bridgeStoneVertical, Assets.bridgeStoneCornerBottomRight, Assets.bridgeStoneCornerTopLeft);
	public static Skin city = new Skin(Assets.pavement, Assets.rock, Assets.roadHorizontal, Assets.roadVertical, Assets.roadCorner, Assets.bridgeStoneHorizontal, Assets.bridgeStoneVertical, Assets.bridgeStoneCornerBottomRight, Assets.bridgeStoneCornerTopLeft);
	public static Skin x16 = new Skin(Assets.grass16, Assets.flower16, Assets.path16Horizontal, Assets.path16Vertical, Assets.path16Corner, Assets.bridgeStoneHorizontal, Assets.bridgeStoneVertical, Assets.bridgeStoneCornerBottomRight, Assets.bridgeStoneCornerTopLeft);

	public static Skin getRandomSkin() {
		Random rand = new Random();
		Road road = Skins.roadAll.get(rand.nextInt(Skins.roadAll.size()));
		Bridge bridge = Skins.bridgeAll.get(rand.nextInt(Skins.bridgeAll.size()));
		Skin skin = new Skin(Skins.grassAll.get(rand.nextInt(Skins.grassAll.size())).get(),
			 			     Skins.flowerAll.get(rand.nextInt(Skins.flowerAll.size())).get(),
			 			     road.getHorizontal(),
			 			     road.getVertical(),
			 			     road.getCorner(),
			 			     bridge.getHorizontal(),
			 			     bridge.getVertical(),
			 			     bridge.getCornerBottomRight(),
			 			     bridge.getCornerTopLeft());
		return skin;
	}
}