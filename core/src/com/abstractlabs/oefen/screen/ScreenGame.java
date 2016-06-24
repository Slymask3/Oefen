package com.abstractlabs.oefen.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Deck;
import com.abstractlabs.oefen.ImprovedButton.ImprovedButtonStyle;
import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.Tile;
import com.abstractlabs.oefen.card.Card;
import com.abstractlabs.oefen.card.CardAttacker;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.entity.other.Blood;
import com.abstractlabs.oefen.entity.tower.TowerMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
	List<Tower> towers = new ArrayList<Tower>();
	ImprovedButtonStyle goblinButtonStyle;
	CardAttacker goblinButton;
	CardAttacker goblinButton2;
	Map map = Map.generateRandomMap();
//	Map map = Map.generateMap1();
	
	Deck deck;
	
	public ScreenGame (Oefen game) {
		this.game = game;

		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
		guiCam.position.set(Oefen.WIDTH / 2, Oefen.HEIGHT / 2, 0);
		
		vp = new FitViewport(Oefen.WIDTH, Oefen.HEIGHT);
		stage = new Stage(vp);
        Gdx.input.setInputProcessor(stage);

        rand = new Random();
        
//        Goblin attackerBlue = new Goblin(map, "Blue", 64+3*32, 122+8*32+10);
//        attackerBlue.setTouchable(Touchable.enabled);
//        stage.addActor(attackerBlue);
//        attackers.add(attackerBlue);
//        
//        Goblin attackerRed = new Goblin(map, "Red", 64+32*32, 122+8*32+10);
//        attackerRed.setTouchable(Touchable.enabled);
//        stage.addActor(attackerRed);
//        attackers.add(attackerRed);
        
//        Wtfisthis tower = new Wtfisthis(map, "Blue", 64+11*32, 122+10*32+10);
//        stage.addActor(tower);

        Tower towerBlue = new TowerMain(map, "Blue", 64+2*32, 122+13+(map.getBlueStart())*32);
        stage.addActor(towerBlue);
        towers.add(towerBlue);
        
        Tower towerRed = new TowerMain(map, "Red", 64+33*32, 122+13+(map.getRedStart())*32);
        stage.addActor(towerRed);
        towers.add(towerRed);
        
        List<Card> cards = new ArrayList<Card>();

        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 20, map, "Blue", Attacker.GOBLIN)); //1
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //2
        cards.add(new CardAttacker(Assets.cardFairy, Assets.clickSound, 30, map, "Blue", Attacker.FAIRY)); //3
        cards.add(new CardAttacker(Assets.cardFairy, Assets.clickSound, 30, map, "Red", Attacker.FAIRY)); //4
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //5
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //6
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //7
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //8
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //9
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //10
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //11
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //12
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //13
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //14
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //15
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 20, map, "Blue", Attacker.GOBLIN)); //16
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //17
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //18
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //19
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 5000, map, "Red", Attacker.GOBLIN)); //20
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //21
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //22
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //23
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //24
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //25
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //26
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //27
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //28
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //29
        cards.add(new CardAttacker(Assets.cardGoblin, Assets.clickSound, 500, map, "Red", Attacker.GOBLIN)); //30
        
        deck = new Deck(cards);
        
        for(int i=0; i<deck.getCards().size(); i++) {
        	final Card card = deck.getCards().get(i);
			System.out.println("card "+i+": "+card.getClass());
			if(i<15) {
				card.setPosition(303+(65*i), 68);
			} else {
				card.setPosition(303+(65*(i-15)), 3);
			}
        	card.addListener(new ClickListener() {
        		@Override
        		public void clicked(InputEvent e, float x, float y) {
        			if(card.getClass() == CardAttacker.class) {
        				CardAttacker cardAttacker = (CardAttacker)card;
        				Attacker attacker = cardAttacker.createAttacker();
        				attacker.setWalking(true);
        				stage.addActor(attacker);
        				attackers.add(attacker);
        			} else {
        				//not attacker
        			}
        		}
        	});
        	stage.addActor(card);
        }

