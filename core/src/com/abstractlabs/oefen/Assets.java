package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture backgroundMainMenu;
	public static Texture backgroundMastery;
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
	public static TextureRegion grassFlowerTile;

	public static Texture towers;
	public static TextureRegion wtfisthis;

	public static Texture cards;
	public static TextureRegion teemoCard;
	public static TextureRegion skeleCard;
	
	public static Texture book;
	public static Animation bookStill;
	public static Animation bookFrames;	
	
	public static Texture goblin;
	public static Texture skeleton;
	public static Animation goblinWalkUp;
	public static Animation goblinWalkDown;
	public static Animation goblinWalkLeft;
	public static Animation goblinWalkRight;
	public static Animation goblinAttackUp;
	public static Animation goblinAttackDown;
	public static Animation goblinAttackLeft;
	public static Animation goblinAttackRight;
	public static Animation skeleWalkUp;
	public static Animation skeleWalkDown;
	public static Animation skeleWalkLeft;
	public static Animation skeleWalkRight;
	public static Animation skeleAttackUp;
	public static Animation skeleAttackDown;
	public static Animation skeleAttackLeft;
	public static Animation skeleAttackRight;
	
	public static TextureRegion hpbar;
	
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
		backgroundMastery = loadTexture("gfx/backgroundMastery.jpg");

		//Buttons
		buttons = loadTexture("gfx/buttons.png");
		play = new TextureRegion(buttons, 0, 0, 200, 53);
		playHover = new TextureRegion(buttons, 200, 0, 200, 53);
		playClick = new TextureRegion(buttons, 400, 0, 200, 53);

		//Tiles
		tiles = loadTexture("gfx/tiles.png");
		voidTile = new TextureRegion(tiles, 0*32, 0*32, 16, 16);
		grassTile = new TextureRegion(tiles, 5*32, 0*32, 32, 32);
		dirtTile = new TextureRegion(tiles, 2*32, 0*32, 32, 32);
		//bridgeTile = new TextureRegion(tiles, 3*32, 0*32, 32, 32);
		dirtCornerTile = new TextureRegion(tiles, 6*32, 0*32, 32, 32);
		waterTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*32, 9*32, 32, 32), 
				new TextureRegion(tiles, 1*32, 9*32, 32, 32), 
				new TextureRegion(tiles, 2*32, 9*32, 32, 32), 
				new TextureRegion(tiles, 3*32, 9*32, 32, 32));
		waterCornerTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*32, 5*32, 32, 32), 
				new TextureRegion(tiles, 1*32, 5*32, 32, 32), 
				new TextureRegion(tiles, 2*32, 5*32, 32, 32), 
				new TextureRegion(tiles, 3*32, 5*32, 32, 32));
		bridgeTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*32, 10*32, 32, 32), 
				new TextureRegion(tiles, 1*32, 10*32, 32, 32), 
				new TextureRegion(tiles, 2*32, 10*32, 32, 32), 
				new TextureRegion(tiles, 3*32, 10*32, 32, 32));
		bridge2Tile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*32, 11*32, 32, 32), 
				new TextureRegion(tiles, 1*32, 11*32, 32, 32), 
				new TextureRegion(tiles, 2*32, 11*32, 32, 32), 
				new TextureRegion(tiles, 3*32, 11*32, 32, 32));
		waterSideTile = new Animation(5.0f, 
//				new TextureRegion(tiles, 0*32, 8*32, 32, 32), 
//				new TextureRegion(tiles, 1*32, 8*32, 32, 32), 
				new TextureRegion(tiles, 3*32, 8*32, 32, 32)); 
