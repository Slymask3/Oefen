package com.abstractlabs.oefen.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.Goblin;
import com.abstractlabs.oefen.entity.Skeleton;
import com.abstractlabs.oefen.entity.Wtfisthis;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScreenGame extends ScreenAdapter {
	Oefen game;
	OrthographicCamera guiCam;
	float stateTime;
	Stage stage;
	Viewport vp;
	Random rand;
	List<Attacker> attackers = new ArrayList<Attacker>();
	Button goblinButton;
	Button skeleButton;
	ButtonStyle skeleButtonStyle;
	ButtonStyle goblinButtonStyle;
	Button goblinButton2;
	Button skeleButton2;

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
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,1,0,0,11,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,5,1,1,1,1,1,2,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,7,7,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	public ScreenGame (Oefen game) {
		this.game = game;

		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
		guiCam.position.set(Oefen.WIDTH / 2, Oefen.HEIGHT / 2, 0);
		
		vp = new FitViewport(Oefen.WIDTH, Oefen.HEIGHT);
		stage = new Stage(vp);
        Gdx.input.setInputProcessor(stage);
        
//        Goblin attackerBlue = new Goblin(map, "Blue", 64+3*32, 122+8*32+10);
//        attackerBlue.setTouchable(Touchable.enabled);
//        stage.addActor(attackerBlue);
//        attackers.add(attackerBlue);
//        
//        Goblin attackerRed = new Goblin(map, "Red", 64+32*32, 122+8*32+10);
//        attackerRed.setTouchable(Touchable.enabled);
//        stage.addActor(attackerRed);
//        attackers.add(attackerRed);
        
        Wtfisthis tower = new Wtfisthis(map, "Blue", 64+11*32, 122+10*32+10);
        stage.addActor(tower);
        
        goblinButtonStyle = new ButtonStyle();
        goblinButtonStyle.up = new TextureRegionDrawable(Assets.teemoCard);
        goblinButton = new Button(goblinButtonStyle);
        goblinButton.setPosition(50, 50);
        goblinButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
				Assets.playSound(Assets.clickSound);
				Goblin attacker = new Goblin(map, "Blue", 64+3*32, 122+8*32+10);
		        //attacker.setTouchable(Touchable.enabled);
				attacker.setWalking(true);
		        stage.addActor(attacker);
		        attackers.add(attacker);
            }
        } );
        stage.addActor(goblinButton);
        
        goblinButton2 = new Button(goblinButtonStyle);
        goblinButton2.setPosition(1180, 50);
        goblinButton2.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
				Assets.playSound(Assets.clickSound);
				Goblin attacker = new Goblin(map, "Red", 64+32*32, 122+8*32+10);
		        //attacker.setTouchable(Touchable.enabled);
				attacker.setWalking(true);
		        stage.addActor(attacker);
		        attackers.add(attacker);
            }
        } );
        stage.addActor(goblinButton2);
        
        skeleButtonStyle = new ButtonStyle();
        skeleButtonStyle.up = new TextureRegionDrawable(Assets.skeleCard);
        skeleButton = new Button(skeleButtonStyle);
        skeleButton.setPosition(120, 50);
        skeleButton.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
				Assets.playSound(Assets.clickSound);
				Skeleton attacker = new Skeleton(map, "Blue", 64+3*32, 122+8*32+10);
		        //attacker.setTouchable(Touchable.enabled);
				attacker.setWalking(true);
		        stage.addActor(attacker);
		        attackers.add(attacker);
            }
        } );
        stage.addActor(skeleButton);
        
        skeleButton2 = new Button(skeleButtonStyle);
        skeleButton2.setPosition(1180, 50);
        skeleButton2.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
				Assets.playSound(Assets.clickSound);
				Skeleton attacker = new Skeleton(map, "Red", 64+32*32, 122+8*32+10);
		        //attacker.setTouchable(Touchable.enabled);
				attacker.setWalking(true);
		        stage.addActor(attacker);
		        attackers.add(attacker);
            }
        } );
        stage.addActor(skeleButton2);
        
        rand = new Random();
        for(int i=0; i<map.length; i++) {
	    	for(int k=0; k<map[i].length; k++) {
	    		if(map[i][k] == 0) {
	    			int temp = rand.nextInt(30);
	    			if(temp == 0) {
	    				map[i][k] = 20;
	    			}
	    		} else if(map[i][k] == 11) {
	    			int temp = rand.nextInt(6);
	    			if(temp == 0) {
	    				map[i][k] = 11;
	    			} else if(temp == 1) {
	    				map[i][k] = 12;
	    			} else if(temp == 2) {
	    				map[i][k] = 13;
	    			} else if(temp == 3) {
	    				map[i][k] = 14;
	    			} else if(temp == 4) {
	    				map[i][k] = 15;
	    			} else if(temp == 5) {
	    				map[i][k] = 16;
	    			}
	    		}
	    	}
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
	    		else if(map[i][k] == 12) { texture = Assets.gemGreen; xflip = false; yflip = false; }
	    		else if(map[i][k] == 13) { texture = Assets.gemGray; xflip = false; yflip = false; }
	    		else if(map[i][k] == 14) { texture = Assets.gemPurple; xflip = false; yflip = false; }
	    		else if(map[i][k] == 15) { texture = Assets.gemRed; xflip = false; yflip = false; }
	    		else if(map[i][k] == 16) { texture = Assets.gemOrange; xflip = false; yflip = false; }
	    		else if(map[i][k] == 20) { texture = Assets.grassFlowerTile; xflip = false; yflip = false; }
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
		
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	}
	
	public void update() {
		for (int i = attackers.size() - 1; i >= 0; i--) {
		    Attacker attacker = attackers.get(i);
		    for (int j = attackers.size() - 1; j >= 0; j--) {
		    	Attacker defender = attackers.get(j);
		        if(attacker != null && defender != null && attacker.getTeam() != defender.getTeam() && attacker.getRangeRectangle().overlaps(defender.getHitboxRectangle())) {
		            //handle collision
		        	attacker.setTarget(defender);
		        	//defender.setTarget(attacker);
		        	attacker.setWalking(false);
		        	attacker.setAttacking(true);
		        	//defender.setWalking(false);
		        	//defender.setAttacking(true);
		        	
		        	if(attacker.isDead()) {
		        		attackers.remove(i);
		        		attacker.remove();
		        		attacker = null;
		        	}
		        	
		        	if(defender.isDead()) {
		        		attackers.remove(j);
		        		defender.remove();
		        		defender = null;
		        	}
		        }
		    }
		}
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