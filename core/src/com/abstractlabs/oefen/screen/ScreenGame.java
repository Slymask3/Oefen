package com.abstractlabs.oefen.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.Oefen;
import com.abstractlabs.oefen.Settings;
import com.abstractlabs.oefen.User;
import com.abstractlabs.oefen.card.Card;
import com.abstractlabs.oefen.card.CardAttacker;
import com.abstractlabs.oefen.card.CardSpell;
import com.abstractlabs.oefen.card.CardTower;
import com.abstractlabs.oefen.card.Cards;
import com.abstractlabs.oefen.card.Deck;
import com.abstractlabs.oefen.entity.Attacker;
import com.abstractlabs.oefen.entity.Spell;
import com.abstractlabs.oefen.entity.Tower;
import com.abstractlabs.oefen.entity.other.CardInfo;
import com.abstractlabs.oefen.entity.other.Cloud;
import com.abstractlabs.oefen.entity.other.MainTowerHealth;
import com.abstractlabs.oefen.entity.other.UserBars;
import com.abstractlabs.oefen.entity.tower.TowerMain;
import com.abstractlabs.oefen.gui.ImprovedButton.ImprovedButtonStyle;
import com.abstractlabs.oefen.map.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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

	Group clouds = new Group();
	Group cards = new Group();
	
	Group attackers = new Group();
	Group towers = new Group();
	
	Group[] subtowers = new Group[17];
	
	ImprovedButtonStyle goblinButtonStyle;
	CardAttacker goblinButton;
	CardAttacker goblinButton2;
	Map map = Map.generateRandomMap();
