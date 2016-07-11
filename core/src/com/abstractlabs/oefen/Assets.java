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
	public static Texture backgroundMastery;

	public static Texture buttons;
	public static TextureRegion play;
	public static TextureRegion playHover;
	public static TextureRegion playClick;

	public static Texture tiles;
	public static TextureRegion blank;
	public static TextureRegion hoverTile;
	public static TextureRegion grass;
	public static TextureRegion flower;
	public static TextureRegion dirtHorizontal;
	public static TextureRegion dirtVertical;
	public static TextureRegion dirtCorner;
	public static TextureRegion gemBlue;
	public static TextureRegion gemGreen;
	public static TextureRegion gemGray;
	public static TextureRegion gemPurple;
	public static TextureRegion gemRed;
	public static TextureRegion gemOrange;
	public static TextureRegion bridgeStoneHorizontal;
	public static TextureRegion bridgeStoneVertical;
	public static TextureRegion bridgeStoneCornerBottomRight;
	public static TextureRegion bridgeStoneCornerTopLeft;
	public static TextureRegion bridgeStone2Horizontal;
	public static TextureRegion bridgeStone2Vertical;
	public static TextureRegion bridgeStone2CornerBottomRight;
	public static TextureRegion bridgeStone2CornerTopLeft;
	public static Animation water;
	public static Animation waterLeft;
	public static Animation waterRight;
	public static Animation waterTop;
	public static Animation waterBottom;
	public static Animation waterBottomLeft;
	public static Animation waterBottomRight;
	public static Animation waterTopLeft;
	public static Animation waterTopRight;
	public static Animation waterTopLeftCorner;
	public static Animation waterTopRightCorner;
	public static Animation waterBottomLeftCorner;
	public static Animation waterBottomRightCorner;
	public static TextureRegion snow;
	public static TextureRegion sand;
	public static TextureRegion deadTree;
	public static TextureRegion pathHorizontal;
	public static TextureRegion pathVertical;
	public static TextureRegion pathCorner;
	public static TextureRegion sand2;
	public static TextureRegion roadHorizontal;
	public static TextureRegion roadVertical;
	public static TextureRegion roadCorner;
	public static TextureRegion grass16;
	public static TextureRegion flower16;
	public static TextureRegion path16Horizontal;
	public static TextureRegion path16Vertical;
	public static TextureRegion path16Corner;

	public static Texture towers;
	public static TextureRegion mainTower;
	public static TextureRegion wtfisthis;
	public static TextureRegion budhaGold;
	public static TextureRegion lazorRed;

	
	public static Texture book;
	public static Animation bookStill;
	public static Animation bookFrames;	

	public static Texture dummy;
	public static Animation dummySpin;
	public static Animation dummyDeath;

	public static Texture cards;
	public static TextureRegion card;
	public static TextureRegion cardTeemo;
	public static TextureRegion cardGoblin;
	public static TextureRegion cardFairy;
	public static TextureRegion cardGoblinDarkMage;
	public static TextureRegion cardDummy;
	public static TextureRegion cardSpiderRed;
	public static TextureRegion cardCrystalBlue;
	public static TextureRegion cardKnight;
	public static TextureRegion cardBat;
	public static TextureRegion cardGolem;
	public static TextureRegion cardExplosion;
	public static TextureRegion cardMage;
	public static TextureRegion cardBrainmonster;
	public static TextureRegion cardElfHealer;
	public static TextureRegion cardViking;
	public static TextureRegion cardImp;
	
	public static Texture goblin;
	public static Animation goblinWalkUp;
	public static Animation goblinWalkDown;
	public static Animation goblinWalkLeft;
	public static Animation goblinWalkRight;
	public static Animation goblinAttackUp;
	public static Animation goblinAttackDown;
	public static Animation goblinAttackLeft;
	public static Animation goblinAttackRight;
	
	public static Texture goblinDarkMage;
	public static Animation goblinDarkMageWalkUp;
	public static Animation goblinDarkMageWalkDown;
	public static Animation goblinDarkMageWalkLeft;
	public static Animation goblinDarkMageWalkRight;
	public static Animation goblinDarkMageAttackUp;
	public static Animation goblinDarkMageAttackDown;
	public static Animation goblinDarkMageAttackLeft;
	public static Animation goblinDarkMageAttackRight;
	
	public static Texture spiderRed;
	public static Animation spiderRedWalkUp;
	public static Animation spiderRedWalkDown;
	public static Animation spiderRedWalkLeft;
	public static Animation spiderRedWalkRight;
	public static Animation spiderRedAttackUp;
	public static Animation spiderRedAttackDown;
	public static Animation spiderRedAttackLeft;
	public static Animation spiderRedAttackRight;
	
	public static Texture fairy;
	public static Animation fairyWalkUp;
	public static Animation fairyWalkDown;
	public static Animation fairyWalkLeft;
	public static Animation fairyWalkRight;
	
	public static Texture crystalBlue;
	public static Animation crystalBlueSpin;
	
	public static Texture knight;
	public static Animation knightWalkUp;
	public static Animation knightWalkDown;
	public static Animation knightWalkLeft;
	public static Animation knightWalkRight;
	public static Animation knightAttackUp;
	public static Animation knightAttackDown;
	public static Animation knightAttackLeft;
	public static Animation knightAttackRight;
	
	public static Texture bat;
	public static Animation batWalkUp;
	public static Animation batWalkDown;
	public static Animation batWalkLeft;
	public static Animation batWalkRight;
	
	public static Texture golem;
	public static Animation golemWalkUp;
	public static Animation golemWalkDown;
	public static Animation golemWalkLeft;
	public static Animation golemWalkRight;
	public static Animation golemAttackUp;
	public static Animation golemAttackDown;
	public static Animation golemAttackLeft;
	public static Animation golemAttackRight;
	public static Animation golemDeath;
	
	public static Texture mage;
	public static Animation mageIdleUp;
	public static Animation mageIdleDown;
	public static Animation mageIdleLeft;
	public static Animation mageIdleRight;
	public static Animation mageWalkUp;
	public static Animation mageWalkDown;
	public static Animation mageWalkLeft;
	public static Animation mageWalkRight;
	
	public static Texture brainmonster;
	public static Animation brainmonsterWalkUp;
	public static Animation brainmonsterWalkDown;
	public static Animation brainmonsterWalkLeft;
	public static Animation brainmonsterWalkRight;
	
	public static Texture elfHealer;
	public static Animation elfHealerWalkUp;
	public static Animation elfHealerWalkDown;
	public static Animation elfHealerWalkLeft;
	public static Animation elfHealerWalkRight;
	public static Animation elfHealerSpellUp;
	public static Animation elfHealerSpellDown;
	public static Animation elfHealerSpellLeft;
	public static Animation elfHealerSpellRight;
	
	public static Texture viking;
	public static Animation vikingWalkUp;
	public static Animation vikingWalkDown;
	public static Animation vikingWalkLeft;
	public static Animation vikingWalkRight;
	
	public static Texture imp;
	public static Animation impWalkUp;
	public static Animation impWalkDown;
	public static Animation impWalkLeft;
	public static Animation impWalkRight;
	public static Animation impAttackUp;
	public static Animation impAttackDown;
	public static Animation impAttackLeft;
	public static Animation impAttackRight;
	
	public static TextureRegion hpbar;
	
	public static Texture hp;
	public static TextureRegion mainhp;
	
	public static Texture bloodSheet;
	public static Animation blood;
	
	public static Texture projectiles;
	public static TextureRegion fireball;
	public static TextureRegion bullet;
	public static TextureRegion arrow;
	public static TextureRegion katana;
	public static TextureRegion ninjastar;
	public static TextureRegion kunai;
	public static TextureRegion arcaneOrb;
	public static TextureRegion heatOrb;
	public static TextureRegion gasOrb;
	
	public static Texture explosionSheet;
	public static Animation explosion;
	
	public static Texture turtleshellSheet;
	public static Animation turtleshell;
	
	public static Texture checkbox;
	public static TextureRegion unchecked;
	public static TextureRegion checked;
	
	public static Texture ui;
	public static TextureRegion cardinfo;
	
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
		backgroundMastery = loadTexture("gfx/backgroundMastery.jpg");

		//Buttons
		buttons = loadTexture("gfx/buttons.png");
		play = new TextureRegion(buttons, 0, 0, 200, 53);
		playHover = new TextureRegion(buttons, 200, 0, 200, 53);
		playClick = new TextureRegion(buttons, 400, 0, 200, 53);

		//Tiles
		tiles = loadTexture("gfx/tiles.png");
		blank = new TextureRegion(tiles, 0*32, 15*32, 32, 32);
		grass = new TextureRegion(tiles, 0*32, 0*32, 32, 32);
		flower = new TextureRegion(tiles, 1*32, 0*32, 32, 32);
		dirtCorner = new TextureRegion(tiles, 2*32, 0*32, 32, 32);
		dirtHorizontal = new TextureRegion(tiles, 3*32, 0*32, 32, 32);
		dirtVertical = new TextureRegion(tiles, 4*32, 0*32, 32, 32);
		
		hoverTile = new TextureRegion(tiles, 15*32, 15*32, 32, 32);
		gemBlue   = new TextureRegion(tiles, 10*32, 0*32, 32, 32);
		gemGreen  = new TextureRegion(tiles, 11*32, 0*32, 32, 32);
		gemGray   = new TextureRegion(tiles, 12*32, 0*32, 32, 32);
		gemPurple = new TextureRegion(tiles, 13*32, 0*32, 32, 32);
		gemRed    = new TextureRegion(tiles, 14*32, 0*32, 32, 32);
		gemOrange = new TextureRegion(tiles, 15*32, 0*32, 32, 32);
		
		bridgeStoneHorizontal = new TextureRegion(tiles, 5*32, 0*32, 32, 32);
		bridgeStoneCornerBottomRight = new TextureRegion(tiles, 6*32, 0*32, 32, 32);
		bridgeStoneVertical = new TextureRegion(tiles, 7*32, 0*32, 32, 32);
		bridgeStoneCornerTopLeft = new TextureRegion(tiles, 8*32, 0*32, 32, 32);
		
		bridgeStone2Horizontal = new TextureRegion(tiles, 5*32, 1*32, 32, 32);
		bridgeStone2CornerBottomRight = new TextureRegion(tiles, 6*32, 1*32, 32, 32);
		bridgeStone2Vertical = new TextureRegion(tiles, 7*32, 1*32, 32, 32);
		bridgeStone2CornerTopLeft = new TextureRegion(tiles, 8*32, 1*32, 32, 32);
		
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
		waterTopLeftCorner = new Animation(0.5f, 
				new TextureRegion(tiles, 12*32, 4*32, 32, 32), 
				new TextureRegion(tiles, 14*32, 4*32, 32, 32));
		waterTopRightCorner = new Animation(0.5f, 
				new TextureRegion(tiles, 13*32, 4*32, 32, 32), 
				new TextureRegion(tiles, 15*32, 4*32, 32, 32));
		waterBottomLeftCorner = new Animation(0.5f, 
				new TextureRegion(tiles, 12*32, 5*32, 32, 32), 
				new TextureRegion(tiles, 14*32, 5*32, 32, 32));
		waterBottomRightCorner = new Animation(0.5f, 
				new TextureRegion(tiles, 13*32, 5*32, 32, 32), 
				new TextureRegion(tiles, 15*32, 5*32, 32, 32));
		
		snow = new TextureRegion(tiles, 0*32, 4*32, 32, 32);
		sand = new TextureRegion(tiles, 0*32, 1*32, 32, 32);
		sand2 = new TextureRegion(tiles, 0*32, 5*32, 32, 32);
		deadTree = new TextureRegion(tiles, 1*32, 1*32, 32, 32);
		pathCorner = new TextureRegion(tiles, 2*32, 1*32, 32, 32);
		pathHorizontal = new TextureRegion(tiles, 3*32, 1*32, 32, 32);
		pathVertical = new TextureRegion(tiles, 4*32, 1*32, 32, 32);
		roadCorner = new TextureRegion(tiles, 2*32, 2*32, 32, 32);
		roadHorizontal = new TextureRegion(tiles, 3*32, 2*32, 32, 32);
		roadVertical = new TextureRegion(tiles, 4*32, 2*32, 32, 32);
		grass16 = new TextureRegion(tiles, 0*32, 5*32, 32, 32);
		flower16 = new TextureRegion(tiles, 1*32, 5*32, 32, 32);
		path16Corner = new TextureRegion(tiles, 2*32, 3*32, 32, 32);
		path16Horizontal = new TextureRegion(tiles, 3*32, 3*32, 32, 32);
		path16Vertical = new TextureRegion(tiles, 4*32, 3*32, 32, 32);
		
		//Towers
		towers = loadTexture("gfx/towers.png");
		dummy = loadTexture("gfx/dummy.png");
		mainTower = new TextureRegion(towers, 0*32, 1*32, 32, 64);
		wtfisthis = new TextureRegion(towers, 0*32, 0*32, 32, 32);
		budhaGold = new TextureRegion(towers, 2*32, 0*32, 32, 32);
		lazorRed = new TextureRegion(towers, 1*32, 1*32, 32, 64);
		dummySpin = new Animation(0.3f, 
				new TextureRegion(dummy, 0*64, 0*64, 64, 64), 
				new TextureRegion(dummy, 1*64, 0*64, 64, 64), 
				new TextureRegion(dummy, 2*64, 0*64, 64, 64), 
				new TextureRegion(dummy, 3*64, 0*64, 64, 64), 
				new TextureRegion(dummy, 4*64, 0*64, 64, 64), 
				new TextureRegion(dummy, 5*64, 0*64, 64, 64), 
				new TextureRegion(dummy, 6*64, 0*64, 64, 64), 
				new TextureRegion(dummy, 7*64, 0*64, 64, 64));
		dummyDeath = new Animation(0.3f, 
				new TextureRegion(dummy, 0*64, 1*64, 64, 64), 
				new TextureRegion(dummy, 1*64, 1*64, 64, 64), 
				new TextureRegion(dummy, 2*64, 1*64, 64, 64), 
				new TextureRegion(dummy, 3*64, 1*64, 64, 64), 
				new TextureRegion(dummy, 4*64, 1*64, 64, 64), 
				new TextureRegion(dummy, 5*64, 1*64, 64, 64));

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
		goblinDarkMage = loadTexture("gfx/goblinDarkMage.png");
		goblinDarkMageWalkUp = new Animation(0.5f, 
				new TextureRegion(goblinDarkMage, 0*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 8*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 8*64, 8*64, 64, 64));
		goblinDarkMageWalkLeft = new Animation(0.5f, 
				new TextureRegion(goblinDarkMage, 0*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 9*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 8*64, 9*64, 64, 64));
		goblinDarkMageWalkDown = new Animation(0.5f, 
				new TextureRegion(goblinDarkMage, 0*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 10*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 8*64, 10*64, 64, 64));
		goblinDarkMageWalkRight = new Animation(0.3f, 
				new TextureRegion(goblinDarkMage, 0*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 11*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 8*64, 11*64, 64, 64));
		goblinDarkMageAttackUp = new Animation(0.2f, 
				new TextureRegion(goblinDarkMage, 0*64, 4*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 4*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 4*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 4*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 4*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 4*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 4*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 4*64, 64, 64));
		goblinDarkMageAttackLeft = new Animation(0.2f, 
				new TextureRegion(goblinDarkMage, 0*64, 5*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 5*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 5*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 5*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 5*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 5*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 5*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 5*64, 64, 64));
		goblinDarkMageAttackDown = new Animation(0.2f, 
				new TextureRegion(goblinDarkMage, 0*64, 6*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 6*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 6*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 6*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 6*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 6*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 6*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 6*64, 64, 64));
		goblinDarkMageAttackRight = new Animation(0.2f, 
				new TextureRegion(goblinDarkMage, 0*64, 7*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 1*64, 7*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 2*64, 7*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 3*64, 7*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 4*64, 7*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 5*64, 7*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 6*64, 7*64, 64, 64), 
				new TextureRegion(goblinDarkMage, 7*64, 7*64, 64, 64));
		spiderRed = loadTexture("gfx/spiderRed.png");
		spiderRedWalkUp = new Animation(0.1f, 
				new TextureRegion(spiderRed, 4*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 5*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 6*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 7*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 8*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 9*64, 0*64, 64, 64));
		spiderRedWalkLeft = new Animation(0.1f, 
				new TextureRegion(spiderRed, 4*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 5*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 6*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 7*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 8*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 9*64, 1*64, 64, 64));
		spiderRedWalkDown = new Animation(0.1f, 
				new TextureRegion(spiderRed, 4*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 5*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 6*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 7*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 8*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 9*64, 2*64, 64, 64));
		spiderRedWalkRight = new Animation(0.1f, 
				new TextureRegion(spiderRed, 4*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 5*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 6*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 7*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 8*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 9*64, 3*64, 64, 64));
		spiderRedAttackUp = new Animation(0.1f, 
				new TextureRegion(spiderRed, 0*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 1*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 2*64, 0*64, 64, 64), 
				new TextureRegion(spiderRed, 3*64, 0*64, 64, 64));
		spiderRedAttackLeft = new Animation(0.1f, 
				new TextureRegion(spiderRed, 0*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 1*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 2*64, 1*64, 64, 64), 
				new TextureRegion(spiderRed, 3*64, 1*64, 64, 64));
		spiderRedAttackDown = new Animation(0.1f, 
				new TextureRegion(spiderRed, 0*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 1*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 2*64, 2*64, 64, 64), 
				new TextureRegion(spiderRed, 3*64, 2*64, 64, 64));
		spiderRedAttackRight = new Animation(0.1f, 
				new TextureRegion(spiderRed, 0*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 1*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 2*64, 3*64, 64, 64), 
				new TextureRegion(spiderRed, 3*64, 3*64, 64, 64));
		crystalBlue = loadTexture("gfx/crystalBlue.png");
		crystalBlueSpin = new Animation(0.1f, 
				new TextureRegion(crystalBlue, 0*32, 0*32, 32, 32), 
				new TextureRegion(crystalBlue, 1*32, 0*32, 32, 32), 
				new TextureRegion(crystalBlue, 2*32, 0*32, 32, 32), 
				new TextureRegion(crystalBlue, 3*32, 0*32, 32, 32), 
				new TextureRegion(crystalBlue, 4*32, 0*32, 32, 32), 
				new TextureRegion(crystalBlue, 5*32, 0*32, 32, 32), 
				new TextureRegion(crystalBlue, 6*32, 0*32, 32, 32), 
				new TextureRegion(crystalBlue, 7*32, 0*32, 32, 32));
		knight = loadTexture("gfx/knight.png");
		knightWalkUp = new Animation(0.5f, 
				new TextureRegion(knight, 0*64, 8*64, 64, 64), 
				new TextureRegion(knight, 1*64, 8*64, 64, 64), 
				new TextureRegion(knight, 2*64, 8*64, 64, 64), 
				new TextureRegion(knight, 3*64, 8*64, 64, 64), 
				new TextureRegion(knight, 4*64, 8*64, 64, 64), 
				new TextureRegion(knight, 5*64, 8*64, 64, 64), 
				new TextureRegion(knight, 6*64, 8*64, 64, 64), 
				new TextureRegion(knight, 7*64, 8*64, 64, 64), 
				new TextureRegion(knight, 8*64, 8*64, 64, 64));
		knightWalkLeft = new Animation(0.5f, 
				new TextureRegion(knight, 0*64, 9*64, 64, 64), 
				new TextureRegion(knight, 1*64, 9*64, 64, 64), 
				new TextureRegion(knight, 2*64, 9*64, 64, 64), 
				new TextureRegion(knight, 3*64, 9*64, 64, 64), 
				new TextureRegion(knight, 4*64, 9*64, 64, 64), 
				new TextureRegion(knight, 5*64, 9*64, 64, 64), 
				new TextureRegion(knight, 6*64, 9*64, 64, 64), 
				new TextureRegion(knight, 7*64, 9*64, 64, 64), 
				new TextureRegion(knight, 8*64, 9*64, 64, 64));
		knightWalkDown = new Animation(0.5f, 
				new TextureRegion(knight, 0*64, 10*64, 64, 64), 
				new TextureRegion(knight, 1*64, 10*64, 64, 64), 
				new TextureRegion(knight, 2*64, 10*64, 64, 64), 
				new TextureRegion(knight, 3*64, 10*64, 64, 64), 
				new TextureRegion(knight, 4*64, 10*64, 64, 64), 
				new TextureRegion(knight, 5*64, 10*64, 64, 64), 
				new TextureRegion(knight, 6*64, 10*64, 64, 64), 
				new TextureRegion(knight, 7*64, 10*64, 64, 64), 
				new TextureRegion(knight, 8*64, 10*64, 64, 64));
		knightWalkRight = new Animation(0.3f, 
				new TextureRegion(knight, 0*64, 11*64, 64, 64), 
				new TextureRegion(knight, 1*64, 11*64, 64, 64), 
				new TextureRegion(knight, 2*64, 11*64, 64, 64), 
				new TextureRegion(knight, 3*64, 11*64, 64, 64), 
				new TextureRegion(knight, 4*64, 11*64, 64, 64), 
				new TextureRegion(knight, 5*64, 11*64, 64, 64), 
				new TextureRegion(knight, 6*64, 11*64, 64, 64), 
				new TextureRegion(knight, 7*64, 11*64, 64, 64), 
				new TextureRegion(knight, 8*64, 11*64, 64, 64));
		knightAttackUp = new Animation(0.2f, 
				new TextureRegion(knight, 0*64, 12*64, 64, 64), 
				new TextureRegion(knight, 1*64, 12*64, 64, 64), 
				new TextureRegion(knight, 2*64, 12*64, 64, 64), 
				new TextureRegion(knight, 3*64, 12*64, 64, 64), 
				new TextureRegion(knight, 4*64, 12*64, 64, 64), 
				new TextureRegion(knight, 5*64, 12*64, 64, 64));
		knightAttackLeft = new Animation(0.2f, 
				new TextureRegion(knight, 0*64, 13*64, 64, 64), 
				new TextureRegion(knight, 1*64, 13*64, 64, 64), 
				new TextureRegion(knight, 2*64, 13*64, 64, 64), 
				new TextureRegion(knight, 3*64, 13*64, 64, 64), 
				new TextureRegion(knight, 4*64, 13*64, 64, 64), 
				new TextureRegion(knight, 5*64, 13*64, 64, 64));
		knightAttackDown = new Animation(0.2f, 
				new TextureRegion(knight, 0*64, 14*64, 64, 64), 
				new TextureRegion(knight, 1*64, 14*64, 64, 64), 
				new TextureRegion(knight, 2*64, 14*64, 64, 64), 
				new TextureRegion(knight, 3*64, 14*64, 64, 64), 
				new TextureRegion(knight, 4*64, 14*64, 64, 64), 
				new TextureRegion(knight, 5*64, 14*64, 64, 64));
		knightAttackRight = new Animation(0.2f, 
				new TextureRegion(knight, 0*64, 15*64, 64, 64), 
				new TextureRegion(knight, 1*64, 15*64, 64, 64), 
				new TextureRegion(knight, 2*64, 15*64, 64, 64), 
				new TextureRegion(knight, 3*64, 15*64, 64, 64), 
				new TextureRegion(knight, 4*64, 15*64, 64, 64), 
				new TextureRegion(knight, 5*64, 15*64, 64, 64));
		bat = loadTexture("gfx/bat.png");
		batWalkDown = new Animation(0.1f, 
				new TextureRegion(bat, 1*32, 0*32, 32, 32), 
				new TextureRegion(bat, 2*32, 0*32, 32, 32), 
				new TextureRegion(bat, 3*32, 0*32, 32, 32), 
				new TextureRegion(bat, 2*32, 0*32, 32, 32));
		batWalkRight = new Animation(0.1f, 
				new TextureRegion(bat, 1*32, 1*32, 32, 32), 
				new TextureRegion(bat, 2*32, 1*32, 32, 32), 
				new TextureRegion(bat, 3*32, 1*32, 32, 32), 
				new TextureRegion(bat, 2*32, 1*32, 32, 32));
		batWalkUp = new Animation(0.1f, 
				new TextureRegion(bat, 1*32, 2*32, 32, 32), 
				new TextureRegion(bat, 2*32, 2*32, 32, 32), 
				new TextureRegion(bat, 3*32, 2*32, 32, 32), 
				new TextureRegion(bat, 2*32, 2*32, 32, 32));
		batWalkLeft = new Animation(0.1f, 
				new TextureRegion(bat, 1*32, 3*32, 32, 32), 
				new TextureRegion(bat, 2*32, 3*32, 32, 32), 
				new TextureRegion(bat, 3*32, 3*32, 32, 32), 
				new TextureRegion(bat, 2*32, 3*32, 32, 32));
		golem = loadTexture("gfx/golem.png");
		golemWalkUp = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 0*64, 64, 64), 
				new TextureRegion(golem, 1*64, 0*64, 64, 64), 
				new TextureRegion(golem, 2*64, 0*64, 64, 64), 
				new TextureRegion(golem, 3*64, 0*64, 64, 64), 
				new TextureRegion(golem, 4*64, 0*64, 64, 64), 
				new TextureRegion(golem, 5*64, 0*64, 64, 64), 
				new TextureRegion(golem, 6*64, 0*64, 64, 64));
		golemWalkLeft = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 1*64, 64, 64), 
				new TextureRegion(golem, 1*64, 1*64, 64, 64), 
				new TextureRegion(golem, 2*64, 1*64, 64, 64), 
				new TextureRegion(golem, 3*64, 1*64, 64, 64), 
				new TextureRegion(golem, 4*64, 1*64, 64, 64), 
				new TextureRegion(golem, 5*64, 1*64, 64, 64), 
				new TextureRegion(golem, 6*64, 1*64, 64, 64));
		golemWalkDown = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 2*64, 64, 64), 
				new TextureRegion(golem, 1*64, 2*64, 64, 64), 
				new TextureRegion(golem, 2*64, 2*64, 64, 64), 
				new TextureRegion(golem, 3*64, 2*64, 64, 64), 
				new TextureRegion(golem, 4*64, 2*64, 64, 64), 
				new TextureRegion(golem, 5*64, 2*64, 64, 64), 
				new TextureRegion(golem, 6*64, 2*64, 64, 64));
		golemWalkRight = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 3*64, 64, 64), 
				new TextureRegion(golem, 1*64, 3*64, 64, 64), 
				new TextureRegion(golem, 2*64, 3*64, 64, 64), 
				new TextureRegion(golem, 3*64, 3*64, 64, 64), 
				new TextureRegion(golem, 4*64, 3*64, 64, 64), 
				new TextureRegion(golem, 5*64, 3*64, 64, 64), 
				new TextureRegion(golem, 6*64, 3*64, 64, 64));
		golemAttackUp = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 4*64, 64, 64), 
				new TextureRegion(golem, 1*64, 4*64, 64, 64), 
				new TextureRegion(golem, 2*64, 4*64, 64, 64), 
				new TextureRegion(golem, 3*64, 4*64, 64, 64), 
				new TextureRegion(golem, 4*64, 4*64, 64, 64), 
				new TextureRegion(golem, 5*64, 4*64, 64, 64), 
				new TextureRegion(golem, 6*64, 4*64, 64, 64));
		golemAttackLeft = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 5*64, 64, 64), 
				new TextureRegion(golem, 1*64, 5*64, 64, 64), 
				new TextureRegion(golem, 2*64, 5*64, 64, 64), 
				new TextureRegion(golem, 3*64, 5*64, 64, 64), 
				new TextureRegion(golem, 4*64, 5*64, 64, 64), 
				new TextureRegion(golem, 5*64, 5*64, 64, 64), 
				new TextureRegion(golem, 6*64, 5*64, 64, 64));
		golemAttackDown = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 6*64, 64, 64), 
				new TextureRegion(golem, 1*64, 6*64, 64, 64), 
				new TextureRegion(golem, 2*64, 6*64, 64, 64), 
				new TextureRegion(golem, 3*64, 6*64, 64, 64), 
				new TextureRegion(golem, 4*64, 6*64, 64, 64), 
				new TextureRegion(golem, 5*64, 6*64, 64, 64), 
				new TextureRegion(golem, 6*64, 6*64, 64, 64));
		golemAttackRight = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 7*64, 64, 64), 
				new TextureRegion(golem, 1*64, 7*64, 64, 64), 
				new TextureRegion(golem, 2*64, 7*64, 64, 64), 
				new TextureRegion(golem, 3*64, 7*64, 64, 64), 
				new TextureRegion(golem, 4*64, 7*64, 64, 64), 
				new TextureRegion(golem, 5*64, 7*64, 64, 64), 
				new TextureRegion(golem, 6*64, 7*64, 64, 64));
		golemDeath = new Animation(0.3f, 
				new TextureRegion(golem, 0*64, 9*64, 64, 64), 
				new TextureRegion(golem, 1*64, 9*64, 64, 64), 
				new TextureRegion(golem, 2*64, 9*64, 64, 64), 
				new TextureRegion(golem, 3*64, 9*64, 64, 64), 
				new TextureRegion(golem, 4*64, 9*64, 64, 64), 
				new TextureRegion(golem, 5*64, 9*64, 64, 64));
		mage = loadTexture("gfx/mage.png");
		mageIdleUp = new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 0*32, 16, 32), 
				new TextureRegion(mage, 1*16, 0*32, 16, 32), 
				new TextureRegion(mage, 2*16, 0*32, 16, 32), 
				new TextureRegion(mage, 3*16, 0*32, 16, 32), 
				new TextureRegion(mage, 4*16, 0*32, 16, 32));
		mageIdleDown= new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 1*32, 16, 32), 
				new TextureRegion(mage, 1*16, 1*32, 16, 32), 
				new TextureRegion(mage, 2*16, 1*32, 16, 32), 
				new TextureRegion(mage, 3*16, 1*32, 16, 32), 
				new TextureRegion(mage, 4*16, 1*32, 16, 32));
		mageIdleLeft = new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 2*32, 16, 32), 
				new TextureRegion(mage, 1*16, 2*32, 16, 32), 
				new TextureRegion(mage, 2*16, 2*32, 16, 32), 
				new TextureRegion(mage, 3*16, 2*32, 16, 32), 
				new TextureRegion(mage, 4*16, 2*32, 16, 32));
		mageIdleRight = new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 3*32, 16, 32), 
				new TextureRegion(mage, 1*16, 3*32, 16, 32), 
				new TextureRegion(mage, 2*16, 3*32, 16, 32), 
				new TextureRegion(mage, 3*16, 3*32, 16, 32), 
				new TextureRegion(mage, 4*16, 3*32, 16, 32));
		mageWalkUp = new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 4*32, 16, 32), 
				new TextureRegion(mage, 1*16, 4*32, 16, 32), 
				new TextureRegion(mage, 2*16, 4*32, 16, 32), 
				new TextureRegion(mage, 3*16, 4*32, 16, 32), 
				new TextureRegion(mage, 4*16, 4*32, 16, 32), 
				new TextureRegion(mage, 5*16, 4*32, 16, 32), 
				new TextureRegion(mage, 6*16, 4*32, 16, 32), 
				new TextureRegion(mage, 7*16, 4*32, 16, 32), 
				new TextureRegion(mage, 8*16, 4*32, 16, 32), 
				new TextureRegion(mage, 9*16, 4*32, 16, 32));
		mageWalkDown = new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 5*32, 16, 32), 
				new TextureRegion(mage, 1*16, 5*32, 16, 32), 
				new TextureRegion(mage, 2*16, 5*32, 16, 32), 
				new TextureRegion(mage, 3*16, 5*32, 16, 32), 
				new TextureRegion(mage, 4*16, 5*32, 16, 32), 
				new TextureRegion(mage, 5*16, 5*32, 16, 32), 
				new TextureRegion(mage, 6*16, 5*32, 16, 32), 
				new TextureRegion(mage, 7*16, 5*32, 16, 32), 
				new TextureRegion(mage, 8*16, 5*32, 16, 32), 
				new TextureRegion(mage, 9*16, 5*32, 16, 32));
		mageWalkLeft = new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 6*32, 16, 32), 
				new TextureRegion(mage, 1*16, 6*32, 16, 32), 
				new TextureRegion(mage, 2*16, 6*32, 16, 32), 
				new TextureRegion(mage, 3*16, 6*32, 16, 32), 
				new TextureRegion(mage, 4*16, 6*32, 16, 32), 
				new TextureRegion(mage, 5*16, 6*32, 16, 32), 
				new TextureRegion(mage, 6*16, 6*32, 16, 32), 
				new TextureRegion(mage, 7*16, 6*32, 16, 32), 
				new TextureRegion(mage, 8*16, 6*32, 16, 32), 
				new TextureRegion(mage, 9*16, 6*32, 16, 32));
		mageWalkRight = new Animation(0.2f, 
				new TextureRegion(mage, 0*16, 7*32, 16, 32), 
				new TextureRegion(mage, 1*16, 7*32, 16, 32), 
				new TextureRegion(mage, 2*16, 7*32, 16, 32), 
				new TextureRegion(mage, 3*16, 7*32, 16, 32), 
				new TextureRegion(mage, 4*16, 7*32, 16, 32), 
				new TextureRegion(mage, 5*16, 7*32, 16, 32), 
				new TextureRegion(mage, 6*16, 7*32, 16, 32), 
				new TextureRegion(mage, 7*16, 7*32, 16, 32), 
				new TextureRegion(mage, 8*16, 7*32, 16, 32), 
				new TextureRegion(mage, 9*16, 7*32, 16, 32));
		brainmonster = loadTexture("gfx/brainmonster.png");
		brainmonsterWalkDown = new Animation(0.1f, 
				new TextureRegion(brainmonster, 0*32, 0*49, 32, 49), 
				new TextureRegion(brainmonster, 1*32, 0*49, 32, 49), 
				new TextureRegion(brainmonster, 2*32, 0*49, 32, 49));
		brainmonsterWalkUp = new Animation(0.1f, 
				new TextureRegion(brainmonster, 0*32, 1*49, 32, 49), 
				new TextureRegion(brainmonster, 1*32, 1*49, 32, 49), 
				new TextureRegion(brainmonster, 2*32, 1*49, 32, 49));
		brainmonsterWalkLeft = new Animation(0.1f, 
				new TextureRegion(brainmonster, 0*32, 2*49, 32, 49), 
				new TextureRegion(brainmonster, 1*32, 2*49, 32, 49), 
				new TextureRegion(brainmonster, 2*32, 2*49, 32, 49));
		brainmonsterWalkRight = new Animation(0.1f, 
				new TextureRegion(brainmonster, 0*32, 3*49, 32, 49), 
				new TextureRegion(brainmonster, 1*32, 3*49, 32, 49), 
				new TextureRegion(brainmonster, 2*32, 3*49, 32, 49));
		elfHealer = loadTexture("gfx/elfHealer.png");
		elfHealerWalkUp = new Animation(0.5f, 
				new TextureRegion(elfHealer, 0*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 7*64, 8*64, 64, 64), 
				new TextureRegion(elfHealer, 8*64, 8*64, 64, 64));
		elfHealerWalkLeft = new Animation(0.5f, 
				new TextureRegion(elfHealer, 0*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 7*64, 9*64, 64, 64), 
				new TextureRegion(elfHealer, 8*64, 9*64, 64, 64));
		elfHealerWalkDown = new Animation(0.5f, 
				new TextureRegion(elfHealer, 0*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 7*64, 10*64, 64, 64), 
				new TextureRegion(elfHealer, 8*64, 10*64, 64, 64));
		elfHealerWalkRight = new Animation(0.3f, 
				new TextureRegion(elfHealer, 0*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 7*64, 11*64, 64, 64), 
				new TextureRegion(elfHealer, 8*64, 11*64, 64, 64));
		elfHealerSpellUp = new Animation(0.2f, 
				new TextureRegion(elfHealer, 0*64, 0*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 0*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 0*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 0*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 0*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 0*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 0*64, 64, 64));
		elfHealerSpellLeft = new Animation(0.2f, 
				new TextureRegion(elfHealer, 0*64, 1*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 1*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 1*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 1*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 1*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 1*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 1*64, 64, 64));
		elfHealerSpellDown = new Animation(0.2f, 
				new TextureRegion(elfHealer, 0*64, 2*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 2*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 2*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 2*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 2*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 2*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 2*64, 64, 64));
		elfHealerSpellRight = new Animation(0.2f, 
				new TextureRegion(elfHealer, 0*64, 3*64, 64, 64), 
				new TextureRegion(elfHealer, 1*64, 3*64, 64, 64), 
				new TextureRegion(elfHealer, 2*64, 3*64, 64, 64), 
				new TextureRegion(elfHealer, 3*64, 3*64, 64, 64), 
				new TextureRegion(elfHealer, 4*64, 3*64, 64, 64), 
				new TextureRegion(elfHealer, 5*64, 3*64, 64, 64), 
				new TextureRegion(elfHealer, 6*64, 3*64, 64, 64));
		viking = loadTexture("gfx/viking.png");
		vikingWalkDown = new Animation(0.2f, 
				new TextureRegion(viking, 0*32, 0*64, 32, 64), 
				new TextureRegion(viking, 1*32, 0*64, 32, 64), 
				new TextureRegion(viking, 2*32, 0*64, 32, 64));
		vikingWalkLeft = new Animation(0.2f, 
				new TextureRegion(viking, 0*32, 1*64, 32, 64), 
				new TextureRegion(viking, 1*32, 1*64, 32, 64), 
				new TextureRegion(viking, 2*32, 1*64, 32, 64));
		vikingWalkRight = new Animation(0.2f, 
				new TextureRegion(viking, 0*32, 2*64, 32, 64), 
				new TextureRegion(viking, 1*32, 2*64, 32, 64), 
				new TextureRegion(viking, 2*32, 2*64, 32, 64));
		vikingWalkUp = new Animation(0.2f, 
				new TextureRegion(viking, 0*32, 3*64, 32, 64), 
				new TextureRegion(viking, 1*32, 3*64, 32, 64), 
				new TextureRegion(viking, 2*32, 3*64, 32, 64));
		imp = loadTexture("gfx/imp.png");
		impWalkDown = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 0*64, 64, 64), 
				new TextureRegion(imp, 1*64, 0*64, 64, 64), 
				new TextureRegion(imp, 2*64, 0*64, 64, 64), 
				new TextureRegion(imp, 3*64, 0*64, 64, 64));
		impWalkUp = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 1*64, 64, 64), 
				new TextureRegion(imp, 1*64, 1*64, 64, 64), 
				new TextureRegion(imp, 2*64, 1*64, 64, 64), 
				new TextureRegion(imp, 3*64, 1*64, 64, 64));
		impWalkRight = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 2*64, 64, 64), 
				new TextureRegion(imp, 1*64, 2*64, 64, 64), 
				new TextureRegion(imp, 2*64, 2*64, 64, 64), 
				new TextureRegion(imp, 3*64, 2*64, 64, 64));
		impWalkLeft = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 3*64, 64, 64), 
				new TextureRegion(imp, 1*64, 3*64, 64, 64), 
				new TextureRegion(imp, 2*64, 3*64, 64, 64), 
				new TextureRegion(imp, 3*64, 3*64, 64, 64));
		impAttackDown = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 4*64, 64, 64), 
				new TextureRegion(imp, 1*64, 4*64, 64, 64), 
				new TextureRegion(imp, 2*64, 4*64, 64, 64), 
				new TextureRegion(imp, 3*64, 4*64, 64, 64));
		impAttackUp = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 5*64, 64, 64), 
				new TextureRegion(imp, 1*64, 5*64, 64, 64), 
				new TextureRegion(imp, 2*64, 5*64, 64, 64), 
				new TextureRegion(imp, 3*64, 5*64, 64, 64));
		impAttackRight = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 6*64, 64, 64), 
				new TextureRegion(imp, 1*64, 6*64, 64, 64), 
				new TextureRegion(imp, 2*64, 6*64, 64, 64), 
				new TextureRegion(imp, 3*64, 6*64, 64, 64));
		impAttackLeft = new Animation(0.2f, 
				new TextureRegion(imp, 0*64, 7*64, 64, 64), 
				new TextureRegion(imp, 1*64, 7*64, 64, 64), 
				new TextureRegion(imp, 2*64, 7*64, 64, 64), 
				new TextureRegion(imp, 3*64, 7*64, 64, 64));
		
		//Book
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

		//Other
		hpbar = new TextureRegion(tiles, 0, 480, 32, 4);

		hp = loadTexture("gfx/mainhp.png");
		mainhp = new TextureRegion(hp, 0, 0, 60, 544);
		
		//Projectiles
		projectiles = loadTexture("gfx/projectiles.png");
		fireball = new TextureRegion(projectiles, 0*32, 0*32, 32, 32);
		bullet = new TextureRegion(projectiles, 1*32, 0*32, 32, 32);
		arrow = new TextureRegion(projectiles, 2*32, 0*32, 31, 5);
		katana = new TextureRegion(projectiles, 3*32, 0*32, 26, 5);
		ninjastar = new TextureRegion(projectiles, 4*32, 0*32, 6, 6);
		kunai = new TextureRegion(projectiles, 5*32, 0*32, 12, 6);
		arcaneOrb = new TextureRegion(projectiles, 6*32, 0*32, 32, 32);
		heatOrb = new TextureRegion(projectiles, 7*32, 0*32, 32, 32);
		gasOrb = new TextureRegion(projectiles, 0*32, 1*32, 32, 32);
		
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
		
		//Spells
		explosionSheet = loadTexture("gfx/explosion.png");
		explosion = new Animation(0.1f,
				new TextureRegion(explosionSheet, 0*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 1*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 2*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 3*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 4*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 5*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 6*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 7*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 8*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 9*89, 0*89, 89, 89),
				new TextureRegion(explosionSheet, 10*89, 0*89, 89, 89));
		turtleshellSheet = loadTexture("gfx/turtleshell.png");
		turtleshell = new Animation(0.1f,
				new TextureRegion(turtleshellSheet, 0*128, 0*128, 128, 128),
				new TextureRegion(turtleshellSheet, 1*128, 0*128, 128, 128),
				new TextureRegion(turtleshellSheet, 2*128, 0*128, 128, 128),
				new TextureRegion(turtleshellSheet, 3*128, 0*128, 128, 128),
				new TextureRegion(turtleshellSheet, 0*128, 1*128, 128, 128),
				new TextureRegion(turtleshellSheet, 1*128, 1*128, 128, 128),
				new TextureRegion(turtleshellSheet, 2*128, 1*128, 128, 128),
				new TextureRegion(turtleshellSheet, 3*128, 1*128, 128, 128),
				new TextureRegion(turtleshellSheet, 0*128, 2*128, 128, 128),
				new TextureRegion(turtleshellSheet, 1*128, 2*128, 128, 128),
				new TextureRegion(turtleshellSheet, 2*128, 2*128, 128, 128),
				new TextureRegion(turtleshellSheet, 3*128, 2*128, 128, 128),
				new TextureRegion(turtleshellSheet, 0*128, 3*128, 128, 128),
				new TextureRegion(turtleshellSheet, 1*128, 3*128, 128, 128),
				new TextureRegion(turtleshellSheet, 2*128, 3*128, 128, 128),
				new TextureRegion(turtleshellSheet, 3*128, 3*128, 128, 128));

		//Cards
		cards = loadTexture("gfx/cards.png");
		card = new TextureRegion(cards, 2*64, 0*64, 64, 64);
		cardTeemo = new TextureRegion(cards, 0*64, 0*64, 64, 64);
		cardGoblin = new TextureRegion(goblin, 0*64, 2*64, 64, 64);
		cardFairy = new TextureRegion(fairy, 1*32, 0*48, 32, 48);
		cardGoblinDarkMage = new TextureRegion(goblinDarkMage, 0*64, 2*64, 64, 64);
		cardDummy = new TextureRegion(dummy, 0*64, 0*64, 64, 64);
		cardSpiderRed = new TextureRegion(spiderRed, 0*64, 4*64, 64, 64);
		cardCrystalBlue = new TextureRegion(crystalBlue, 0*32, 0*32, 32, 32);
		cardKnight = new TextureRegion(knight, 0*64, 2*64, 64, 64);
		cardBat = new TextureRegion(bat, 3*32, 0*32, 32, 32);
		cardGolem = new TextureRegion(golem, 0*64, 0*64, 64, 64);
		cardExplosion = new TextureRegion(explosionSheet, 4*89, 0*89, 89, 89);
		cardMage = new TextureRegion(mage, 0*16, 1*32, 16, 32);
		cardBrainmonster = new TextureRegion(brainmonster, 0*32, 0*49, 32, 49);
		cardElfHealer = new TextureRegion(elfHealer, 0*64, 2*64, 64, 64);
		cardViking = new TextureRegion(viking, 1*32, 0*64, 32, 64);
		cardImp = new TextureRegion(imp, 0*64, 0*64, 64, 64);

		//Checkbox
		checkbox = loadTexture("gfx/checkbox.png");
		unchecked = new TextureRegion(checkbox, 0*26, 0*29, 26, 29);
		checked = new TextureRegion(checkbox, 1*26, 0*29, 26, 29);

		//UI
		ui = loadTexture("gfx/cardinfo.png");
		cardinfo = new TextureRegion(ui, 0, 0, 128, 90);

		//Sounds
		clickSound = Gdx.audio.newSound(Gdx.files.internal("sound/click.mp3"));
	}

	public static void playSound(Sound sound) {
		if (Settings.soundEnabled) sound.play(0.2f);
	}
	
	public static void dispose() {
		backgroundMainMenu.dispose();
		backgroundIngame.dispose();
		buttons.dispose();
		tiles.dispose();
		towers.dispose();
		dummy.dispose();
		cards.dispose();
		goblin.dispose();
		goblinDarkMage.dispose();
		spiderRed.dispose();
		fairy.dispose();
		crystalBlue.dispose();
		knight.dispose();
		golem.dispose();
		mage.dispose();
		brainmonster.dispose();
		elfHealer.dispose();
		bloodSheet.dispose();
		explosionSheet.dispose();
		turtleshellSheet.dispose();
		projectiles.dispose();
		checkbox.dispose();
		clickSound.dispose();
	}
}