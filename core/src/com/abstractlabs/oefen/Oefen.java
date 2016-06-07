package com.abstractlabs.oefen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Oefen extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Texture spritesheet;
	private Texture ingamebottom;
	
	private int[][] map = 
		   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,4,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,6,2,2,2,2,7,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,1,1,1,2,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,1,1,1,2,1,1,5,5,5,4,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,1,1,1,2,1,1,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,2,1,1,1,1,2,1,0,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,2,2,2,2,8,1,1,1,1,9,2,3,3,3,3,2,7,1,1,1,1,6,2,2,2,2,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,2,1,1,1,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,9,2,2,2,2,8,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,0,5,5,5,4,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 960+4, 480+104+54);

	    spritesheet = new Texture(Gdx.files.internal("sprite_sheet_16.png")); 
	    ingamebottom = new Texture(Gdx.files.internal("background.png")); 
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    batch.setProjectionMatrix(camera.combined);
	    batch.begin();

	    batch.draw(ingamebottom, 0, 0);
	    
	    //batch.draw(spritesheet, 0, 0, 32, 32, 16, 0, 16, 16, false, false);
	    
	    for(int i=0; i<map.length; i++) {
	    	for(int k=0; k<map[i].length; k++) {
	    		int xtile = 0, ytile = 0;
	    		boolean xflip = false, yflip = false;
	    		if(map[i][k] == 1) { xtile = 16; ytile = 0; }
	    		if(map[i][k] == 2) { xtile = 32; ytile = 0; }
	    		if(map[i][k] == 3) { xtile = 48; ytile = 0; }
	    		if(map[i][k] == 5) { xtile = 0; ytile = 64; }
	    		if(map[i][k] == 6) { xtile = 64; ytile = 0; xflip = false; yflip = false; }
	    		if(map[i][k] == 7) { xtile = 64; ytile = 0; xflip = true; yflip = false; }
	    		if(map[i][k] == 8) { xtile = 64; ytile = 0; xflip = true; yflip = true; }
	    		if(map[i][k] == 9) { xtile = 64; ytile = 0; xflip = false; yflip = true; }
	    		if(map[i][k] == 0) { xtile = 0; ytile = 80; xflip = false; yflip = false; }
	    		if(map[i][k] == 4) { xtile = 0; ytile = 80; xflip = true; yflip = true; }
	    		batch.draw(spritesheet, 2+k*32, (480+104)-(i*32)-32, 32, 32, xtile, ytile, 16, 16, xflip, yflip);
		    }
	    }
	    
	    batch.end();
	}
	
	@Override
    public void dispose() {
		batch.dispose();
        spritesheet.dispose();
        ingamebottom.dispose();
    }
}