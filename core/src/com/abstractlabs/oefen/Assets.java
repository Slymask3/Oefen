package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
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
	public static TextureRegion dirt2Tile;
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
	public static Animation waterStone;
	public static TextureRegion stone;
	public static TextureRegion blank;
	public static TextureRegion bridgeStoneHorizontal;
	public static TextureRegion bridgeStoneVertical;
	public static TextureRegion bridgeStoneCornerBottomRight;
	public static TextureRegion bridgeStoneCornerTopLeft;
	public static Animation water;
	public static Animation waterLeft;
	public static Animation waterRight;
	public static Animation waterTop;
	public static Animation waterBottom;
	public static Animation waterBottomLeft;
	public static Animation waterBottomRight;
	public static Animation waterTopLeft;
	public static Animation waterTopRight;

	public static Texture towers;
	public static TextureRegion wtfisthis;
	public static TextureRegion mainTower;

	public static Texture cards;
	public static TextureRegion card;
	public static TextureRegion cardTeemo;
	public static TextureRegion cardGoblin;
	public static TextureRegion cardFairy;
	
	public static Texture goblin;
	public static Animation goblinWalkUp;
	public static Animation goblinWalkDown;
	public static Animation goblinWalkLeft;
	public static Animation goblinWalkRight;
	public static Animation goblinAttackUp;
	public static Animation goblinAttackDown;
	public static Animation goblinAttackLeft;
	public static Animation goblinAttackRight;
	
	public static Texture fairy;
	public static Animation fairyWalkUp;
	public static Animation fairyWalkDown;
	public static Animation fairyWalkLeft;
	public static Animation fairyWalkRight;
	
	public static TextureRegion hpbar;
	
	public static Texture hp;
	public static TextureRegion mainhp;
	
	public static Texture bloodSheet;
	public static Animation blood;
	
	public static Texture arrowSheet;
	public static TextureRegion arrow;
	
	public static Sound clickSound;

	public static Texture loadTexture(String file) {
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
		voidTile = new TextureRegion(tiles, 0*32, 0*32, 32, 32);
		grassTile = new TextureRegion(tiles, 14*32, 0*32, 32, 32);
		dirtTile = new TextureRegion(tiles, 2*32, 1*32, 32, 32);
		dirt2Tile = new TextureRegion(tiles, 8*32, 1*32, 32, 32);
		dirtCornerTile = new TextureRegion(tiles, 6*32, 1*32, 32, 32);
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
		grassFlowerTile = new TextureRegion(tiles, 15*32, 0*32, 32, 32);
		waterStone = new Animation(0.5f, 
				new TextureRegion(tiles, 0*32, 12*32, 32, 32), 
				new TextureRegion(tiles, 1*32, 12*32, 32, 32), 
				new TextureRegion(tiles, 2*32, 12*32, 32, 32), 
				new TextureRegion(tiles, 3*32, 12*32, 32, 32));
		stone = new TextureRegion(tiles, 9*32, 0*32, 32, 32);
		blank = new TextureRegion(tiles, 0*32, 0*32, 32, 32);
		bridgeStoneHorizontal = new TextureRegion(tiles, 10*32, 0*32, 32, 32);
		bridgeStoneVertical = new TextureRegion(tiles, 12*32, 0*32, 32, 32);
		bridgeStoneCornerBottomRight = new TextureRegion(tiles, 11*32, 0*32, 32, 32);
		bridgeStoneCornerTopLeft = new TextureRegion(tiles, 13*32, 0*32, 32, 32);
		water = new Animation(0.5f, 
				new TextureRegion(tiles, 11*32, 2*32, 32, 32), 
				new TextureRegion(tiles, 14*32, 2*32, 32, 32));
		waterLeft = new Animation(0.5f, 
				new TextureRegion(tiles, 10*32, 2*32, 32, 32), 
				new TextureRegion(tiles, 13*32, 2*32, 32, 32));
		waterRight = new Animation(0.5f, 
				new TextureRegion(tiles, 12*32, 2*32, 32, 32), 
				new TextureRegion(tiles, 15*32, 2*32, 32, 32));
		waterTop = new Animation(0.5f, 
				new TextureRegion(tiles, 11*32, 1*32, 32, 32), 
				new TextureRegion(tiles, 14*32, 1*32, 32, 32));
		waterBottom = new Animation(0.5f, 
				new TextureRegion(tiles, 11*32, 3*32, 32, 32), 
				new TextureRegion(tiles, 14*32, 3*32, 32, 32));
		waterBottomLeft = new Animation(0.5f, 
				new TextureRegion(tiles, 10*32, 3*32, 32, 32), 
				new TextureRegion(tiles, 13*32, 3*32, 32, 32));
		waterBottomRight = new Animation(0.5f, 
				new TextureRegion(tiles, 12*32, 3*32, 32, 32), 
				new TextureRegion(tiles, 15*32, 3*32, 32, 32));
		waterTopLeft = new Animation(0.5f, 
				new TextureRegion(tiles, 10*32, 1*32, 32, 32), 
				new TextureRegion(tiles, 13*32, 1*32, 32, 32));
		waterTopRight = new Animation(0.5f, 
				new TextureRegion(tiles, 12*32, 1*32, 32, 32), 
				new TextureRegion(tiles, 15*32, 1*32, 32, 32));
		
		//Towers
		towers = loadTexture("gfx/towers.png");
		wtfisthis = new TextureRegion(towers, 0*32, 0*32, 32, 32);
		mainTower = new TextureRegion(towers, 0*32, 1*32, 32, 64);

		//Attackers
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
		fairy = loadTexture("gfx/fairy.png");
		fairyWalkDown = new Animation(0.2f, 
				new TextureRegion(fairy, 0*32, 0*48, 32, 48), 
				new TextureRegion(fairy, 1*32, 0*48, 32, 48), 
				new TextureRegion(fairy, 2*32, 0*48, 32, 48));
		fairyWalkLeft = new Animation(0.2f, 
				new TextureRegion(fairy, 0*32, 1*48, 32, 48), 
				new TextureRegion(fairy, 1*32, 1*48, 32, 48), 
				new TextureRegion(fairy, 2*32, 1*48, 32, 48));
		fairyWalkRight = new Animation(0.2f, 
				new TextureRegion(fairy, 0*32, 2*48, 32, 48), 
				new TextureRegion(fairy, 1*32, 2*48, 32, 48), 
				new TextureRegion(fairy, 2*32, 2*48, 32, 48));
		fairyWalkUp = new Animation(0.2f, 
				new TextureRegion(fairy, 0*32, 3*48, 32, 48), 
				new TextureRegion(fairy, 1*32, 3*48, 32, 48), 
				new TextureRegion(fairy, 2*32, 3*48, 32, 48));
		
		//Other
		hpbar = new TextureRegion(tiles, 0, 480, 32, 4);

		hp = loadTexture("gfx/mainhp.png");
		mainhp = new TextureRegion(hp, 0, 0, 60, 544);
		
		arrowSheet = loadTexture("gfx/arrow.png");
		arrow = new TextureRegion(arrowSheet, 0, 0, 31, 5);
		
		//Particles
		bloodSheet = loadTexture("gfx/blood.png");
		blood = new Animation(0.1f,
				new TextureRegion(bloodSheet, 0*32, 0*32, 32, 32), 
				new TextureRegion(bloodSheet, 1*32, 0*32, 32, 32), 
				new TextureRegion(bloodSheet, 2*32, 0*32, 32, 32), 
				new TextureRegion(bloodSheet, 3*32, 0*32, 32, 32), 
				new TextureRegion(bloodSheet, 0*32, 1*32, 32, 32), 
				new TextureRegion(bloodSheet, 1*32, 1*32, 32, 32), 
				new TextureRegion(bloodSheet, 2*32, 1*32, 32, 32), 
				new TextureRegion(bloodSheet, 3*32, 1*32, 32, 32), 
				new TextureRegion(bloodSheet, 0*32, 2*32, 32, 32), 
				new TextureRegion(bloodSheet, 1*32, 2*32, 32, 32), 
				new TextureRegion(bloodSheet, 2*32, 2*32, 32, 32), 
				new TextureRegion(bloodSheet, 3*32, 2*32, 32, 32), 
				new TextureRegion(bloodSheet, 0*32, 3*32, 32, 32), 
				new TextureRegion(bloodSheet, 1*32, 3*32, 32, 32), 
				new TextureRegion(bloodSheet, 2*32, 3*32, 32, 32), 
				new TextureRegion(bloodSheet, 3*32, 3*32, 32, 32));

		//Cards
		cards = loadTexture("gfx/cards.png");
		card = new TextureRegion(cards, 2*64, 0*64, 64, 64);
		cardTeemo = new TextureRegion(cards, 0*64, 0*64, 64, 64);
		cardGoblin = new TextureRegion(goblin, 0*64, 2*64, 64, 64);
		cardFairy = new TextureRegion(fairy, 1*32, 0*48, 32, 48);

		//Sounds
		clickSound = Gdx.audio.newSound(Gdx.files.internal("sound/click.mp3"));
	}

	public static void playSound (Sound sound) {
		if (Settings.soundEnabled) sound.play(0.2f);
	}
}