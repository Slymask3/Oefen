package com.abstractlabs.oefen.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.abstractlabs.oefen.Animation;
import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Cards;
import com.abstractlabs.oefen.Deck;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.ImprovedButton.ImprovedButtonStyle;
import com.abstractlabs.oefen.Map;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.Tile;
import com.abstractlabs.oefen.card.Card;
import com.abstractlabs.oefen.card.CardAttacker;
import com.abstractlabs.oefen.card.CardSpell;
import com.abstractlabs.oefen.card.CardTower;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.Spell;
import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.entity.other.CardInfo;
import com.abstractlabs.oefen.entity.other.Death;
import com.abstractlabs.oefen.entity.tower.TowerMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScreenGame extends ScreenAdapter {
	ScreenGame screen = this;
	Oefen game;
	OrthographicCamera guiCam;
	float stateTime;
	Stage stage;
	Viewport vp;
	Random rand;
	List<Attacker> attackers = new ArrayList<Attacker>();
	//List<Tower> towers = new ArrayList<Tower>();
	
	Group towers = new Group();
	
//	List<Group> subtowers = new ArrayList<Group>();
	
	Group[] subtowers = new Group[17];
	
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

        for(int i=0; i<subtowers.length; i++) {
        	subtowers[i] = new Group();
        	subtowers[i].setZIndex(i);
        }
        
        Tower towerBlue = new TowerMain(this, "Blue", 64+2*32, 122+13+(map.getBlueStart())*32);
//        towerBlue.setMapPos(16-map.getBlueStart(), 35-2);
        towerBlue.setMapPos(map.getBlueStart(), 2);
//        towerBlue.setZIndex(1000+(map.getBlueStart()+(17*2)));
        System.out.println(map.getBlueStart());
        subtowers[16-map.getBlueStart()].addActor(towerBlue);
        //towers.add(towerBlue);
        
        Tower towerRed = new TowerMain(this, "Red", 64+33*32, 122+13+(map.getRedStart())*32);
//        towerRed.setMapPos(16-map.getRedStart(), 35-33);
        towerRed.setMapPos(map.getRedStart(), 33);
//        towerRed.setZIndex(1000+(map.getBlueStart()+(17*33)));
        subtowers[16-map.getRedStart()].addActor(towerRed);
        //towers.add(towerRed);
        
        List<Card> cards = new ArrayList<Card>();

//        cards.add(new CardAttacker(this, Cards.goblin, Assets.clickSound, "Blue")); //1
//        cards.add(new CardAttacker(this, Assets.cardGoblin, Assets.clickSound, 500, "Red", Attacker.GOBLIN, 1f, 30, 7, 16, 100)); //2
//        cards.add(new CardAttacker(this, Assets.cardFairy, Assets.clickSound, 30, "Blue", Attacker.FAIRY, 1.2f, 20, 12, 32, 100)); //3
//        cards.add(new CardAttacker(this, Assets.cardFairy, Assets.clickSound, 30, "Red", Attacker.FAIRY, 1.2f, 20, 12, 32, 100)); //4
//        cards.add(new CardAttacker(this, Assets.cardGoblinDarkMage, Assets.clickSound, 30, "Blue", Attacker.GOBLINDARKMAGE, 1.05f, 20, 9, 32, 100)); //5
//        cards.add(new CardAttacker(this, Assets.cardGoblinDarkMage, Assets.clickSound, 404, "Red", Attacker.GOBLINDARKMAGE, 1.05f, 20, 9, 32, 100)); //6
//        cards.add(new CardTower(this, Assets.cardDummy, Assets.clickSound, 420, "Blue", Tower.DUMMY, 30, 0, 0, 0)); //7
//        cards.add(new CardTower(this, Assets.cardDummy, Assets.clickSound, 9000, "Red", Tower.DUMMY, 30, 0, 0, 0)); //8
//        cards.add(new CardAttacker(this, Assets.cardSpiderRed, Assets.clickSound, 2, "Blue", Attacker.SPIDERRED, 1.3f, 10, 4, 16, 100)); //9
//        cards.add(new CardAttacker(this, Assets.cardSpiderRed, Assets.clickSound, 21, "Red", Attacker.SPIDERRED, 1.3f, 10, 4, 16, 100)); //10
//        cards.add(new CardAttacker(this, Assets.cardCrystalBlue, Assets.clickSound, 1337, "Blue", Attacker.CRYSTALBLUE, 1.1f, 40, 3, 80, 100)); //11
//        cards.add(new CardAttacker(this, Assets.cardCrystalBlue, Assets.clickSound, 13337, "Red", Attacker.CRYSTALBLUE, 1.1f, 40, 3, 80, 100)); //12
//        cards.add(new CardAttacker(this, Assets.cardGoblin, Assets.clickSound, 500, "Red", Attacker.GOBLIN, 1f, 30, 7, 16, 100)); //13
//        cards.add(new CardTower(this, Assets.budhaGold, Assets.clickSound, 500, "Blue", Tower.BUDDHAGOLD, 100, 0, 0, 0)); //14
//        cards.add(new CardTower(this, Assets.budhaGold, Assets.clickSound, 500, "Red", Tower.BUDDHAGOLD, 100, 0, 0, 0)); //15
//        cards.add(new CardAttacker(this, Assets.cardKnight, Assets.clickSound, 91, "Blue", Attacker.KNIGHT, 0.8f, 60, 12, 16, 100)); //16
//        cards.add(new CardAttacker(this, Assets.cardKnight, Assets.clickSound, 880, "Red", Attacker.KNIGHT, 0.8f, 60, 12, 16, 100)); //17
//        cards.add(new CardAttacker(this, Assets.cardBat, Assets.clickSound, 50, "Blue", Attacker.BAT, 1.1f, 15, 6, 16, 100)); //18
//        cards.add(new CardAttacker(this, Assets.cardBat, Assets.clickSound, 500, "Red", Attacker.BAT, 1.1f, 15, 6, 16, 100)); //19
//        cards.add(new CardAttacker(this, Assets.cardGolem, Assets.clickSound, 5000, "Blue", Attacker.GOLEM, 0.8f, 200, 7, 16, 100)); //20
//        cards.add(new CardAttacker(this, Assets.cardGolem, Assets.clickSound, 50000, "Red", Attacker.GOLEM, 0.8f, 200, 7, 16, 100)); //21
//        cards.add(new CardSpell(this, Assets.cardExplosion, Assets.clickSound, 50, "Blue", Spell.EXPLOSION, 30, 48)); //22
//        cards.add(new CardSpell(this, Assets.cardExplosion, Assets.clickSound, 500, "Red", Spell.EXPLOSION, 30, 48)); //23
//        cards.add(new CardAttacker(this, Assets.cardMage, Assets.clickSound, 50, "Blue", Attacker.MAGE, 1.1f, 25, 11, 48, 50)); //24
//        cards.add(new CardAttacker(this, Assets.cardMage, Assets.clickSound, 500, "Red", Attacker.MAGE, 1.1f, 25, 11, 48, 50)); //25
//        cards.add(new CardAttacker(this, Assets.cardGoblin, Assets.clickSound, 500, "Red", Attacker.GOBLIN, 1f, 30, 7, 16, 100)); //26
//        cards.add(new CardAttacker(this, Assets.cardGoblin, Assets.clickSound, 500, "Red", Attacker.GOBLIN, 1f, 30, 7, 16, 100)); //27
//        cards.add(new CardAttacker(this, Assets.cardGoblin, Assets.clickSound, 500, "Red", Attacker.GOBLIN, 1f, 30, 7, 16, 100)); //28
//        cards.add(new CardTower(this, Assets.wtfisthis, Assets.clickSound, 40, "Blue", Tower.WTFISTHIS, 100, 8, 48, 50)); //29
//        cards.add(new CardTower(this, Assets.wtfisthis, Assets.clickSound, 6, "Red", Tower.WTFISTHIS, 100, 8, 48, 50)); //30
        
        //random deck boii
        for(int i=0; i<30; i++) {
        	int r = rand.nextInt(Cards.all.size());
        	String team = rand.nextInt(2)==0?"Blue":"Red";
        	if(Cards.all.get(r).getType() == "Attacker") {
                cards.add(new CardAttacker(this, Cards.all.get(r), Assets.clickSound, team));
        	} else if(Cards.all.get(r).getType() == "Tower") {
                cards.add(new CardTower(this, Cards.all.get(r), Assets.clickSound, team));
        	} else if(Cards.all.get(r).getType() == "Spell") {
                cards.add(new CardSpell(this, Cards.all.get(r), Assets.clickSound, team));
        	}
        }
        
        deck = new Deck(cards);
        
        for(int i=0; i<deck.getCards().size(); i++) {
        	final Card card = deck.getCards().get(i);
			//System.out.println("card "+i+": "+card.getClass());
			if(i<15) {
				card.setPosition(303+(65*i), 68);
			} else {
				card.setPosition(303+(65*(i-15)), 3);
			}
        	card.addListener(new ActorGestureListener() {
    			CardInfo cardinfo = new CardInfo(screen, card);
        		@Override
        		public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        			cardinfo.remove();
        		}
        		@Override
        		public boolean longPress(Actor actor, float x, float y) {
        			stage.addActor(cardinfo);
					return true;
        		}
        		@Override
        		public void tap (InputEvent event, float x, float y, int count, int button) {
        			//System.out.println("count=="+count+" | button=="+button);
        			if(card.getClass() == CardAttacker.class) { //Attacker
        				CardAttacker cardAttacker = (CardAttacker)card;
        				Attacker attacker = cardAttacker.createAttacker();
        				attacker.setWalking(true);
        				stage.addActor(attacker);
        				attackers.add(attacker);
        			} else if(card.getClass() == CardTower.class) { //Tower
        				CardTower cardTower = (CardTower)card;
        				if(!cardTower.isSelected()) {
            				cardTower.select();
        				} else {
        					cardTower.cancel();
        				}
        			} else if(card.getClass() == CardSpell.class) { //Spell
        				CardSpell cardSpell = (CardSpell)card;
        				if(!cardSpell.isSelected()) {
        					cardSpell.select();
        				} else {
        					cardSpell.cancel();
        				}
        			}
        			cardinfo.remove();
        		}
        	});
        	stage.addActor(card);
        }
        
        this.stage.addListener(new ClickListener() {
        	@Override
    		public void clicked(InputEvent e, float x, float y) { //if stage is clicked.
	        	for(int i=0; i<deck.getCards().size(); i++) { //loop through all the cards
	        		if(deck.getCards().get(i).getClass() == CardTower.class) { //if the card is a tower
						CardTower cardTower = (CardTower)deck.getCards().get(i); //cast as cardtower
						if(cardTower.isSelected()) { //if this card is selected
							for(int o=0; o<map.getTowers().length; o++) { //loop through all the tiles
								for(int p=0; p<map.getTowers()[o].length; p++) { //^^
									if(x >= 64+p*32 && x < 64+p*32+32 && y >= (480+184)-(o*32)-32+2+13 && y < (480+184)-(o*32)-32+2+13+32) { //if mouse is inside a tile
										if(map.getTowers()[o][p] == cardTower.getTowerAvailable()) { //if the tile is green
											//System.out.println("card is selected and stage is clicked");
											cardTower.setTowerXY(64+p*32, (480+184)-(o*32)-32+2+13);
											Tower tower = cardTower.createTower();
											tower.setMapPos(o, p);
											subtowers[o].addActor(tower);
											//towers.add(tower);
											map.getTowers()[o][p] = 1;
											//tower.setOrder((o+(17*p)));
											cardTower.cancel();
										} else {
											//player trying to place on a red square.
											//play sound to let them know it wont work.
										}
									} else {
										//player trying to place outside the game board.
										//maybe play sound to let them know theyre crazy.
									}
								}
							}
						}
					} else if(deck.getCards().get(i).getClass() == CardSpell.class) { //if the card is a spell
						CardSpell cardSpell = (CardSpell)deck.getCards().get(i); //cast as cardspell
						if(cardSpell.isSelected()) { //if this card is selected
							for(int o=0; o<map.getTowers().length; o++) { //loop through all the tiles
								for(int p=0; p<map.getTowers()[o].length; p++) { //^^
									if(x >= 64+p*32 && x < 64+p*32+32 && y >= (480+184)-(o*32)-32+2+13 && y < (480+184)-(o*32)-32+2+13+32) { //if mouse is inside a tile
										cardSpell.setSpellXY(64+p*32, (480+184)-(o*32)-32+2+13);
										Spell spell = cardSpell.createSpell();
	//									spell.setMapPos(o, p);
										stage.addActor(spell);
	//									spells.add(spell);
	//									map.getTowers()[o][p] = 1;
										cardSpell.cancel();
									}
								}
							}
						}
					}
				}
        	}
		});
        
        CheckBoxStyle style = new CheckBoxStyle();
        style.font = Font.create(Font.sufrimeda, 25);
        style.checkboxOff = new TextureRegionDrawable(Assets.unchecked);
        style.checkboxOn = new TextureRegionDrawable(Assets.checked);
        final CheckBox check = new CheckBox("Hitbox", style);
        check.setPosition(10, 32);
        check.addListener(new ClickListener() {
        	@Override
    		public void clicked(InputEvent e, float x, float y) {
        		if(!check.isChecked()) {
        			Settings.showHitbox = false;
        		} else {
        			Settings.showHitbox = true;
        		}
        	}
        });
        stage.addActor(check);
        final CheckBox check2 = new CheckBox("Rangebox", style);
        check2.setPosition(10, 10);
        check2.addListener(new ClickListener() {
        	@Override
    		public void clicked(InputEvent e, float x, float y) {
        		if(!check2.isChecked()) {
        			Settings.showRangebox = false;
        		} else {
        			Settings.showRangebox = true;
        		}
        	}
        });
        stage.addActor(check2);
        
        this.stage.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println(actor+" has been changed");
			}
        });
        
