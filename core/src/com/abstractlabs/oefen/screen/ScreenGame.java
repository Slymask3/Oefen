package com.abstractlabs.oefen.screen;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class ScreenGame extends ScreenAdapter {
	Oefen game;
	OrthographicCamera guiCam;
	Vector3 touchPoint;
	float stateTime;

	int[][] map1 = 
		{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,3,1,1,1,1,4,0,0,7,7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,7,7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,7,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,8,7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,1,1,1,1,1,2,0,0,0,0,5,1,6,6,6,6,1,4,0,0,0,0,3,1,1,1,1,1,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,7,9,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,7,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,7,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,7,7,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,7,7,0,0,5,1,1,1,1,2,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

	int[][] map = 
		{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	     {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,3,1,1,1,1,1,4,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,11,0,0,1,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,1,1,1,1,1,2,0,0,0,0,0,5,1,6,6,6,10,1,4,0,0,0,0,0,3,1,1,1,1,1,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,1,0,0,12,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,5,1,1,1,1,1,2,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

//	int[][] map = 
//		{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,3,1,1,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0},
//         {0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0},
//         {0,0,0,1,0,0,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,0},
//         {0,0,0,1,0,0,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0},
//         {0,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,0,0,0,0,0,0,0,0},
//         {0,0,0,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0},
//         {0,0,0,5,1,1,2,0,1,1,1,1,0,0,1,0,0,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	public ScreenGame (Oefen game) {
		this.game = game;

		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
		guiCam.position.set(Oefen.WIDTH / 2, Oefen.HEIGHT / 2, 0);
		touchPoint = new Vector3();
	}

	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
		}
	}

	public void draw () {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stateTime += Gdx.graphics.getDeltaTime();
		
		guiCam.update();
		game.batch.setProjectionMatrix(guiCam.combined);

		game.batch.disableBlending();
		game.batch.begin();
		game.batch.draw(Assets.backgroundIngameRegion, 0, 0, Oefen.WIDTH, Oefen.HEIGHT);
		
		for(int i=0; i<map.length; i++) {
	    	for(int k=0; k<map[i].length; k++) {
	    		TextureRegion texture = null;
	    		boolean xflip = false, yflip = false;
	    		if(map[i][k] == 0) { texture = Assets.grassTile; xflip = false; yflip = false; } 
	    		else if(map[i][k] == 1) { texture = Assets.dirtTile; xflip = false; yflip = false; } 
	    		else if(map[i][k] == 2) { texture = Assets.dirtCornerTile; xflip = true; yflip = true; } 
	    		else if(map[i][k] == 3) { texture = Assets.dirtCornerTile; xflip = false; yflip = false; } 
	    		else if(map[i][k] == 4) { texture = Assets.dirtCornerTile; xflip = true; yflip = false; } 
	    		else if(map[i][k] == 5) { texture = Assets.dirtCornerTile; xflip = false; yflip = true; }
	    		else if(map[i][k] == 6) { texture = Assets.bridgeTile.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; } 
	    		else if(map[i][k] == 7) { texture = Assets.waterTile.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; } 
	    		else if(map[i][k] == 8) { texture = Assets.waterSideTile.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; } 
	    		else if(map[i][k] == 9) { texture = Assets.waterSideTile.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = true; yflip = true; } 
	    		else if(map[i][k] == 10) { texture = Assets.bridge2Tile.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; }
	    		else if(map[i][k] == 11) { texture = Assets.gemBlue; xflip = false; yflip = false; }
	    		else if(map[i][k] == 12) { texture = Assets.gemRed; xflip = false; yflip = false; }
//	    		else if(map[i][k] == 11) { 
//	    			Random rand = new Random();
//	    			int n = rand.nextInt(5);
//	    			if(n == 0) { texture = Assets.gemBlue; } 
//	    			else if(n == 1) { texture = Assets.gemGreen; }
//	    			else if(n == 2) { texture = Assets.gemGray; }
//	    			else if(n == 3) { texture = Assets.gemPurple; }
//	    			else if(n == 4) { texture = Assets.gemRed; }
//	    			else if(n == 5) { texture = Assets.gemOrange; }
//	    			xflip = false; yflip = false;
//	    		} 
	    		texture.flip(xflip, yflip);
	    		game.batch.draw(texture, 64+k*32, (480+184)-(i*32)-32+2, 32, 32);
//	    		game.batch.draw(texture, 24+k*48, (480+104)-(i*48)-48+2, 48, 48);
	    		texture.flip(xflip, yflip);
		    }
	    }
		
		game.batch.end();
	}

	@Override
	public void render (float delta) {
		draw();
		update();
	}

	@Override
	public void pause () {
		Settings.save();
	}
}