//	Map map = Map.generateMap1();
	
	Deck deck;
	
	User blue, red;
	
	public ScreenGame (Oefen game, final User blue, final User red) {
		this.game = game;
		this.blue = blue;
		this.red = red;
		
//		System.out.println(DB.getName(game.db));
		
		guiCam = new OrthographicCamera(Oefen.WIDTH, Oefen.HEIGHT);
		guiCam.position.set(Oefen.WIDTH/2, Oefen.HEIGHT/2, 0);
		
		vp = new FitViewport(Oefen.WIDTH, Oefen.HEIGHT);
		stage = new Stage(vp);
        Gdx.input.setInputProcessor(stage);

        rand = new Random();

        for(int i=0; i<subtowers.length; i++) {
        	subtowers[i] = new Group();
        	subtowers[i].setZIndex(i);
        }
        
        TowerMain towerBlue = new TowerMain(this, "Blue", 64+2*32, 122+13+(map.getBlueStart())*32);
//        towerBlue.setMapPos(16-map.getBlueStart(), 35-2);
        towerBlue.setMapPos(map.getBlueStart(), 2);
//        towerBlue.setZIndex(1000+(map.getBlueStart()+(17*2)));
        System.out.println(map.getBlueStart());
        subtowers[16-map.getBlueStart()].addActor(towerBlue);
        //towers.add(towerBlue);
        
        TowerMain towerRed = new TowerMain(this, "Red", 64+33*32, 122+13+(map.getRedStart())*32);
//        towerRed.setMapPos(16-map.getRedStart(), 35-33);
        towerRed.setMapPos(map.getRedStart(), 33);
//        towerRed.setZIndex(1000+(map.getBlueStart()+(17*33)));
        subtowers[16-map.getRedStart()].addActor(towerRed);
        //towers.add(towerRed);
        
//        List<Card> cards = new ArrayList<Card>();

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
//        for(int i=0; i<30; i++) {
//        	int r = rand.nextInt(Cards.all.size());
//        	String team = rand.nextInt(2)==0?"Blue":"Red";
//        	if(Cards.all.get(r).getType() == "Attacker") {
//                cards.add(new CardAttacker(this, Cards.all.get(r), Assets.clickSound, team));
//        	} else if(Cards.all.get(r).getType() == "Tower") {
//                cards.add(new CardTower(this, Cards.all.get(r), Assets.clickSound, team));
//        	} else if(Cards.all.get(r).getType() == "Spell") {
//                cards.add(new CardSpell(this, Cards.all.get(r), Assets.clickSound, team));
//        	}
//        }
//        
//        deck = new Deck(cards);
        
        List<Card> cardsList = new ArrayList<Card>();
        for(int i=0; i<blue.getCards().length; i++) {
        	//int r = rand.nextInt(Cards.all.size());
//        	String team = rand.nextInt(2)==0?"Blue":"Red";
        	if(Cards.all.get(blue.getCards()[i]).getType() == "Attacker") {
        		cardsList.add(new CardAttacker(this, Cards.all.get(blue.getCards()[i]), Assets.clickSound, blue));
        	} else if(Cards.all.get(blue.getCards()[i]).getType() == "Tower") {
        		cardsList.add(new CardTower(this, Cards.all.get(blue.getCards()[i]), Assets.clickSound, blue));
        	} else if(Cards.all.get(blue.getCards()[i]).getType() == "Spell") {
        		cardsList.add(new CardSpell(this, Cards.all.get(blue.getCards()[i]), Assets.clickSound, blue));
        	}
        }
        
        deck = new Deck(cardsList);
        
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
        			cards.addActor(cardinfo);
					return true;
        		}
        		@Override
        		public void tap (InputEvent event, float x, float y, int count, int button) {
        			//System.out.println("count=="+count+" | button=="+button);
        			if(card.getClass() == CardAttacker.class) { //Attacker
        				CardAttacker cardAttacker = (CardAttacker)card;
        				if(cardAttacker.getCost() <= blue.getGold()) {
            				Attacker attacker = cardAttacker.createAttacker();
            				attacker.setWalking(true);
            				attackers.addActor(attacker);
            				blue.setGold(blue.getGold()-cardAttacker.getCost());
        				}
        				//attackers.add(attacker);
        			} else if(card.getClass() == CardTower.class) { //Tower
        				CardTower cardTower = (CardTower)card;
        				if(!cardTower.isSelected()) {
	        				if(cardTower.getCost() <= blue.getGold()) {
	        					cardTower.select();
	        				}
        				} else {
        					cardTower.cancel();
        				}
        			} else if(card.getClass() == CardSpell.class) { //Spell
        				CardSpell cardSpell = (CardSpell)card;
        				if(!cardSpell.isSelected()) {
	        				if(cardSpell.getCost() <= blue.getGold()) {
	        					cardSpell.select();
	        				}
        				} else {
        					cardSpell.cancel();
        				}
        			}
        			cardinfo.remove();
        		}
        	});
        	cards.addActor(card);
        }
        
        this.stage.addListener(new ActorGestureListener() {
        	@Override
        	public void tap (InputEvent event, float x, float y, int count, int button) { //if stage is clicked.
	        	for(int i=0; i<deck.getCards().size(); i++) { //loop through all the cards
	        		if(deck.getCards().get(i).getClass() == CardTower.class) { //if the card is a tower
						CardTower cardTower = (CardTower)deck.getCards().get(i); //cast as cardtower
						if(cardTower.isSelected()) { //if this card is selected
	        				if(cardTower.getCost() <= blue.getGold()) {
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
					            				blue.setGold(blue.getGold()-cardTower.getCost());
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
						}
					} else if(deck.getCards().get(i).getClass() == CardSpell.class) { //if the card is a spell
						CardSpell cardSpell = (CardSpell)deck.getCards().get(i); //cast as cardspell
						if(cardSpell.isSelected()) { //if this card is selected
							if(cardSpell.getCost() <= blue.getGold()) {
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
				            				blue.setGold(blue.getGold()-cardSpell.getCost());
										}
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
        final CheckBox hitbox = new CheckBox("Hitbox", style);
        hitbox.setPosition(10, 32);
        hitbox.addListener(new ClickListener() {
        	@Override
    		public void clicked(InputEvent e, float x, float y) {
        		if(!hitbox.isChecked()) {
        			Settings.showHitbox = false;
        		} else {
        			Settings.showHitbox = true;
        		}
//        		Cloud cloud = new Cloud();
//        		clouds.addActor(cloud);
        	}
        });
        final CheckBox rangebox = new CheckBox("Rangebox", style);
        rangebox.setPosition(10, 10);
        rangebox.addListener(new ClickListener() {
        	@Override
    		public void clicked(InputEvent e, float x, float y) {
        		if(!rangebox.isChecked()) {
        			Settings.showRangebox = false;
        		} else {
        			Settings.showRangebox = true;
        		}
        	}
        });
        
        this.stage.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
//				System.out.println(actor+" has been changed");
			}
        });
        	
        for(int i=0; i<subtowers.length; i++) {
        	towers.addActor(subtowers[i]);
        }

        stage.addActor(attackers);
        stage.addActor(towers);

        stage.addActor(clouds);
        
        Image background = new Image(Assets.backgroundIngame);
        background.setX(0);
        background.setY(0);
        
        stage.addActor(background);
        stage.addActor(new MainTowerHealth(towerBlue));
        stage.addActor(new MainTowerHealth(towerRed));
        stage.addActor(new UserBars(blue, red));
        stage.addActor(cards);
        stage.addActor(hitbox);
        stage.addActor(rangebox);
	}

	public void draw () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stateTime += Gdx.graphics.getDeltaTime();
		
		guiCam.update();
		game.batch.setProjectionMatrix(guiCam.combined);
		game.sr.setProjectionMatrix(guiCam.combined);

		//game.batch.disableBlending();
		game.batch.begin();
		
		map.draw(game.batch, stateTime, 64, 647);
		
//		font.setColor(0, 1, 0.3f, 1);
//		layout.setText(font, blue.getUsername());
//		font.draw(game.batch, layout, 5, Oefen.HEIGHT-5);
//
//		font.setColor(0.7f, 0.7f, 0.7f, 1);
//		layout.setText(font, blue.getElo()+" OP");
//		font.draw(game.batch, layout, 5, Oefen.HEIGHT-10-layout.height);
//		
//		font.setColor(1, 0, 0.3f, 1);
//		layout.setText(font, red.getUsername());
//		font.draw(game.batch, layout, Oefen.WIDTH-5-layout.width, Oefen.HEIGHT-5);
//
//		font.setColor(0.7f, 0.7f, 0.7f, 1);
//		layout.setText(font, red.getElo()+" OP");
//		font.draw(game.batch, layout, Oefen.WIDTH-5-layout.width, Oefen.HEIGHT-10-layout.height);
		
		game.batch.end();
		
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	    
//	    game.batch.enableBlending();
//	    game.batch.begin();
//		game.batch.draw(Assets.backgroundIngameRegion, 0, 0, Oefen.WIDTH, Oefen.HEIGHT);
//		game.batch.end();
	}
	
	private int ticks = 0;
	public void update() {
		ticks++;
		if(ticks>=1000) {
			clouds.addActor(new Cloud());
			ticks=0;
			//System.out.println("cloud spawned");
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
	
	public Group getAttackers() {
		return this.attackers;
	}
	
	public Group getTowers() {
		return this.towers;
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public Oefen getOefen() {
		return this.game;
	}
}