//        for(int i=0; i<610; i++) {
////        	towers.addActor(new TowerEmpty(this));
//        	towers.addActor(new TowerMain(this, "Blue", -100, -100));
//        }
        	
        for(int i=0; i<subtowers.length; i++) {
        	towers.addActor(subtowers[i]);
        }
        
        stage.addActor(towers);
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
	    		else if(map.getTiles()[i][k] == Tile.BRIDGE) { texture = Assets.bridgeTile.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.WATER) { texture = Assets.water.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.WATER_LEFT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.WATER_RIGHT) { texture = Assets.waterLeft.getKeyFrame(stateTime, Animation.LOOPING); xflip = true; yflip = false; } 
	    		else if(map.getTiles()[i][k] == Tile.BRIDGE2) { texture = Assets.bridge2Tile.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_BLUE) { texture = Assets.gemBlue; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_GREEN) { texture = Assets.gemGreen; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_GRAY) { texture = Assets.gemGray; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_PURPLE) { texture = Assets.gemPurple; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_RED) { texture = Assets.gemRed; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GEM_ORANGE) { texture = Assets.gemOrange; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.GRASS_FLOWER) { texture = Assets.grassFlowerTile; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.PATH_VERTICAL) { texture = Assets.dirt2Tile; xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.STONE) { texture = Assets.waterStone.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.WATER_BOTTOM) { texture = Assets.waterBottom.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.WATER_TOPLEFT_CORNER) { texture = Assets.waterTopLeftCorner.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
	    		else if(map.getTiles()[i][k] == Tile.WATER_TOPRIGHT_CORNER) { texture = Assets.waterTopRightCorner.getKeyFrame(stateTime, Animation.LOOPING); xflip = false; yflip = false; }
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
//		for(int i=0; i<stage.getActors().size; i++) {
//			if(stage.getActors().get(i) instanceof Tower) {
//				Tower t = (Tower) stage.getActors().get(i);
//				//t.setZIndex(t.getMapY()+(17*t.getMapX()));
//				
//				if(t.getMapY()+(17*t.getMapX()) > stage.getActors().size) {
//					t.setZIndex(stage.getActors().size+1);
//				} else {
//					t.setZIndex(stage.getActors().size-1);
//				}
//			} else {
//				stage.getActors().get(i).setZIndex(i);
//			}
//		}
		
		//Collections.sort(Arrays.asList(stage.getActors().toArray()), new ActorComparator());
		
//		Collections.sort(Arrays.asList(towers.getChildren().toArray()), new ActorComparator());
//		
//		for(int i=0; i<towers.getChildren().size; i++) {
//			Tower t = (Tower) towers.getChildren().get(i);
////			Tower tl = (Tower) towers.getChildren().get(towers.getChildren().size-1);
////			if(t.getZOrder() > tl.getZOrder()) {
////				t.setZIndex(towers.getChildren().size-1);
////			} else if(t.getZOrder() == tl.getZOrder()) {
////				//.setZIndex(i);
////			} else {
////				t.setZIndexBy(0);
////			}
//			t.setZIndex(t.getZOrder());
//		}
		
		//System.out.println(towers);
		
//		for(int i=0; i<subtowers.length; i++) {
//			for(int j=0; j<subtowers[i].getChildren().size; j++) {
//				subtowers[i].setZIndex(((Tower)subtowers[i].getChildren().get(j)).getMapY());
//			}
//		}
		
		checkForCollision();
	}
	
	private void checkForCollision() {
		//loop through attackers and towers, and check if one's rangebox collides with one's hitbox. if so, then attack
		for (int i = attackers.size() - 1; i >= 0; i--) {
		    Attacker attacker = attackers.get(i); //main attacker.
		    for (int j = attackers.size() - 1; j >= 0; j--) { //loop through attackers whom we check for hitboxes.
		    	Attacker defender = attackers.get(j);
		        if(attacker != null && defender != null && attacker.getTeam() != defender.getTeam() && attacker.getRangeRectangle().overlaps(defender.getHitboxRectangle())) {
		        	attacker.setTarget(defender);
		        	attacker.setWalking(false);
		        	attacker.setAttacking(true);
		        	
		        	if(attacker.isDead()) {
		        		Death death = attacker.getDeath();
		        		stage.addActor(death);
		        		attackers.remove(i);
		        		attacker.remove();
		        		attacker = null;
		        	}
		        	if(defender.isDead()) {
		        		Death death = defender.getDeath();
		        		stage.addActor(death);
		        		attackers.remove(j);
		        		defender.remove();
		        		defender = null;
		        	}
		        }
		    }
		    for (int j=0; j<subtowers.length; j++) { //loop though all rows. (17 rows)
		    	if(subtowers[j].getChildren().size > 0) {
			    	for(int l=0; l<subtowers[j].getChildren().size; l++) { //loop through all towers inside each row
			    		Tower defender = (Tower)subtowers[j].getChildren().get(l);
				        if(attacker != null && defender != null && attacker.getTeam() != defender.getTeam() && attacker.getRangeRectangle().overlaps(defender.getHitboxRectangle())) {
				        	attacker.setTarget(defender);
				        	attacker.setWalking(false);
				        	attacker.setAttacking(true);
				        	
				        	if(attacker.isDead()) {
				        		Death death = attacker.getDeath();
				        		stage.addActor(death);
				        		attackers.remove(i);
				        		attacker.remove();
				        		attacker = null;
				        	}
				        	if(defender.isDead()) {
				        		map.getTowers()[defender.getMapY()][defender.getMapX()] = defender.getTeam()=="Blue"?0:9;
				        		Death death = defender.getDeath();
				        		stage.addActor(death);
				        		//towers.remove(j);
				        		defender.remove();
				        		defender = null;
				        	}
				        }
			    	}
		    	}
		    }
		}
		
		//loop through all towers, and set the tower's target to the attacker that collides with it's range.
		for (int i=0; i<subtowers.length; i++) { //loop though all rows. (17 rows)
	    	if(subtowers[i].getChildren().size > 0) {
		    	for(int l=0; l<subtowers[i].getChildren().size; l++) { //loop through all towers inside each row
			    	Tower tower = (Tower)subtowers[i].getChildren().get(l);
				    for (int j=0; j<attackers.size(); j++) {
					    Attacker attacker = attackers.get(j);
					    if(attacker != null && tower != null && attacker.getTeam() != tower.getTeam() && tower.getRangeRectangle().overlaps(attacker.getHitboxRectangle())) {
					    	tower.setTarget(attacker);
					    	tower.setAttacking(true);
				        	
				        	if(tower.isDead()) {
				        		map.getTowers()[tower.getMapY()][tower.getMapX()] = tower.getTeam()=="Blue"?0:9;
				        		Death death = tower.getDeath();
				        		stage.addActor(death);
				        		//towers.remove(i);
				        		tower.remove();
				        		tower = null;
				        	}
					    	if(attacker.isDead()) {
				        		Death death = attacker.getDeath();
				        		stage.addActor(death);
				        		attackers.remove(j);
				        		attacker.remove();
				        		attacker = null;
				        	}
					    } else {
					    	tower.setTarget(null);
					    }
				    }
		    	}
	    	}
		}
	}

	@Override
	public void render(float delta) {
		draw();
		update();
	}

	@Override
	public void pause() {
		Settings.save();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
	
	public Map getMap() {
		return this.map;
	}
	
	public List<Attacker> getAttackers() {
		return this.attackers;
	}
	
//	public List<Tower> getTowers() {
//		return this.towers;
//	}
	
	public Group getTowers() {
		return this.towers;
	}
	
	public Stage getStage() {
		return this.stage;
	}
}