package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture backgroundIngame;
	public static TextureRegion backgroundIngameRegion;

	public static Texture tiles;
	public static Texture skeleton;
	public static TextureRegion voidTile;
	public static TextureRegion grassTile;
	public static TextureRegion dirtTile;
	public static TextureRegion dirtCornerTile;
	public static TextureRegion currentFrame;
	public static TextureRegion[] walkFrames;
	public static Animation waterTile;
	public static Animation waterCornerTile;
	public static Animation bridgeTile;
	public static Animation skeleWalkUp;
	public static Animation skeleWalkDown;
	public static Animation skeleWalkRight;
	public static Animation skeleWalkLeft;
	public static Animation skeleAttackUp;
	public static Animation skeleAttackLeft;
	public static Animation skeleAttackDown;
	public static Animation skeleAttackRight;
	public static TextureRegion hoverTile;
	
	private static final int FRAME_COLS = 6;
	private static final int FRAME_ROWS = 4;

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
		backgroundIngame = loadTexture("gfx/background_ingame.png");
		backgroundIngameRegion = new TextureRegion(backgroundIngame, 0, 0, 1136, 640);

		//Tiles
		tiles = loadTexture("gfx/tiles.png");
		voidTile = new TextureRegion(tiles, 0*16, 0*16, 16, 16);
		grassTile = new TextureRegion(tiles, 1*16, 0*16, 16, 16);
		dirtTile = new TextureRegion(tiles, 2*16, 0*16, 16, 16);
		//bridgeTile = new TextureRegion(tiles, 3*16, 0*16, 16, 16);
		dirtCornerTile = new TextureRegion(tiles, 4*16, 0*16, 16, 16);
		waterTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*16, 4*16, 16, 16), 
				new TextureRegion(tiles, 1*16, 4*16, 16, 16), 
				new TextureRegion(tiles, 2*16, 4*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 4*16, 16, 16));
		waterCornerTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*16, 5*16, 16, 16), 
				new TextureRegion(tiles, 1*16, 5*16, 16, 16), 
				new TextureRegion(tiles, 2*16, 5*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 5*16, 16, 16));
		bridgeTile = new Animation(0.5f, 
				new TextureRegion(tiles, 0*16, 6*16, 16, 16), 
				new TextureRegion(tiles, 1*16, 6*16, 16, 16), 
				new TextureRegion(tiles, 2*16, 6*16, 16, 16), 
				new TextureRegion(tiles, 3*16, 6*16, 16, 16));
		hoverTile = new TextureRegion(tiles, 0*16, 15*16, 16, 16);
		
		skeleton = loadTexture("gfx/skeleton_sprites.png");
		skeleWalkUp = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 8*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 8*64, 64, 64));
		skeleWalkLeft = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 9*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 9*64, 64, 64));
		skeleWalkDown = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 10*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 10*64, 64, 64));
		skeleWalkRight = new Animation(0.5f,
				new TextureRegion(skeleton, 0*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 1*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 2*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 3*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 4*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 5*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 6*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 7*64, 11*64, 64, 64),
				new TextureRegion(skeleton, 8*64, 11*64, 64, 64));
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