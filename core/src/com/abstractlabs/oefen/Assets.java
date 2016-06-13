package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture backgroundMainMenu;
	public static TextureRegion backgroundMainMenuRegion;
	public static Texture backgroundIngame;
	public static TextureRegion backgroundIngameRegion;
	
	public static Texture buttons;
	public static TextureRegion play;
	public static TextureRegion playHover;
	public static TextureRegion playClick;

	public static Texture tiles;
	public static TextureRegion voidTile;
	public static TextureRegion grassTile;
	public static TextureRegion dirtTile;
	public static TextureRegion dirtCornerTile;
	public static Animation waterTile;
	public static Animation waterCornerTile;
	public static Animation bridgeTile;
	public static Animation bridge2Tile;
	public static Animation waterSideTile;
	public static TextureRegion hoverTile;
	public static TextureRegion gemBlue;
	public static TextureRegion gemGreen;
	public static TextureRegion gemGray;
	public static TextureRegion gemPurple;
	public static TextureRegion gemRed;
	public static TextureRegion gemOrange;

	public static Texture towers;
	public static TextureRegion greenTower;
	public static TextureRegion redTower;

	public static Texture cards;
	public static TextureRegion teemoCard;
	
	public static BitmapFont font;
	
	public static Sound clickSound;

	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		//Backgrounds
		backgroundMainMenu = loadTexture("gfx/background_mainmenu.png");
		backgroundMainMenuRegion = new TextureRegion(backgroundMainMenu, 0, 0, Oefen.WIDTH, Oefen.HEIGHT);
		backgroundIngame = loadTexture("gfx/background_ingame.png");
		backgroundIngameRegion = new TextureRegion(backgroundIngame, 0, 0, Oefen.WIDTH, Oefen.HEIGHT);

		//Buttons
		buttons = loadTexture("gfx/buttons.png");
		play = new TextureRegion(buttons, 0, 0, 200, 53);
		playHover = new TextureRegion(buttons, 200, 0, 200, 53);
		playClick = new TextureRegion(buttons, 400, 0, 200, 53);

		//Tiles
		tiles = loadTexture("gfx/tiles.png");
		voidTile = new TextureRegion(tiles, 0*16, 0*16, 16, 16);
		grassTile = new TextureRegion(tiles, 5*16, 0*16, 16, 16);
		dirtTile = new TextureRegion(tiles, 2*16, 0*16, 16, 16);
		//bridgeTile = new TextureRegion(tiles, 3*16, 0*16, 16, 16);
		dirtCornerTile = new TextureRegion(tiles, 6*16, 0*16, 16, 16);
		waterTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*16, 9*16, 16, 16), 
				new TextureRegion(tiles, 1*16, 9*16, 16, 16), 
				new TextureRegion(tiles, 2*16, 9*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 9*16, 16, 16));
		waterCornerTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*16, 5*16, 16, 16), 
				new TextureRegion(tiles, 1*16, 5*16, 16, 16), 
				new TextureRegion(tiles, 2*16, 5*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 5*16, 16, 16));
		bridgeTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*16, 10*16, 16, 16), 
				new TextureRegion(tiles, 1*16, 10*16, 16, 16), 
				new TextureRegion(tiles, 2*16, 10*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 10*16, 16, 16));
		bridge2Tile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*16, 11*16, 16, 16), 
				new TextureRegion(tiles, 1*16, 11*16, 16, 16), 
				new TextureRegion(tiles, 2*16, 11*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 11*16, 16, 16));
		waterSideTile = new Animation(5.0f, 
//				new TextureRegion(tiles, 0*16, 8*16, 16, 16), 
//				new TextureRegion(tiles, 1*16, 8*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 8*16, 16, 16)); 
//				new TextureRegion(tiles, 3*16, 8*16, 16, 16)); 
//				new TextureRegion(tiles, 2*16, 8*16, 16, 16));
//				new TextureRegion(tiles, 1*16, 8*16, 16, 16));
		hoverTile = new TextureRegion(tiles, 0*16, 15*16, 16, 16);
		gemBlue   = new TextureRegion(tiles, 0*16, 2*16, 16, 16);
		gemGreen  = new TextureRegion(tiles, 1*16, 2*16, 16, 16);
		gemGray   = new TextureRegion(tiles, 2*16, 2*16, 16, 16);
		gemPurple = new TextureRegion(tiles, 3*16, 2*16, 16, 16);
		gemRed    = new TextureRegion(tiles, 4*16, 2*16, 16, 16);
		gemOrange = new TextureRegion(tiles, 5*16, 2*16, 16, 16);

		//Towers
		towers = loadTexture("gfx/towers.png");
		greenTower = new TextureRegion(towers, 0*64, 0*64, 64, 64);
		redTower = new TextureRegion(towers, 1*64, 0*64, 64, 64);

		//Cards
		cards = loadTexture("gfx/cards.png");
		teemoCard = new TextureRegion(cards, 0*64, 0*64, 64, 64);

		//Font
		font = new BitmapFont();

		//Sounds
		clickSound = Gdx.audio.newSound(Gdx.files.internal("sound/click.wav"));
	}

	public static void playSound (Sound sound) {
		if (Settings.soundEnabled) sound.play(1);
	}
}