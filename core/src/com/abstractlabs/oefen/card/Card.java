package com.abstractlabs.oefen.card;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.gui.ImprovedButton;
import com.abstractlabs.oefen.screen.ScreenGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public abstract class Card extends ImprovedButton {
	public static String ATTACKER = "Attacker";
	public static String TOWER = "Tower";
	public static String SPELL = "Spell";

	protected ScreenGame screen;
	protected Cards card;
	protected BitmapFont font;
	protected float cost;
	protected String type;
	protected Color color;
	protected TextureRegion front;
	protected String team;
	protected float speed;
	protected int hp, dmg, range, attackspeed;
	
	public Card(ScreenGame screen, String type, Cards card, Sound sound, String team) {
		super(new ImprovedButtonStyle(Assets.card, sound));
        //this.setPosition(x, y);
		this.card = card;
        this.cost = card.getPrice();
        this.font = Font.create(Font.sufrimeda, 15, 1);
        this.font.setColor(1, 1, 0, 1);
        this.type = type;
        this.color = type==Card.ATTACKER?new Color(1,0.3f,0.3f,1):type==Card.TOWER?new Color(0.5f,0.5f,1,1):new Color(0,1,0,1);
        this.front = card.getTexture();
        this.setColor(color);
        this.screen = screen;
        this.team = team;
		this.speed = card.getMoveSpeed();
		this.hp = card.getHealth();
		this.dmg = card.getDamage();
		this.range = card.getRange();
		this.attackspeed = card.getAttackSpeed();
	}
	
	public Card(String type, Cards card, Sound sound, String team) {
		this(null, type, card, sound, team);
	}
	
	public Cards getCardsObj() {
		return this.card;
	}
	
	public float getCost() {
		return this.cost;
	}
	
	public int getHealth() {
		return this.hp;
	}
	
	public int getDamage() {
		return this.dmg;
	}
	
	public int getRange() {
		return this.range;
	}
	
	public int getAttackSpeed() {
		return this.attackspeed;
	}
	
	public float getMoveSpeed() {
		return this.speed;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha) {
        //super.draw(batch, parentAlpha);
		
		validate();
		
        //batch.setColor(color);

		boolean isPressed = isPressed();
		boolean isDisabled = isDisabled();

		setBackground(new TextureRegionDrawable(Assets.card));

		float offsetX = 0, offsetY = 0;
		if (isPressed && !isDisabled) {
			offsetX = istyle.pressedOffsetX;
			offsetY = istyle.pressedOffsetY;
		} else if (isChecked() && !isDisabled) {
			offsetX = istyle.checkedOffsetX;
			offsetY = istyle.checkedOffsetY;
		} else {
			offsetX = istyle.unpressedOffsetX;
			offsetY = istyle.unpressedOffsetY;
		}

		Array<Actor> children = getChildren();
		for (int i = 0; i < children.size; i++)
			children.get(i).moveBy(offsetX, offsetY);
		super.draw(batch, parentAlpha);
		for (int i = 0; i < children.size; i++)
			children.get(i).moveBy(-offsetX, -offsetY);

		Stage stage = getStage();
		if (stage != null && stage.getActionsRequestRendering() && isPressed != getClickListener().isPressed())
			Gdx.graphics.requestRendering();
		
		/////////////////////////
		
        if( isPressed()) {
            if (!isPressedOnce) {                   
                if (istyle.sound!=null) {
                  istyle.sound.play(0.2f);
                }
                isPressedOnce=true;
                originalHeight=getHeight();
                originalWidth=getWidth();
                setWidth(originalWidth-istyle.changeInWidth);
                setHeight(originalHeight-istyle.changeInHeight);
            }
        }
        else {
            if (isPressedOnce) {
                isPressedOnce=false;
                setWidth(originalWidth);
                setHeight(originalHeight);
            }           
        }
        
        int nrh=front.getRegionHeight(), nrw=front.getRegionWidth();
        if(front.getRegionHeight() > 48) {
        	double ratio = (double)front.getRegionWidth()/front.getRegionHeight();
//        	System.out.println(ratio);
        	nrh = 48;
        	nrw = (int)(ratio*48);
        }
//        if(front.getRegionWidth() > 48) {
//        	nrw = 48;
//        }
        
        batch.setColor(1, 1, 1, 1);
        batch.draw(front, this.getX()+((64-nrw)/2), this.getY()+5+((64-nrh)/2), (float)nrw, (float)nrh);
        this.font.draw(batch, "$"+Math.round(cost), this.getX()+5, this.getY()+12);
        //font.draw(batch, this.getZIndex()+"", getX()+32, getY()+32);
    }
}