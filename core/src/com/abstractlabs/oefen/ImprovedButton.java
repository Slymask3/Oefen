package com.abstractlabs.oefen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImprovedButton extends Button {

    protected boolean isPressedOnce=false;//is press started or touchDown
    protected float originalWidth,originalHeight;
    protected ImprovedButtonStyle istyle;

    public ImprovedButton() {
        super();
        this.istyle=new ImprovedButtonStyle();
    }    
    public ImprovedButton(Actor child, ImprovedButtonStyle style) {
        super(child, style);
        this.istyle=style;
    }    
    public ImprovedButton(Actor child, Skin skin, String styleName) {
        this(child,skin.get(styleName, ImprovedButtonStyle.class));         
    }    
    public ImprovedButton(Actor child, Skin skin) {
        this(child,skin.get(ImprovedButtonStyle.class));
    }    
    public ImprovedButton(ImprovedButtonStyle style) {
        super(style);
        this.istyle=style;
    }    
    public ImprovedButton(Drawable up, Drawable down, Drawable checked) {
        super(up, down, checked);
        istyle=new ImprovedButtonStyle();
    }    
    public ImprovedButton(Drawable up, Drawable down) {
        this(up, down,null);
    }    
    public ImprovedButton(Drawable up) {
        this(up,null,null);
    }    
    public ImprovedButton(Skin skin, String styleName) {
        super(skin, styleName);
        this.istyle=skin.get(ImprovedButtonStyle.class);    
    }    
    public ImprovedButton(Skin skin) {
        super(skin);
        setStyle(skin.get(ButtonStyle.class));    
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
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
    }

    @Override
    protected void drawBackground(Batch batch, float parentAlpha, float x,float y) {
         int offsetX=0;
         int offsetY=0;
         if(isPressed()){                
            offsetX=istyle.changeInWidth/2;
            offsetY=istyle.changeInHeight/2;
          }   
         super.drawBackground(batch, parentAlpha, x+offsetX, y+offsetY);
    }

    public static class ImprovedButtonStyle extends ButtonStyle {
        public int changeInWidth=2,changeInHeight=2;
        public Sound sound=null;
        
        public ImprovedButtonStyle() {
            super();
        }
        
        public ImprovedButtonStyle(TextureRegion up, Sound sound) {
        	super();
        	this.up = new TextureRegionDrawable(up);
        	this.sound = sound;
        }

        public ImprovedButtonStyle(ButtonStyle style,int changeInWidth,int changeInHeight,Sound sound) {
            super(style);
            this.changeInHeight=changeInHeight;
            this.changeInWidth=changeInWidth;
            this.sound=sound;
        }
        public ImprovedButtonStyle(Drawable up, Drawable down, Drawable checked) {
            super(up, down, checked);
        }
        public ImprovedButtonStyle(ImprovedButtonStyle style) {
            super(style);
            this.changeInHeight=style.changeInHeight;
            this.changeInWidth=style.changeInWidth;
            this.sound=style.sound;    
        }
    }
}