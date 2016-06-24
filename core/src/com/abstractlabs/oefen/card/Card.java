package com.abstractlabs.oefen.card;

import com.abstractlabs.oefen.Assets;
import com.abstractlabs.oefen.Font;
import com.abstractlabs.oefen.ImprovedButton;
import com.abstractlabs.oefen.Map;
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

	protected BitmapFont font;
	protected float cost;
	protected String type;
	protected Color color;
	protected TextureRegion front;
	protected Map map;
	protected String team;
	
	public Card(String type, TextureRegion texture, Sound sound, float cost, Map map, String team) {
		super(new ImprovedButtonStyle(Assets.card, sound));
        //this.setPosition(x, y);
        this.cost = cost;
        this.font = Font.create(Font.sufrimeda, 15, 1);
        this.font.setColor(1, 1, 0, 1);
        this.type = type;
        this.color = type==Card.ATTACKER?new Color(1,0.3f,0.3f,1):type==Card.TOWER?new Color(0.5f,1,0.5f,1):new Color(0.5f,0.5f,1,1);
        this.front = texture;
        this.setColor(color);
        this.map = map;
        this.team = team;
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
        batch.setColor(1, 1, 1, 1);
        batch.draw(front, this.getX()+((64-front.getRegionWidth())/2), this.getY()+5+((64-front.getRegionHeight())/2));
        this.font.draw(batch, Math.round(cost)+"", this.getX()+5, this.getY()+12);
    }
}