//				new TextureRegion(tiles, 3*32, 8*32, 32, 32)); 
//				new TextureRegion(tiles, 2*32, 8*32, 32, 32));
//				new TextureRegion(tiles, 1*32, 8*32, 32, 32));
		hoverTile = new TextureRegion(tiles, 0*32, 15*32, 32, 32);
		gemBlue   = new TextureRegion(tiles, 0*32, 2*32, 32, 32);
		gemGreen  = new TextureRegion(tiles, 1*32, 2*32, 32, 32);
		gemGray   = new TextureRegion(tiles, 2*32, 2*32, 32, 32);
		gemPurple = new TextureRegion(tiles, 3*32, 2*32, 32, 32);
		gemRed    = new TextureRegion(tiles, 4*32, 2*32, 32, 32);
		gemOrange = new TextureRegion(tiles, 5*32, 2*32, 32, 32);
		grassFlowerTile = new TextureRegion(tiles, 7*32, 0*32, 32, 32);

		//Towers
		towers = loadTexture("gfx/towers.png");
		wtfisthis = new TextureRegion(towers, 0*32, 0*32, 32, 32);

		//Cards
		cards = loadTexture("gfx/cards.png");
		teemoCard = new TextureRegion(cards, 0*64, 0*64, 64, 64);
		skeleCard = new TextureRegion(cards, 1*64, 0*64, 64, 64);

		//Tiles
		goblin = loadTexture("gfx/goblin.png");
		goblinWalkUp = new Animation(0.5f, 
				new TextureRegion(goblin, 0*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 8*64, 64, 64), 
				new TextureRegion(goblin, 8*64, 8*64, 64, 64));
		goblinWalkLeft = new Animation(0.5f, 
				new TextureRegion(goblin, 0*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 9*64, 64, 64), 
				new TextureRegion(goblin, 8*64, 9*64, 64, 64));
		goblinWalkDown = new Animation(0.5f, 
				new TextureRegion(goblin, 0*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 10*64, 64, 64), 
				new TextureRegion(goblin, 8*64, 10*64, 64, 64));
		goblinWalkRight = new Animation(0.3f, 
				new TextureRegion(goblin, 0*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 11*64, 64, 64), 
				new TextureRegion(goblin, 8*64, 11*64, 64, 64));
		goblinAttackUp = new Animation(0.2f, 
				new TextureRegion(goblin, 0*64, 4*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 4*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 4*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 4*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 4*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 4*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 4*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 4*64, 64, 64));
		goblinAttackLeft = new Animation(0.2f, 
				new TextureRegion(goblin, 0*64, 5*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 5*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 5*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 5*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 5*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 5*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 5*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 5*64, 64, 64));
		goblinAttackDown = new Animation(0.2f, 
				new TextureRegion(goblin, 0*64, 6*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 6*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 6*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 6*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 6*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 6*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 6*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 6*64, 64, 64));
		goblinAttackRight = new Animation(0.2f, 
				new TextureRegion(goblin, 0*64, 7*64, 64, 64), 
				new TextureRegion(goblin, 1*64, 7*64, 64, 64), 
				new TextureRegion(goblin, 2*64, 7*64, 64, 64), 
				new TextureRegion(goblin, 3*64, 7*64, 64, 64), 
				new TextureRegion(goblin, 4*64, 7*64, 64, 64), 
				new TextureRegion(goblin, 5*64, 7*64, 64, 64), 
				new TextureRegion(goblin, 6*64, 7*64, 64, 64), 
				new TextureRegion(goblin, 7*64, 7*64, 64, 64));
		
		book = loadTexture("gfx/book.png");
		bookFrames = new Animation(0.1f,
				new TextureRegion(book, 0*1000, 0*700, 1000, 700),
				new TextureRegion(book, 1*1000, 0*700, 1000, 700),
				new TextureRegion(book, 2*1000, 0*700, 1000, 700),
				new TextureRegion(book, 3*1000, 0*700, 1000, 700),
				new TextureRegion(book, 4*1000, 0*700, 1000, 700),
				new TextureRegion(book, 5*1000, 0*700, 1000, 700),
				new TextureRegion(book, 6*1000, 0*700, 1000, 700));
		
		bookStill = new Animation(0f, 
				new TextureRegion(book, 0*1000, 0*700, 1000, 700));
		
//		bookFrame_2 = new Animation(0.1f,
//				new TextureRegion(book, 1*64, 0*64, 256, 256));
//		bookFrame_3 = new Animation(0.1f,
//				new TextureRegion(book, 2*64, 0*64, 256, 256));
//		bookFrame_4 = new Animation(0.1f,
//				new TextureRegion(book, 3*64, 0*64, 256, 256));
//		bookFrame_5 = new Animation(0.1f,
//				new TextureRegion(book, 4*64, 1*64, 256, 256));
//		bookFrame_6 = new Animation(0.1f,
//				new TextureRegion(book, 5*64, 1*64, 256, 256));
//		bookFrame_7 = new Animation(0.1f,
//				new TextureRegion(book, 6*64, 1*64, 256, 256));
		
		
		skeleton = loadTexture("gfx/skeleton_sprites.png");
		skeleWalkUp = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 0*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 0*64, 64, 64));
		skeleWalkLeft = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 1*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 1*64, 64, 64));
		skeleWalkDown = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 2*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 2*64, 64, 64));
		skeleWalkRight = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 3*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 3*64, 64, 64));
		skeleAttackUp = new Animation(0.2f,
				new TextureRegion(skeleton, 0*64, 4*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 4*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 4*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 4*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 4*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 4*64, 64, 64));
		skeleAttackLeft = new Animation(0.2f,
				new TextureRegion(skeleton, 0*64, 5*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 5*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 5*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 5*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 5*64, 64, 64));
		skeleAttackDown = new Animation(0.2f,
				new TextureRegion(skeleton, 0*64, 6*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 6*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 6*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 6*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 6*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 6*64, 64, 64));
		skeleAttackRight = new Animation(0.2f,
				new TextureRegion(skeleton, 0*64, 7*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 7*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 7*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 7*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 7*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 7*64, 64, 64));
		
		//Other
		hpbar = new TextureRegion(tiles, 0, 480, 32, 4);
		
		//Font
		font = new BitmapFont();

		//Sounds
		clickSound = Gdx.audio.newSound(Gdx.files.internal("sound/click.wav"));
	}

	public static void playSound (Sound sound) {
		if (Settings.soundEnabled) sound.play(1);
	}
}