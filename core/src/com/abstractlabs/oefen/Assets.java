package com.abstractlabs.oefen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture backgroundIngame;
	public static TextureRegion backgroundIngameRegion;

	public static Texture tiles;
	public static TextureRegion voidTile;
	public static TextureRegion grassTile;
	public static TextureRegion dirtTile;
	public static TextureRegion dirtCornerTile;
	public static Animation waterTile;
	public static Animation waterCornerTile;
	public static Animation bridgeTile;
	public static TextureRegion hoverTile;

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