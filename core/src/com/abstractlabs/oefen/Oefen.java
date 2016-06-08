package com.abstractlabs.oefen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Oefen extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Texture spritesheet;
	private Texture background;
	private Texture towersplacement;
	private BitmapFont font;
	private float stateTime;
	private TextureRegion[] watertexture;
	private Animation water;
	private TextureRegion currentWater;
	private TextureRegion[] waterctexture;
	private Animation waterc;
	private TextureRegion currentWaterc;
	
	private int[][] map = 
		   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,4,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,6,2,2,2,2,7,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,5,5,5,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,0,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,2,2,2,2,2,8,1,1,1,1,9,2,3,3,3,3,2,7,1,1,1,1,6,2,2,2,2,2,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,9,2,2,2,2,8,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,5,5,5,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
	    //camera.setToOrtho(false, 960+4, 480+104+54);
	    camera.setToOrtho(false, 1136, 640);

	    spritesheet = new Texture(Gdx.files.internal("sprite_sheet_16.png"));
	    background = new Texture(Gdx.files.internal("background.png"));
	    towersplacement = new Texture(Gdx.files.internal("towersplacement.png"));
	    
	    font = new BitmapFont();
	    
	    TextureRegion[][] tmp = TextureRegion.split(spritesheet, 256/16, 256/16);
	    watertexture = new TextureRegion[4];
        for (int i = 0; i < 4; i++) {
        	watertexture[i] = tmp[4][i];
        }
        
	    waterctexture = new TextureRegion[4];
        for (int i = 0; i < 4; i++) {
            waterctexture[i] = tmp[5][i];
        }

        water = new Animation(0.5f, watertexture);
        waterc = new Animation(0.5f, waterctexture);
        stateTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    batch.setProjectionMatrix(camera.combined);
	    
	    stateTime += Gdx.graphics.getDeltaTime();
	    currentWater = water.getKeyFrame(stateTime, true);
	    currentWaterc = waterc.getKeyFrame(stateTime, true);
	    
	    batch.begin();

	    batch.draw(background, 0, 0);
	    
	    //batch.draw(spritesheet, 0, 0, 32, 32, 16, 0, 16, 16, false, false);
	    
	    for(int i=0; i<map.length; i++) {
	    	for(int k=0; k<map[i].length; k++) {
	    		int xtile = 0, ytile = 0;
	    		boolean xflip = false, yflip = false;
	    		if(map[i][k] == 1) { xtile = 16; ytile = 0; } //grass
	    		if(map[i][k] == 2) { xtile = 32; ytile = 0; } //dirt
	    		if(map[i][k] == 3) { xtile = 48; ytile = 0; } //path
	    		if(map[i][k] == 5) { xtile = 0; ytile = 64; } //bridge
	    		if(map[i][k] == 6) { xtile = 64; ytile = 0; xflip = false; yflip = false; } //topleft path corner
	    		if(map[i][k] == 7) { xtile = 64; ytile = 0; xflip = true; yflip = false; } //topright path corner
	    		if(map[i][k] == 8) { xtile = 64; ytile = 0; xflip = true; yflip = true; } //bottomright path corner
	    		if(map[i][k] == 9) { xtile = 64; ytile = 0; xflip = false; yflip = true; } //bottomleft path corner
	    		if(map[i][k] == 0) { xtile = 0; ytile = 80; xflip = false; yflip = false; } //topleft water diagonal
	    		if(map[i][k] == 4) { xtile = 0; ytile = 80; xflip = true; yflip = true; } //bottomright water diagonal
	    		if(map[i][k] == 5) {
		    		batch.draw(currentWater, 24+k*32, (480+104)-(i*32)-32+2, 0, 0, 32, 32, 1, 1, 0);
	    		} else if(map[i][k] == 0) {
		    		batch.draw(currentWaterc, 24+k*32, (480+104)-(i*32)-32+2, 0, 0, 32, 32, 1, 1, 0);
	    		} else if(map[i][k] == 4) {
		    		batch.draw(currentWaterc, 24+k*32+32, (480+104)-(i*32)-32+32+2, 0, 0, 32, 32, 1, 1, 180);
	    		} else {
		    		batch.draw(spritesheet, 24+k*32, (480+104)-(i*32)-32+2, 32, 32, xtile, ytile, 16, 16, xflip, yflip);
	    		}
		    }
	    }
        //batch.draw(currentWater, 50, 50); 

	    //tower placement concept
	    if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
		    //batch.setColor(1, 1, 1, 0.2f);
		    //batch.draw(towersplacement, 2, 104);
		    
		    for(int i=0; i<map.length; i++) {
		    	for(int k=0; k<map[i].length; k++) {
		    		if(map[i][k] == 1 && k<17) { //k>17 for red team
		    		    batch.setColor(0, 1, 0, 0.2f);
		    			batch.draw(spritesheet, 24+k*32, (480+104)-(i*32)-32+2, 32, 32, 0, 240, 16, 16, false, false);
		    		    batch.setColor(1, 1, 1, 1f);
		    		} else {
		    		    batch.setColor(1, 0, 0, 0.2f);
		    			batch.draw(spritesheet, 24+k*32, (480+104)-(i*32)-32+2, 32, 32, 0, 240, 16, 16, false, false);
		    		    batch.setColor(1, 1, 1, 1f);
		    		}
		    	}
		    }
		    
		    //batch.setColor(1, 1, 1, 1f);
	    }

	    font.setColor(1, 1, 0, 1);
	    font.draw(batch, Gdx.graphics.getFramesPerSecond()+" FPS", 4, 15);
	    
	    batch.end();
	    
//	    Gdx.graphics.setTitle("Oefen ("+Gdx.graphics.getFramesPerSecond()+" FPS)");
	}
	
	@Override
    public void dispose() {
		batch.dispose();
        spritesheet.dispose();
        background.dispose();
        font.dispose();
    }
}