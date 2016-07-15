package com.abstractlabs.oefen.map;

import java.util.ArrayList;
import java.util.List;

import com.abstractlabs.oefen.Assets;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Skins {
	private TextureRegion texture;

	private static String GRASS = "Grass";
	private static String FLOWER = "Flower";
	private static String PATH_HORIZONTAL = "Path Horizontal";
	private static String PATH_VERTICAL = "Path Vertical";
	private static String PATH_CORNER = "Path Corner";
	
	public static List<Skins> grassAll = new ArrayList<Skins>();
	public static List<Skins> flowerAll = new ArrayList<Skins>();
	public static List<Skins> pathHorizontalAll = new ArrayList<Skins>();
	public static List<Skins> pathVerticalAll = new ArrayList<Skins>();
	public static List<Skins> pathCornerAll = new ArrayList<Skins>();
	public static List<Road> roadAll = new ArrayList<Road>();
	public static List<Bridge> bridgeAll = new ArrayList<Bridge>();
	
	public Skins(String type, TextureRegion texture) {
		this.texture = texture;
		if(type==GRASS) {
			grassAll.add(this);
		} else if(type==FLOWER) {
			flowerAll.add(this);
		} else if(type==PATH_HORIZONTAL) {
			pathHorizontalAll.add(this);
		} else if(type==PATH_VERTICAL) {
			pathVerticalAll.add(this);
		} else if(type==PATH_CORNER) {
			pathCornerAll.add(this);
		}
	}
	
	public TextureRegion get() {
		return this.texture;
	}

	//GRASS
	public static Skins grass = new Skins(GRASS, Assets.grass);
	public static Skins sand = new Skins(GRASS, Assets.sand);
	public static Skins grass16 = new Skins(GRASS, Assets.grass16);
	public static Skins snow = new Skins(GRASS, Assets.snow);
	public static Skins sand2 = new Skins(GRASS, Assets.sand2);
	public static Skins pavement = new Skins(GRASS, Assets.pavement);
	
	//FLOWER
	public static Skins flower = new Skins(FLOWER, Assets.flower);
	public static Skins deadTree = new Skins(FLOWER, Assets.deadTree);
	public static Skins flower16 = new Skins(FLOWER, Assets.flower16);
	public static Skins rock = new Skins(FLOWER, Assets.rock);
	public static Skins puddle = new Skins(FLOWER, Assets.puddle);
	
	//PATH_HORIZONTAL
	public static Skins dirtHorizontal = new Skins(PATH_HORIZONTAL, Assets.dirtHorizontal);
	public static Skins pathHorizontal = new Skins(PATH_HORIZONTAL, Assets.pathHorizontal);
	public static Skins roadHorizontal = new Skins(PATH_HORIZONTAL, Assets.roadHorizontal);
	public static Skins path16Horizontal = new Skins(PATH_HORIZONTAL, Assets.path16Horizontal);
	
	//PATH_VERTICAL
	public static Skins dirtVertical = new Skins(PATH_VERTICAL, Assets.dirtVertical);
	public static Skins pathVertical = new Skins(PATH_VERTICAL, Assets.pathVertical);
	public static Skins roadVertical = new Skins(PATH_VERTICAL, Assets.roadVertical);
	public static Skins path16Vertical = new Skins(PATH_VERTICAL, Assets.path16Vertical);
	
	//PATH_CORNER
	public static Skins dirtCorner = new Skins(PATH_CORNER, Assets.dirtCorner);
	public static Skins pathCorner = new Skins(PATH_CORNER, Assets.pathCorner);
	public static Skins roadCorner = new Skins(PATH_CORNER, Assets.roadCorner);
	public static Skins path16Corner = new Skins(PATH_CORNER, Assets.path16Corner);
	
	//PATH
	public static Road dirt = new Road(Assets.dirtHorizontal, Assets.dirtVertical, Assets.dirtCorner);
	public static Road path = new Road(Assets.pathHorizontal, Assets.pathVertical, Assets.pathCorner);
	public static Road road = new Road(Assets.roadHorizontal, Assets.roadVertical, Assets.roadCorner);
	public static Road path16 = new Road(Assets.path16Horizontal, Assets.path16Vertical, Assets.path16Corner);
	
	//BRIDGE
	public static Bridge stone = new Bridge(Assets.bridgeStoneHorizontal, Assets.bridgeStoneVertical, Assets.bridgeStoneCornerBottomRight, Assets.bridgeStoneCornerTopLeft);
	public static Bridge stone2 = new Bridge(Assets.bridgeStone2Horizontal, Assets.bridgeStone2Vertical, Assets.bridgeStone2CornerBottomRight, Assets.bridgeStone2CornerTopLeft);
	public static Bridge wood = new Bridge(Assets.woodBridgeHorizontal, Assets.woodBridgeVertical, Assets.woodBridgeCornerBottomRight, Assets.woodBridgeCornerTopLeft);
}