//        goblinButton.addListener( new ClickListener() {
//            @Override
//            public void clicked(InputEvent e, float x, float y) {
//            	Attacker attacker = goblinButton.createAttacker();
//            	attacker.setWalking(true);
//		        stage.addActor(attacker);
//		        attackers.add(attacker);
//            }
//        } );
//        stage.addActor(goblinButton);
//
//        goblinButton2.addListener( new ClickListener() {
//            @Override
//            public void clicked(InputEvent e, float x, float y) {
//            	Attacker attacker = goblinButton2.createAttacker();
//            	attacker.setWalking(true);
//		        stage.addActor(attacker);
//		        attackers.add(attacker);
//            }
//        } );
//        stage.addActor(goblinButton2);
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
		
		for(int i=0; i<map.getTiles().length; i++) {
	    	for(int k=0; k<map.getTiles()[i].length; k++) {
	    		TextureRegion texture = null;
	    		boolean xflip = false, yflip = false;
	    		if(map.getTiles()[i][k] == Tile.GRASS) { texture = Assets.grassTile; xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.PATH_HORIZONTAL) { texture = Assets.dirtTile; xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.PATH_BOTTOM_RIGHT) { texture = Assets.dirtCornerTile; xflip = true; yflip = true; } 
	    		else if(map.getTiles()[i][k] == Tile.PATH_TOP_LEFT) { texture = Assets.dirtCornerTile; xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.PATH_TOP_RIGHT) { texture = Assets.dirtCornerTile; xflip = true; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.PATH_BOTTOM_LEFT) { texture = Assets.dirtCornerTile; xflip = false; yflip = true; }
	    		else if(map.getTiles()[i][k] == Tile.BRIDGE) { texture = Assets.bridgeTile.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.WATER) { texture = Assets.water.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.WATER_LEFT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.WATER_RIGHT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = true; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.BRIDGE2) { texture = Assets.bridge2Tile.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_BLUE) { texture = Assets.gemBlue; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_GREEN) { texture = Assets.gemGreen; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_GRAY) { texture = Assets.gemGray; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_PURPLE) { texture = Assets.gemPurple; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_RED) { texture = Assets.gemRed; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_ORANGE) { texture = Assets.gemOrange; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GRASS_FLOWER) { texture = Assets.grassFlowerTile; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.PATH_VERTICAL) { texture = Assets.dirt2Tile; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.STONE) { texture = Assets.waterStone.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING); xflip = false; yflip = false; }
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
	    		game.batch.draw(texture, 64+k*32, (480+184)-(i*32)-32+2+13, 32, 32);
//	    		game.batch.draw(texture, 24+k*48, (480+104)-(i*48)-48+2, 48, 48);
	    		texture.flip(xflip, yflip);
		    }
	    }
		game.batch.end();

		game.batch.enableBlending();
		game.batch.begin();
		for(int i=0; i<map.getTiles().length; i++) {
	    	for(int k=0; k<map.getTiles()[i].length; k++) {
	    		TextureRegion texture = null;
	    		boolean xflip = false, yflip = false;
	    		if(map.getOverlay()[i][k] == Tile.NULL) { texture = Assets.blank; xflip = false; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.STONE) { texture = Assets.stone; xflip = false; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.BRIDGE_STONE_HORIZONTAL) { texture = Assets.bridgeStoneHorizontal; xflip = false; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.BRIDGE_STONE_VERTICAL) { texture = Assets.bridgeStoneVertical; xflip = false; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.BRIDGE_STONE_BOTTOM_RIGHT) { texture = Assets.bridgeStoneCornerBottomRight; xflip = false; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.BRIDGE_STONE_TOP_LEFT) { texture = Assets.bridgeStoneCornerTopLeft; xflip = false; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.BRIDGE_STONE_TOP_RIGHT) { texture = Assets.bridgeStoneCornerTopLeft; xflip = true; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.BRIDGE_STONE_BOTTOM_LEFT) { texture = Assets.bridgeStoneCornerBottomRight; xflip = true; yflip = false; } 
	    		else if(map.getOverlay()[i][k] == Tile.GRASS_FLOWER) { texture = Assets.grassFlowerTile; xflip = false; yflip = false; }
	    		
	    		texture.flip(xflip, yflip);
	    		game.batch.draw(texture, 64+k*32, (480+184)-(i*32)-32+2+13, 32, 32);
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
		        	attacker.setTarget(defender);
		        	attacker.setWalking(false);
		        	attacker.setAttacking(true);
		        	
		        	if(attacker.isDead()) {
		        		Blood blood = new Blood(attacker.getX(), attacker.getY(), 1, 0, 0, map);
		        		stage.addActor(blood);
		        		attackers.remove(i);
		        		attacker.remove();
		        		attacker = null;
		        	}
		        	if(defender.isDead()) {
		        		Blood blood = new Blood(defender.getX(), defender.getY(), 1, 0, 0, map);
		        		stage.addActor(blood);
		        		attackers.remove(j);
		        		defender.remove();
		        		defender = null;
		        	}
		        }
		    }
		    for (int j = towers.size() - 1; j >= 0; j--) {
		    	Tower defender = towers.get(j);
		        if(attacker != null && defender != null && attacker.getTeam() != defender.getTeam() && attacker.getRangeRectangle().overlaps(defender.getHitboxRectangle())) {
		        	attacker.setTarget(defender);
		        	attacker.setWalking(false);
		        	attacker.setAttacking(true);
		        	
		        	if(attacker.isDead()) {
		        		Blood blood = new Blood(attacker.getX(), attacker.getY(), 1, 0, 0, map);
		        		stage.addActor(blood);
		        		attackers.remove(i);
		        		attacker.remove();
		        		attacker = null;
		        	}
		        	if(defender.isDead()) {
		        		Blood blood = new Blood(defender.getX(), defender.getY(), 1, 0, 0, map);
		        		stage.addActor(blood);
		        		towers.remove(j);
		        		defender.remove();
		        		defender = null;
		        	}
		        }
		    }
		}
		
		for (int i = towers.size() - 1; i >= 0; i--) {
		    Tower tower = towers.get(i);
		    for (int j=0; j<attackers.size(); j++) {
			    Attacker attacker = attackers.get(j);
			    if(attacker != null && tower != null && attacker.getTeam() != tower.getTeam() && tower.getRangeRectangle().overlaps(attacker.getHitboxRectangle())) {
			    	tower.setTarget(attacker);
			    	tower.setAttacking(true);
		        	
		        	if(tower.isDead()) {
		        		Blood blood = new Blood(tower.getX(), tower.getY(), 1, 0, 0, map);
		        		stage.addActor(blood);
		        		towers.remove(i);
		        		tower.remove();
		        		tower = null;
		        	}
			    	if(attacker.isDead()) {
		        		Blood blood = new Blood(attacker.getX(), attacker.getY(), 1, 0, 0, map);
		        		stage.addActor(blood);
		        		attackers.remove(j);
		        		attacker.remove();
		        		attacker = null;
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