package com.abstractlabs.oefen.map;

import java.util.Random;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Map {
	private int[][] mapPath; //Used for the straight up path for walking, so entities know where they are allowed to go.
	private int[][] mapTiles; //Used to display the tiles.
	private int[][] mapOverlay1; //Used for water sides and corners so no need to make redundant skin textures.
	private int[][] mapOverlay2; //Used for the bridge atm.
	private int[][] mapTowers; //Used to tell the game where towers are allowed to be placed.
	private int blueStart;
	private int redStart;
	private Skin blueSkin;
	private Skin redSkin;
	private int split;
	
	public Map(int[][] mapPath, int[][] mapTiles, int[][] mapOverlay1, int[][] mapOverlay2, int[][] mapTowers, int blueStart, int redStart, Skin blueSkin, Skin redSkin, int split) {
		this.mapPath = mapPath;
		this.mapTiles = mapTiles;
		this.mapOverlay1 = mapOverlay1;
		this.mapOverlay2 = mapOverlay2;
		this.mapTowers = mapTowers;
		this.blueStart = blueStart;
		this.redStart = redStart;
		this.blueSkin = blueSkin;
		this.redSkin = redSkin;
		this.split = split;
	}
	
	public int[][] getPath() {
		return this.mapPath;
	}
	
	public int[][] getTiles() {
		return this.mapTiles;
	}
	
	public int[][] getOverlay1() {
		return this.mapOverlay1;
	}
	
	public int[][] getOverlay2() {
		return this.mapOverlay2;
	}
	
	public int[][] getTowers() {
		return this.mapTowers;
	}
	
	public int getBlueStart() {
		return this.blueStart;
	}
	
	public int getRedStart() {
		return this.redStart;
	}
	
	public Skin gtBlueSkin() {
		return this.blueSkin;
	}
	
	public Skin gtRedSkin() {
		return this.redSkin;
	}
	
	public int getSplit() {
		return this.split;
	}
	
	public void draw(SpriteBatch batch, float stateTime, float x, float y) {
		for(int i=0; i<mapTiles.length; i++) {
	    	for(int k=0; k<mapTiles[i].length; k++) {
	    		TextureRegion texture = null;
	    		boolean xflip = false, yflip = false;
	    		if(mapTiles[i][k] == Tile.GRASS) { texture = k<split?blueSkin.getGrass():redSkin.getGrass(); xflip = false; yflip = false; } 
	    		else if(mapTiles[i][k] == Tile.PATH_HORIZONTAL) { texture = Assets.dirtHorizontal; xflip = false; yflip = false; } 
	    		else if(mapTiles[i][k] == Tile.PATH_BOTTOM_RIGHT) { texture = Assets.dirtCorner; xflip = true; yflip = true; } 
	    		else if(mapTiles[i][k] == Tile.PATH_TOP_LEFT) { texture = Assets.dirtCorner; xflip = false; yflip = false; } 
	    		else if(mapTiles[i][k] == Tile.PATH_TOP_RIGHT) { texture = Assets.dirtCorner; xflip = true; yflip = false; } 
	    		else if(mapTiles[i][k] == Tile.PATH_BOTTOM_LEFT) { texture = Assets.dirtCorner; xflip = false; yflip = true; }
	    		else if(mapTiles[i][k] == Tile.WATER) { texture = Assets.water.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; } 
	    		else if(mapTiles[i][k] == Tile.WATER_LEFT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; } 
	    		else if(mapTiles[i][k] == Tile.WATER_RIGHT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.LOOPING); xflip = true; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.GEM_BLUE) { texture = Assets.gemBlue; xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.GEM_GREEN) { texture = Assets.gemGreen; xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.GEM_GRAY) { texture = Assets.gemGray; xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.GEM_PURPLE) { texture = Assets.gemPurple; xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.GEM_RED) { texture = Assets.gemRed; xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.GEM_ORANGE) { texture = Assets.gemOrange; xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.PATH_VERTICAL) { texture = Assets.dirtVertical; xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.WATER_BOTTOM) { texture = Assets.waterBottom.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.WATER_TOPLEFT_CORNER) { texture = Assets.waterTopLeftCorner.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(mapTiles[i][k] == Tile.WATER_TOPRIGHT_CORNER) { texture = Assets.waterTopRightCorner.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }

	    		texture.flip(xflip, yflip);
	    		batch.draw(texture, x+k*32, y-(i*32), 32, 32);
	    		texture.flip(xflip, yflip);
		    }
	    }
		
		batch.enableBlending();
		
		for(int i=0; i<mapTiles.length; i++) {
	    	for(int k=0; k<mapTiles[i].length; k++) {
	    		TextureRegion texture = null;
	    		boolean xflip = false, yflip = false;
	    		if(mapOverlay1[i][k] == Tile.NULL) { texture = Assets.blank; xflip = false; yflip = false; } 
	    		else if(mapOverlay1[i][k] == Tile.WATER_BOTTOM) { texture = Assets.waterBottom.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(mapOverlay1[i][k] == Tile.WATER_TOPLEFT_CORNER) { texture = Assets.waterTopLeftCorner.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(mapOverlay1[i][k] == Tile.WATER_TOPRIGHT_CORNER) { texture = Assets.waterTopRightCorner.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(mapOverlay1[i][k] == Tile.WATER_LEFT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; } 
	    		else if(mapOverlay1[i][k] == Tile.WATER_RIGHT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.LOOPING); xflip = true; yflip = false; } 
	    		else if(mapOverlay1[i][k] == Tile.PATH_HORIZONTAL) { texture = k<split?blueSkin.getPathHorizontal():redSkin.getPathHorizontal(); xflip = false; yflip = false; } 
	    		else if(mapOverlay1[i][k] == Tile.PATH_BOTTOM_RIGHT) { texture = k<split?blueSkin.getPathCorner():redSkin.getPathCorner(); xflip = true; yflip = true; } 
	    		else if(mapOverlay1[i][k] == Tile.PATH_TOP_LEFT) { texture = k<split?blueSkin.getPathCorner():redSkin.getPathCorner(); xflip = false; yflip = false; } 
	    		else if(mapOverlay1[i][k] == Tile.PATH_TOP_RIGHT) { texture = k<split?blueSkin.getPathCorner():redSkin.getPathCorner(); xflip = true; yflip = false; } 
	    		else if(mapOverlay1[i][k] == Tile.PATH_BOTTOM_LEFT) { texture = k<split?blueSkin.getPathCorner():redSkin.getPathCorner(); xflip = false; yflip = true; }
	    		else if(mapOverlay1[i][k] == Tile.PATH_VERTICAL) { texture = k<split?blueSkin.getPathVertical():redSkin.getPathVertical(); xflip = false; yflip = false; }
	    		else if(mapOverlay1[i][k] == Tile.GRASS_FLOWER) { texture = k<split?blueSkin.getFlower():redSkin.getFlower(); xflip = false; yflip = false; }
	    		
	    		texture.flip(xflip, yflip);
	    		batch.draw(texture, x+k*32, y-(i*32), 32, 32);
	    		texture.flip(xflip, yflip);
		    }
	    }
		
		for(int i=0; i<mapTiles.length; i++) {
	    	for(int k=0; k<mapTiles[i].length; k++) {
	    		TextureRegion texture = null;
	    		boolean xflip = false, yflip = false;
	    		if(mapOverlay2[i][k] == Tile.NULL) { texture = Assets.blank; xflip = false; yflip = false; } 
	    		else if(mapOverlay2[i][k] == Tile.BRIDGE_STONE_HORIZONTAL) { texture = k<split?blueSkin.getBridgeHorizontal():redSkin.getBridgeHorizontal(); xflip = false; yflip = false; } 
	    		else if(mapOverlay2[i][k] == Tile.BRIDGE_STONE_VERTICAL) { texture = k<split?blueSkin.getBridgeVertical():redSkin.getBridgeVertical(); xflip = false; yflip = false; } 
	    		else if(mapOverlay2[i][k] == Tile.BRIDGE_STONE_BOTTOM_RIGHT) { texture = k<split?blueSkin.getBridgeCornerBottomRight():redSkin.getBridgeCornerBottomRight(); xflip = false; yflip = false; } 
	    		else if(mapOverlay2[i][k] == Tile.BRIDGE_STONE_TOP_LEFT) { texture = k<split?blueSkin.getBridgeCornerTopLeft():redSkin.getBridgeCornerTopLeft(); xflip = false; yflip = false; } 
	    		else if(mapOverlay2[i][k] == Tile.BRIDGE_STONE_TOP_RIGHT) { texture = k<split?blueSkin.getBridgeCornerTopLeft():redSkin.getBridgeCornerTopLeft(); xflip = true; yflip = false; } 
	    		else if(mapOverlay2[i][k] == Tile.BRIDGE_STONE_BOTTOM_LEFT) { texture = k<split?blueSkin.getBridgeCornerBottomRight():redSkin.getBridgeCornerBottomRight(); xflip = true; yflip = false; }
	    		
	    		texture.flip(xflip, yflip);
	    		batch.draw(texture, x+k*32, y-(i*32), 32, 32);
	    		texture.flip(xflip, yflip);
		    }
	    }
		
		//water at the top.
		for(int i=0; i<2; i++) {
			for(int j=0; j<36; j++) {
				batch.draw(Assets.water.getKeyFrame(stateTime, Animation.LOOPING), x+j*32, y-(i*32)+64, 32, 32);
			}
		}
	}

	/////////////////////////////////////////////////// Static Class Start ///////////////////////////////////////////////////
	
	private static int[][] mapPath1 = 
{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,3,1,1,1,1,1,4,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,1,1,1,1,1,1,2,0,0,0,0,0,5,1,1,1,1,1,1,4,0,0,0,0,0,3,1,1,1,1,1,1,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,5,1,1,1,1,1,2,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	private static int[][] mapTiles1 = 
{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,3,1,1,1,1,1,4,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,0,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,0,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,11,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,30,0,0,0,0,0,30,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,1,1,1,1,1,2,0,0,0,0,0,5,1,8,7,7,9,1,4,0,0,0,0,0,3,1,1,1,1,1,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,0,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,11,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,0,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,30,0,0,0,0,0,30,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,5,1,1,1,1,1,2,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	private static int[][] mapOverlay11 = 
{{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
	
	private static int[][] mapOverlay21 = 
{{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
	
	private static int[][] mapTowers1 = 
		{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,1,2,2,2,2,2,2,2,0,0,0,0,0,2,2,2,2,2,2,2,2,9,0,0,0,0,2,2,2,2,2,2,2,1,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,9,0,0,0,0,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	public static Map map1 = new Map(mapPath1, mapTiles1, mapOverlay11, mapOverlay21, mapTowers1, 8, 8, Skin.classic, Skin.classic, 18);
	
	public static Map generateMap1() {
		int[][] mapPath = Map.mapPath1;
		int[][] mapTiles = Map.mapTiles1;
		int[][] mapOverlay1 = Map.mapOverlay11;
		int[][] mapOverlay2 = Map.mapOverlay21;
		int[][] mapTowers = Map.mapTowers1;
		
		Random rand = new Random();
        for(int i=0; i<mapTiles.length; i++) {
	    	for(int k=0; k<mapTiles[i].length; k++) {
	    		if(mapTiles[i][k] == 0) {
	    			int temp = rand.nextInt(30);
	    			if(temp == 0) {
	    				mapTiles[i][k] = 20;
	    			}
	    		} else if(mapTiles[i][k] == 11) {
	    			int temp = rand.nextInt(6);
	    			if(temp == 0) {
	    				mapTiles[i][k] = 11;
	    			} else if(temp == 1) {
	    				mapTiles[i][k] = 12;
	    			} else if(temp == 2) {
	    				mapTiles[i][k] = 13;
	    			} else if(temp == 3) {
	    				mapTiles[i][k] = 14;
	    			} else if(temp == 4) {
	    				mapTiles[i][k] = 15;
	    			} else if(temp == 5) {
	    				mapTiles[i][k] = 16;
	    			}
	    		}
	    	}
        }
        
        return new Map(mapPath, mapTiles, mapOverlay1, mapOverlay2, mapTowers, 8, 8, Skin.classic, Skin.classic, 18);
	}
	
	public static Map generateRandomMap() {
		int[][] mapPath = new int[17][36];
		int[][] mapTiles = new int[17][36];
		int[][] mapOverlay1 = new int[17][36];
		int[][] mapOverlay2 = new int[17][36];
		int[][] mapTowers = new int[17][36];
		
		Random rand = new Random();
		
		//Grass generator
		for(int i=0; i<mapTiles.length; i++) {
			for(int k=0; k<mapTiles[i].length; k++) {
				int temp1 = rand.nextInt(60)+1;
				int temp2 = rand.nextInt(temp1);
				if(temp2==0) {
					mapOverlay1[i][k] = Tile.GRASS_FLOWER;
					mapTiles[i][k] = Tile.GRASS;
				} else {
					mapOverlay1[i][k] = Tile.NULL;
					mapTiles[i][k] = Tile.GRASS;
				}
				mapPath[i][k] = 0;
				mapOverlay2[i][k] = Tile.NULL;
				mapTowers[i][k] = k<18?Tile.TOWER_BLUE_ALLOWED:Tile.TOWER_RED_ALLOWED;
				
				if(i==0) {
					mapPath[i][k] = 9;
					mapTiles[i][k] = Tile.GRASS;
					mapOverlay1[i][k] = Tile.WATER_BOTTOM;
					mapTowers[i][k] = Tile.TOWER_NOTALLOWED;
				}
			}
		}
		
		//Starting point
		int start = rand.nextInt(16)+1;
		mapOverlay1[start][3] = Tile.PATH_HORIZONTAL;
		mapPath[start][3] = Tile.PATH_GO;
		mapPath[start][2] = Tile.PATH_GO;
		mapTowers[start][3] = Tile.TOWER_NOTALLOWED;
		mapTowers[start][2] = Tile.TOWER_BLUE_TAKEN;
		int blueStart = 16-start;
		
		for(int i=1; i<29; i++) {
			int turn = rand.nextInt(2);
			if(turn == 0) {
				int temp = rand.nextInt(2);
				if(temp == 0 && start != 1) { //turn up
					mapOverlay1[start][3+i] = Tile.PATH_BOTTOM_RIGHT;
					mapPath[start][3+i] = 2;
					mapTowers[start][3+i] = Tile.TOWER_NOTALLOWED;
					int timesvertical = rand.nextInt(start);
					timesvertical = timesvertical<2?2:timesvertical;
					//System.out.println(timesvertical);
					for(int k=1; k<timesvertical; k++) {
						mapOverlay1[start-k][3+i] = Tile.PATH_VERTICAL;
						mapPath[start-k][3+i] = Tile.PATH_GO;
						mapTowers[start-k][3+i] = Tile.TOWER_NOTALLOWED;
						if(k==timesvertical-1) {
							mapOverlay1[start-k][3+i] = Tile.PATH_TOP_LEFT;
							mapPath[start-k][3+i] = 3;
						}
					}
					start -= timesvertical-1;
				} else if(temp == 1 && start != 16) { //turn down
					mapOverlay1[start][3+i] = Tile.PATH_TOP_RIGHT;
					mapPath[start][3+i] = 4;
					mapTowers[start][3+i] = Tile.TOWER_NOTALLOWED;
					int timesvertical = rand.nextInt(16-start);
					if(timesvertical < 2) {
						timesvertical = 2;
					}
					timesvertical = timesvertical<2?2:timesvertical;
					//System.out.println(timesvertical);
					for(int k=1; k<timesvertical; k++) {
						mapOverlay1[start+k][3+i] = Tile.PATH_VERTICAL;
						mapPath[start+k][3+i] = Tile.PATH_GO;
						mapTowers[start+k][3+i] = Tile.TOWER_NOTALLOWED;
						if(k==timesvertical-1) {
							mapOverlay1[start+k][3+i] = Tile.PATH_BOTTOM_LEFT;
							mapPath[start+k][3+i] = 5;
						}
					}
					start += timesvertical-1;
				} else {
					mapOverlay1[start][3+i] = Tile.PATH_HORIZONTAL;
					mapPath[start][3+i] = Tile.PATH_GO;
					mapTowers[start][3+i] = Tile.TOWER_NOTALLOWED;
				}
			} else {
				mapOverlay1[start][3+i] = Tile.PATH_HORIZONTAL;
				mapPath[start][3+i] = Tile.PATH_GO;
				mapTowers[start][3+i] = Tile.TOWER_NOTALLOWED;
			}
		}

		mapOverlay1[start][32] = Tile.PATH_HORIZONTAL;
		mapPath[start][32] = Tile.PATH_GO;
		mapPath[start][33] = Tile.PATH_GO;
		mapTowers[start][32] = Tile.TOWER_NOTALLOWED;
		mapTowers[start][33] = Tile.TOWER_RED_TAKEN;
		int redStart = 16-start;
		
		//Water
		int waterStart = rand.nextInt(4)+13;
		int waterEnd = rand.nextInt(4)+16;
		int splitamount = (waterEnd-waterStart-1)/2;
		int split = waterEnd-splitamount;
		
		for(int i=0; i<mapTiles.length; i++) {
			for(int k=waterStart; k<waterEnd+1; k++) {
				if(mapOverlay1[i][k] == Tile.PATH_HORIZONTAL || mapOverlay1[i][k] == Tile.PATH_BOTTOM_RIGHT || mapOverlay1[i][k] == Tile.PATH_TOP_LEFT || mapOverlay1[i][k] == Tile.PATH_TOP_RIGHT || mapOverlay1[i][k] == Tile.PATH_BOTTOM_LEFT || mapOverlay1[i][k] == Tile.PATH_VERTICAL) {
					mapOverlay2[i][k] = mapOverlay1[i][k]; //bridge
					mapTiles[i][k] = Tile.WATER;
					mapOverlay1[i][k] = Tile.NULL;
				} else if(mapTiles[i][k] == Tile.GRASS || mapTiles[i][k] == Tile.GRASS_FLOWER || mapOverlay1[i][k] == Tile.WATER_BOTTOM) {
					mapTiles[i][k] = Tile.WATER;
					mapOverlay1[i][k] = Tile.NULL;
				}
				mapTowers[i][k] = Tile.TOWER_NOTALLOWED;
			}
		}
		for(int i=0; i<mapTiles.length; i++) {
			for(int k=waterStart; k<waterEnd+1; k+=(waterEnd-waterStart)) {
				if(mapTiles[i][k] == Tile.WATER) {
					mapTiles[i][k] = Tile.GRASS;
					mapOverlay1[i][k] = k==waterStart?Tile.WATER_LEFT:Tile.WATER_RIGHT;
				}
				if(i==0) {
					mapTiles[i][k] = Tile.GRASS;
					mapOverlay1[i][k] = k==waterStart?Tile.WATER_TOPRIGHT_CORNER:Tile.WATER_TOPLEFT_CORNER;
				}
			}
		}

		System.out.println(Skins.grassAll);

		Skin skinBlue = Skin.getRandomSkin();
		Skin skinRed = Skin.getRandomSkin();
		
        return new Map(mapPath, mapTiles, mapOverlay1, mapOverlay2, mapTowers, blueStart, redStart, skinBlue, skinRed, split);
	}
}